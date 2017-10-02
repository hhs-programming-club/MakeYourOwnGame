import processing.core.PApplet;

/**
 * 
 * @author Varun Tandon
 *
 */
public class Player {
	
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int direction; //1 = up, 2 = right, 3 = down, 4 = left
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Player(int xPos, int yPos, int width, int height) {
		this.setX(xPos);
		this.setY(yPos);
		this.width = width;
		this.height = height;
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
		canvas.fill(50);
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void shoot() {
<<<<<<< HEAD
		if(direction == 1) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 90));
		}else if(direction == 2) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 0));

		}else if(direction == 3) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 270));
=======
		if(direction % 4 == 1) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, -90));
		}else if(direction % 4 == 2) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 0));
		}else if(direction % 4 == 3) {			
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 90));
>>>>>>> 1eaab7ea2d3c4417d973015766f681da65f835e2
		}else {
			System.out.println(4);
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 180));
		}
	}
}
