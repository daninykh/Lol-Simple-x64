package com.kayzio.observer.model.health;

import java.util.ArrayList;
import javafx.scene.control.Alert.AlertType;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.*;

import com.kayzio.observer.model.DLLCall;
import com.kayzio.observer.dialog.Dialog;
import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public abstract class Health implements Subject {

	public DLLCall dllCall;
	private ArrayList<Observer> observerList;
	public FloatProperty healthProperty = new SimpleFloatProperty(1.0f);

	public Health(){
		observerList = new ArrayList<Observer>();
		dllCall = DLLCall.getInstance();

		initListeners();
	}

	private void initListeners(){
		healthProperty.addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				notifyObservers();
			}
		});
	}

	public float getHealthValue(){
		return healthProperty.get();
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
		return getHealthValue();
	}

}