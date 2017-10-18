package com.kayzio.observer.view.health;

import java.util.ArrayList;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.*;

import com.kayzio.observer.model.DLLCall;
import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class TargetHealthSubject implements Subject{

	private float healtValue;
	private ArrayList<Observer> observerList;

	public TargetHealthSubject(){
		observerList = new ArrayList<Observer>();
	}

	public void setHealthValue(float value){
		healtValue = value;
		notifyObservers();
	}

	@Override 
	public void register(Observer observer){
		if(!observerList.contains(observer)){
			observerList.add(observer);
		}
	}
	@Override
	public void unregister(Observer observer){
		observerList.remove(observer);
	}
	@Override
	public void notifyObservers(){
		for(Observer observer: observerList){
			observer.update();
		}
	}
	@Override
	public Object getUpdate(){
		return healtValue;
	}

}