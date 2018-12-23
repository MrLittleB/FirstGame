package shootBird;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame{
	Image bgImg = GameUtil.getImage("Image/Background.png");
	Image birdImg = GameUtil.getImage("Image/niao1.png");
	Image cannonImg = GameUtil.getImage("Image/大炮.png");
	
	Image offScreenImage = null; //双缓冲用
	
	Bird bird1 = new Bird(birdImg, 300, 400);
	Bird bird2 = new Bird(birdImg, 300, 300);
	Bird bird3 = new Bird(birdImg, 300, 200);
	Cannon cannon = new Cannon(cannonImg, 456, 462, 10);
	
	static int count = 0;
	
	
	public void launchFrame() {
		setTitle("打鸟游戏");
		setVisible(true);
		setSize(1000,562);
		setLocation(0,0);
		addKeyListener(new KeyMonitor());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		 new PaintThread().start(); 
	}
	
	////////////双缓冲，解决闪烁问题
	public void update(Graphics g) {
        if(offScreenImage == null)
                  offScreenImage = this.createImage(1000,562);//这是游戏窗口的宽度和高度
        
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);

}       
	
	public void paint(Graphics g) {
		g.drawImage(bgImg, 0, 0, null);
        bird1.drawMySelf(g);
        bird2.drawMySelf(g);
        bird3.drawMySelf(g);
        cannon.DrawMySelf(g);
	}

	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
			repaint();
			try {
				Thread.sleep(40);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}
		
	
	
	////////键盘监听
	class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			cannon.addDrection(e);
		}
		
		public void keyReleased(KeyEvent e) {
			cannon.minusDrection(e);
		}
	}
	
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}

}
