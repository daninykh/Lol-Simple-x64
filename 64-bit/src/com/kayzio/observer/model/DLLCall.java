package com.kayzio.observer.model;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import com.kayzio.observer.dialog.Dialog;

public class DLLCall{
	static{
		try{
			System.loadLibrary("lol64");
		}catch(UnsatisfiedLinkError e){
			e.printStackTrace();
			Platform.runLater(new Runnable(){
				public void run(){
					Dialog.dialog(AlertType.WARNING, "DLL ERROR", null, "Could not load dll.");
					System.exit(-1);
				}
			});	
		}
	}
	// Initialize everything (looks for the active window first with while loop)
	// (return 0 if OKAY)
	private native int functionF(int z); 
	// Check if window is active (return 0 if OKAY)
	private native int functionF(int z, int a);
	// Close handles
	private native void functionF(int z, int a, int b);
	// Get current zoom value
	private native float functionF(int z, int a, int b, int c);
	// Set current zoom value
	private native void functionF(int z, int a, int b, int c, int d);
	// Get current health value
	private native float functionF(int z, int a, int b, int c, int d, int e);
	// Get max health value
	private native float functionF(int z, int a, int b, int c, int d, int e, int f);
	// Get physical damage
	private native float functionF(int z, int a, int b, int c, int d, int e, int f, int g);
	// Get target current health
	private native float functionF(int z, int a, int b, int c, int d, int e, int f, int g, int h);
	// Get target max health
	private native float functionF(int z, int a, int b, int c, int d, int e, int f, int g, int h, int i);

	// The main properties of the Singleton design for a object
	private static DLLCall instance = new DLLCall();
	private DLLCall(){}
	public static DLLCall getInstance(){ return instance; }

	public int getWindowAndInitEverything(){
		return functionF(0);
	}
	public int checkForWindow(){
		return functionF(0, 0);
	}
	public void closeHandles(){
		functionF(0, 0, 0);
	}
	public float getZoomValue(){
		return functionF(0, 0, 0, 0);
	}
	public void setZoomValue(int zoomValue){
		functionF(zoomValue, 0, 0, 0, 0);
	}
	public float getHealthValue(){
		return functionF(0, 0, 0, 0, 0, 0);
	}
	public float getMaxHealthValue(){
		return functionF(0, 0, 0, 0, 0, 0, 0);
	}
	public float getPhysicalDamage(){
		return functionF(0, 0, 0, 0, 0, 0, 0, 0);
	}
	public float getTargetCurrentHealth(){
		return functionF(0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	public float getTargetMaxHealth(){
		return functionF(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

}