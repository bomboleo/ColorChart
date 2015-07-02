package com.bombo.colorchart;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class ColorShow extends Application {

	private GraphicsContext gc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parameters parameters = getParameters();
		List<String> args = parameters.getRaw();

		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		int canvaWidth = 900;
		Canvas canvas = new Canvas(canvaWidth, canvaWidth);

		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}