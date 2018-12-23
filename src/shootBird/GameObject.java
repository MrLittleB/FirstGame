package shootBird;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;   //对象图片
	double x,y;  //对象坐标
	int speed;   //运动速度
	int width, height; //矩形区域
	
	
	/////////////绘制自身
	public void drawMySelf(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}
	
	
	/////////////初始化成员变量
	public GameObject(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		if(img != null) {
			this.width = img.getWidth(null);
			this.height = img.getHeight(null);
		}
	}
	
	
	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {
		
	}
	
	///////////返回矩形区域
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width, height);
	}
	

}
