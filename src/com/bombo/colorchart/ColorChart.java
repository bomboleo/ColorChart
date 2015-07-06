package com.bombo.colorchart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColorChart {

	private Map<Color, List<Color>> hueVariationbase;
	private Map<Color, List<Color>> lightVariationbase;
	private Map<Color, List<Color>> saturationVariationbase;
	private Map<Color, List<Color>> valueVariationbase;
	private Map<Color, List<Color>> pastelBase;
	private Map<Color, List<Color>> tintShadeBase;
	private Map<Color, List<Color>> complementaryBase;
	private Color[] baseColors;
	private int variations;
	private float delta;
	
	public ColorChart(int variations, float delta, Color... baseColors) {
		this.variations = variations;
		this.delta = delta;
		this.baseColors = baseColors;
		this.hueVariationbase = new HashMap<Color, List<Color>>();
		this.lightVariationbase = new HashMap<Color, List<Color>>();
		this.saturationVariationbase = new HashMap<Color, List<Color>>();
		this.valueVariationbase = new HashMap<Color, List<Color>>();
		this.pastelBase = new HashMap<Color, List<Color>>();
		this.tintShadeBase = new HashMap<Color, List<Color>>();
		this.complementaryBase = new HashMap<Color, List<Color>>();
		generateHueVariations();
		generateLightVariations();
		generateSaturationVariations();
		generateValueVariations();
		generatePastelBase();
		generateTintShade();
		generateComplementary();
	}
	
	private void generateHueVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.hueVariate(i*delta));
			}
			hueVariationbase.put(color, variations);
		}
	}
	
	private void generateLightVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.lightVariate(i*delta));
			}
			lightVariationbase.put(color, variations);
		}
	}
	
	private void generateSaturationVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.saturationVariate(i*delta));
			}
			saturationVariationbase.put(color, variations);
		}
	}
	
	private void generateValueVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.valueVariate(i*delta));
			}
			valueVariationbase.put(color, variations);
		}
	}
	
	private void generatePastelBase() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.getPastel(0.2f+i*(0.3f/this.variations)));
			}
			pastelBase.put(color, variations);
		}
	}
	
	private void generateTintShade() {
		int s = Math.floorDiv(variations, 2);
		int e = s + variations +1;
		for(Color color : baseColors) {
			List<Color> variations = new ArrayList<>();
			for(int i = s; i < e; i++) {
				variations.add(color.mix(new Color((256/this.variations)*(i-s), (256/this.variations)*(i-s), (256/this.variations)*(i-s))));
			}
			tintShadeBase.put(color, variations);
		}
	}
	
	private void generateComplementary() {
		for(Color color : baseColors) {
			int r = color.getR();
			int g = color.getG();
			int b = color.getB();
			int c1 = (255-r)/this.variations;
			int c2 = (255-g)/this.variations;
			int c3= (255-b)/this.variations;
			List<Color> cBase = new ArrayList<>();
			for(int i = 1; i <= this.variations; i++) {
				cBase.add(new Color(c1, c2, c3));
			}
			complementaryBase.put(color, cBase);
		}
	}
	
	public Set<Map.Entry<Color, List<Color>>> getHueVariations() {
		return hueVariationbase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getLightVariations() {
		return lightVariationbase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getSaturationVariations() {
		return saturationVariationbase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getValueVariations() {
		return valueVariationbase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getPastelBase() {
		return pastelBase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getTintShadeBase() {
		return tintShadeBase.entrySet();
	}
	
	public Set<Map.Entry<Color, List<Color>>> getComplementaryBase() {
		return complementaryBase.entrySet();
	}
	
	public Color[] getBaseColor() {
		return baseColors;
	}

}
