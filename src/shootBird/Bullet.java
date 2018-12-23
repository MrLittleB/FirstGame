package shootBird;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Bullet extends GameObject{
	
	boolean space = false;
	
	public void drawMySelf(double x, double y, Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
		this.changeX((int)x);
	}
	public void drawMySelf(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
		if(space) {
			y-=speed;
		}
	}
	
	public void launch(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			space = true;
			break;
		default:
				break;
		}
	}
	
	public Bullet(Image img, double x, double y, int speed) {
		super(img, x, y);
		this.speed = speed;
	}
	
	public void changeX(int x) {
		this.x = x;
	}
	
	public void init(Image img, double x, double y, int speed) {
		this.img = img;
		this.x = x;
		this.y = y;
		if(img != null) {
			this.width = img.getWidth(null);
			this.height = img.getHeight(null);
		}
		this.speed = speed;
	}

}
