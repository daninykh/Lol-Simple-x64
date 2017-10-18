package com.kayzio.observer.view.control;

import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.beans.value.*;

public class ZoomSliderNode extends GridPane{

	// DIMENSIONS FOR NODE CALCULATIONS
	private int windowWidth, windowHeight, edgeMargin;

	// DEFAULT SLIDER VALUES
	private static final int MIN_ZOOM_VALUE = 1000;
	private static final int MAX_ZOOM_VALUE = 6000;
	private static final int DEFAULT_ZOOM = 2250;

	// MAIN COMPONENTS / NODES
	private Label zoomLabel;
	private Slider zoomSlider;

	public ZoomSliderNode(int windowWidth, int windowHeight, int edgeMargin){
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		this.edgeMargin = edgeMargin;

		zoomLabel = new Label("Zoom");
		zoomSlider = new Slider(MIN_ZOOM_VALUE, MAX_ZOOM_VALUE, DEFAULT_ZOOM);
		zoomSlider.setMajorTickUnit(2000);
		zoomSlider.setShowTickLabels(true);
		zoomSlider.setShowTickMarks(true);

		setHgrow(zoomSlider, Priority.ALWAYS);
		setValignment(zoomLabel, VPos.TOP);

		add(zoomLabel, 0, 0, 1, 1);
		add(zoomSlider, 1, 0, 1, 1);
		setMaxWidth(windowWidth - edgeMargin);
	}

	public void setZoomListener(ChangeListener listener){
		zoomSlider.valueProperty().addListener(listener);
	}
	public void setZoomValue(float value){
		synchronized(this){
			zoomSlider.setValue((double)value);
		}
	}

}