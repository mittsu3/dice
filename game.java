import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class game extends Applet implements Runnable{
	
	
	
	int t;
	int count;
	int deme1,deme2;
	final int FRAMEPOSX=500,FRAMEWIDTH=70,
			  FRAMEPOSY=150,FRAMEHEIGHT=70;					//枠線の位置設定
	static int gameMode=0;				//0:タイトル画面を表示
	static int mode=-1;					//-1:ニュース決定,0:さいころ,1:移動,2:イベント処理,3:家の売買,4:家の処理,5:株の売買,6:株の処理,7:ターン終了
	static Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
	Panel startPanel=new Panel();
	Thread th;
	Image backGround;
	Image title;
	Configuration con=new Configuration();
	Image sai1,sai2,sai3,sai4,sai5,sai6;
	int sleepTime=500;
	int num=200;
	int animeMode=0;
	PlayerA playerA=new PlayerA();
	PlayerB playerB=new PlayerB();
	PlayerC playerC=new PlayerC();
	PlayerD playerD=new PlayerD();
	Event Event = new Event();
	Image komaA,komaB,komaC,komaD;
	Image houseA,houseB,houseC,houseD;
	int house_A=0,house_B=0,house_C=0,house_D=0;
	ニュース ニュース=new ニュース();
	int newsNumber;
	Image ルールA,ルールB,ロード背景;
	int change=0;
	int t1;
	boolean check;
	int 刑務所カウントA,刑務所カウントB,刑務所カウントC,刑務所カウントD;
	boolean sleepCheck;
	
	
	
	//最初に行う処理
	public void init() {
		setLayout(null);
		con.座標の設定();
		con.OSI = createImage(getSize().width,getSize().height);
		con.OSG = con.OSI.getGraphics();
		con.OSG.setColor(Color.black);
		sai1=getImage(getDocumentBase(),"saikoro1.gif");
		sai2=getImage(getDocumentBase(),"saikoro2.gif");
		sai3=getImage(getDocumentBase(),"saikoro3.gif");
		sai4=getImage(getDocumentBase(),"saikoro4.gif");
		sai5=getImage(getDocumentBase(),"saikoro5.gif");
		sai6=getImage(getDocumentBase(),"saikoro6.gif");
		backGround=getImage(getDocumentBase(),"earth.jpg");
		komaA=getImage(getDocumentBase(),"泣く.png");
		komaB=getImage(getDocumentBase(),"うーん.png");
		komaC=getImage(getDocumentBase(),"弱そう.png");
		komaD=getImage(getDocumentBase(),"天狗.png");
		houseA=getImage(getDocumentBase(),"赤い家.png");
		houseB=getImage(getDocumentBase(),"青い家.png");
		houseC=getImage(getDocumentBase(),"緑の家.png");
		houseD=getImage(getDocumentBase(),"黄色の家.png");
		ルールA=getImage(getDocumentBase(),"ルール.jpg");
		ルールB=getImage(getDocumentBase(),"株式会社.png");
		ロード背景=getImage(getDocumentBase(),"紫.jpg");
		
		
		if (gameMode==0) {
			bt2=new Button("NEW GAME");
			add(bt2);
			bt2.setBounds(300,700,100,50);
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					con.OSG.clearRect(0,0,getSize().width,getSize().height); //オフスクリーンの初期化
					gameMode=1;
					removeAll();
					if (animeMode==0) {
						repaint();
					}
				}
			});
		}
		count=0;
	}
	//描画する
	public void paint(Graphics g) {
		if (gameMode==0) {
			title=getImage(getDocumentBase(),"sun.jpeg");
			con.OSG.drawImage(title,0,0,getSize().width,getSize().height,this);
			draw.タイトル画面を表示(g);
		}
		if (gameMode==1) {
			con.OSG.drawImage(ロード背景,0,0,getSize().width,getSize().height,this);
			gameMode=2;
		}
		if (gameMode==2) {
			gameMode=3;
			th=new Thread(this);
			th.start();
		}
		if (gameMode==3) {
			gameMode++;
			//if (num<210) con.OSG.drawImage(ルールA,0,0,getSize().width,getSize().height,this);
			//if (num>600) con.OSG.drawImage(ルールB,200,0,getSize().width-300,750,this);
			//ロード画面(g);
		}else if (gameMode==4) 黒紙(g);
		else if (gameMode==5) {
			con.OSG.clearRect(0,0,getSize().width,getSize().height); //オフスクリーンの初期化
			con.OSG.setColor(Color.white);
			ゲーム本編(g);
		}
		g.drawImage(con.OSI,0,0,this);
	}
	public void 黒紙(Graphics g) {
		gameMode++;
		remove(bt2);
		con.OSG.clearRect(0,0,getSize().width,getSize().height); //オフスクリーンの初期化
		con.OSG.setColor(Color.black);
		con.OSG.fillRect(0,0,getSize().width,getSize().height);
		repaint();
	}
	public void ロード画面(Graphics g) {
		
		con.OSG.setColor(Color.black);
		ローディング枠の表示(g);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,30));
		con.OSG.drawString("NOW LOADING",1500,800);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
		con.OSG.setColor(Color.darkGray);
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,45));
		con.OSG.drawString("|",num,840);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void ゲーム本編(Graphics g) {
		con.OSG.drawImage(backGround,0,0,getSize().width,getSize().height,this);
		draw.枠の表示(g);
		draw.株価の枠の表示(g);
		draw.イベント枠の表示(g);
		draw.所持金表示枠の描画(g);
		draw.所持資産の表示(g);
		draw.ターンの表示(g);
		イベントマスの塗りつぶし(g);
		コマの表示(g);
		
		draw.会社名表示(g);
		draw.ニュース枠表示(g);
		ボタンの表示(g);
		draw.株価の表示(g);
		速度変更ボタンの表示(g);
		家の表示(g);
		
		con.OSG.drawString(刑務所カウントA+" ",FRAMEPOSX+FRAMEWIDTH+100,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(刑務所カウントB+" ",FRAMEPOSX+FRAMEWIDTH+110,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(刑務所カウントC+" ",FRAMEPOSX+FRAMEWIDTH+100,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString(刑務所カウントD+" ",FRAMEPOSX+FRAMEWIDTH+110,FRAMEPOSY+FRAMEHEIGHT*5);
		
		con.OSG.drawString(playerA.刑務所チェック()+" ",FRAMEPOSX+FRAMEWIDTH+130,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(playerB.刑務所チェック()+" ",FRAMEPOSX+FRAMEWIDTH+160,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(playerC.刑務所チェック()+" ",FRAMEPOSX+FRAMEWIDTH+130,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString(playerD.刑務所チェック()+" ",FRAMEPOSX+FRAMEWIDTH+160,FRAMEPOSY+FRAMEHEIGHT*5);
		
		
		if (con.turn==0) sleepCheck=playerA.休みチェック();
		if (con.turn==1) sleepCheck=playerB.休みチェック();
		if (con.turn==2) sleepCheck=playerC.休みチェック();
		if (con.turn==3) sleepCheck=playerD.休みチェック();
		if (sleepCheck==true) mode=9;
		if (mode==13) 刑務所チェック(g);
		if (con.turn==0&&刑務所カウントA==2) mode=9;
		if (con.turn==1&&刑務所カウントB==2) mode=9;
		if (con.turn==2&&刑務所カウントC==2) mode=9;
		if (con.turn==3&&刑務所カウントD==2) mode=9;
		
		//if (check==true) mode=9;
		if (t==con.ターン) サイコロ表示(g);
		if (mode==11) {
			draw.マスイベント(g);
		}
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (mode==-1) ニュースの決定();
		draw.ニュースの表示(g,newsNumber);
		if (mode==12) {
			mode=2;
			repaint();
		}
		if (mode==2&&(masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32||masu==9||masu==18||masu==27)) mode=5;
		//bt1:さいころ,bt2:NEWGAME,bt3:早送り,bt4:ゆっくり,bt5:家を買う,bt6:家を買わない,bt7:ターン終了,bt8:株の購入,bt9:株の売却,bt10:株を買わない
		

		
		
		if (mode==2) {
			if (Event.houseCheck(masu)==true) Event.通行料の支払い(con.turn,masu);
			else 家の購入ボタンの表示();
		}
		if (mode==5) 株の購入ボタンの表示();
		if (mode==6) 株式会社の選択ボタンの表示();
		if (mode==7) {
			売買株式数の調整ボタンの表示();
			売買株式数の表示(g);
			株式購入確認ボタンの表示();
		}
		if (mode==8) {
			売買株式数の調整ボタンの表示();
			売買株式数の表示(g);
			株式売却確認ボタンの表示();
		}
		if (mode==9) {
			ENDボタンの表示();
			if (con.turn==0&&刑務所カウントA==2) 刑務所の表示(g);
			if (con.turn==1&&刑務所カウントB==2) 刑務所の表示(g);
			if (con.turn==2&&刑務所カウントC==2) 刑務所の表示(g);
			if (con.turn==3&&刑務所カウントD==2) 刑務所の表示(g);
		}
		if (mode==10) 確認ボタンの表示();
	}
	public void 刑務所の表示(Graphics g) {
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,24));
		con.OSG.drawString("現在刑務所にいるため行動できません",FRAMEPOSX+FRAMEWIDTH+40,FRAMEPOSY+FRAMEHEIGHT*6);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
		ENDボタンの表示();
	}
	
	public void 家の表示(Graphics g) {
		int num=0;
		for (int i=0;i<playerA.houseList.size();i++) {
			num=playerA.houseList.get(i);
			con.OSG.drawImage(houseA,(con.Ax[num]+con.Bx[num])/2,(con.Ay[num]+con.Cy[num])/2,40,40,this);
		}for (int i=0;i<playerB.houseList.size();i++) {
			num=playerB.houseList.get(i);
			con.OSG.drawImage(houseB,(con.Ax[num]+con.Bx[num])/2,(con.Ay[num]+con.Cy[num])/2,40,40,this);
		}
		for (int i=0;i<playerC.houseList.size();i++) {
			num=playerC.houseList.get(i);
			con.OSG.drawImage(houseC,(con.Ax[num]+con.Bx[num])/2,(con.Ay[num]+con.Cy[num])/2,40,40,this);
		}
		for (int i=0;i<playerD.houseList.size();i++) {
			num=playerD.houseList.get(i);
			con.OSG.drawImage(houseD,(con.Ax[num]+con.Bx[num])/2,(con.Ay[num]+con.Cy[num])/2,40,40,this);
		}
	}
	public void 刑務所チェック(Graphics g) {
		if (con.turn==0) {
			if (playerA.刑務所チェック()==true) 刑務所カウントA++;
		}
		if (con.turn==1) {
			if (playerB.刑務所チェック()==true) 刑務所カウントB++;
		}
		if (con.turn==2) {
			if (playerC.刑務所チェック()==true) 刑務所カウントC++;
		}
		if (con.turn==3) {
			if (playerD.刑務所チェック()==true) 刑務所カウントD++;
		}mode=0;
	}
	public void イベントマスの塗りつぶし(Graphics g) {
		con.OSG.setColor(Color.yellow);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*4+3,FRAMEPOSY+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*5+3,FRAMEPOSY+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*9+3,FRAMEPOSY+FRAMEHEIGHT*4+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*9+3,FRAMEPOSY+FRAMEHEIGHT*5+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*4+3,FRAMEPOSY+FRAMEHEIGHT*9+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*5+3,FRAMEPOSY+FRAMEHEIGHT*9+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+3,FRAMEPOSY+FRAMEHEIGHT*4+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+3,FRAMEPOSY+FRAMEHEIGHT*5+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.setColor(Color.cyan);
		con.OSG.fillRect(FRAMEPOSX+3,FRAMEPOSY+FRAMEWIDTH*9+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+3,FRAMEPOSY+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*9+3,FRAMEPOSY+FRAMEWIDTH*9+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.fillRect(FRAMEPOSX+FRAMEWIDTH*9+3,FRAMEPOSY+3,FRAMEWIDTH-5,FRAMEHEIGHT-5);
		con.OSG.setColor(Color.white);
	}
	
	public void コマの表示(Graphics g) {
		con.OSG.drawImage(komaA,con.Ax[con.aX],con.Ay[con.aY],20,20,this);
		con.OSG.drawImage(komaB,con.Bx[con.bX],con.By[con.bY],20,20,this);
		con.OSG.drawImage(komaC,con.Cx[con.cX],con.Cy[con.cY],20,20,this);
		con.OSG.drawImage(komaD,con.Dx[con.dX],con.Dy[con.dY],20,20,this);
	}
	public void 株の購入処理(int storeNumber,int kabuNumber) {
		mode=5;
		int kabuka=0;
		if (storeNumber==0) kabuka=kabu.getKabukaOta();
		else if (storeNumber==1) kabuka=kabu.getKabukaFuku();
		else if (storeNumber==2) kabuka=kabu.getKabukaUchi();
		else if (storeNumber==3) kabuka=kabu.getKabukaTom();
		
		if (con.turn==0) {
			playerA.株の増減(storeNumber,kabuNumber);
			playerA.お金の増減(kabuka*kabuNumber*-1);
		}
		if (con.turn==1) {
			playerB.株の増減(storeNumber,kabuNumber);
			playerB.お金の増減(kabuka*kabuNumber*-1);
		}
		if (con.turn==2) {
			playerC.株の増減(storeNumber,kabuNumber);
			playerC.お金の増減(kabuka*kabuNumber*-1);
		}
		if (con.turn==3) {
			playerD.株の増減(storeNumber,kabuNumber);
			playerD.お金の増減(kabuka*kabuNumber*-1);
		}
	}
	public void 株の売却処理(int storeNumber,int kabuNumber) {
		mode=9;
		int kabuka=0;
		if (storeNumber==0) kabuka=kabu.getKabukaOta();
		else if (storeNumber==1) kabuka=kabu.getKabukaFuku();
		else if (storeNumber==2) kabuka=kabu.getKabukaUchi();
		else if (storeNumber==3) kabuka=kabu.getKabukaTom();
		
		if (con.turn==0) {
			playerA.株の増減(storeNumber,kabuNumber*-1);
			playerA.お金の増減(kabuka*kabuNumber);
		}
		if (con.turn==1) {
			playerB.株の増減(storeNumber,kabuNumber*-1);
			playerB.お金の増減(kabuka*kabuNumber);
		}
		if (con.turn==2) {
			playerC.株の増減(storeNumber,kabuNumber*-1);
			playerC.お金の増減(kabuka*kabuNumber);
		}
		if (con.turn==3) {
			playerD.株の増減(storeNumber,kabuNumber*-1);
			playerD.お金の増減(kabuka*kabuNumber);
		}
	}
	int money,masu;
	public void 家の購入ボタンの表示() {
		if (con.turn==0) {
			money=playerA.getMoney();
			masu=playerA.A;
		}
		if (con.turn==1) {
			money=playerB.getMoney();
			masu=playerB.B;
		}
		if (con.turn==2) {
			money=playerC.getMoney();
			masu=playerC.C;
		}
		if (con.turn==3) {
			money=playerD.getMoney();
			masu=playerD.D;
		}
		if (Event.houseCheck(masu)==true) {
			Event.通行料の支払い(con.turn,masu);
			mode=5;
		}else if (con.housePrice[masu]<=money) {
			bt5=new Button("家を買う");
			add(bt5);
			bt5.setBounds(FRAMEPOSX+FRAMEWIDTH*4,FRAMEPOSY+FRAMEHEIGHT*3,150,45);
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mode=4;					//4:処理中
					Event.家の購入処理(con.turn,masu);
					removeAll();
					repaint();
					
				}
			});
			
			bt6=new Button("家を買わない");
			add(bt6);
			bt6.setBounds(FRAMEPOSX+FRAMEWIDTH*6,FRAMEPOSY+FRAMEHEIGHT*3,150,45);
			bt6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mode=5;
					removeAll();
					repaint();
				}
			});
		}else {
			con.OSG.drawString("所持金が足りないため家を購入できません",FRAMEPOSX+FRAMEWIDTH+80,FRAMEPOSY+FRAMEHEIGHT*6);
			mode=5;
		}
	}
	int buy;
	public void 株の購入ボタンの表示() {
		bt8=new Button("株の購入");
		add(bt8);
		bt8.setBounds(FRAMEPOSX+FRAMEWIDTH*4,FRAMEPOSY+FRAMEHEIGHT*4,150,45);
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode=6;
				buy=1;
				removeAll();
				repaint();
			}
		});
		
		bt9=new Button("株の売却");
		add(bt9);
		bt9.setBounds(FRAMEPOSX+FRAMEWIDTH*6,FRAMEPOSY+FRAMEHEIGHT*4,150,45);
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode=6;
				buy=0;
				removeAll();
				repaint();
			}
		});
		
		bt10=new Button("株を買わない");
		add(bt10);
		bt10.setBounds(FRAMEPOSX+FRAMEWIDTH*5,FRAMEPOSY+FRAMEHEIGHT*5,150,45);
			bt10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mode=9;
					removeAll();
					repaint();
				}
			});
	}
	public void 売買株式数の表示(Graphics g) {
		con.OSG.drawString(kabuNumber+" 枚",FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*3);
	}
	int kabuNumber;
	public void 売買株式数の調整ボタンの表示() {
		Button bt12=new Button("+10");
		add(bt12);
		bt12.setBounds(FRAMEPOSX+FRAMEWIDTH*5,FRAMEPOSY+FRAMEHEIGHT*3,50,20);
		bt12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kabuNumber+=10;
				repaint();
			}
		});
		
		Button bt13=new Button("+1");
		add(bt13);
		bt13.setBounds(FRAMEPOSX+FRAMEWIDTH*6,FRAMEPOSY+FRAMEHEIGHT*3,50,20);
		bt13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kabuNumber+=1;
				repaint();
			}
		});
		
		Button bt14=new Button("-1");
		add(bt14);
		bt14.setBounds(FRAMEPOSX+FRAMEWIDTH*8,FRAMEPOSY+FRAMEHEIGHT*3,50,20);
		bt14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kabuNumber-=1;
				repaint();
			}
		});
		
		Button bt15=new Button("-10");
		add(bt15);
		bt15.setBounds(FRAMEPOSX+FRAMEWIDTH*9,FRAMEPOSY+FRAMEHEIGHT*3,50,20);
		bt15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kabuNumber-=10;
				repaint();
			}
		});
	}
	public void 株式売却確認ボタンの表示() {
		Button bt21=new Button("売却する");
		add(bt21);
		bt21.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*5,100,30);
		bt21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				株の売却処理(storeNumber,kabuNumber);
				kabuNumber=0;
				removeAll();
				repaint();
			}
		});
	}
	public void 株式購入確認ボタンの表示() {
		Button bt16 = new Button("購入する");
		add(bt16);
		bt16.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*5,100,30);
		bt16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				株の購入処理(storeNumber,kabuNumber);
				kabuNumber=0;
				removeAll();
				repaint();
			}
		});
	}int storeNumber;
	public void 株式会社の選択ボタンの表示() {
		Button bt17=new Button("大田自動車");
		add(bt17);
		bt17.setBounds(FRAMEPOSX+FRAMEWIDTH*5,FRAMEPOSY+FRAMEHEIGHT*3,100,30);
		bt17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNumber=0;
				if (buy==1) mode=7;
				else if (buy==0) mode=8;
				removeAll();
				repaint();
			}
		});
		
		Button bt18=new Button("復光電力");
		add(bt18);
		bt18.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*3,100,30);
		bt18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNumber=1;
				if (buy==1) mode=7;
				else if (buy==0) mode=8;
				removeAll();
				repaint();
			}
		});
		
		
		Button bt19=new Button("ウチクロ");
		add(bt19);
		bt19.setBounds(FRAMEPOSX+FRAMEWIDTH*5,FRAMEPOSY+FRAMEHEIGHT*4,100,30);
		bt19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNumber=2;
				if (buy==1) mode=7;
				else if (buy==0) mode=8;
				removeAll();
				repaint();
			}
		});
		
		
		Button bt20=new Button("末永旅行代理店");
		add(bt20);
		bt20.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*4,100,30);
		bt20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeNumber=3;
				if (buy==1) mode=7;
				else if (buy==0) mode=8;
				removeAll();
				repaint();
			}
		});
	}
	public void ENDボタンの表示() {
		bt7=new Button("ターン終了");
		add(bt7);
		bt7.setBounds(FRAMEPOSX+FRAMEWIDTH*6,FRAMEPOSY+FRAMEHEIGHT*8,150,45);
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((con.turn==3&&mode==9)||(con.turn==3&&mode==12)) {
					ニュース.ニュースイベント処理(newsNumber);
					mode=10;
					count=0;
					removeAll();
					確認ボタンの表示();
					draw.eventCount=0;
					repaint();
				}
				else {
					mode=13;
					//mode=0;
					draw.eventCount=0;
					con.turn++;
					removeAll();
					repaint();
				}
			}
		});
	}
	public void 確認ボタンの表示() {
		Button bt11=new Button("確認OK");
		add(bt11);
		bt11.setBounds(FRAMEPOSX+FRAMEWIDTH*8,FRAMEPOSY+FRAMEHEIGHT*8,150,45);
		bt11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode=-1;
				con.turn=0;
				//刑務所のカウント();
				刑務所の処理();
				removeAll();
				repaint();
			}
		});
	}
	public void 刑務所のカウント() {
		if (playerA.刑務所==true) 刑務所カウントA++;
		if (playerB.刑務所==true) 刑務所カウントB++;
		if (playerC.刑務所==true) 刑務所カウントC++;
		if (playerD.刑務所==true) 刑務所カウントD++;
		
	}
	public void 刑務所の処理() {
		if (刑務所カウントA==2) {
			playerA.刑務所から出る();
			刑務所カウントA=0;
		}
		if (刑務所カウントB==2) {
			playerB.刑務所から出る();
			刑務所カウントB=0;
		}
		if (刑務所カウントC==2) {
			playerC.刑務所から出る();
			刑務所カウントC=0;
		}
		if (刑務所カウントD==2) {
			playerD.刑務所から出る();
			刑務所カウントD=0;
		}
	}
	public void ニュースの決定() {
		Random r=new Random();
		newsNumber=r.nextInt(24);
		mode=13;
	}
	
	public void ローディング枠の表示(Graphics g) {
		con.OSG.drawLine(210,850,1700,850);
		con.OSG.drawLine(210,810,1700,810);
		con.OSG.drawLine(210,850,210,810);
		con.OSG.drawLine(1700,850,1700,810);
	}
	public void サイコロ表示(Graphics g) {
		if (deme1==1) con.OSG.drawImage(sai1,800,250,50,50,this);
		if (deme1==2) con.OSG.drawImage(sai2,800,250,50,50,this);
		if (deme1==3) con.OSG.drawImage(sai3,800,250,50,50,this);
		if (deme1==4) con.OSG.drawImage(sai4,800,250,50,50,this);
		if (deme1==5) con.OSG.drawImage(sai5,800,250,50,50,this);
		if (deme1==6) con.OSG.drawImage(sai6,800,250,50,50,this);
		if (deme2==1) con.OSG.drawImage(sai1,900,250,50,50,this);
		if (deme2==2) con.OSG.drawImage(sai2,900,250,50,50,this);
		if (deme2==3) con.OSG.drawImage(sai3,900,250,50,50,this);
		if (deme2==4) con.OSG.drawImage(sai4,900,250,50,50,this);
		if (deme2==5) con.OSG.drawImage(sai5,900,250,50,50,this);
		if (deme2==6) con.OSG.drawImage(sai6,900,250,50,50,this);
	}
	public void 速度変更ボタンの表示(Graphics g) {
		bt3=new Button("早送り");
		add(bt3);
		bt3.setBounds(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY-100,150,45);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sleepTime=10;
			}
		});
		
		bt4=new Button("ゆっくり");
		add(bt4);
		bt4.setBounds(FRAMEPOSX+FRAMEWIDTH*10+20+170,FRAMEPOSY-100,150,45);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sleepTime=500;
			}
		});
	}
	public void ボタンの表示(Graphics g) {
		bt1=new Button("さいころ");
		add(bt1);
		bt1.setBounds(600,250,150,45);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mode==0) {
					さいころ();
					mode=1;
				}
				repaint();
			}
		});
	}
	//サイコロを振る時の処理
	public void さいころ() {
		Random r=new Random();
		deme1=r.nextInt(6)+1;
		deme2=r.nextInt(6)+1;//サイコロの出目を乱数で出す	範囲:2～12
		//con.deme = deme1 + deme2;
		con.deme=9;
		t=con.ターン;
		if(con.turn==0) {
			con.masu=playerA.A;
			playerA.A+=con.deme;
		}
		if (con.turn==1) {
			con.masu=playerB.B;
			playerB.B+=con.deme;
		}
		if (con.turn==2) {
			con.masu=playerC.C;
			playerC.C+=con.deme;
		}
		if (con.turn==3) {
			con.masu=playerD.D;
			playerD.D+=con.deme;
		}
		animeMode=1;
		th=new Thread(this);
		th.start();
	}
	public void run() {
		if (animeMode==0) {
			try{
				int num1=乱数();
				int num2=乱数();
				int num3=乱数();
				for (int i=num;i<=getSize().width-200;i++) {
					num=i;
					repaint();
					if (i==num1*100) th.sleep(1500);
					else if (i==num2*100) th.sleep(1500);
					else if (i==num3*100) th.sleep(1500);
					else th.sleep(10);
					if (i==getSize().width-200) {
						bt3=new Button("ゲームを始める");
						add(bt3);
						bt3.setBounds(300,750,100,50);
						bt3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								remove(bt3);
								gameMode=4;
							}
						});
					}
				}animeMode=1;
			}catch(InterruptedException e) {}
		}
		else if (animeMode==1) {
			try {
				int i;
				if (con.turn==0) {
					for (i=con.masu;i<=playerA.A;i++) {
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
							con.startCheck=true;
							i=0;
							playerA.A-=36;
							con.masu=0;
							con.aX=0;
							con.aY=0;
						}
						repaint();
						Thread.sleep(sleepTime);
						con.deme--;
						if (con.deme==0) mode=11;
					}
				}
				else if (con.turn==1) {
					for (i=con.masu;i<=playerB.B;i++) {
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
							con.startCheck=true;
							i=0;
							playerB.B-=36;
							con.masu=0;
							con.bX=0;
							con.bY=0;
						}
						repaint();
						Thread.sleep(sleepTime);
						con.deme--;
						if (con.deme==0) mode=11;
					}
				}
				else if (con.turn==2) {
					for (i=con.masu;i<=playerC.C;i++) {
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
							con.startCheck=true;
							i=0;
							playerC.C-=36;
							con.masu=0;
							con.cX=0;
							con.cY=0;
						}
						repaint();
						Thread.sleep(sleepTime);
						con.deme--;
						if (con.deme==0) mode=11;
					}
				}
				else if (con.turn==3) {
					for (i=con.masu;i<=playerD.D;i++) {
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
							con.startCheck=true;
							i=0;
							playerD.D-=36;
							con.masu=0;
							con.dX=0;
							con.dY=0;
						}
						repaint();
						Thread.sleep(sleepTime);
						con.deme--;
						if (con.deme==0) mode=11;
					}
				}
			}
			catch(InterruptedException e) {}
		}
	}
	public int 乱数() {
		Random r=new Random();
		int a=r.nextInt(10)+2;
		return a;
	}
}