package com.bombo.colorchart;

public class ColorUtils {
	
	public static float[] rgb2hsv(int r, int g, int b) {
		float r1 = ((float)r)/255;
		float g1 = ((float)g)/255;
		float b1 = ((float)b)/255;
		
		float cMax = max(r1, g1, b1);
		float cMin = min(r1, g1, b1);
		
		float delta = cMax - cMin;
		
		float h = 0, s = 0, v = 0;
		
		
		if(delta == 0) {
			h = 0;
		} else if(cMax == r1) {
			h = 60 * (((g1-b1)/delta)%6);
		} else if(cMax == g1) {
			h = 60 * (((b1-r1)/delta)+2);
		} else if(cMax == b1) {
			h = 60 * (((r1-g1)/delta)+4);
		}
		
		if(h < 0) h+=360;
		
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
	
	public static float[] rgb2hsl(int r, int g, int b) {
		float r1 = ((float)r)/255;
		float g1 = ((float)g)/255;
		float b1 = ((float)b)/255;
		
		float cMax = max(r1, g1, b1);
		float cMin = min(r1, g1, b1);
		
		float delta = cMax - cMin;
		
		float h = 0, s = 0, l = 0;
		
		
		if(delta == 0) {
			h = 0;
		} else if(cMax == r1) {
			h = 60 * (((g1-b1)/delta)%6);
		} else if(cMax == g1) {
			h = 60 * (((b1-r1)/delta)+2);
		} else if(cMax == b1) {
			h = 60 * (((r1-g1)/delta)+4);
		}
		
		if(h < 0) h+=360;

		l = (cMax+cMin)/2;
		
		if(delta == 0) {
			s = 0;
		} else {
			s = delta/(1-Math.abs(2*l-1));
		}
		
		return new float[]{h, s, l};
	}
	
	public static int[] hsl2rgb(float h, float s, float l) {
		float c = (1 - Math.abs(2*l-1))*s;
		float x = c * (1 - Math.abs((h / 60)%2 - 1));
		float m = l - c/2;
		
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

}
