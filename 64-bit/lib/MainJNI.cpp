//#include "MainJNI.h"
#include "com_kayzio_observer_model_DLLCall.h"
#include <jni.h>
#include <stdio.h>
#include <Windows.h>
#include <sstream>
#include <iostream>
#include <math.h>
#include <vector>
#include <algorithm>
#include <tlhelp32.h>
#include <tchar.h>
#include <cstdio>

using namespace std;

TCHAR lolDLLName[] = _T("League of Legends.exe");
DWORD lolGetter = 0;

// Zoom + Offsets (returns float)
const DWORD zoomBase = 0x16ACA28;
const DWORD zoomOff1 = 0x238;
const DWORD zoomOff2 = 0x0C;

// Health + Offsets (returns float)
const DWORD healthBase = 0x16A985C;
const DWORD healthOff1 = 0x94;
const DWORD healthOff2 = 0x0;
const DWORD healthOff3 = 0x18;

// Max Health + Offsets (returns float)
const DWORD maxHealthBase = 0x16A985C;
const DWORD maxHealthOff1 = 0x98;
const DWORD maxHealthOff2 = 0x0;
const DWORD maxHealthOff3 = 0x18;

// PHYSICAL DAMAGE + Offsets (returns float)
const DWORD physicalDmgBase = 0x16A985C;
const DWORD physicalDmgOff1 = 0x10;
const DWORD physicalDmgOff2 = 0x10;
const DWORD physicalDmgOff3 = 0x4;
const DWORD physicalDmgOff4 = 0x20;

// Target Health + Offsets (return float)
const DWORD targetHealthBase = 0x16A985C;
const DWORD targetHealthOff1 = 0x94;
const DWORD targetHealthOff2 = 0x4;
const DWORD targetHealthOff3 = 0x6C;

// Target Max Health + Offsets (return float)
const DWORD targetMaxHealthBase = 0x16A985C;
const DWORD targetMaxHealthOff1 = 0x98;
const DWORD targetMaxHealthOff2 = 0x4;
const DWORD targetMaxHealthOff3 = 0x6C;

// Target Armor + Offsets (return float)
const DWORD targetArmorBase = 0x16A985C;
const DWORD targetArmorOff1 = 0x8;
const DWORD targetArmorOff2 = 0x14;
const DWORD targetArmorOff3 = 0x6C;

LPCTSTR gameWindowName = "League of Legends (TM) Client"; // ALSO CHECK "League of Legends (TM) Client (32 bit)"
HWND hGameWindow = NULL; 
DWORD dwProcID = NULL;
HANDLE hProcHandle = NULL;


DWORD_PTR functionF(DWORD dwProcID, TCHAR *szModuleName, int z, int a, int b){
    HANDLE hiddenSnapShitForever = CreateToolhelp32Snapshot(TH32CS_SNAPMODULE | TH32CS_SNAPMODULE32, dwProcID);
    DWORD_PTR baseModuleAddressHiddenAwayForever = 0;
    if (hiddenSnapShitForever != INVALID_HANDLE_VALUE){
        MODULEENTRY32 moduleHiddenEntryCant;
        moduleHiddenEntryCant.dwSize = sizeof(MODULEENTRY32);
        if (Module32First(hiddenSnapShitForever, &moduleHiddenEntryCant)){
            do{
                if (_tcsicmp(moduleHiddenEntryCant.szModule, szModuleName) == 0){
                    baseModuleAddressHiddenAwayForever = (DWORD_PTR)moduleHiddenEntryCant.modBaseAddr;
                    break;
                }
            } while (Module32Next(hiddenSnapShitForever, &moduleHiddenEntryCant));
        }
        CloseHandle(hiddenSnapShitForever);
    }
    return baseModuleAddressHiddenAwayForever;
}

//-----------------------THIS WILL BE PART OF THE MAIN CODE----------------------------

// Initialize everything
JNIEXPORT jint JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__I (JNIEnv *env, jobject thisObj, jint z) {
    hGameWindow = NULL;
    while(hGameWindow == NULL){
   		hGameWindow = FindWindow(NULL, gameWindowName); 
   		//cout << "Looking for window --> " << "\"" << gameWindowName << "\"" << endl;
	}
	if(hGameWindow){
		GetWindowThreadProcessId(hGameWindow, &dwProcID);
		if(dwProcID != 0){
			hProcHandle = OpenProcess(PROCESS_ALL_ACCESS, FALSE, dwProcID);
			if(hProcHandle == INVALID_HANDLE_VALUE || hProcHandle == NULL){
				return 1;
			}else{
				lolGetter = functionF(dwProcID, lolDLLName, 0, 0, 0);
			}
		}else{
			return 1;
		}
	}else{
		return 1;
	}
	return 0;
}

// Check for window
JNIEXPORT jint JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__II (JNIEnv *env, jobject thisObj, jint z, jint a) {
	HWND hwnd = FindWindow(NULL, gameWindowName);
	if(hwnd){
		CloseHandle(hwnd);
		return 0;
	}else{
		CloseHandle(hwnd);
		return 1;
	}
}

// Close handles
JNIEXPORT void JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__III (JNIEnv *env, jobject thisObj, jint z, jint a, jint b) {
    if(hProcHandle != NULL || hGameWindow != NULL){
    	CloseHandle(hProcHandle);
		CloseHandle(hGameWindow);
    }
}

// get zoom
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c) {
    DWORD returnValue1, returnValue2;
	float zoomValue;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + zoomBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + zoomOff2), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + zoomOff1), &zoomValue, sizeof(float), 0);
	return zoomValue;
}

// write to zoom (the first z argument is the write value)
JNIEXPORT void JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d) {
    DWORD returnValue1, returnValue2;
   	//LPCVOID zVoid = (LPCVOID *)z;
   	float zoomValue = (float)z;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + zoomBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + zoomOff2), &returnValue2, sizeof(DWORD), 0);
	WriteProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + zoomOff1), &zoomValue, sizeof(float), 0);
	//cout << "UPDATED ZOOM TO --> " << zoomValue << endl;
}

// get health
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e) {
    DWORD returnValue1, returnValue2, returnValue3;
	float healthValue;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + healthBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + healthOff3), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + healthOff2), &returnValue3, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue3 + healthOff1), &healthValue, sizeof(float), 0);
	//cout << "Current Health --> " << healthValue << endl;
	return healthValue;
}

// get max health
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e, jint f) {
    DWORD returnValue1, returnValue2, returnValue3;
	float healthValue;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + maxHealthBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + maxHealthOff3), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + maxHealthOff2), &returnValue3, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue3 + maxHealthOff1), &healthValue, sizeof(float), 0);
	//cout << "Max Health --> " << healthValue << endl;
	return healthValue;
}

// get physical damage
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e, jint f, jint g) {
    DWORD returnValue1, returnValue2, returnValue3, returnValue4;
	float physicalDmg;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + physicalDmgBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + physicalDmgOff4), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + physicalDmgOff3), &returnValue3, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue3 + physicalDmgOff2), &returnValue4, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue4 + physicalDmgOff1), &physicalDmg, sizeof(float), 0);
	//cout << "Max Health --> " << healthValue << endl;
	return physicalDmg;
}

// get target health
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIIIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e, jint f, jint g, jint h) {
    DWORD returnValue1, returnValue2, returnValue3;
	float healthValue;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + targetHealthBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + targetHealthOff3), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + targetHealthOff2), &returnValue3, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue3 + targetHealthOff1), &healthValue, sizeof(float), 0);
	//cout << "Max Health --> " << healthValue << endl;
	return healthValue;
}
// get target maxhealth
JNIEXPORT jfloat JNICALL Java_com_kayzio_observer_model_DLLCall_functionF__IIIIIIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e, jint f, jint g, jint h, jint i) {
    DWORD returnValue1, returnValue2, returnValue3;
	float healthValue;
	ReadProcessMemory(hProcHandle, (PBYTE*)(lolGetter + targetMaxHealthBase), &returnValue1, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue1 + targetMaxHealthOff3), &returnValue2, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue2 + targetMaxHealthOff2), &returnValue3, sizeof(DWORD), 0);
	ReadProcessMemory(hProcHandle, (PBYTE*)(returnValue3 + targetMaxHealthOff1), &healthValue, sizeof(float), 0);
	//cout << "Max Health --> " << healthValue << endl;
	return healthValue;
}

// USE AS REFERENCE IN CASE ERROR OCCURE (BECAUSE I DON'T UNDERSTAND C++)
/*
JNIEXPORT void JNICALL Java_Controller_functionF__IIIIIIIIIIIII (JNIEnv *env, jobject thisObj, jint z, jint a, jint b, jint c, jint d, jint e, jint f, jint g, jint h, jint i, jint j, jint k, jint l) {
	pList.infoForP();

	tList* tlist = new tList[mainSize];
	int tLoop = 0;
	for(int i = 0; i < mainSize; i++){
		testList[i].infoForE(i);

		if(testList[i].eT == pList.pT){
			continue;
		}
		if(testList[i].he < 2){
			continue;
		}

		functionF(pList.pos, testList[i].pos, testList[i].a);
		tlist[tLoop] = tList(testList[i].a, pList.pos, testList[i].pos);
		tLoop++;
	}
	if(tLoop > 0){
		std::sort(tlist, tlist+tLoop, helperTA());
		DWORD ang;
		float gAng;
		ReadProcessMemory(hProcHandle, (PBYTE*)(engineGetter + vAng), &ang, sizeof(DWORD), 0);
		ReadProcessMemory(hProcHandle, (PBYTE*)(ang + angOff), &gAng, sizeof(float), 0);
		if(pList.he >= 1 && !std::isnan(gAng) && (gAng >= -88.0f && gAng <= 88.0f)){
			WriteProcessMemory(hProcHandle, (PBYTE*)(ang + angOff), tlist[0].a, 12, 0);
		}
		//std::cout << gAng << std::endl;
	}
	tLoop = 0;
	delete[] tlist;
}
*/