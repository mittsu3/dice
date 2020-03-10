import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class draw extends Applet {
	
	final static int FRAMEPOSX=500,FRAMEWIDTH=70,
			 		 FRAMEPOSY=150,FRAMEHEIGHT=70;					//枠線の位置設定
	static String[] マスイベント=new String[36];
	static game game=new game();
	static Configuration con=new Configuration();
	static int eventNumber;
	static massEvent massEvent=new massEvent();
	static Event Event=new Event();
	static PlayerA playerA=new PlayerA();
	static PlayerB playerB=new PlayerB();
	static PlayerC playerC=new PlayerC();
	static PlayerD playerD=new PlayerD();
	static ニュース ニュース=new ニュース();
	static int eventCount=0;
	static int kabuOta_A,kabuFuku_A,kabuUchi_A,kabuTom_A;		//所持株
	static int kabuOta_B,kabuFuku_B,kabuUchi_B,kabuTom_B;
	static int kabuOta_C,kabuFuku_C,kabuUchi_C,kabuTom_C;
	static int kabuOta_D,kabuFuku_D,kabuUchi_D,kabuTom_D;
	static kabu kabu=new kabu();
	static int kabukaOta,kabukaFuku,kabukaUchi,kabukaTom;
	static int capitalA,capitalB,capitalC,capitalD;
	static int[] cap=new int[4];
	
	/*
	public static void 株の売買(Graphics g) {
		
	}*/
	
	
	
	
	public static void ニュースの表示(Graphics g,int newsNumber) {
		String str1=ニュース.NewsA(newsNumber);
		String str2=ニュース.NewsB(newsNumber);
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,30));
		con.OSG.drawString(str1,FRAMEPOSX+10,FRAMEPOSY-100);
		con.OSG.drawString(str2,FRAMEPOSX+10,FRAMEPOSY-70);
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,12));
	}
	public static void マスイベント(Graphics g) {
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (con.startCheck==true&&eventCount==0) スタート通過の処理();
		if ((masu==0||masu==9||masu==18||masu==27)&&game.mode>=2) {
			特別イベントの表示(g,masu);
			if (eventCount==0) Event.特別イベント処理(con.turn,eventNumber);
		}
		else {
			if (eventCount==0){
				if (masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32) {
					eventNumber=イベント内容の決定();
					//Event.イベント処理(con.turn,eventNumber);
				}
				else {
					eventNumber=30;
					if (Event.houseCheck(masu)==true) {
						//Event.通行料の処理(con.turn,con.masu);
					}
				}if (masu!=0&&masu!=9&&masu!=18&&masu!=27&&game.mode==2) イベント内容の表示(g,eventNumber);
			}
		}game.mode=12;
	}
	public static void スタート通過の処理() {
		if (con.ターン>=2) {
			con.OSG.drawString("スタートを通過したので、２０，０００円もらう",FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+20);
			Event.特別イベント処理(con.turn,0);
			con.startCheck=false;
		}
	}
	public static void 特別イベントの表示(Graphics g,int masu) {
		int number=0;
		if (masu==0) number=0;
		if (masu==9) number=1;
		if (masu==18) number=2;
		if (masu==27) number=3;
		String str=massEvent.specialEvent(number);
		con.OSG.drawString(str,FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+40);
	}
	public static int イベント内容の決定() {
		Random r=new Random();
		int n=r.nextInt(27);
		return n;
	}
	public static void イベント内容の表示(Graphics g,int eventNumber) {
		String str=massEvent.massEvent(eventNumber);
		con.OSG.drawString(str,FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+40);
	}
	public static void タイトル画面を表示(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,96));
		con.OSG.drawString("ゲーム",300,200);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	public static void ニュース枠表示(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY - 20,FRAMEPOSX,FRAMEPOSY - 130);
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY - 130,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -130);
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY -20,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -20);
		con.OSG.drawLine(FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -20,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY - 130);
	}
	public static void 会社名表示(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,45));
		con.OSG.drawString("株価",FRAMEPOSX - 300,FRAMEPOSY + FRAMEHEIGHT);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,30));
		con.OSG.drawString("大田自動車",FRAMEPOSX -315,FRAMEPOSY + FRAMEHEIGHT*3-30);
		con.OSG.drawString("復光電力",FRAMEPOSX - 300,FRAMEPOSY + FRAMEHEIGHT*5-30);
		con.OSG.drawString("ウチクロ",FRAMEPOSX -300,FRAMEPOSY + FRAMEHEIGHT*7-30);
		con.OSG.drawString("末永旅行代理店",FRAMEPOSX -330,FRAMEPOSY + FRAMEHEIGHT*9-30);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	public static void ターンの表示(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,30));
		con.OSG.drawString("現在 "+con.ターン+" ターン目です",100,100);
		con.OSG.setFont(new Font ("Serif",Font.BOLD,28));
		if (con.turn==0) 
			con.OSG.drawString("Aさんのターンです",600,350);
		else if (con.turn==1) 
			con.OSG.drawString("Bさんのターンです",600,350);
		else if (con.turn==2)
			con.OSG.drawString("Cさんのターンです",600,350);
		else if (con.turn==3) 
			con.OSG.drawString("Dさんのターンです",600,350);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		if (con.deme>0) 
			con.OSG.drawString("あと"+con.deme+"マス進めます",600,400);
		
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (game.mode==2) {
			if (masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32)
				con.OSG.drawString("イベントマスに停まりました",600,400);
			if (masu==0||masu==9||masu==18||masu==27)
				con.OSG.drawString("イベントマスに停まりました",600,400);
			else if(masu!=4 && masu!=5 && masu!=13 && masu!=14 && masu!=22 && masu!=23 && masu!=31 && masu!=32 && masu!=0 && masu!=9 && masu!=18 && masu!=27)
			con.OSG.drawString("通常マスに停まりました",600,400);
		}
	}
	
	
	public static void 所持株の確認() {
		kabuOta_A = playerA.getKabuOta();
		kabuFuku_A = playerA.getKabuFuku();
		kabuUchi_A = playerA.getKabuUchi();
		kabuTom_A = playerA.getKabuTom();
		
		kabuOta_B = playerB.getKabuOta();
		kabuFuku_B = playerB.getKabuFuku();
		kabuUchi_B = playerB.getKabuUchi();
		kabuTom_B = playerB.getKabuTom();
		
		kabuOta_C = playerC.getKabuOta();
		kabuFuku_C = playerC.getKabuFuku();
		kabuUchi_C = playerC.getKabuUchi();
		kabuTom_C = playerC.getKabuTom();
		
		kabuOta_D = playerD.getKabuOta();
		kabuFuku_D = playerD.getKabuFuku();
		kabuUchi_D = playerD.getKabuUchi();
		kabuTom_D = playerD.getKabuTom();
	}
	public static void 株価の確認() {
		kabukaOta=kabu.getKabukaOta();
		kabukaFuku=kabu.getKabukaFuku();
		kabukaUchi=kabu.getKabukaUchi();
		kabukaTom=kabu.getKabukaTom();
	}
	public static void 所持株の表示(Graphics g) {
		所持株の確認();
		株価の確認();
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("所持株",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*3);
		con.OSG.drawString("所持株",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString("所持株",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*7);
		con.OSG.drawString("所持株",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*9);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		
		//A
		con.OSG.drawString("太田自動車:"+kabuOta_A+" 枚 ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3);
		con.OSG.drawString("復光電力:"+kabuFuku_A+" 枚 ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+20);
		con.OSG.drawString("ウチクロ:"+kabuUchi_A+" 枚 ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+40);
		con.OSG.drawString("末永旅行代理店:"+kabuTom_A+" 枚 ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+60);
		
		//B
		con.OSG.drawString("太田自動車:"+kabuOta_B+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString("復光電力:"+kabuFuku_B+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+20);
		con.OSG.drawString("ウチクロ:"+kabuUchi_B+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+40);
		con.OSG.drawString("末永旅行代理店:"+kabuTom_B+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+60);
		
		//C
		con.OSG.drawString("太田自動車:"+kabuOta_C+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7);
		con.OSG.drawString("復光電力:"+kabuFuku_C+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+20);
		con.OSG.drawString("ウチクロ:"+kabuUchi_C+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+40);
		con.OSG.drawString("末永旅行代理店:"+kabuTom_C+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+60);
		
		//D
		con.OSG.drawString("太田自動車:"+kabuOta_D+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9);
		con.OSG.drawString("復光電力:"+kabuFuku_D+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+20);
		con.OSG.drawString("ウチクロ:"+kabuUchi_D+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+40);
		con.OSG.drawString("末永旅行代理店:"+kabuTom_D+" 枚",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+60);
	}
	public static void 所持資産の表示(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*2+20,FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2+20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2,FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2+20);
		
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,40));
		con.OSG.drawString("所持資産の内訳",FRAMEPOSX+FRAMEWIDTH*10+80,FRAMEPOSY+FRAMEHEIGHT);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,25));
		con.OSG.drawString("プレーヤーA",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*2+20);
		con.OSG.drawString("プレーヤーB",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*4+20);
		con.OSG.drawString("プレーヤーC",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*6+20);
		con.OSG.drawString("プレーヤーD",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*8+20);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		所持金の表示(g);
		所持株の表示(g);
		総資産の表示(g);
		順位の表示(g);
	}
	public static void 総資産の表示(Graphics g) {
		//プレイヤーAの資産
		int money=playerA.getMoney();
		int kabuOta=kabu.getKabukaOta()*playerA.getKabuOta();
		int kabuFuku=kabu.getKabukaFuku()*playerA.getKabuFuku();
		int kabuUchi=kabu.getKabukaUchi()*playerA.getKabuUchi();
		int kabuTom=kabu.getKabukaTom()*playerA.getKabuTom();
		capitalA=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("総資産",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*3-30);
		con.OSG.drawString(capitalA+" 円",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*3);
		
		//プレイヤーBの資産
		money=playerB.getMoney();
		kabuOta=kabu.getKabukaOta()*playerB.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerB.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerB.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerB.getKabuTom();
		capitalB=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("総資産",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*5-30);
		con.OSG.drawString(capitalB+" 円",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*5);
		
		//プレイヤーCの資産
		money=playerC.getMoney();
		kabuOta=kabu.getKabukaOta()*playerC.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerC.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerC.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerC.getKabuTom();
		capitalC=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("総資産",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*7-30);
		con.OSG.drawString(capitalC+" 円",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*7);
		
		//プレイヤーDの資産
		money=playerD.getMoney();
		kabuOta=kabu.getKabukaOta()*playerD.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerD.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerD.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerD.getKabuTom();
		capitalD=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("総資産",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*9-30);
		con.OSG.drawString(capitalD+" 円",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*9);
	}
	public static void 順位の表示(Graphics g) {
		//0:A,1:B,2:C,3:D
		int a=capitalA;
		int b=capitalB;
		int c=capitalC;
		int d=capitalD;
		cap[0]=capitalA;
		cap[1]=capitalB;
		cap[2]=capitalC;
		cap[3]=capitalD;
		
		for (int j=0;j<=4;j++) {
			for (int i=0;i<cap.length-1;i++) {
				if (cap[i]<cap[i+1]){
					int n=cap[i];
					cap[i]=cap[i+1];
					cap[i+1]=n;
				}
			}
		}
		if (cap[0]==cap[1]&&cap[0]==cap[2]&&cap[0]==cap[3]) {
			con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
		}else {
			if (cap[0]==a) con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[1]==a) con.OSG.drawString("２位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[2]==a) con.OSG.drawString("３位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[3]==a) con.OSG.drawString("４位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			
			if (cap[0]==b) con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[1]==b) con.OSG.drawString("２位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[2]==b) con.OSG.drawString("３位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[3]==b) con.OSG.drawString("４位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			
			if (cap[0]==c) con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[1]==c) con.OSG.drawString("２位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[2]==c) con.OSG.drawString("３位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[3]==c) con.OSG.drawString("４位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			
			if (cap[0]==d) con.OSG.drawString("１位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[1]==d) con.OSG.drawString("２位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[2]==d) con.OSG.drawString("３位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[3]==d) con.OSG.drawString("４位",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
		}
	}
	public static void 所持金の表示(Graphics g) {
		int moneyA=playerA.getMoney();
		int moneyB=playerB.getMoney();
		int moneyC=playerC.getMoney();
		int moneyD=playerD.getMoney();
		
		//A
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("現金",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*2+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		con.OSG.drawString(moneyA+"円",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*2+45);
		
		//B
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("現金",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*4+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		con.OSG.drawString(moneyB+"  円",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*4+45);
		
		//C
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("現金",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*6+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		con.OSG.drawString(moneyC+"  円",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*6+45);
		
		//D
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("現金",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*8+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//デフォルトのサイズ
		con.OSG.drawString(moneyD+"  円",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*8+45);
	}
	public static void 株価の表示(Graphics g) {
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,25));
		con.OSG.drawString(kabu.getKabukaOta() + "  円",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*3 + 30);
		con.OSG.drawString(kabu.getKabukaFuku() + "  円",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*5 + 30);
		con.OSG.drawString(kabu.getKabukaUchi() + "  円",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*7 + 30);
		con.OSG.drawString(kabu.getKabukaTom() + "  円",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*9 + 30);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	//所持金を表示する枠の表示
	public static void 所持金表示枠の描画(Graphics g) {
		for (int i=0;i<=10;i+=2)
			con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*i,FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY+FRAMEHEIGHT*i);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY,FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*10);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY,FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY+FRAMEHEIGHT*10);
	}
	public static void イベント枠の表示(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*9-20,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*9-20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*9-20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*9-20);
	}
	//株価表示の枠の描画
	public static void 株価の枠の表示(Graphics g) {
		//OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY,FRAMEPOSX-20,FRAMEPOSY);
		for (int i=0;i<=10;i+=2)
			con.OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY+FRAMEHEIGHT*i,FRAMEPOSX-20,FRAMEPOSY+FRAMEHEIGHT*i);
		con.OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY,FRAMEPOSX-420,FRAMEPOSY+FRAMEHEIGHT*10);
		con.OSG.drawLine(FRAMEPOSX-20,FRAMEPOSY,FRAMEPOSX-20,FRAMEPOSY+FRAMEHEIGHT*10);
	}
	//盤面の枠線を描画する
	public static void 枠の表示(Graphics g) {
		
		//横線の表示
		for (int i=0;i<11;i++) {
			if (i<2||i>8) {
				con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH*10+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
			}
			else{
				con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
				con.OSG.drawLine(FRAMEPOSX+(10*FRAMEWIDTH),FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH*9+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
			}
		}
		
		//縦線の表示
		for (int i=0;i<11;i++) {
			if (i<2||i>8)
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY,FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+(10*FRAMEHEIGHT));
			else 
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY,FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+FRAMEHEIGHT);
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+(10*FRAMEHEIGHT),FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+FRAMEHEIGHT*9);
		}
	}
}