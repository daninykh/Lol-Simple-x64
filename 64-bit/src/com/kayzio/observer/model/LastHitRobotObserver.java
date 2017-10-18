package com.kayzio.observer.model;

import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.*;

import com.kayzio.observer.dialog.Dialog;
import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class LastHitRobotObserver implements Observer{

	private Robot robot;
	private DLLCall dllCall;
	private Subject subject;

	public LastHitRobotObserver(){
		try{
			robot = new Robot();
		}catch(Exception e){
			Platform.runLater(new Runnable(){
				public void run(){
					Dialog.dialog(AlertType.WARNING, "AWTException", null, "Robot could not be instantiated... exiting.");
					System.exit(-1);
				}
			});
		}	
		dllCall = DLLCall.getInstance();
	}

	@Override
	public void update(){
		float healthValue = (float)subject.getUpdate();
		float physDmg = dllCall.getPhysicalDamage();
		System.out.println(physDmg);
		if(physDmg >= healthValue){
			robot.mousePress(InputEvent.BUTTON3_MASK);
			robot.delay(10);
			robot.mouseRelease(InputEvent.BUTTON3_MASK);
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