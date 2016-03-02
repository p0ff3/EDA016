import se.lth.cs.ptdc.fractal.MandelbrotGUI;
import java.awt.Color;

public class Generator {
	public void render(MandelbrotGUI gui) {

		gui.disableInput();
		int pixelHeight = 1;
		String text = gui.getExtraText();
		int maxIterations;

		try {
			maxIterations = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			maxIterations = 200;
		}

		switch (gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			pixelHeight = 1;
			System.out.println("Very high");
			break;

		case MandelbrotGUI.RESOLUTION_HIGH:
			pixelHeight = 3;
			System.out.println("High");
			break;

		case MandelbrotGUI.RESOLUTION_MEDIUM:
			pixelHeight = 5;
			System.out.println("medium");
			break;

		case MandelbrotGUI.RESOLUTION_LOW:
			pixelHeight = 7;
			System.out.println("low");
			break;

		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			pixelHeight = 9;
			System.out.println("Very low");
			break;

		}

		Complex[][] complex = mesh(gui.getMinimumReal(), gui.getMaximumReal(),
				gui.getMinimumImag(), gui.getMaximumImag(), gui.getWidth(),
				gui.getHeight());
		Color[][] picture;

		// Switch för color mode.
		if (gui.getMode() == MandelbrotGUI.MODE_COLOR) {
			picture = colorMatrix(gui.getHeight(), gui.getWidth(), complex,
					pixelHeight, maxIterations);
		} else {
			picture = blackAndWhiteMatrix(gui.getHeight(), gui.getWidth(),
					complex, pixelHeight, maxIterations);

		}

		gui.putData(picture, pixelHeight, pixelHeight);
		gui.enableInput();

	}

	private Color[][] blackAndWhiteMatrix(int height, int width,
			Complex[][] complex, int pixelHeight, int maxIterations) {

		Color[][] picture = new Color[height / pixelHeight][width / pixelHeight];

		for (int i = 0; i < height / pixelHeight; i++) {

			for (int r = 0; r < width / pixelHeight; r++) {
				// För att hantera resolution.
				int complexi = i * pixelHeight + pixelHeight / 2;
				int complexr = r * pixelHeight + pixelHeight / 2;

				if (converges(complex[complexi][complexr], maxIterations) == maxIterations) {
					picture[i][r] = Color.black;
				} else {
					picture[i][r] = Color.white;
				}

			}

		}

		return picture;
	}

	private Color[][] colorMatrix(int height, int width, Complex[][] complex,
			int pixelHeight, int maxIterations) {

		Color[] colors = new Color[200];
		for (int i = 0; i < 200; i++) {
			colors[i] = new Color(56 + i, 0, 0);
		}

		Color[][] picture = new Color[height / pixelHeight][width / pixelHeight];

		for (int i = 0; i < height / pixelHeight; i++) {

			for (int r = 0; r < width / pixelHeight; r++) {
				// För att hantera resolution.
				int complexi = i * pixelHeight + pixelHeight / 2;
				int complexr = r * pixelHeight + pixelHeight / 2;

				if (converges(complex[complexi][complexr], maxIterations) == maxIterations) {
					picture[i][r] = Color.black;
				} else {
					picture[i][r] = colors[converges(
							complex[complexi][complexr], 199)];
				}

			}

		}

		return picture;
	}

	private Complex[][] mesh(double minRe, double maxRe, double minIm,
			double maxIm, int width, int height) {

		Complex[][] matrix = new Complex[height][width];

		double reRaise = ((maxRe - minRe) / (width - 1));
		double imRaise = ((maxIm - minIm) / (height - 1));

		for (int i = 0; i < height; i++) {
			for (int r = 0; r < width; r++) {
				matrix[i][r] = new Complex(minRe + reRaise * r, maxIm - imRaise
						* i);
			}
		}

		return matrix;

	}

	private int converges(Complex c, int maxIterations) {
		Complex z = new Complex(0, 0);

		for (int i = 0; i < maxIterations; i++) {
			z.mult(z);
			z.add(c);
			if (z.getAbs2() > 4) {
				return i;
			}
		}

		return maxIterations;

	}

}
