import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Player person;
	private Platform p;

	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		person = new Player(250, 200, 50, 50);
		p = new Platform(150, 250, 200, 20);
	}

	public void draw() {
		clear();
		background(255);
		if (checkKey(RIGHT)) {
			System.out.println("Move Player Right");
		} if (checkKey(LEFT)) {
			System.out.println("Move Player Left");
		} if (checkKey(UP)) {
			System.out.println("Make Player Jump");
		}
		person.draw(this);
		p.draw(this);
	}
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while (checkKey(keyCode))
			keys.remove(new Integer(keyCode));
	}

	private boolean checkKey(int i) {
		return keys.contains(i);
	}
}
