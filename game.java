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
			  FRAMEPOSY=150,FRAMEHEIGHT=70;					//�g���̈ʒu�ݒ�
	static int gameMode=0;				//0:�^�C�g����ʂ�\��
	static int mode=-1;					//-1:�j���[�X����,0:��������,1:�ړ�,2:�C�x���g����,3:�Ƃ̔���,4:�Ƃ̏���,5:���̔���,6:���̏���,7:�^�[���I��
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
	�j���[�X �j���[�X=new �j���[�X();
	int newsNumber;
	Image ���[��A,���[��B,���[�h�w�i;
	int change=0;
	int t1;
	boolean check;
	int �Y�����J�E���gA,�Y�����J�E���gB,�Y�����J�E���gC,�Y�����J�E���gD;
	boolean sleepCheck;
	
	
	
	//�ŏ��ɍs������
	public void init() {
		setLayout(null);
		con.���W�̐ݒ�();
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
		komaA=getImage(getDocumentBase(),"����.png");
		komaB=getImage(getDocumentBase(),"���[��.png");
		komaC=getImage(getDocumentBase(),"�セ��.png");
		komaD=getImage(getDocumentBase(),"�V��.png");
		houseA=getImage(getDocumentBase(),"�Ԃ���.png");
		houseB=getImage(getDocumentBase(),"����.png");
		houseC=getImage(getDocumentBase(),"�΂̉�.png");
		houseD=getImage(getDocumentBase(),"���F�̉�.png");
		���[��A=getImage(getDocumentBase(),"���[��.jpg");
		���[��B=getImage(getDocumentBase(),"�������.png");
		���[�h�w�i=getImage(getDocumentBase(),"��.jpg");
		
		
		if (gameMode==0) {
			bt2=new Button("NEW GAME");
			add(bt2);
			bt2.setBounds(300,700,100,50);
			bt2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					con.OSG.clearRect(0,0,getSize().width,getSize().height); //�I�t�X�N���[���̏�����
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
	//�`�悷��
	public void paint(Graphics g) {
		if (gameMode==0) {
			title=getImage(getDocumentBase(),"sun.jpeg");
			con.OSG.drawImage(title,0,0,getSize().width,getSize().height,this);
			draw.�^�C�g����ʂ�\��(g);
		}
		if (gameMode==1) {
			con.OSG.drawImage(���[�h�w�i,0,0,getSize().width,getSize().height,this);
			gameMode=2;
		}
		if (gameMode==2) {
			gameMode=3;
			th=new Thread(this);
			th.start();
		}
		if (gameMode==3) {
			gameMode++;
			//if (num<210) con.OSG.drawImage(���[��A,0,0,getSize().width,getSize().height,this);
			//if (num>600) con.OSG.drawImage(���[��B,200,0,getSize().width-300,750,this);
			//���[�h���(g);
		}else if (gameMode==4) ����(g);
		else if (gameMode==5) {
			con.OSG.clearRect(0,0,getSize().width,getSize().height); //�I�t�X�N���[���̏�����
			con.OSG.setColor(Color.white);
			�Q�[���{��(g);
		}
		g.drawImage(con.OSI,0,0,this);
	}
	public void ����(Graphics g) {
		gameMode++;
		remove(bt2);
		con.OSG.clearRect(0,0,getSize().width,getSize().height); //�I�t�X�N���[���̏�����
		con.OSG.setColor(Color.black);
		con.OSG.fillRect(0,0,getSize().width,getSize().height);
		repaint();
	}
	public void ���[�h���(Graphics g) {
		
		con.OSG.setColor(Color.black);
		���[�f�B���O�g�̕\��(g);
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
	public void �Q�[���{��(Graphics g) {
		con.OSG.drawImage(backGround,0,0,getSize().width,getSize().height,this);
		draw.�g�̕\��(g);
		draw.�����̘g�̕\��(g);
		draw.�C�x���g�g�̕\��(g);
		draw.�������\���g�̕`��(g);
		draw.�������Y�̕\��(g);
		draw.�^�[���̕\��(g);
		�C�x���g�}�X�̓h��Ԃ�(g);
		�R�}�̕\��(g);
		
		draw.��Ж��\��(g);
		draw.�j���[�X�g�\��(g);
		�{�^���̕\��(g);
		draw.�����̕\��(g);
		���x�ύX�{�^���̕\��(g);
		�Ƃ̕\��(g);
		
		con.OSG.drawString(�Y�����J�E���gA+" ",FRAMEPOSX+FRAMEWIDTH+100,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(�Y�����J�E���gB+" ",FRAMEPOSX+FRAMEWIDTH+110,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(�Y�����J�E���gC+" ",FRAMEPOSX+FRAMEWIDTH+100,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString(�Y�����J�E���gD+" ",FRAMEPOSX+FRAMEWIDTH+110,FRAMEPOSY+FRAMEHEIGHT*5);
		
		con.OSG.drawString(playerA.�Y�����`�F�b�N()+" ",FRAMEPOSX+FRAMEWIDTH+130,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(playerB.�Y�����`�F�b�N()+" ",FRAMEPOSX+FRAMEWIDTH+160,FRAMEPOSY+FRAMEHEIGHT*4);
		con.OSG.drawString(playerC.�Y�����`�F�b�N()+" ",FRAMEPOSX+FRAMEWIDTH+130,FRAMEPOSY+FRAMEHEIGHT*5);
		con.OSG.drawString(playerD.�Y�����`�F�b�N()+" ",FRAMEPOSX+FRAMEWIDTH+160,FRAMEPOSY+FRAMEHEIGHT*5);
		
		
		if (con.turn==0) sleepCheck=playerA.�x�݃`�F�b�N();
		if (con.turn==1) sleepCheck=playerB.�x�݃`�F�b�N();
		if (con.turn==2) sleepCheck=playerC.�x�݃`�F�b�N();
		if (con.turn==3) sleepCheck=playerD.�x�݃`�F�b�N();
		if (sleepCheck==true) mode=9;
		if (mode==13) �Y�����`�F�b�N(g);
		if (con.turn==0&&�Y�����J�E���gA==2) mode=9;
		if (con.turn==1&&�Y�����J�E���gB==2) mode=9;
		if (con.turn==2&&�Y�����J�E���gC==2) mode=9;
		if (con.turn==3&&�Y�����J�E���gD==2) mode=9;
		
		//if (check==true) mode=9;
		if (t==con.�^�[��) �T�C�R���\��(g);
		if (mode==11) {
			draw.�}�X�C�x���g(g);
		}
		int masu=0;
		if (con.turn==0) masu=playerA.A;
		if (con.turn==1) masu=playerB.B;
		if (con.turn==2) masu=playerC.C;
		if (con.turn==3) masu=playerD.D;
		if (mode==-1) �j���[�X�̌���();
		draw.�j���[�X�̕\��(g,newsNumber);
		if (mode==12) {
			mode=2;
			repaint();
		}
		if (mode==2&&(masu==4||masu==5||masu==13||masu==14||masu==22||masu==23||masu==31||masu==32||masu==9||masu==18||masu==27)) mode=5;
		//bt1:��������,bt2:NEWGAME,bt3:������,bt4:�������,bt5:�Ƃ𔃂�,bt6:�Ƃ𔃂�Ȃ�,bt7:�^�[���I��,bt8:���̍w��,bt9:���̔��p,bt10:���𔃂�Ȃ�
		

		
		
		if (mode==2) {
			if (Event.houseCheck(masu)==true) Event.�ʍs���̎x����(con.turn,masu);
			else �Ƃ̍w���{�^���̕\��();
		}
		if (mode==5) ���̍w���{�^���̕\��();
		if (mode==6) ������Ђ̑I���{�^���̕\��();
		if (mode==7) {
			�����������̒����{�^���̕\��();
			�����������̕\��(g);
			�����w���m�F�{�^���̕\��();
		}
		if (mode==8) {
			�����������̒����{�^���̕\��();
			�����������̕\��(g);
			�������p�m�F�{�^���̕\��();
		}
		if (mode==9) {
			END�{�^���̕\��();
			if (con.turn==0&&�Y�����J�E���gA==2) �Y�����̕\��(g);
			if (con.turn==1&&�Y�����J�E���gB==2) �Y�����̕\��(g);
			if (con.turn==2&&�Y�����J�E���gC==2) �Y�����̕\��(g);
			if (con.turn==3&&�Y�����J�E���gD==2) �Y�����̕\��(g);
		}
		if (mode==10) �m�F�{�^���̕\��();
	}
	public void �Y�����̕\��(Graphics g) {
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,24));
		con.OSG.drawString("���݌Y�����ɂ��邽�ߍs���ł��܂���",FRAMEPOSX+FRAMEWIDTH+40,FRAMEPOSY+FRAMEHEIGHT*6);
		con.OSG.setFont(new Font ("Dialog",Font.PLAIN,12));
		END�{�^���̕\��();
	}
	
	public void �Ƃ̕\��(Graphics g) {
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
	public void �Y�����`�F�b�N(Graphics g) {
		if (con.turn==0) {
			if (playerA.�Y�����`�F�b�N()==true) �Y�����J�E���gA++;
		}
		if (con.turn==1) {
			if (playerB.�Y�����`�F�b�N()==true) �Y�����J�E���gB++;
		}
		if (con.turn==2) {
			if (playerC.�Y�����`�F�b�N()==true) �Y�����J�E���gC++;
		}
		if (con.turn==3) {
			if (playerD.�Y�����`�F�b�N()==true) �Y�����J�E���gD++;
		}mode=0;
	}
	public void �C�x���g�}�X�̓h��Ԃ�(Graphics g) {
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
	
	public void �R�}�̕\��(Graphics g) {
		con.OSG.drawImage(komaA,con.Ax[con.aX],con.Ay[con.aY],20,20,this);
		con.OSG.drawImage(komaB,con.Bx[con.bX],con.By[con.bY],20,20,this);
		con.OSG.drawImage(komaC,con.Cx[con.cX],con.Cy[con.cY],20,20,this);
		con.OSG.drawImage(komaD,con.Dx[con.dX],con.Dy[con.dY],20,20,this);
	}
	public void ���̍w������(int storeNumber,int kabuNumber) {
		mode=5;
		int kabuka=0;
		if (storeNumber==0) kabuka=kabu.getKabukaOta();
		else if (storeNumber==1) kabuka=kabu.getKabukaFuku();
		else if (storeNumber==2) kabuka=kabu.getKabukaUchi();
		else if (storeNumber==3) kabuka=kabu.getKabukaTom();
		
		if (con.turn==0) {
			playerA.���̑���(storeNumber,kabuNumber);
			playerA.�����̑���(kabuka*kabuNumber*-1);
		}
		if (con.turn==1) {
			playerB.���̑���(storeNumber,kabuNumber);
			playerB.�����̑���(kabuka*kabuNumber*-1);
		}
		if (con.turn==2) {
			playerC.���̑���(storeNumber,kabuNumber);
			playerC.�����̑���(kabuka*kabuNumber*-1);
		}
		if (con.turn==3) {
			playerD.���̑���(storeNumber,kabuNumber);
			playerD.�����̑���(kabuka*kabuNumber*-1);
		}
	}
	public void ���̔��p����(int storeNumber,int kabuNumber) {
		mode=9;
		int kabuka=0;
		if (storeNumber==0) kabuka=kabu.getKabukaOta();
		else if (storeNumber==1) kabuka=kabu.getKabukaFuku();
		else if (storeNumber==2) kabuka=kabu.getKabukaUchi();
		else if (storeNumber==3) kabuka=kabu.getKabukaTom();
		
		if (con.turn==0) {
			playerA.���̑���(storeNumber,kabuNumber*-1);
			playerA.�����̑���(kabuka*kabuNumber);
		}
		if (con.turn==1) {
			playerB.���̑���(storeNumber,kabuNumber*-1);
			playerB.�����̑���(kabuka*kabuNumber);
		}
		if (con.turn==2) {
			playerC.���̑���(storeNumber,kabuNumber*-1);
			playerC.�����̑���(kabuka*kabuNumber);
		}
		if (con.turn==3) {
			playerD.���̑���(storeNumber,kabuNumber*-1);
			playerD.�����̑���(kabuka*kabuNumber);
		}
	}
	int money,masu;
	public void �Ƃ̍w���{�^���̕\��() {
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
			Event.�ʍs���̎x����(con.turn,masu);
			mode=5;
		}else if (con.housePrice[masu]<=money) {
			bt5=new Button("�Ƃ𔃂�");
			add(bt5);
			bt5.setBounds(FRAMEPOSX+FRAMEWIDTH*4,FRAMEPOSY+FRAMEHEIGHT*3,150,45);
			bt5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mode=4;					//4:������
					Event.�Ƃ̍w������(con.turn,masu);
					removeAll();
					repaint();
					
				}
			});
			
			bt6=new Button("�Ƃ𔃂�Ȃ�");
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
			con.OSG.drawString("������������Ȃ����߉Ƃ��w���ł��܂���",FRAMEPOSX+FRAMEWIDTH+80,FRAMEPOSY+FRAMEHEIGHT*6);
			mode=5;
		}
	}
	int buy;
	public void ���̍w���{�^���̕\��() {
		bt8=new Button("���̍w��");
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
		
		bt9=new Button("���̔��p");
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
		
		bt10=new Button("���𔃂�Ȃ�");
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
	public void �����������̕\��(Graphics g) {
		con.OSG.drawString(kabuNumber+" ��",FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*3);
	}
	int kabuNumber;
	public void �����������̒����{�^���̕\��() {
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
	public void �������p�m�F�{�^���̕\��() {
		Button bt21=new Button("���p����");
		add(bt21);
		bt21.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*5,100,30);
		bt21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				���̔��p����(storeNumber,kabuNumber);
				kabuNumber=0;
				removeAll();
				repaint();
			}
		});
	}
	public void �����w���m�F�{�^���̕\��() {
		Button bt16 = new Button("�w������");
		add(bt16);
		bt16.setBounds(FRAMEPOSX+FRAMEWIDTH*7,FRAMEPOSY+FRAMEHEIGHT*5,100,30);
		bt16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				���̍w������(storeNumber,kabuNumber);
				kabuNumber=0;
				removeAll();
				repaint();
			}
		});
	}int storeNumber;
	public void ������Ђ̑I���{�^���̕\��() {
		Button bt17=new Button("��c������");
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
		
		Button bt18=new Button("�����d��");
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
		
		
		Button bt19=new Button("�E�`�N��");
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
		
		
		Button bt20=new Button("���i���s�㗝�X");
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
	public void END�{�^���̕\��() {
		bt7=new Button("�^�[���I��");
		add(bt7);
		bt7.setBounds(FRAMEPOSX+FRAMEWIDTH*6,FRAMEPOSY+FRAMEHEIGHT*8,150,45);
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((con.turn==3&&mode==9)||(con.turn==3&&mode==12)) {
					�j���[�X.�j���[�X�C�x���g����(newsNumber);
					mode=10;
					count=0;
					removeAll();
					�m�F�{�^���̕\��();
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
	public void �m�F�{�^���̕\��() {
		Button bt11=new Button("�m�FOK");
		add(bt11);
		bt11.setBounds(FRAMEPOSX+FRAMEWIDTH*8,FRAMEPOSY+FRAMEHEIGHT*8,150,45);
		bt11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode=-1;
				con.turn=0;
				//�Y�����̃J�E���g();
				�Y�����̏���();
				removeAll();
				repaint();
			}
		});
	}
	public void �Y�����̃J�E���g() {
		if (playerA.�Y����==true) �Y�����J�E���gA++;
		if (playerB.�Y����==true) �Y�����J�E���gB++;
		if (playerC.�Y����==true) �Y�����J�E���gC++;
		if (playerD.�Y����==true) �Y�����J�E���gD++;
		
	}
	public void �Y�����̏���() {
		if (�Y�����J�E���gA==2) {
			playerA.�Y��������o��();
			�Y�����J�E���gA=0;
		}
		if (�Y�����J�E���gB==2) {
			playerB.�Y��������o��();
			�Y�����J�E���gB=0;
		}
		if (�Y�����J�E���gC==2) {
			playerC.�Y��������o��();
			�Y�����J�E���gC=0;
		}
		if (�Y�����J�E���gD==2) {
			playerD.�Y��������o��();
			�Y�����J�E���gD=0;
		}
	}
	public void �j���[�X�̌���() {
		Random r=new Random();
		newsNumber=r.nextInt(24);
		mode=13;
	}
	
	public void ���[�f�B���O�g�̕\��(Graphics g) {
		con.OSG.drawLine(210,850,1700,850);
		con.OSG.drawLine(210,810,1700,810);
		con.OSG.drawLine(210,850,210,810);
		con.OSG.drawLine(1700,850,1700,810);
	}
	public void �T�C�R���\��(Graphics g) {
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
	public void ���x�ύX�{�^���̕\��(Graphics g) {
		bt3=new Button("������");
		add(bt3);
		bt3.setBounds(FRAMEPOSX+FRAMEWIDTH*10+20,FRAMEPOSY-100,150,45);
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sleepTime=10;
			}
		});
		
		bt4=new Button("�������");
		add(bt4);
		bt4.setBounds(FRAMEPOSX+FRAMEWIDTH*10+20+170,FRAMEPOSY-100,150,45);
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sleepTime=500;
			}
		});
	}
	public void �{�^���̕\��(Graphics g) {
		bt1=new Button("��������");
		add(bt1);
		bt1.setBounds(600,250,150,45);
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mode==0) {
					��������();
					mode=1;
				}
				repaint();
			}
		});
	}
	//�T�C�R����U�鎞�̏���
	public void ��������() {
		Random r=new Random();
		deme1=r.nextInt(6)+1;
		deme2=r.nextInt(6)+1;//�T�C�R���̏o�ڂ𗐐��ŏo��	�͈�:2�`12
		//con.deme = deme1 + deme2;
		con.deme=9;
		t=con.�^�[��;
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
				int num1=����();
				int num2=����();
				int num3=����();
				for (int i=num;i<=getSize().width-200;i++) {
					num=i;
					repaint();
					if (i==num1*100) th.sleep(1500);
					else if (i==num2*100) th.sleep(1500);
					else if (i==num3*100) th.sleep(1500);
					else th.sleep(10);
					if (i==getSize().width-200) {
						bt3=new Button("�Q�[�����n�߂�");
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
	public int ����() {
		Random r=new Random();
		int a=r.nextInt(10)+2;
		return a;
	}
}