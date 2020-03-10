import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Animation extends Thread{
	
	static Configuration con = new Configuration();
	static ver3 ver = new ver3();
	
	/*
	public static void paint(Graphics g) {
		con.OSG.drawString("A",con.Ax[con.aX],con.Ay[con.aY]);
		con.OSG.drawString("B",con.Bx[con.bX],con.By[con.bY]);
		con.OSG.drawString("C",con.Cx[con.cX],con.Cy[con.cY]);
		con.OSG.drawString("D",con.Dx[con.dX],con.Dy[con.dY]);
	}
	*/
	public void run() {
		try {
			int i;
			if (con.turn==0) {
				for (i=con.masu;i<=con.A;i++) {
					con.aX=i;
					con.aY=con.masu;
					if (i<=9);
					else if (i<=18) {
						con.aX=9;
						con.aY=i;
					}
					else if (i<=27) {
						con.aX=i;
						con.aY=18;
					}
					else if (i<=35) {
						con.aX=27;
						con.aY=i;
					}if (i==36) {
						i=0;
						con.A-=36;
						con.masu=0;
						con.aX=0;
						con.aY=0;
					}
					ver.repaint();
					Thread.sleep(500);
					con.deme--;
					if (con.deme==-1) con.turn++;
					if (con.turn==4) {
						con.turn=0;
						con.ターン++;
					}
				}
			}
			else if (con.turn==1) {
				for (i=con.masu;i<=con.B;i++) {
					con.bX=i;
					con.bY=con.masu;
					if (i<=9);
					else if (i<=18) {
						con.bX=9;
						con.bY=i;
					}
					else if (i<=27) {
						con.bX=i;
						con.bY=18;
					}
					else if (i<=35) {
						con.bX=27;
						con.bY=i;
					}
					if (i==36) {
						i=0;
						con.B-=36;
						con.masu=0;
						con.bX=0;
						con.bY=0;
					}
					ver.repaint();
					Thread.sleep(500);
					con.deme--;
					if (con.deme==-1) con.turn++;
					if (con.turn==4) {
						con.turn=0;
						con.ターン++;
					}
				}
			}
			else if (con.turn==2) {
				for (i=con.masu;i<=con.C;i++) {
					con.cX=i;
					con.cY=con.masu;
					if (i<=9);
					else if (i<=18) {
						con.cX=9;
						con.cY=i;
					}
					else if (i<=27) {
						con.cX=i;
						con.cY=18;
					}
					else if (i<=35) {
						con.cX=27;
						con.cY=i;
					}
					if (i==36) {
						i=0;
						con.C-=36;
						con.masu=0;
						con.cX=0;
						con.cY=0;
					}
					ver.repaint();
					Thread.sleep(500);
					con.deme--;
					if (con.deme==-1) con.turn++;
					if (con.turn==4) {
						con.turn=0;
						con.ターン++;
					}
				}
			}
			else if (con.turn==3) {
				for (i=con.masu;i<=con.D;i++) {
					con.dX=i;
					con.dY=con.masu;
					if (i<=9);
					else if (i<=18) {
						con.dX=9;
						con.dY=i;
					}
					else if (i<=27) {
						con.dX=i;
						con.dY=18;
					}
					else if (i<=35) {
						con.dX=27;
						con.dY=i;
					}
					if (i==36) {
						i=0;
						con.D-=36;
						con.masu=0;
						con.dX=0;
						con.dY=0;
					}
					ver.repaint();
					Thread.sleep(500);
					con.deme--;
					if (con.deme==-1) con.turn++;
					if (con.turn==4) {
						con.turn=0;
						con.ターン++;
					}
				}
			}
		}
		catch(InterruptedException e) {}
	}
}