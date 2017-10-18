package com.kayzio.observer.model;

import java.lang.Thread;

import com.kayzio.observer.model.zoom.*;
import com.kayzio.observer.model.health.*;
import com.kayzio.observer.Observer;
import com.kayzio.observer.Subject;

public class Model implements Runnable{

	// THREAD
	private Thread modelThread;
	
	// GAME CHECKER
	private CheckForGame checkForGame;

	// HEALTH
	private CurrentHealth currHealth;
	private MaxHealth maxHealth;
	private TargetCurrentHealth targetCurrHealth;
	private TargetMaxHealth targetMaxHealth;

	// ZOOM
	private ReadGameZoom readGameZoom;
	private WriteGameZoom writeGameZoom;

	// GLOBAL KEY LISTENER
	private GlobalKeyListener globalKeyListener;

	// LAST HIT ROBOT
	private LastHitRobotObserver lastHitRobot;

	public Model(){
		checkForGame = new CheckForGame();

		currHealth = new CurrentHealth();
		maxHealth = new MaxHealth();
		targetCurrHealth = new TargetCurrentHealth();
		targetMaxHealth = new TargetMaxHealth();

		readGameZoom = new ReadGameZoom();
		writeGameZoom = new WriteGameZoom();

		globalKeyListener = new GlobalKeyListener();

		lastHitRobot = new LastHitRobotObserver();

		modelThread = new Thread(this);
	}

	// START THREAD
	public void startModelThread(){
		modelThread.start();
	}

	// RETURN MODEL OBJECTS
	public Subject getCheckForGame(){
		return checkForGame;
	}
	public Subject getCurrentHealth(){
		return currHealth;
	}
	public Subject getMaxHealth(){
		return maxHealth;
	}
	public Subject getTargetCurrentHealth(){
		return targetCurrHealth;
	}
	public Subject getTargetMaxHealth(){
		return targetMaxHealth;
	}
	public Subject getReadGameZoom(){
		return readGameZoom;
	}
	public Observer getWriteGameZoom(){
		return writeGameZoom;
	}
	public Subject getGlobalKeyListener(){
		return globalKeyListener;
	}
	public Observer getLastHitRobotObserver(){
		return lastHitRobot;
	}

	@Override
	public void run(){
		checkForGame.getWindowAndInitEverything();
		while(true){
			checkForGame.calculateGameRoute();
			if(checkForGame.getIsGameRunning()){
				currHealth.updatePlayerHealth();
				targetCurrHealth.updateTargetHealth();

				maxHealth.updateMaxPlayerHealth();
				targetMaxHealth.updateTargetMaxHealth();

				readGameZoom.updateZoomValue();
			}
		}
	}

}	