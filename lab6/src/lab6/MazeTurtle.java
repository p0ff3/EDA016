package lab6;
import java.util.Scanner;
import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.window.SimpleWindow;
import lab4.Turtle;
/**
 * 
 * @author povel
 * MazeTurtle is designed to find it's way though a maze.
 *
 */
public class MazeTurtle extends Turtle {
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		Maze theMaze = new Maze(scan.nextInt());
		SimpleWindow w = new SimpleWindow(300,300,"PÄR HÅLM");
		MazeTurtle MT = new MazeTurtle(w, theMaze.getXEntry(), theMaze.getYEntry());
		MT.penDown();
		theMaze.draw(w);
		MT.walk(theMaze);
	}
	
	public MazeTurtle(SimpleWindow w, int x, int y) {
		super(w, x, y);
		// TODO Auto-generated constructor stub
		
	}
	
	public void walk(Maze maze){
		while(!maze.atExit(super.getX(), super.getY())){
			if(!maze.wallAtLeft(super.getDirection(), super.getX(), super.getY())){
				super.left(90);
			}
			else if(maze.wallInFront(super.getDirection(), super.getX(), super.getY())){
				super.left(270);
			}
			super.forward(1);
		}
	}
}