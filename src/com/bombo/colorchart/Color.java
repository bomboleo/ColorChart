package com.bombo.colorchart;

public class Color {

	private int r;
	private int g;
	private int b;

	public Color(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public Color(int[] rgb) {
		super();
		this.r = rgb[0];
		this.g = rgb[1];
		this.b = rgb[2];
	}
	
	public Color(String color) {
		if(color.startsWith("#")) {
			color = color.substring(1);
		}
		String r = color.substring(0, 2);
		String g = color.substring(2, 4);
		String b = color.substring(4, 6);
		this.r = Integer.parseInt(r, 16);
		this.g = Integer.parseInt(g, 16);
		this.b = Integer.parseInt(b, 16);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public Color hueVariate(float d) {
		float[] hsv = ColorUtils.rgb2hsv(this.r, this.g, this.b);
		hsv[0] = (hsv[0]*(1+d))%360;
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}
	
	public Color hueVariateAngle(float angle) {
		float[] hsv = ColorUtils.rgb2hsv(this.r, this.g, this.b);
		hsv[0] = (hsv[0]+angle);
		if(hsv[0] < 0) hsv[0] += 360;
		hsv[0] = hsv[0]%360;
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}
	
	public Color saturationVariate(float d) {
		float[] hsv = ColorUtils.rgb2hsv(this.r, this.g, this.b);
		hsv[1] = hsv[1]*(1+d);
		hsv[1] = Math.max(0, hsv[1]);
		hsv[1] = Math.min(1, hsv[1]);
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}
	
	public Color valueVariate(float d) {
		float[] hsv = ColorUtils.rgb2hsv(this.r, this.g, this.b);
		hsv[2] = hsv[2]*(1+d);
		hsv[2] = Math.max(0, hsv[2]);
		hsv[2] = Math.min(1, hsv[2]);
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}
	
	public Color lightVariate(float d) {
		float[] hsl = ColorUtils.rgb2hsl(this.r, this.g, this.b);
		hsl[2] = hsl[2]*(1+d);
		hsl[2] = Math.max(0, hsl[2]);
		hsl[2] = Math.min(1, hsl[2]);
		return new Color(ColorUtils.hsl2rgb(hsl[0], hsl[1], hsl[2]));
	}
	
	public Color getPastel(float saturation) {
		float[] hsv = ColorUtils.rgb2hsv(this.r, this.g, this.b);
		hsv[2] = 0.8f;
		hsv[1] = saturation;
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}
	
	public Color mix(Color toMixWith) {
		return new Color((r+toMixWith.getR())/2, (g+toMixWith.getG())/2, (b+toMixWith.getB())/2);
	}
	
	public Color whiteMix() {
		return new Color(255, 255, 255);
	}
	
	public String toHexString() {
		return ("#"+Integer.toHexString(r)+Integer.toHexString(g)+Integer.toHexString(b)).toUpperCase();
	}
	
	public Color getOpposite() {
		return new Color(256-r, 256-g, 256-b);
	}
	
	public Color blackOrWhite() {
		float[] hsl = ColorUtils.rgb2hsl(this.r, this.g, this.b);
		if(hsl[2]<0.5) return new Color(255, 255, 255);
		else return new Color(0, 0, 0);
	}

}
