import java.awt.Color;

import processing.core.PApplet;

public class Platform {

	int x = 0;
	int y = 0;
	int width = 0;
	int height = 0;
	boolean drawRect = true;
	public Platform(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		drawRect = true;
	}
	
	/* Initialize platform when you take in an image
	   public Platform(String filename, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		drawRect= false;
	}*/
	
	public void draw(PApplet g) {
		g.pushMatrix();
		g.pushStyle();
		if(drawRect) {
			g.fill(Color.blue.darker().getRGB());
			g.rect(x,y,width,height);
		}
		/* Draw image version of platform
		  else {
			
		}*/
		
		g.popMatrix();
		g.popStyle();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
