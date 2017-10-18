package com.kayzio.observer.model.health;

public class MaxHealth extends Health{

	public MaxHealth(){ 
		super();
	}

	public void updateMaxPlayerHealth(){
		healthProperty.set(dllCall.getMaxHealthValue());
	}

}