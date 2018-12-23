package shootBird;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Cannon extends GameObject{

	 boolean left, right, space;
	boolean live = true;
	int bulletNum = 0;
	Bullet bullet;
	
	
	public void addDrection(KeyEvent e) {
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
	

	public void drawMySelf(Graphics g) {
		super.drawMySelf(g);
		if(bullet.space) {
			bullet.drawMySelf(g);
			bulletNum++;
			System.out.println(bulletNum);
		}
		else
		{
			bullet.drawMySelf(x, y, g);
		}
		if(left) {
			x-=speed;
		}
		if(right) {
			x+=speed;
		}
	}
	
	public Cannon(Image img, double x, double y, int speed) {
		super(img, x, y);
		Image bulletImg = GameUtil.getImage("Image/ÅÚµ¯.png");
		

		bullet = new Bullet(bulletImg, x,y,20);
		this.speed = speed;
	}

}
