package lab10;

import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape {
	private int side;
	public Triangle(int x, int y, int side){
		super(x,y);
		this.side = side;
	}
	
	public void draw(SimpleWindow w){
		w.moveTo(x, y);
		w.lineTo(x+side/2, y-(int)Math.sqrt(((side*side) - (side/2)*(side/2))));
		w.lineTo(x+side, y);
		w.lineTo(x,y);
	}
}
