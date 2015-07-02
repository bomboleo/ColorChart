package com.bombo.colorchart;

public class ColorUtils {
	
	public static float[] rgb2hsv(int r, int g, int b) {
		float r2 = ((float)r)/255;
		float g2 = ((float)g)/255;
		float b2 = ((float)b)/255;
		
		float cMax = max(r2, g2, b2);
		float cMin = min(r2, g2, b2);
		
		float delta = cMax - cMin;
		
		float h = 0, s = 0, v = 0;
		
		
		if(delta == 0) {
			h = 0;
		} else if(cMax == r2) {
			h = 60 * ((g2-b2)/delta)%6;
		} else if(cMax == g2) {
			h = 60 * ((b2-r2)/delta)+2;
		} else if(cMax == b2) {
			h = 60 * ((r2-g2)/delta)+4;
		}
		
		if(cMax == 0) {
			s = 0;
		} else {
			s = delta/cMax;
		}
		
		v = cMax;
		
		return new float[]{h, s, v};
	}
	
	public static int[] hsv2rgb(float h, float s, float v) {
		float c = v*s;
		h = h/60;
		float x = c * (1 - Math.abs((h / 60)%2 - 1));
		float m = v - c;
		
		float r1 = 0, g1 = 0, b1 = 0;
		
		if(h <60) {
			r1 = c;g1 = x;b1 = 0;
		} else if(h >= 60 && h < 120) {
			r1 = x;g1 = c;b1 = 0;
		} else if(h >= 120 && h < 180) {
			r1 = 0;g1 = c;b1 = x;
		} else if(h >= 180 && h < 240) {
			r1 = 0;g1 = x;b1 = c;
		} else if(h >= 240 && h < 300) {
			r1 = x;g1 = 0;b1 = c;
		} else if(h >= 300 && h < 360) {
			r1 = c;g1 = 0;b1 = x;
		}
		
		return new int[]{(int) ((r1+m)*255), (int) ((g1+m)*255), (int) ((b1+m)*255)};	
	}
	
	private static float max(float... f) {
		float max = Float.MIN_VALUE;
		for(float n : f) {
			if(max<n) max = n;
		}
		return max;
	}
	
	private static float min(float... f) {
		float min = Float.MAX_VALUE;
		for(float n : f) {
			if(min>n) min = n;
		}
		return min;
	}

}
