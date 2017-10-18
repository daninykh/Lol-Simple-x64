package com.kayzio.observer.model.health;

public class TargetMaxHealth extends Health{

	public TargetMaxHealth(){ 
		super();
	}

	public void updateTargetMaxHealth(){
		healthProperty.set(dllCall.getTargetMaxHealth());
	}

}