package com.kayzio.observer;

import com.kayzio.observer.dialog.Dialog;
import com.kayzio.observer.model.*;
import com.kayzio.observer.view.*;

import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class LolSimple extends Application{

	private DLLCall dllCall = DLLCall.getInstance();
	private View view;
	private Model model;

	public LolSimple(){
		view = new View();
		model = new Model();

		// IS GAME ACTIVE
		model.getCheckForGame().register(view.getCheckForGameObserver());
		view.getCheckForGameObserver().setSubject(model.getCheckForGame());

		// CURR HEALTH
		model.getCurrentHealth().register(view.getCurrentHealthObserver());
		view.getCurrentHealthObserver().setSubject(model.getCurrentHealth());
		// MAX HEALTH
		model.getMaxHealth().register(view.getMaxHealthObserver());
		view.getMaxHealthObserver().setSubject(model.getMaxHealth());
		// TARGET HEALTH
		model.getTargetCurrentHealth().register(view.getTargetHealthObserver());
		view.getTargetHealthObserver().setSubject(model.getTargetCurrentHealth());
		// TAGET MAX HEALTH
		model.getTargetMaxHealth().register(view.getTargetMaxHealthObserver());
		view.getTargetMaxHealthObserver().setSubject(model.getTargetMaxHealth());

		// READ ZOOM
		model.getReadGameZoom().register(view.getZoomObserver());
		view.getZoomObserver().setSubject(model.getReadGameZoom());
		// WRITE ZOOM
		model.getWriteGameZoom().setSubject(view.getZoomListener());
		view.getZoomListener().register(model.getWriteGameZoom());

		// LISTEN FOR SHIT KEYS
		model.getGlobalKeyListener().register(view.getHealthBarNode());
		model.getGlobalKeyListener().register(view.getTargetHealthBarNode());
		view.getHealthBarNode().setSubject(model.getGlobalKeyListener());
		view.getTargetHealthBarNode().setSubject(model.getGlobalKeyListener());

		// LAST HIT ROBOT
		model.getLastHitRobotObserver().setSubject(view.getTargetHealthSubject());
		view.getTargetHealthSubject().register(model.getLastHitRobotObserver());

		// START CHECKING B1CH
		model.startModelThread();
	}

	@Override
	public void start(Stage stage){
		view.initLolSimpleGui(stage);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			public void handle(WindowEvent e){
				try{
					dllCall.closeHandles();
				}catch(UnsatisfiedLinkError ex){
					Platform.runLater(new Runnable(){
						public void run(){
							Dialog.dialog(AlertType.WARNING, "UnsatisfiedLinkError", null, "Could not close handles from DLL call.");
							System.exit(-1);
						}
					});
				}
				System.out.println("Handles Closed.");
				System.exit(0);
			}
		});
	}

	public static void main(String[] args){
		try{
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.OFF);

			GlobalScreen.registerNativeHook();
		}catch(NativeHookException e){
			Platform.runLater(new Runnable(){
				public void run(){
					Dialog.dialog(AlertType.WARNING, "NativeHookExcepion", null, "Problem registering the native hook.");
					System.exit(-1);
				}
			});
		}

		Application.launch(LolSimple.class, args);
	}	

}