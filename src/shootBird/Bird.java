package shootBird;


import java.awt.Graphics;
import java.awt.Image;

public class Bird extends GameObject {
	public void drawMySelf(Graphics g) {
		super.drawMySelf(g);
		this.x = this.x + 3;
	}
	
	public Bird(Image img, double x, double y) {
		super(img, x, y);
	}
}
