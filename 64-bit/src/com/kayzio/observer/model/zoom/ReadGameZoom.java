package com.kayzio.observer.model.zoom;

import java.util.ArrayList;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.*;

import com.kayzio.observer.model.DLLCall;
import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class ReadGameZoom implements Subject{

	private FloatProperty zoomValue = new SimpleFloatProperty(1.0f);

	private ArrayList<Observer> observerList;
	private DLLCall dllCall;

	public ReadGameZoom(){ 
		observerList = new ArrayList<Observer>(); 
		dllCall = DLLCall.getInstance();

		initListeners();
	}
	private void initListeners(){
		zoomValue.addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				notifyObservers();
			}
		});
	}

	private float getZoomValue(){
		return zoomValue.get();
	}

	public void updateZoomValue(){
		zoomValue.set(dllCall.getZoomValue());
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
		return getZoomValue();
	}

}