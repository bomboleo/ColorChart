package com.bombo.colorchart;

import java.util.List;
import java.util.Map;

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
		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		int canvaWidth = 920;
		Canvas canvas = new Canvas(canvaWidth, canvaWidth);
		
		Color green = new Color("2BAF49");
		
		ColorChart chart = new ColorChart(7, 0.1f, green);

		gc = canvas.getGraphicsContext2D();

		drawChart(gc, canvaWidth, chart);
		
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	private void drawChart(GraphicsContext gc, int canvaWidth, ColorChart chart) {
		int i = 0;
		int w = 120;
		float g = 48f/256;
		gc.setFill(javafx.scene.paint.Color.color(g, g, g));
		gc.fillRect(0, 0, canvaWidth, canvaWidth);
		for(Map.Entry<Color, List<Color>> kvp : chart.getHueVariations()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Hue", 10+(w+5)*i+w/2-33, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getLightVariations()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Light", 10+(w+5)*i+w/2-35, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getSaturationVariations()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Saturation", 10+(w+5)*i+w/2-50, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getValueVariations()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Value", 10+(w+5)*i+w/2-35, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getPastelBase()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Pastel", 10+(w+5)*i+w/2-40, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getTintShadeBase()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Tint&Shade", 10+(w+5)*i+w/2-57, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
		
		for(Map.Entry<Color, List<Color>> kvp : chart.getComplementaryBase()) {
			gc.setFill(javafx.scene.paint.Color.WHITE);
			gc.fillText(kvp.getKey().toHexString() + " Complementary", 10+(w+5)*i+w/2-65, 20);
			int j = 0;
			for(Color c : kvp.getValue()) {
				drawColor(c, 10+i*(w+5), 30+j*35, w, 30);
				j++;
			}
			i++;
		}
	}	
	
	private javafx.scene.paint.Color toJavaFXColor(Color color) {
		return javafx.scene.paint.Color.color((float)color.getR()/256, (float)color.getG()/256, (float)color.getB()/256);
	}
	
	private void drawColor(Color color, double x, double y, double w, double h) {
		gc.setFill(toJavaFXColor(color));
		gc.fillRect(x, y, w, h);
		gc.setStroke(javafx.scene.paint.Color.WHITE);
		gc.strokeRect(x, y, w, h);
		gc.setFill(toJavaFXColor(color.blackOrWhite()));
		gc.fillText(color.toHexString(), x+w/2-25, y+h/2+4);
	}

}