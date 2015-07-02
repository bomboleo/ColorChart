package com.bombo.colorchart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorChart {
	
	private Map<Color, List<Color>> hueVariationbase;	
	private Color[] baseColors;
	private int hueVariations;
	
	public ColorChart(int hueVariations, Color... baseColors) {
		this.hueVariations = hueVariations;
		this.baseColors = baseColors;
		this.hueVariationbase = new HashMap<Color, List<Color>>();
		
		generateHueVariations();
	}
	
	private void generateHueVariations() {
		for(Color color : baseColors) {
			for(int i = 0; i < hueVariations; i++) {
				
			}
		}
	}

}
