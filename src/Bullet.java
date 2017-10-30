import java.awt.Color;

import processing.core.PApplet;
/**
 * 
 * @author Lily Li and Yash Bengali
 *
 */
public class Bullet {
	private int xPos;
	private int yPos;
	private int width;
	private Color color;
	private int velocity;
	private int direction;
	private Player player;
	
	public Bullet(int xPos, int yPos, int width, int direction, Player player) {
		this.setX(xPos);
		this.setY(yPos);
		this.width = width;
		this.color = Color.BLACK;
		this.velocity = 10;
		this.direction = direction;
		this.player = player;
	}

	public int getVelocity() {
		return velocity;
	}
	
	public void setVelocity(int vel) {
		velocity = vel;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int dir) {
		direction = dir;
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
		
		double xMove = velocity*Math.cos(Math.toRadians(direction));
		double yMove = velocity*Math.sin(Math.toRadians(direction));
		
		xPos += xMove;
		yPos -= yMove;
		
		canvas.pushMatrix();
		canvas.pushStyle();
		canvas.fill(color.getRed(), color.getGreen(), color.getBlue());
		canvas.ellipse(xPos, yPos, width, width);
		canvas.popMatrix();
		canvas.popStyle();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Player getPlayer() {
		return player;
	}
}
