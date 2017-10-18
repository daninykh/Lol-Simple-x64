package com.kayzio.observer.view.zoom;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class ZoomObserver implements Observer {

	private FloatProperty zoomProperty = new SimpleFloatProperty(1.0f);
	private Subject subject;

	public FloatProperty getZoomProperty(){
		return zoomProperty;
	}

	@Override
	public void update(){
		zoomProperty.set((float)subject.getUpdate());
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