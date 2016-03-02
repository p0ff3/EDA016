package lab5;
//import lab4.Turtle;
import java.util.Random;
import se.lth.cs.window.SimpleWindow;
import lab5.ColorTurtle;
import java.awt.Color;

public class TwoTurtles {
	public static void main(String[] args){
		SimpleWindow w = new SimpleWindow(700,700,"TwoTurtles");
		ColorTurtle t1 = new ColorTurtle(w, 250, 250, new Color(255,0,0));
		ColorTurtle t2 = new ColorTurtle(w, 350, 350, new Color(0,0,255));
		t1.penDown();
		t2.penDown(); 
		Random r = new Random();
		
		while( Math.hypot((t2.getX() - t1.getX()), (t2.getY() - t1.getY())) >= 50 ){
			SimpleWindow.delay(3);
			t1.forward(r.nextInt(10)+1);
			t1.left(r.nextInt(360)+1);
			t2.forward(r.nextInt(10)+1);
			t2.left(r.nextInt(360)+1);
		}
	}
}