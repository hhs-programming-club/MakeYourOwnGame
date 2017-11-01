import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * 
 * @author Lily Li and Yash Bengali
 *
 */
public class Player {
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int direction; //1 = up, 2 = right, 3 = down, 4 = left
	public static final int PLAYER_UP = 1;
	public static final int PLAYER_DOWN = 3;
	public static final int PLAYER_RIGHT = 2;
	public static final int PLAYER_LEFT= 4;
	public ArrayList<Bullet> bullets;

	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Player(int xPos, int yPos, int width, int height, Color color) {
		this.setX(xPos);
		this.setY(yPos);
		this.width = width;
		this.height = height;
		this.direction = PLAYER_UP;
		this.color = color;
		this.bullets = new ArrayList<Bullet>();
	}
	
	public void addBullet(Bullet bull) {
		bullets.add(bull);
	}
	
	public ArrayList<Bullet> getBulletsArray(){
		return bullets;
	}
	
	public void deleteBullet(int i) {
		bullets.remove(i);
	}
	public Bullet getBullet(int i) {
		return bullets.get(i);
	}
	
	public int getBulletSize() {
		return bullets.size();
	}

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}
	
	public void draw(PApplet canvas) {
		canvas.pushMatrix();
		canvas.pushStyle();
		canvas.fill(color.getRed(), color.getGreen(), color.getBlue());
		canvas.rect(xPos - width/2, yPos - height/2, width, width);
		canvas.fill(0);
		canvas.ellipse(xPos + 15 - width/2, yPos + 17 - height/2, 5, 5);
		canvas.ellipse(xPos + width/2 - 15, yPos + 17 - height/2, 5, 5);
		canvas.arc(xPos , yPos + 25 - height/2, 20, 30, 0,(float)Math.PI);
		canvas.popMatrix();
		canvas.popStyle();
	}
	
	public void move() {
		if(direction == PLAYER_UP)
			setY(getY() - 10);
		else if(direction == PLAYER_DOWN)
			setY(getY() + 10);
		else if(direction == PLAYER_RIGHT) 
			setX(getX() + 10);
		else
			setX(getX() - 10);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Bullet shoot() {
		if(direction == PLAYER_UP) {
			return new Bullet( xPos,  yPos - 30, 5, 90);
		}else if(direction == PLAYER_RIGHT) {
			return new Bullet( xPos + 30,  yPos, 5, 0);
		}else if(direction == PLAYER_DOWN) {			
			return new Bullet( xPos,  yPos + 30, 5, -90);
		}else {
			return new Bullet( xPos - 30, yPos, 5, 180);
		}
	}
}
