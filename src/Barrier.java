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
	
	public Platform(String filename, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		drawRect= false;
	}
	
	public void draw(PApplet g) {
		g.pushMatrix();
		g.pushStyle();
		if(drawRect) {
		g.fill(Color.blue.darker().getRGB());
		g.rect(x,y,width,height);}
		else {
			//draww the image 
		}
		
		g.popMatrix();
		g.popStyle();
	}
}
