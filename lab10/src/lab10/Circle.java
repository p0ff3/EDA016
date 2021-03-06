package lab10;

import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.window.SimpleWindow;

public class Circle extends Shape {
	private int side;

	public Circle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(x + side, y);

		for (int i = 1; i < 360; i++) {
			w.lineTo(x + (int) (side * (Math.cos(Math.toRadians(i)))), y
					+ (int) (side * (Math.sin(Math.toRadians(i)))));
		}
	}

}
