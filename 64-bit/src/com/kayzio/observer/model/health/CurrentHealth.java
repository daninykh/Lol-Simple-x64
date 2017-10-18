package com.kayzio.observer.model.health;

public class CurrentHealth extends Health{

	public CurrentHealth(){ 
		super();
	}

	public void updatePlayerHealth(){
		healthProperty.set(dllCall.getHealthValue());
	}

}