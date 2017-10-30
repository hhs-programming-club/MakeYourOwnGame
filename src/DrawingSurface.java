import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import processing.core.*;
import processing.event.MouseEvent;
/**
 * 
 * @author Lily Li and Yash Bengali
 *
 */
public class DrawingSurface extends PApplet {
	private ArrayList<Integer> keys;
	private static ArrayList<Bullet> bullets;
	private Player player1;
	private Player player2;
	//	private Barrier p;

	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		player1 = new Player(250, 400, 50, 50, Color.MAGENTA);
		player2 = new Player(250,50,50,50, Color.GREEN);
		//		p = new Barrier(225,200,50,100);
		bullets = new ArrayList<Bullet>();
	}

	public void draw() {
		clear();
		background(255);

		if (checkKey(RIGHT)) {
			player1.setDirection(Player.PLAYER_RIGHT);
			player1.move();
		} if (checkKey(LEFT)) {
			player1.setDirection(Player.PLAYER_LEFT);
			player1.move();
		} if (checkKey(UP)) {
			player1.setDirection(Player.PLAYER_UP);
			player1.move();
		} if (checkKey(DOWN)) {
			player1.setDirection(Player.PLAYER_DOWN);
			player1.move();
		}

		if (checkKey(87)) { //W key
			player2.setDirection(Player.PLAYER_UP);
			player2.move();
		} 
		if (checkKey(65)) { //A
			player2.setDirection(Player.PLAYER_LEFT);
			player2.move();
		} if (checkKey(83)) { //S
			player2.setDirection(Player.PLAYER_DOWN);
			player2.move();
		} if (checkKey(68)) { //D
			player2.setDirection(Player.PLAYER_RIGHT);
			player2.move();
		}

		player1.draw(this);
		player2.draw(this);

		for(Bullet b: bullets) {
			b.draw(this);
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if(bullet.getX() > width || bullet.getX() < 0 || bullet.getY() > height || bullet.getY() < 0) {
				bullets.remove(i);
			}
		}

	}

	public void keyPressed() {
		keys.add(keyCode);

		if(checkKey(18)) { //OPTION to rotate bullet direction of player1
			player1.setDirection(player1.getDirection() +1);
		}
		if(checkKey(9)) { //TAB to rotate bullet direction of player2
			player2.setDirection(player2.getDirection() +1);
		}
		if (checkKey(16)) { // Shift
			player2.shoot();
			System.out.println("Shoot by Player2");
		}
		if (checkKey(80)) { //p
			player1.shoot();
			System.out.println("Shoot by Player1");
		}

	}

	public void keyReleased() {
		while (checkKey(keyCode))
			keys.remove(new Integer(keyCode));
	}

	private boolean checkKey(int i) {
		return keys.contains(i);
	}

	public static void addBullet(Bullet b) {
		bullets.add(b);
	}

//	public void mousePressed() {
//		//		if (mousePressed && (mouseButton == LEFT)) {
//		//		    fill(0);
//		//		  } else if (mousePressed && (mouseButton == RIGHT)) {
//		//		    fill(255);
//		//		  } else {
//		//			  }
//	}

}
