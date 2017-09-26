/**
 * 
 * @author Varun
 *
 */
public class Player {
	
	private int xPos;
	private int yPos;
	
	public Player(int xPos, int yPos) {
		this.setX(xPos);
		this.setY(yPos);
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
	
	
}
