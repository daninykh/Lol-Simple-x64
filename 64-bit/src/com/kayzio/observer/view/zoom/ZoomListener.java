package com.kayzio.observer.view.zoom;

import java.lang.Double;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class ZoomListener implements ChangeListener, Subject{

	private double zoomValue = 0.0d;
	private ArrayList<Observer> observerList;

	public ZoomListener(){ observerList = new ArrayList<Observer>(); }
	
	@Override
	public void changed(ObservableValue obs, Object oldVal, Object newVal){
		zoomValue = (double)newVal;
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
		return (int)zoomValue;
	}

}