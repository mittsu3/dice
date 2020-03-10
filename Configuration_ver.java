import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class Configuration {
	
	final static int FRAMEPOSX=500,FRAMEWIDTH=70,
			  FRAMEPOSY=150,FRAMEHEIGHT=70;					//枠線の位置設定
	
	int[] housePrice={0,6000,6500,7000,0,0,8000,8500,9000,
						0,10000,10500,11000,0,0,12000,12500,13000,
						0,14000,14500,15000,0,0,16000,16500,17000,
						0,18000,18500,19000,0,0,20000,20500,21000};
	
	int[] 通行料={0,2000,2200,2400,0,0,2700,2900,3000,
					0,3400,3500,3700,0,0,4000,4200,4400,
					0,4700,4900,5000,0,0,5400,5500,5700,
					0,6000,6200,6400,6700,6900,7000};
	
	//static int newsNumber;
	static int[] x = new int[36];			//基本座標
	static int[] y = new int[36];			//基本座標
	static int[] Ax = new int[37];
	static int[] Ay = new int[37];
	static int[] Bx = new int[37];
	static int[] By = new int[37];
	static int[] Cx = new int[37];
	static int[] Cy = new int[37];
	static int[] Dx = new int[37];
	static int[] Dy = new int[37];
	//static int A=0,B=0,C=0,D=0;			//各プレイヤーの現在のマス
	static int masu=0;
	static int deme=-1;					//サイコロの出目
	static int turn=0;					//0:A,1:B,2:C,3:D
	static int ターン=1;				//経過ターン数
	//static int moneyA=1000,moneyB=1000,moneyC=1000,moneyD=1000;				//各プレイヤーの所持金
	static int aX=0,aY=0,bX=0,bY=0,cX=0,cY=0,dX=0,dY=0;
	//static Button bt1,bt2;
	static Graphics OSG;	//オフスクリーングラフィックス
	static Image OSI;	//オフスクリーンイメージ
	static Thread th;
	static Image osi;
	static boolean startCheck=false;
	int ota=5000,fuku=5000,uchi=5000,tom=5000;
	
	public static void 座標の設定() {
		int j=17;
		int n=8;
		for (int i=0;i<36;i++){
			//基本座標の設定
			if (i<=9) {
				x[i]=FRAMEPOSX+FRAMEWIDTH*i;
				y[i]=FRAMEPOSY;
			}
			if (10<=i&&i<=18) {
				x[i]=FRAMEPOSX+FRAMEWIDTH*9;
				int m=i-9;
				y[i]=FRAMEPOSY+FRAMEHEIGHT*m;
			}
			if (19<=i&&i<=27) {
				x[i]=FRAMEPOSX+FRAMEWIDTH*n;
				n--;
				y[i]=FRAMEPOSY+FRAMEHEIGHT*9;
			}
			if (28<=i&&i<=35) {
				x[i]=FRAMEPOSX;
				y[i]=y[j];
				j--;
			}
		}
		//ABCD座標の設定
		for (int i=0;i<36;i++) {
			Ax[i]=x[i]+FRAMEWIDTH/4-15;
			Ay[i]=y[i]+FRAMEHEIGHT/4-15;
			Bx[i]=x[i]+FRAMEWIDTH/4*3;
			By[i]=y[i]+FRAMEHEIGHT/4-15;
			Cx[i]=x[i]+FRAMEWIDTH/4-15;
			Cy[i]=y[i]+FRAMEHEIGHT/4*3;
			Dx[i]=x[i]+FRAMEWIDTH/4*3;
			Dy[i]=y[i]+FRAMEHEIGHT/4*3;
		}
	}
}