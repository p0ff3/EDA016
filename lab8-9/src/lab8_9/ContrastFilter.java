package lab8_9;

import java.awt.Color;
import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ContrastFilter extends ImageFilter {
	public ContrastFilter(String name) {
		super(name);
	}

	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		int pixels = height * width;
		Color[][] outPixels = new Color[height][width];
		int[] histogram = new int[256];
		short[][] intensity = computeIntensity(inPixels);
		Color grayLevels[] = new Color[256];

		for (int i = 0; i < 256; i++) {
			grayLevels[i] = new Color(i, i, i);
		}

		// Histogram
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				histogram[intensity[i][j]]++;
			}
		}

		// lowCut
		int lowCut = 0;
		int lowCutSum = 0;
		double cutOff = paramValue / 100 * pixels;
		while (lowCutSum < cutOff) {
			lowCutSum += histogram[lowCut];
			lowCut++;
		}

		// highCut
		int highCut = 255;
		int highCutSum = 0;
		while (highCutSum < cutOff) {
			highCutSum += histogram[highCut];
			highCut--;
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (intensity[i][j] <= lowCut) {
					outPixels[i][j] = grayLevels[0];
				} else if (intensity[i][j] >= highCut) {
					outPixels[i][j] = grayLevels[255];
				} else {
					outPixels[i][j] = grayLevels[255
							* (intensity[i][j] - lowCut) / (highCut - lowCut)];
				}
			}
		}
		return outPixels;
	}
}
