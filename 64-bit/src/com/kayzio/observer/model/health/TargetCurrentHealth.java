package com.kayzio.observer.model.health;

public class TargetCurrentHealth extends Health{

	public TargetCurrentHealth(){ 
		super();
	}

	public void updateTargetHealth(){
		healthProperty.set(dllCall.getTargetCurrentHealth());
	}

}