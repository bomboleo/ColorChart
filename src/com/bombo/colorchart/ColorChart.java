package com.bombo.colorchart;

import java.util.ArrayList;
import java.util.List;

public class ColorChart {

	private List<Color> analogous;
	private List<Color> lightVariationbase;
	private List<Color> saturationVariationbase;
	private List<Color> valueVariationbase;
	private List<Color> pastelBase;
	private List<Color> tintShadeBase;
	private Color complementary;
	private Color[] triadic;
	private Color[] tetradic;
	private Color[] square;
	private Color[] splitComplementary;
	private Color baseColor;
	private int variations;
	private float delta;

	public ColorChart(int variations, float delta, Color baseColor) {
		this.variations = variations;
		this.delta = delta;
		this.baseColor = baseColor;
		this.analogous = new ArrayList<Color>();
		this.lightVariationbase = new ArrayList<Color>();
		this.saturationVariationbase = new ArrayList<Color>();
		this.valueVariationbase = new ArrayList<Color>();
		this.pastelBase = new ArrayList<Color>();
		this.tintShadeBase = new ArrayList<Color>();
		this.triadic = new Color[3];
		this.tetradic = new Color[4];
		this.square = new Color[4];
		this.splitComplementary = new Color[3];
		generateAnalogous();
		generateLightVariations();
		generateSaturationVariations();
		generateValueVariations();
		generatePastelBase();
		generateTintShade();
		generateComplementary();
		generateTriadic();
		generateSplitComplementary();
		generateTetradic();
		generateSquare();
	}

	private void generateAnalogous() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			analogous.add(baseColor.hueVariateAngle(i*60/variations));
		}
	}

	private void generateLightVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			lightVariationbase.add(baseColor.lightVariate(i * delta));
		}
	}

	private void generateSaturationVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			saturationVariationbase.add(baseColor.saturationVariate(i * delta));
		}
	}

	private void generateValueVariations() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			valueVariationbase.add(baseColor.valueVariate(i * delta));
		}
	}

	private void generatePastelBase() {
		int s = -Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			pastelBase.add(baseColor.getPastel(0.2f + i * (0.3f / this.variations)));
		}
	}

	private void generateTintShade() {
		int s = Math.floorDiv(variations, 2);
		int e = s + variations + 1;
		for (int i = s; i < e; i++) {
			tintShadeBase.add(baseColor.mix(new Color((256 / this.variations) * (i - s), (256 / this.variations) * (i - s),
					(256 / this.variations) * (i - s))));
		}
	}
	
	private void generateTriadic() {
		triadic[0] = baseColor.hueVariateAngle(-120);
		triadic[1] = baseColor;
		triadic[2] = baseColor.hueVariateAngle(120);
	}

	private void generateComplementary() {
		complementary = baseColor.hueVariateAngle(180);
	}
	
	private void generateSplitComplementary() {
		splitComplementary[0] = baseColor.hueVariateAngle(-150);
		splitComplementary[1] = baseColor;
		splitComplementary[2] = baseColor.hueVariateAngle(150);
	}
	
	private void generateTetradic() {
		tetradic[0] = baseColor;
		tetradic[1] = baseColor.hueVariateAngle(60);
		tetradic[2] = baseColor.hueVariateAngle(180);
		tetradic[3] = tetradic[2].hueVariateAngle(60);
	}
	
	private void generateSquare() {
		square[0] = baseColor;
		square[1] = baseColor.hueVariateAngle(90);
		square[2] = baseColor.hueVariateAngle(180);
		square[3] = baseColor.hueVariateAngle(270);
	}

	public List<Color> getAnalogous() {
		return analogous;
	}

	public List<Color> getLightVariationbase() {
		return lightVariationbase;
	}

	public List<Color> getSaturationVariationbase() {
		return saturationVariationbase;
	}

	public List<Color> getValueVariationbase() {
		return valueVariationbase;
	}

	public List<Color> getPastelBase() {
		return pastelBase;
	}

	public List<Color> getTintShadeBase() {
		return tintShadeBase;
	}

	public Color getComplementary() {
		return complementary;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public int getVariations() {
		return variations;
	}

	public float getDelta() {
		return delta;
	}
	
	public Color[] getTriadic() {
		return triadic;
	}
	public Color[] getTetradic() {
		return tetradic;
	}
	
	public Color[] getSplitComplementary() {
		return splitComplementary;
	}
	
	public Color[] getSquare() {
		return square;
	}

}
