package com.kayzio.observer.model.zoom;

import com.kayzio.observer.model.DLLCall;
import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class WriteGameZoom implements Observer {

	private DLLCall dllCall;
	private Subject subject;

	public WriteGameZoom(){
		dllCall = DLLCall.getInstance();
	}

	@Override
	public void update(){
		int zoomValue = (int)subject.getUpdate();
		if(zoomValue > 2250){
			dllCall.setZoomValue(zoomValue);
			//System.out.println("JAVA ZOOM VALUE --> " + zoomValue);
		}
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