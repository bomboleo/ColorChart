package com.bombo.colorchart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorUtilsTest {

	@Test
	public void testHSV() {
		for(int r = 0; r < 256; r++) {
			for(int g = 0; g < 256; g++) {
				for(int b = 0; b < 256; b++) {
					float[] hsv = ColorUtils.rgb2hsv(r, g, b);
					int[] rgb = ColorUtils.hsv2rgb(hsv[0], hsv[1], hsv[2]);
					assertEquals("Wrong value for red at [" + r + ", " + g + ", " + b +"]", rgb[0], r, 1);
					assertEquals("Wrong value for green at [" + r + ", " + g + ", " + b +"]", rgb[1], g, 1);
					assertEquals("Wrong value for blue at [" + r + ", " + g + ", " + b +"]", rgb[2], b, 1);
				}
			}
		}
	}
	
	@Test
	public void testHSL() {
		for(int r = 0; r < 256; r++) {
			for(int g = 0; g < 256; g++) {
				for(int b = 0; b < 256; b++) {
					float[] hsl = ColorUtils.rgb2hsl(r, g, b);
					int[] rgb = ColorUtils.hsl2rgb(hsl[0], hsl[1], hsl[2]);
					assertEquals("Wrong value for red at [" + r + ", " + g + ", " + b +"]", rgb[0], r, 1);
					assertEquals("Wrong value for green at [" + r + ", " + g + ", " + b +"]", rgb[1], g, 1);
					assertEquals("Wrong value for blue at [" + r + ", " + g + ", " + b +"]", rgb[2], b, 1);
				}
			}
		}
	}

}
