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
		
		hsv[0] = (hsv[0]*d)%360;
		
		return new Color(ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]));
	}

}