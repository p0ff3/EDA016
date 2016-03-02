package lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import se.lth.cs.ptdc.shapes.Shape;
import se.lth.cs.window.SimpleWindow;

public class ShapeList {
	private ArrayList<Shape> list;

	public ShapeList() {
		list = new ArrayList<Shape>();
	}
	/**
	 * 
	 * @param path - Path of a text-file with appropriate info regarding shapes.
	 */
	public ShapeList(String path) {
		list = new ArrayList<Shape>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block - För jag är lat
			System.out.println("DET DÄR ÄR FAN INGEN FIL!");
			System.exit(0);
		}

		while (scan.hasNext()) {
			String type = scan.next();
			if (type.equals("S")) {
				insert(new Square(scan.nextInt(), scan.nextInt(), scan.nextInt()));
			} else if (type.equals("T")) {
				insert(new Triangle(scan.nextInt(), scan.nextInt(), scan.nextInt()));
			} else {
				insert(new Circle(scan.nextInt(), scan.nextInt(), scan.nextInt()));
			}
		}
	}

	/** Lägger in figuren s i listan */
	public void insert(Shape s) {
		list.add(s);
	}

	/** Ritar upp figurerna i listan i fönstret w */
	public void draw(SimpleWindow w) {
		for (Shape s : list) {
			s.draw(w);
		}
	}

	/**
	 * Tar reda på en figur som ligger nära punkten xc,yc (null om ingen sådan
	 * figur finns i listan
	 */
	public Shape findHit(int xc, int yc) {
		for (Shape s : list) {
			if (s.near(xc, yc)) {
				return s;
			}
		}
		return null;
	}
}
