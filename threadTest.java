import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class threadTest extends Applet implements Runnable{
	
	int mode=0;
	int x=100;
	int y=50;
	Thread th;
	//Image OSI;
	//Graphics OSG;
	boolean check=false;
	
	public void init() {
		//OSI=createImage(getSize().width,getSize().height);
		//OSG=OSI.getGraphics();
		th=new Thread(this);
		th.start();
		mode=1;
		th.start();
	}
	public void run(){
		if (mode==0) {
			try{
				for (int i=0;i<1000;i++) {
					x=i;
					repaint();
					th.sleep(10);
				}mode++;
				check=true;
			}catch(InterruptedException e) {}
		}else {
			try{
				for (int i=0;i<1000;i++) {
					y=i;
					repaint();
					th.sleep(10);
				}
			}catch(InterruptedException e) {}
		}
	}
	public void paint(Graphics g) {
		//OSG.drawString("|",num,50);
		//g.drawImage(OSI,0,0,this);
		g.drawString("|",x,y);
		/*if (mode==1&&check==true) {
			th=new Thread(this);
			th.start();
		}*/
	}
	public void update(Graphics g) {
		paint(g);
	}
}