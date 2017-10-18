package com.kayzio.observer.view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.value.*;
import javafx.geometry.Pos;

import com.kayzio.observer.view.control.*;
import com.kayzio.observer.view.zoom.*;
import com.kayzio.observer.view.health.*;
import com.kayzio.observer.Observer;
import com.kayzio.observer.Subject;

import org.jnativehook.keyboard.NativeKeyEvent;

public class View {

	/*---- Objects ----*/
	// CHECK GAME SHIT
	private CheckForGameObserver gameObserver;
	// ZOOM SHIT
	private ZoomListener zoomListener;
	private ZoomObserver zoomObserver;
	// HEALTH SHIT
	private HealthObserver currHealthObserver, maxHealthObserver, targetCurrHealthObserver, targetMaxHealthObserver;
	private TargetHealthSubject targetHealthSubject;

	// Application dimensions for node calculations
	private static final int WINDOW_WIDTH = 250;
	private static final int WINDOW_HEIGHT = 150;
	private static final int EDGE_MARGIN = 40;

	// Lol Simple Main Layout
	StackPane root;
	// Lol Simple Before Found Game Layouts
	VBox beforeNodesPane;
	// Lol Simple After Found Game Layouts
	VBox afterNodesPane;

	// Lol Simple Scene
	private Scene mainScene;

	/*	more view controls will be added
		once the basic functionality and
		design pattern is completed.	
	*/
	// Lol Simple No Window Open Label
	private WaitingForGameNode waitingForGameNode;
	// Lol Simple Controls
	private ZoomSliderNode zoomSliderNode;
	private HealthBarNode healthBarNode;
	private HealthBarNode targetHealthBarNode;

	public View(){
		gameObserver = new CheckForGameObserver();

		zoomListener = new ZoomListener();
		zoomObserver = new ZoomObserver();

		currHealthObserver = new HealthObserver();
		targetCurrHealthObserver = new HealthObserver();
		maxHealthObserver = new HealthObserver();
		targetMaxHealthObserver = new HealthObserver();

		healthBarNode = new HealthBarNode(WINDOW_WIDTH, WINDOW_HEIGHT, EDGE_MARGIN, NativeKeyEvent.VC_F1);
		targetHealthBarNode = new HealthBarNode(WINDOW_WIDTH, WINDOW_HEIGHT, EDGE_MARGIN, NativeKeyEvent.VC_F2);

		targetHealthSubject = new TargetHealthSubject();

		initListeners();
	}

	public void initLolSimpleGui(Stage mainStage){
		root = new StackPane();

		beforeNodesPane = new VBox();
		beforeNodesPane.setAlignment(Pos.CENTER);
		afterNodesPane = new VBox();
		afterNodesPane.setAlignment(Pos.CENTER);

		initNodes();

		mainScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		root.getChildren().addAll(beforeNodesPane, afterNodesPane);

		mainStage.setTitle("Lol Simple v2.4.3");
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		mainStage.sizeToScene();
		mainStage.show();

	}

	// INITIALIZE SHIT
	private void initNodes(){
		initWaitingForGameNode();
		initZoomSliderNode();
		initHealthBarNode();
		initTargetHealthBarNode();

		setBeforeGameNodesVisible(true);
		setAfterGameNodesVisible(false);
	}
	private void initListeners(){
		gameObserver.getIsGameRunningProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						if((boolean)newVal){
							setBeforeGameNodesVisible(false);
							setAfterGameNodesVisible(true);
						}else{
							setBeforeGameNodesVisible(true);
							setAfterGameNodesVisible(false);
						}
					}
				});
			}
		});
		zoomObserver.getZoomProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						zoomSliderNode.setZoomValue((float)newVal);
					}
				});
			}
		});

		currHealthObserver.getHealthProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						updatePlayerHealthBar((float)newVal, (float)maxHealthObserver.getHealthProperty().get());
					}
				});
			}
		});
		maxHealthObserver.getHealthProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						updatePlayerHealthBar((float)currHealthObserver.getHealthProperty().get(), (float)newVal);
					}
				});
			}
		});
		targetCurrHealthObserver.getHealthProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						updateTargetHealthBar((float)newVal, (float)targetMaxHealthObserver.getHealthProperty().get());
						if(!targetHealthBarNode.isNodeDisabled()){
							targetHealthSubject.setHealthValue((float)newVal);
						}
					}
				});
			}
		});
		targetMaxHealthObserver.getHealthProperty().addListener(new ChangeListener(){
			public void changed(ObservableValue obs, Object oldVal, Object newVal){
				Platform.runLater(new Runnable(){
					public void run(){
						updateTargetHealthBar((float)targetCurrHealthObserver.getHealthProperty().get(), (float)newVal);
					}
				});
			}
		});
	}

	// HEALTH BAR UPDATERS
	private void updatePlayerHealthBar(float currHealth, float maxHealth){
		synchronized(this){
			if(healthBarNode != null){
				healthBarNode.setLabelText(currHealth + " / " + maxHealth);
				healthBarNode.setProgress(currHealth / maxHealth);
			}
		}
	}
	private void updateTargetHealthBar(float currHealth, float maxHealth){
		synchronized(this){
			if(targetHealthBarNode != null){
				targetHealthBarNode.setLabelText(currHealth + " / " + maxHealth);
				targetHealthBarNode.setProgress(currHealth / maxHealth);
			}
		}
	}

	// SET VISIBILITY
	private void setBeforeGameNodesVisible(boolean bool){
		beforeNodesPane.setVisible(bool);
	}
	private void setAfterGameNodesVisible(boolean bool){
		afterNodesPane.setVisible(bool);
	}

	// INITIALIZE CONTROLS / NODES
	private void initWaitingForGameNode(){
		waitingForGameNode = new WaitingForGameNode(WINDOW_WIDTH, WINDOW_HEIGHT, EDGE_MARGIN);
		beforeNodesPane.getChildren().addAll(waitingForGameNode);
	}
	private void initZoomSliderNode(){
		zoomSliderNode = new ZoomSliderNode(WINDOW_WIDTH, WINDOW_HEIGHT, EDGE_MARGIN);
		zoomSliderNode.setZoomListener(zoomListener);
		afterNodesPane.getChildren().add(zoomSliderNode);
	}
	private void initHealthBarNode(){
		healthBarNode.setTitle("Player Health");
		healthBarNode.setHealthBarColor("green");
		healthBarNode.setStatus(healthBarNode.ENABLE, Color.GREEN);
		afterNodesPane.getChildren().add(healthBarNode);
	}
	public void initTargetHealthBarNode(){
		targetHealthBarNode.setTitle("Target Health");
		targetHealthBarNode.setHealthBarColor("red");
		targetHealthBarNode.setStatus(targetHealthBarNode.ENABLE, Color.GREEN);
		afterNodesPane.getChildren().add(targetHealthBarNode);
	}

	// RETURN OBJECTS
	public Subject getZoomListener(){
		return zoomListener;
	}
	public Observer getZoomObserver(){
		return zoomObserver;
	}
	public Observer getCheckForGameObserver(){
		return gameObserver;
	}
	public Observer getCurrentHealthObserver(){
		return currHealthObserver;
	}
	public Observer getMaxHealthObserver(){
		return maxHealthObserver;
	}
	public Observer getTargetHealthObserver(){
		return targetCurrHealthObserver;
	}
	public Observer getTargetMaxHealthObserver(){
		return targetMaxHealthObserver;
	}
	public Observer getHealthBarNode(){
		return healthBarNode;
	}
	public Observer getTargetHealthBarNode(){
		return targetHealthBarNode;
	}
	public Subject getTargetHealthSubject(){
		return targetHealthSubject;
	}

}