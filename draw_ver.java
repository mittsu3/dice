import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class draw extends Applet {
	
	final static int FRAMEPOSX=500,FRAMEWIDTH=70,
			 		 FRAMEPOSY=150,FRAMEHEIGHT=70;					//�g���̈ʒu�ݒ�
	static String[] �}�X�C�x���g=new String[36];
	static game game=new game();
	static Configuration con=new Configuration();
	static int eventNumber;
	static massEvent massEvent=new massEvent();
	static Event Event=new Event();
	static PlayerA playerA=new PlayerA();
	static PlayerB playerB=new PlayerB();
	static PlayerC playerC=new PlayerC();
	static PlayerD playerD=new PlayerD();
	static �j���[�X �j���[�X=new �j���[�X();
	static int eventCount=0;
	static int kabuOta_A,kabuFuku_A,kabuUchi_A,kabuTom_A;		//������
	static int kabuOta_B,kabuFuku_B,kabuUchi_B,kabuTom_B;
	static int kabuOta_C,kabuFuku_C,kabuUchi_C,kabuTom_C;
	static int kabuOta_D,kabuFuku_D,kabuUchi_D,kabuTom_D;
	static kabu kabu=new kabu();
	static int kabukaOta,kabukaFuku,kabukaUchi,kabukaTom;
	static int capitalA,capitalB,capitalC,capitalD;
	static int[] cap=new int[4];
	
	/*
	public static void ���̔���(Graphics g) {
		
	}*/
	
	
	
	
	public static void �j���[�X�̕\��(Graphics g,int newsNumber) {
		String str1=�j���[�X.NewsA(newsNumber);
		String str2=�j���[�X.NewsB(newsNumber);
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,30));
		con.OSG.drawString(str1,FRAMEPOSX+10,FRAMEPOSY-100);
		con.OSG.drawString(str2,FRAMEPOSX+10,FRAMEPOSY-70);
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,12));
	}
	public static void �}�X�C�x���g(Graphics g) {
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (con.startCheck==true&&eventCount==0) �X�^�[�g�ʉ߂̏���();
		if ((masu==0||masu==9||masu==18||masu==27)&&game.mode>=2) {
			���ʃC�x���g�̕\��(g,masu);
			if (eventCount==0) Event.���ʃC�x���g����(con.turn,eventNumber);
		}
		else {
			if (eventCount==0){
				if (masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32) {
					eventNumber=�C�x���g���e�̌���();
					//Event.�C�x���g����(con.turn,eventNumber);
				}
				else {
					eventNumber=30;
					if (Event.houseCheck(masu)==true) {
						//Event.�ʍs���̏���(con.turn,con.masu);
					}
				}if (masu!=0&&masu!=9&&masu!=18&&masu!=27&&game.mode==2) �C�x���g���e�̕\��(g,eventNumber);
			}
		}game.mode=12;
	}
	public static void �X�^�[�g�ʉ߂̏���() {
		if (con.�^�[��>=2) {
			con.OSG.drawString("�X�^�[�g��ʉ߂����̂ŁA�Q�O�C�O�O�O�~���炤",FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+20);
			Event.���ʃC�x���g����(con.turn,0);
			con.startCheck=false;
		}
	}
	public static void ���ʃC�x���g�̕\��(Graphics g,int masu) {
		int number=0;
		if (masu==0) number=0;
		if (masu==9) number=1;
		if (masu==18) number=2;
		if (masu==27) number=3;
		String str=massEvent.specialEvent(number);
		con.OSG.drawString(str,FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+40);
	}
	public static int �C�x���g���e�̌���() {
		Random r=new Random();
		int n=r.nextInt(27);
		return n;
	}
	public static void �C�x���g���e�̕\��(Graphics g,int eventNumber) {
		String str=massEvent.massEvent(eventNumber);
		con.OSG.drawString(str,FRAMEPOSX+FRAMEWIDTH+30,FRAMEPOSY+FRAMEHEIGHT*5+40);
	}
	public static void �^�C�g����ʂ�\��(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,96));
		con.OSG.drawString("�Q�[��",300,200);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	public static void �j���[�X�g�\��(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY - 20,FRAMEPOSX,FRAMEPOSY - 130);
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY - 130,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -130);
		con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY -20,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -20);
		con.OSG.drawLine(FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY -20,FRAMEPOSX + FRAMEWIDTH * 10,FRAMEPOSY - 130);
	}
	public static void ��Ж��\��(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,45));
		con.OSG.drawString("����",FRAMEPOSX - 300,FRAMEPOSY + FRAMEHEIGHT);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,30));
		con.OSG.drawString("��c������",FRAMEPOSX -315,FRAMEPOSY + FRAMEHEIGHT*3-30);
		con.OSG.drawString("�����d��",FRAMEPOSX - 300,FRAMEPOSY + FRAMEHEIGHT*5-30);
		con.OSG.drawString("�E�`�N��",FRAMEPOSX -300,FRAMEPOSY + FRAMEHEIGHT*7-30);
		con.OSG.drawString("���i���s�㗝�X",FRAMEPOSX -330,FRAMEPOSY + FRAMEHEIGHT*9-30);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	public static void �^�[���̕\��(Graphics g) {
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,30));
		con.OSG.drawString("���� "+con.�^�[��+" �^�[���ڂł�",100,100);
		con.OSG.setFont(new Font ("Serif",Font.BOLD,28));
		if (con.turn==0) 
			con.OSG.drawString("A����̃^�[���ł�",600,350);
		else if (con.turn==1) 
			con.OSG.drawString("B����̃^�[���ł�",600,350);
		else if (con.turn==2)
			con.OSG.drawString("C����̃^�[���ł�",600,350);
		else if (con.turn==3) 
			con.OSG.drawString("D����̃^�[���ł�",600,350);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		if (con.deme>0) 
			con.OSG.drawString("����"+con.deme+"�}�X�i�߂܂�",600,400);
		
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (game.mode==2) {
			if (masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32)
				con.OSG.drawString("�C�x���g�}�X�ɒ�܂�܂���",600,400);
			if (masu==0||masu==9||masu==18||masu==27)
				con.OSG.drawString("�C�x���g�}�X�ɒ�܂�܂���",600,400);
			else if(masu!=4 && masu!=5 && masu!=13 && masu!=14 && masu!=22 && masu!=23 && masu!=31 && masu!=32 && masu!=0 && masu!=9 && masu!=18 && masu!=27)
			con.OSG.drawString("�ʏ�}�X�ɒ�܂�܂���",600,400);
		}
	}
	
	
	public static void �������̊m�F() {
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
	public static void �����̊m�F() {
		kabukaOta=kabu.getKabukaOta();
		kabukaFuku=kabu.getKabukaFuku();
		kabukaUchi=kabu.getKabukaUchi();
		kabukaTom=kabu.getKabukaTom();
	}
	public static void �������̕\��(Graphics g) {
		�������̊m�F();
		�����̊m�F();
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("������",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*3);
		con.OSG.drawString("������",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString("������",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*7);
		con.OSG.drawString("������",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*9);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		
		//A
		con.OSG.drawString("���c������:"+kabuOta_A+" �� ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3);
		con.OSG.drawString("�����d��:"+kabuFuku_A+" �� ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+20);
		con.OSG.drawString("�E�`�N��:"+kabuUchi_A+" �� ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+40);
		con.OSG.drawString("���i���s�㗝�X:"+kabuTom_A+" �� ",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*3+60);
		
		//B
		con.OSG.drawString("���c������:"+kabuOta_B+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString("�����d��:"+kabuFuku_B+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+20);
		con.OSG.drawString("�E�`�N��:"+kabuUchi_B+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+40);
		con.OSG.drawString("���i���s�㗝�X:"+kabuTom_B+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*5+60);
		
		//C
		con.OSG.drawString("���c������:"+kabuOta_C+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7);
		con.OSG.drawString("�����d��:"+kabuFuku_C+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+20);
		con.OSG.drawString("�E�`�N��:"+kabuUchi_C+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+40);
		con.OSG.drawString("���i���s�㗝�X:"+kabuTom_C+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*7+60);
		
		//D
		con.OSG.drawString("���c������:"+kabuOta_D+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9);
		con.OSG.drawString("�����d��:"+kabuFuku_D+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+20);
		con.OSG.drawString("�E�`�N��:"+kabuUchi_D+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+40);
		con.OSG.drawString("���i���s�㗝�X:"+kabuTom_D+" ��",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*9+60);
	}
	public static void �������Y�̕\��(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*2+20,FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2+20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2,FRAMEPOSX+FRAMEWIDTH*10+180,FRAMEPOSY+FRAMEHEIGHT*2+20);
		
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,40));
		con.OSG.drawString("�������Y�̓���",FRAMEPOSX+FRAMEWIDTH*10+80,FRAMEPOSY+FRAMEHEIGHT);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		
		con.OSG.setFont(new Font ("Serif",Font.ITALIC,25));
		con.OSG.drawString("�v���[���[A",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*2+20);
		con.OSG.drawString("�v���[���[B",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*4+20);
		con.OSG.drawString("�v���[���[C",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*6+20);
		con.OSG.drawString("�v���[���[D",FRAMEPOSX+FRAMEWIDTH*10+30,FRAMEPOSY+FRAMEHEIGHT*8+20);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		�������̕\��(g);
		�������̕\��(g);
		�����Y�̕\��(g);
		���ʂ̕\��(g);
	}
	public static void �����Y�̕\��(Graphics g) {
		//�v���C���[A�̎��Y
		int money=playerA.getMoney();
		int kabuOta=kabu.getKabukaOta()*playerA.getKabuOta();
		int kabuFuku=kabu.getKabukaFuku()*playerA.getKabuFuku();
		int kabuUchi=kabu.getKabukaUchi()*playerA.getKabuUchi();
		int kabuTom=kabu.getKabukaTom()*playerA.getKabuTom();
		capitalA=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("�����Y",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*3-30);
		con.OSG.drawString(capitalA+" �~",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*3);
		
		//�v���C���[B�̎��Y
		money=playerB.getMoney();
		kabuOta=kabu.getKabukaOta()*playerB.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerB.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerB.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerB.getKabuTom();
		capitalB=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("�����Y",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*5-30);
		con.OSG.drawString(capitalB+" �~",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*5);
		
		//�v���C���[C�̎��Y
		money=playerC.getMoney();
		kabuOta=kabu.getKabukaOta()*playerC.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerC.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerC.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerC.getKabuTom();
		capitalC=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("�����Y",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*7-30);
		con.OSG.drawString(capitalC+" �~",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*7);
		
		//�v���C���[D�̎��Y
		money=playerD.getMoney();
		kabuOta=kabu.getKabukaOta()*playerD.getKabuOta();
		kabuFuku=kabu.getKabukaFuku()*playerD.getKabuFuku();
		kabuUchi=kabu.getKabukaUchi()*playerD.getKabuUchi();
		kabuTom=kabu.getKabukaTom()*playerD.getKabuTom();
		capitalD=money+kabuOta+kabuFuku+kabuUchi+kabuTom;
		con.OSG.drawString("�����Y",FRAMEPOSX+FRAMEWIDTH*10+250,FRAMEPOSY+FRAMEHEIGHT*9-30);
		con.OSG.drawString(capitalD+" �~",FRAMEPOSX+FRAMEWIDTH*10+260,FRAMEPOSY+FRAMEHEIGHT*9);
	}
	public static void ���ʂ̕\��(Graphics g) {
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
			con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
		}else {
			if (cap[0]==a) con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[1]==a) con.OSG.drawString("�Q��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[2]==a) con.OSG.drawString("�R��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			else if (cap[3]==a) con.OSG.drawString("�S��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*3+60);
			
			if (cap[0]==b) con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[1]==b) con.OSG.drawString("�Q��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[2]==b) con.OSG.drawString("�R��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			else if (cap[3]==b) con.OSG.drawString("�S��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*5+60);
			
			if (cap[0]==c) con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[1]==c) con.OSG.drawString("�Q��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[2]==c) con.OSG.drawString("�R��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			else if (cap[3]==c) con.OSG.drawString("�S��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*7+60);
			
			if (cap[0]==d) con.OSG.drawString("�P��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[1]==d) con.OSG.drawString("�Q��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[2]==d) con.OSG.drawString("�R��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
			else if (cap[3]==d) con.OSG.drawString("�S��",FRAMEPOSX+FRAMEWIDTH*10+280,FRAMEPOSY+FRAMEHEIGHT*9+60);
		}
	}
	public static void �������̕\��(Graphics g) {
		int moneyA=playerA.getMoney();
		int moneyB=playerB.getMoney();
		int moneyC=playerC.getMoney();
		int moneyD=playerD.getMoney();
		
		//A
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("����",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*2+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		con.OSG.drawString(moneyA+"�~",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*2+45);
		
		//B
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("����",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*4+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		con.OSG.drawString(moneyB+"  �~",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*4+45);
		
		//C
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("����",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*6+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		con.OSG.drawString(moneyC+"  �~",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*6+45);
		
		//D
		con.OSG.setFont(new Font ("Serif",Font.PLAIN,18));
		con.OSG.drawString("����",FRAMEPOSX+FRAMEWIDTH*10+25,FRAMEPOSY+FRAMEHEIGHT*8+45);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));				//�f�t�H���g�̃T�C�Y
		con.OSG.drawString(moneyD+"  �~",FRAMEPOSX+FRAMEWIDTH*10+90,FRAMEPOSY+FRAMEHEIGHT*8+45);
	}
	public static void �����̕\��(Graphics g) {
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,25));
		con.OSG.drawString(kabu.getKabukaOta() + "  �~",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*3 + 30);
		con.OSG.drawString(kabu.getKabukaFuku() + "  �~",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*5 + 30);
		con.OSG.drawString(kabu.getKabukaUchi() + "  �~",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*7 + 30);
		con.OSG.drawString(kabu.getKabukaTom() + "  �~",FRAMEPOSX -240,FRAMEPOSY + FRAMEHEIGHT*9 + 30);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
	}
	//��������\������g�̕\��
	public static void �������\���g�̕`��(Graphics g) {
		for (int i=0;i<=10;i+=2)
			con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*i,FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY+FRAMEHEIGHT*i);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY,FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY+FRAMEHEIGHT*10);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY,FRAMEPOSX+FRAMEWIDTH*10+420,FRAMEPOSY+FRAMEHEIGHT*10);
	}
	public static void �C�x���g�g�̕\��(Graphics g) {
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*9-20,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*9-20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH+20,FRAMEPOSY+FRAMEHEIGHT*9-20);
		con.OSG.drawLine(FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*5,FRAMEPOSX+FRAMEWIDTH*9-20,FRAMEPOSY+FRAMEHEIGHT*9-20);
	}
	//�����\���̘g�̕`��
	public static void �����̘g�̕\��(Graphics g) {
		//OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY,FRAMEPOSX-20,FRAMEPOSY);
		for (int i=0;i<=10;i+=2)
			con.OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY+FRAMEHEIGHT*i,FRAMEPOSX-20,FRAMEPOSY+FRAMEHEIGHT*i);
		con.OSG.drawLine(FRAMEPOSX-420,FRAMEPOSY,FRAMEPOSX-420,FRAMEPOSY+FRAMEHEIGHT*10);
		con.OSG.drawLine(FRAMEPOSX-20,FRAMEPOSY,FRAMEPOSX-20,FRAMEPOSY+FRAMEHEIGHT*10);
	}
	//�Ֆʂ̘g����`�悷��
	public static void �g�̕\��(Graphics g) {
		
		//�����̕\��
		for (int i=0;i<11;i++) {
			if (i<2||i>8) {
				con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH*10+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
			}
			else{
				con.OSG.drawLine(FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
				con.OSG.drawLine(FRAMEPOSX+(10*FRAMEWIDTH),FRAMEPOSY+(i*FRAMEHEIGHT),FRAMEWIDTH*9+FRAMEPOSX,FRAMEPOSY+(i*FRAMEHEIGHT));
			}
		}
		
		//�c���̕\��
		for (int i=0;i<11;i++) {
			if (i<2||i>8)
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY,FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+(10*FRAMEHEIGHT));
			else 
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY,FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+FRAMEHEIGHT);
			con.OSG.drawLine(FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+(10*FRAMEHEIGHT),FRAMEPOSX+(i*FRAMEWIDTH),FRAMEPOSY+FRAMEHEIGHT*9);
		}
	}
}