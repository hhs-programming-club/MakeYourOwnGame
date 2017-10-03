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
	public static final int PLAYER_UP = 1;
	public static final int PLAYER_DOWN = 3;
	public static final int PLAYER_RIGHT = 2;
	public static final int PLAYER_LEFT= 4;

	
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
		this.direction = PLAYER_UP;
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
		if(direction == PLAYER_UP) {
			DrawingSurface.addBullet(new Bullet( xPos,  yPos - 30, 5, 90));
		}else if(direction == PLAYER_RIGHT) {
			DrawingSurface.addBullet(new Bullet( xPos + 30,  yPos, 5, 0));
		}else if(direction == PLAYER_DOWN) {			
			DrawingSurface.addBullet(new Bullet( xPos,  yPos + 30, 5, -90));
		}else {
			System.out.println(4);
			DrawingSurface.addBullet(new Bullet( xPos - 30, yPos, 5, 180));
		}
	}
}
