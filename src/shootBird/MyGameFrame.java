package shootBird;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame{
	Image bgImg = GameUtil.getImage("Image/Background.png");
	Image birdImg = GameUtil.getImage("Image/niao1.png");
	
	Image offScreenImage = null; //双缓冲用
	
	Bird bird = new Bird(birdImg, 300, 300);
	
	static int count = 0;
	
	
	public void launchFrame() {
		setTitle("打鸟游戏");
		setVisible(true);
		setSize(1000,562);
		setLocation(0,0);
		
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
		System.out.println("调用paint，重画窗口，次数："+(count++));
        bird.drawMySelf(g);
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
		
	
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}

}
