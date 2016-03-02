import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Mandelbrot {

	public static void main(String[] args) {
		MandelbrotGUI gui = new MandelbrotGUI();
		boolean isRendered = false;
		Generator Gen = new Generator();

		while (true) {

			switch (gui.getCommand()) {

			case MandelbrotGUI.RENDER:
				isRendered = true;
				System.out.println("Render");
				Gen.render(gui);
				break;

			case MandelbrotGUI.RESET:
				isRendered = false;
				gui.resetPlane();
				gui.clearPlane();
				break;

			case MandelbrotGUI.QUIT:
				System.exit(0);
				System.out.println("Quit");
				break;

			case MandelbrotGUI.ZOOM:
				if (isRendered) {
					gui.clearPlane();
					Gen.render(gui);
				}
				System.out.println("Zoom");
				break;

			/*
			 * case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			 * System.out.println("very high"); break;
			 * 
			 * case MandelbrotGUI.RESOLUTION_HIGH: System.out.println("high");
			 * break;
			 * 
			 * case MandelbrotGUI.RESOLUTION_MEDIUM:
			 * System.out.println("medium"); break;
			 * 
			 * case MandelbrotGUI.RESOLUTION_LOW: System.out.println("low");
			 * break;
			 * 
			 * case MandelbrotGUI.RESOLUTION_VERY_LOW:
			 * System.out.println("very low"); break;
			 * 
			 * case MandelbrotGUI.MODE_BW:
			 * System.out.println("Mode black and white"); break;
			 * 
			 * case MandelbrotGUI.MODE_COLOR: System.out.println("Mode color");
			 * break;
			 */

			}
		}

	}
}
