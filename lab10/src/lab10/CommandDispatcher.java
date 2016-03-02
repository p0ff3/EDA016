package lab10;

import se.lth.cs.window.SimpleWindow;
import se.lth.cs.ptdc.shapes.Shape;

class CommandDispatcher {
	private SimpleWindow w;
	private ShapeList shapes;

	public CommandDispatcher(SimpleWindow w, ShapeList shapes) {
		this.w = w;
		this.shapes = shapes;
	}

	public void mainLoop() {
		while (true) {
			// användaren klickar på en figur
			w.waitForMouseClick();
			Shape newShape = shapes.findHit(w.getMouseX(), w.getMouseY());
			if(newShape == null){
				continue;
			}
			// användaren klickar på en ny position
			w.waitForMouseClick();
			newShape.moveToAndDraw(w, w.getMouseX(), w.getMouseY());
			// figuren flyttas till den nya positionen
		}
	}
}