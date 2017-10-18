package com.kayzio.observer.view.control;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.*;

import com.kayzio.observer.Subject;
import com.kayzio.observer.Observer;

public class HealthBarNode extends VBox implements Observer{

	private Subject subject;

	// For making calculations on the dimensions of our controls
	private int windowWidth, windowHeight, edgeMargin;
	private static final int HEALTH_BAR_HEIGHT = 25;

	private int disableKey;
	public static final String ENABLE = "Enabled";
	public static final String DISABLE = "Disabled";

	// Health Title Label to put above the health bar (looks nice)
	private HBox titleBox;
	private Label titleLabel;
	private Label statusLabel;
	// main controls / componenets
	private StackPane healthStackPane;
	private ProgressBar healthBar;
	private Label healthLabel;

	public HealthBarNode(int windowWidth, int windowHeight, int edgeMargin, int keyCode){
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.edgeMargin = edgeMargin;
		disableKey = keyCode;
		
		titleBox = new HBox();
		titleLabel = new Label("Default - ");
		statusLabel = new Label("Default");
		titleBox.getChildren().addAll(titleLabel, statusLabel);

		healthStackPane = new StackPane();
		healthLabel = new Label("0");
		healthBar = new ProgressBar(0.0f);
		healthBar.setMaxWidth(Double.MAX_VALUE);
		healthBar.setMinHeight(healthLabel.getBoundsInLocal().getHeight() + HEALTH_BAR_HEIGHT);

		healthStackPane.getChildren().addAll(healthBar, healthLabel);
		getChildren().addAll(titleBox, healthStackPane);
		setMaxWidth(windowWidth - edgeMargin);
	}

	// TITLE
	public void setTitle(String title){
		titleLabel.setText(title + " - ");
	}
	public void setStatus(String status, Color color){
		statusLabel.setText(status);
		statusLabel.setTextFill(color);
	}
	public String getStatus(){
		return statusLabel.getText();
	}

	// MAIN NODES
	public void setHealthBarColor(String color){
		healthBar.setStyle("-fx-accent: "+color+";");
	}
	public void setProgress(float progress){
		if(healthBar != null){
			healthBar.setProgress(progress);
		}
	}
	public void setLabelText(String text){
		if(healthLabel != null){
			healthLabel.setText(text);
		}
	}
	public void setHealthBarNodeDisable(boolean disable){
		healthBar.setDisable(disable);
	}
	public boolean isNodeDisabled(){
		return healthBar.isDisable();
	}

	@Override
	public void update(){
		Platform.runLater(new Runnable(){
			public void run(){
				int keyCode = (int)subject.getUpdate();
				if(keyCode == disableKey){
					if(getStatus().equals(ENABLE)){
						setStatus(DISABLE, Color.RED);
						healthLabel.setDisable(true);
						setHealthBarNodeDisable(true);
					}else{
						setStatus(ENABLE, Color.GREEN);
						healthLabel.setDisable(false);
						setHealthBarNodeDisable(false);
					}
				}
			}
		});
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