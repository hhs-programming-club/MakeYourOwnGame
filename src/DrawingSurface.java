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
	private Player player1;
	private Player player2;

	public DrawingSurface() {
		keys = new ArrayList<Integer>();
		player1 = new Player(250, 400, 50, 50, Color.MAGENTA, "player1");
		player2 = new Player(250,50,50,50, Color.GREEN, "player2");
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

		drawBullets(player1);
		drawBullets(player2);
		
		checkWithinBonds(player1);
		checkWithinBonds(player2);
		
		checkCollision(player1, player2.getBulletsArray());
		checkCollision(player2, player1.getBulletsArray());
		
		pushMatrix();
		pushStyle();
		noFill();
		rect(0,0,150,100);
		fill(0, 102, 153);
		textSize(20);
		text(player1.getName() + ":", 20,40);
		text(player1.getHitCount(), 110, 40);
		text(player2.getName() + ":", 20,75);
		text(player2.getHitCount(), 110,75);	
		popMatrix();
		popStyle();
	}
	
	public void drawBullets(Player p) {
		for(Bullet b: p.getBulletsArray()) {
			b.draw(this);
		}
	}
	
	public void checkWithinBonds(Player player) {
		for(int i = 0; i < player.getBulletSize(); i++) {
			Bullet bullet = player.getBullet(i);
			if(bullet.getX() > width || bullet.getX() < 0 || bullet.getY() > height || bullet.getY() < 0) {
				player.deleteBullet(i);
			}
		}
	}
	
	public void checkCollision(Player p, ArrayList<Bullet> bullets) {
		for(int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			System.out.println("player: " + p.getX() + ", " + p.getY() + " bullet: " + b.getX() + ", " + b.getY());

			if(b.getY() >= p.getY() && b.getY() <= p.getY() + p.getHeight()) {
				if(b.getX() >= p.getX() && b.getX() <= p.getX() + width) {
					endSequence(p);
					bullets.remove(b);
					return;
				}
			}
		}
	}
	
	public void endSequence(Player p) {
		p.hit();
	}

	public void keyPressed() {
		keys.add(keyCode);
		
		if (checkKey(16)) { // Shift
			player2.addBullet(player2.shoot());
		}
		if (checkKey(80)) { //p
			player1.addBullet(player1.shoot());
		}

	}

	public void keyReleased() {
		while (checkKey(keyCode))
			keys.remove(new Integer(keyCode));
	}

	private boolean checkKey(int i) {
		return keys.contains(i);
	}
}
