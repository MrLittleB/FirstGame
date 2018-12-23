package shootBird;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Cannon extends GameObject{
	static boolean left, right;
	boolean live = true;
	
	public void addDrection(KeyEvent e) {
		System.out.println(e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
            right = true;
            break;
		default:
            break;
		}
	}
	
	public void minusDrection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		default:
				break;
				
		}
	}
	
	public void DrawMySelf(Graphics g) {
		super.drawMySelf(g);
		if(left) {
			x-=speed;
		}
		if(right) {
			x+=speed;
		}
	}
	
	public Cannon(Image img, double x, double y, int speed) {
		super(img, x, y);
		this.speed = speed;
	}

}
