import java.util.ArrayList;

import processing.core.*;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private Player player1;
	private Player player2;

	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		player1 = new Player(250, 400, 50, 50);
		player2 = new Player(250,50,50,50);
		
	}

	public void draw() {
		clear();
		background(255);
		if (checkKey(RIGHT)) {
			System.out.println("Move Player1 Right");
		} if (checkKey(LEFT)) {
			System.out.println("Move Player1 Left");
		} if (checkKey(UP)) {
			System.out.println("Move Player1 Up");
		} if (checkKey(DOWN)) {
			System.out.println("Move Player1 Down");
		}
		
		if (checkKey(87)) { //W key
			System.out.println("Move Player1 Up");
		} 
		if (checkKey(65)) { //A
			System.out.println("Move Player1 Left");
		} if (checkKey(83)) { //S
			System.out.println("Move Player1 Down");
		} if (checkKey(68)) { //D
			System.out.println("Move Player1 Right");
		}
		player1.draw(this);
		player2.draw(this);

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
