import processing.core.PApplet;

public class Bullet {
	private int xPos;
	private int yPos;
	private int width;
	
	private int velocity;
	private int direction;
	
	public Bullet(int xPos, int yPos, int width, int direction) {
		this.setX(xPos);
		this.setY(yPos);
		this.width = width;
		
		this.velocity = 10;
		
		this.direction = direction;
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
		
		double xMove = Math.sin(Math.toRadians(direction));
		double yMove = Math.cos(Math.toRadians(direction));
		
		xPos += xMove;
		yPos += yMove;
		
		canvas.pushMatrix();
		canvas.pushStyle();
		canvas.fill(255, 0, 0);
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
}
