package com.kayzio.observer.view.health;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class HealthObserver implements Observer {

	private FloatProperty healthProperty = new SimpleFloatProperty(1.0f);
	private Subject subject;

	public FloatProperty getHealthProperty(){
		return healthProperty;
	}

	@Override
	public void update(){
		healthProperty.set((float)subject.getUpdate());
	}
	@Override
	public void setSubject(Subject subject){
		this.subject = subject;
	}
	@Override 
	public Subject getSubject(){
		return subject;
	}

}