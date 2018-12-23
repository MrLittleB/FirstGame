package shootBird;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame{
	Image bgImg = GameUtil.getImage("Image/Background.png");
	Image birdImg = GameUtil.getImage("Image/niao1.png");
	
	Image offScreenImage = null; //˫������
	
	Bird bird = new Bird(birdImg, 300, 300);
	
	static int count = 0;
	
	
	public void launchFrame() {
		setTitle("������Ϸ");
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
	
	////////////˫���壬�����˸����
	public void update(Graphics g) {
        if(offScreenImage == null)
                  offScreenImage = this.createImage(1000,562);//������Ϸ���ڵĿ�Ⱥ͸߶�
        
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);

}       
	
	public void paint(Graphics g) {
		g.drawImage(bgImg, 0, 0, null);
		System.out.println("����paint���ػ����ڣ�������"+(count++));
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
