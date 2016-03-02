package lab10;

import se.lth.cs.window.SimpleWindow;

public class ShapeTest {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		ShapeList shapes = new ShapeList("shapedata.txt");
		CommandDispatcher cd = new CommandDispatcher(w, shapes);
		
		/*shapes.insert(new Square(100, 300, 100));
		shapes.insert(new Triangle(400, 200, 100));
		shapes.insert(new Circle(400, 400, 50));
		shapes.insert(new Square(450, 450, 50));
		shapes.insert(new Square(200, 200, 35));
		shapes.draw(w);*/
		shapes.draw(w);
		cd.mainLoop();

	}
}
