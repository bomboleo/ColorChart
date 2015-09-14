package com.bombo.colorchart;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ColorShow extends Application {

	private GraphicsContext gc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		int canvaWidth = 975;
		Canvas canvas = new Canvas(canvaWidth, canvaWidth);
		
		Color green = new Color("336699");
		
		ColorChart chart = new ColorChart(6, 0.1f, green);

		gc = canvas.getGraphicsContext2D();

		drawChart(gc, canvaWidth, chart);
		
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	private void drawChart(GraphicsContext gc, int canvaWidth, ColorChart chart) {
		float g = 48f/256;
		gc.setFill(javafx.scene.paint.Color.color(g, g, g));
		gc.fillRect(0, 0, canvaWidth, canvaWidth);
		
		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.setFont(Font.font("Calibry", FontWeight.BOLD, 30));
		gc.fillText("Color: ", 10, 30);
		drawColor(chart.getBaseColor(), 100, 5, 75, 30, false);

		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillText("Square scheme", 10, 100);
		
		int y = 2;
		for(Color color : chart.getSquare()) {
			drawColor(color, 10, 60*y, 50, 50, false);
			ColorChart cc = new ColorChart(5, 0.1f, color);
			int x = 1;
			for(Color subColor : cc.getTintShadeBase()) {
				drawColor(subColor, 60*x+10, 60*y, 50, 50, false);
				x++;
			}
			y++;
		}

		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillText("Tetradic scheme", 10, y*60+40);
		y++;
		
		for(Color color : chart.getTetradic()) {
			drawColor(color, 10, 60*y, 50, 50, false);
			ColorChart cc = new ColorChart(5, 0.1f, color);
			int x = 1;
			for(Color subColor : cc.getTintShadeBase()) {
				drawColor(subColor, 60*x+10, 60*y, 50, 50, false);
				x++;
			}
			y++;
		}

		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillText("Split scheme", 10, y*60+40);
		y++;
		
		for(Color color : chart.getSplitComplementary()) {
			drawColor(color, 10, 60*y, 50, 50, false);
			ColorChart cc = new ColorChart(5, 0.1f, color);
			int x = 1;
			for(Color subColor : cc.getTintShadeBase()) {
				drawColor(subColor, 60*x+10, 60*y, 50, 50, false);
				x++;
			}
			y++;
		}
		
		y = 1;
		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillText("Triadic scheme", 490, y*60+40);
		y++;
		
		for(Color color : chart.getTriadic()) {
			drawColor(color, 490, 60*y, 50, 50, false);
			ColorChart cc = new ColorChart(5, 0.1f, color);
			int x = 8;
			for(Color subColor : cc.getTintShadeBase()) {
				drawColor(subColor, 60*x+70, 60*y, 50, 50, false);
				x++;
			}
			y++;
		}
		
		gc.setFill(javafx.scene.paint.Color.WHITE);
		gc.fillText("Analogous scheme", 490, y*60+40);
		y++;
		
		for(Color color : chart.getAnalogous()) {
			drawColor(color, 490, 60*y, 50, 50, false);
			ColorChart cc = new ColorChart(6, 0.1f, color);
			int x = 8;
			for(Color subColor : cc.getTintShadeBase()) {
				drawColor(subColor, 60*x+70, 60*y, 50, 50, false);
				x++;
			}
			y++;
		}
	}
	
	private javafx.scene.paint.Color toJavaFXColor(Color color) {
		return javafx.scene.paint.Color.color((float)color.getR()/256, (float)color.getG()/256, (float)color.getB()/256);
	}
	
	private void drawColor(Color color, double x, double y, double w, double h, boolean text) {
		gc.setFill(toJavaFXColor(color));
		gc.fillRect(x, y, w, h);
		gc.setStroke(javafx.scene.paint.Color.WHITE);
		gc.strokeRect(x, y, w, h);
		if(text) {
			gc.setFill(toJavaFXColor(color.blackOrWhite()));
			gc.fillText(color.toHexString(), x+w/2-25, y+h/2+4);
		}
	}

}