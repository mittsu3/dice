import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Event {
	static Configuration con = new Configuration();
	static draw draw=new draw();
	static game game=new game();
	static PlayerA playerA=new PlayerA();
	static PlayerB playerB=new PlayerB();
	static PlayerC playerC=new PlayerC();
	static PlayerD playerD=new PlayerD();

	public static void �Ƃ̍w������(int turn,int masu) {
		if (turn==0) {
			playerA.�Ƃ̒ǉ�(masu);
			playerA.�����̑���(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==1) {
			playerB.�Ƃ̒ǉ�(masu);
			playerB.�����̑���(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==2) {
			playerC.�Ƃ̒ǉ�(masu);
			playerC.�����̑���(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==3) {
			playerD.�Ƃ̒ǉ�(masu);
			playerD.�����̑���(con.housePrice[masu]*-1);
			game.mode=5;
		}
	}
	public static void �ʍs���̎x����(int turn,int masu) {
		int playerNumber=�Ƃ̏����҂��m�F(masu);
		if (turn==playerNumber); //"�������������Ă���Ƃł�"
		else if (turn==0) {
			playerA.�����̑���(con.�ʍs��[masu]*-1);
			if (playerNumber==1) playerB.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==2) playerC.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==3) playerD.�����̑���(con.�ʍs��[masu]);
		}else if (turn==1) {
			playerB.�����̑���(con.�ʍs��[masu]*-1);
			if (playerNumber==0) playerA.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==2) playerC.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==3) playerD.�����̑���(con.�ʍs��[masu]);
		}else if (turn==2) {
			playerC.�����̑���(con.�ʍs��[masu]*-1);
			if (playerNumber==0) playerA.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==1) playerB.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==3) playerD.�����̑���(con.�ʍs��[masu]);
		}else if (turn==3) {
			playerD.�����̑���(con.�ʍs��[masu]*-1);
			if (playerNumber==0) playerA.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==1) playerB.�����̑���(con.�ʍs��[masu]);
			if (playerNumber==2) playerC.�����̑���(con.�ʍs��[masu]);
		}
	}
	public static int �Ƃ̏����҂��m�F (int masu) {
		boolean check=playerA.�Ƃ̊m�F(masu);
		if (check==true) return 0;
		check=playerB.�Ƃ̊m�F(masu);
		if (check==true) return 1;
		check=playerC.�Ƃ̊m�F(masu);
		if (check==true) return 2;
		return 3;
	}
	public static boolean houseCheck(int masu) {
		boolean check=playerA.�Ƃ̊m�F(masu);
		if (check==false) check=playerB.�Ƃ̊m�F(masu);
		if (check==false) check=playerC.�Ƃ̊m�F(masu);
		if (check==false) check=playerD.�Ƃ̊m�F(masu);
		return check;
	}
	public static void �C�x���g����(int turn,int eventNumber) {
		
		if (eventNumber==0) {
			if (turn==0) playerA.�����̑���(30000);
			if (turn==1) playerB.�����̑���(30000);
			if (turn==2) playerC.�����̑���(30000);
			if (turn==3) playerD.�����̑���(30000);
		}else if (eventNumber==1) {
			if (turn==0) playerA.�����̑���(5000);
			if (turn==1) playerB.�����̑���(5000);
			if (turn==2) playerC.�����̑���(5000);
			if (turn==3) playerD.�����̑���(5000);
		}else if (eventNumber==2) {
			if (turn==0) playerA.�����̑���(100000);
			if (turn==1) playerB.�����̑���(100000);
			if (turn==2) playerC.�����̑���(100000);
			if (turn==3) playerD.�����̑���(100000);
		}else if (eventNumber==3) {
			if (turn==0) playerA.�����̑���(50000);
			if (turn==1) playerB.�����̑���(50000);
			if (turn==2) playerC.�����̑���(50000);
			if (turn==3) playerD.�����̑���(50000);
		}else if (eventNumber==4) {
			if (turn==0) playerA.�����̑���(-30000);
			if (turn==1) playerB.�����̑���(-30000);
			if (turn==2) playerC.�����̑���(-30000);
			if (turn==3) playerD.�����̑���(-30000);
		}else if (eventNumber==5) {
			if (turn==0) playerA.�����̑���(3000);
			if (turn==1) playerB.�����̑���(3000);
			if (turn==2) playerC.�����̑���(3000);
			if (turn==3) playerD.�����̑���(3000);
		}if (eventNumber==6) {
			if (turn==0) playerA.�Ƃ̃����_������();
			if (turn==1) playerB.�Ƃ̃����_������();
			if (turn==2) playerC.�Ƃ̃����_������();
			if (turn==3) playerD.�Ƃ̃����_������();
		}
		else if (eventNumber==7) {
			if (turn==0) playerA.�����̑���(-3000);
			if (turn==1) playerB.�����̑���(-3000);
			if (turn==2) playerC.�����̑���(-3000);
			if (turn==3) playerD.�����̑���(-3000);
		}else if (eventNumber==8) {
			if (turn==0) playerA.A=9;
			if (turn==1) playerB.B=9;
			if (turn==2) playerC.C=9;
			if (turn==3) playerD.D=9;
		}else if (eventNumber==9) {
			if (turn==0) playerA.�x��();
			if (turn==1) playerB.�x��();
			if (turn==2) playerC.�x��();
			if (turn==3) playerD.�x��();
		}else if (eventNumber==10) {
			if (turn==0) playerA.�����̑���(-3000);
			if (turn==1) playerB.�����̑���(-3000);
			if (turn==2) playerC.�����̑���(-3000);
			if (turn==3) playerD.�����̑���(-3000);
		}else if (eventNumber==11) {
			if (turn==0) playerA.���̑���(0,1);
			if (turn==1) playerB.���̑���(0,1);
			if (turn==2) playerC.���̑���(0,1);
			if (turn==3) playerD.���̑���(0,1);
		}else if (eventNumber==12) {
			if (turn==0) playerA.���̑���(1,1);
			if (turn==1) playerB.���̑���(1,1);
			if (turn==2) playerC.���̑���(1,1);
			if (turn==3) playerD.���̑���(1,1);
		}else if (eventNumber==13) {
			if (turn==0) playerA.���̑���(2,1);
			if (turn==1) playerB.���̑���(2,1);
			if (turn==2) playerC.���̑���(2,1);
			if (turn==3) playerD.���̑���(2,1);
		}else if (eventNumber==14) {
			if (turn==0) playerA.���̑���(3,1);
			if (turn==1) playerB.���̑���(3,1);
			if (turn==2) playerC.���̑���(3,1);
			if (turn==3) playerD.���̑���(3,1);
		}else if (eventNumber==15) {
			if (turn==0) playerA.�����̑���(1000);
			if (turn==1) playerB.�����̑���(1000);
			if (turn==2) playerC.�����̑���(1000);
			if (turn==3) playerD.�����̑���(1000);
		}else if (eventNumber==16) {
			playerA.�����̑���(-5000);
			playerB.�����̑���(-5000);
			playerC.�����̑���(-5000);
			playerD.�����̑���(-5000);
		}else if (eventNumber==17) {
			if (turn==0) playerA.�����̑���(-75000);
			if (turn==1) playerB.�����̑���(-75000);
			if (turn==2) playerC.�����̑���(-75000);
			if (turn==3) playerD.�����̑���(-75000);
		}else if (eventNumber==18) {
			if (turn==0) playerA.�����̑���(-20000);
			if (turn==1) playerB.�����̑���(-20000);
			if (turn==2) playerC.�����̑���(-20000);
			if (turn==3) playerD.�����̑���(-20000);
		}else if (eventNumber==19) {
			if (turn==0) playerA.A=9;
			if (turn==1) playerB.B=9;
			if (turn==2) playerC.C=9;
			if (turn==3) playerD.D=9;
		}else if (eventNumber==20) {
			if (turn==0) playerA.�����̑���(-10000);
			if (turn==1) playerB.�����̑���(-10000);
			if (turn==2) playerC.�����̑���(-10000);
			if (turn==3) playerD.�����̑���(-10000);
		}else if (eventNumber==21) {
			if (turn==0) playerA.�����̑���(-30000);
			if (turn==1) playerB.�����̑���(-30000);
			if (turn==2) playerC.�����̑���(-30000);
			if (turn==3) playerD.�����̑���(-30000);
		}else if (eventNumber==22) {
			if (turn==0) playerA.�����̑���(125000);
			if (turn==1) playerB.�����̑���(125000);
			if (turn==2) playerC.�����̑���(125000);
			if (turn==3) playerD.�����̑���(125000);
		}else if (eventNumber==23) {
			if (turn==0) playerA.�����̑���(-10000);
			if (turn==1) playerB.�����̑���(-10000);
			if (turn==2) playerC.�����̑���(-10000);
			if (turn==3) playerD.�����̑���(-10000);
		}else if (eventNumber==24) {
			if (turn==0) playerA.�����̑���(-30000);
			if (turn==1) playerB.�����̑���(-30000);
			if (turn==2) playerC.�����̑���(-30000);
			if (turn==3) playerD.�����̑���(-30000);
		}else if (eventNumber==25) {
			if (turn==0) playerA.�����̑���(-100000);
			if (turn==1) playerB.�����̑���(-100000);
			if (turn==2) playerC.�����̑���(-100000);
			if (turn==3) playerD.�����̑���(-100000);
		}else if (eventNumber==26) {
			if (turn==0) playerA.�����̑���(-20000);
			if (turn==1) playerB.�����̑���(-20000);
			if (turn==2) playerC.�����̑���(-20000);
			if (turn==3) playerD.�����̑���(-20000);
		}
		draw.eventCount++;
	}
	public static void ���ʃC�x���g����(int turn,int eventNumber) {
		if (eventNumber==0) {
			if (turn==0) playerA.�����̑���(20000);
			if (turn==1) playerB.�����̑���(20000);
			if (turn==2) playerC.�����̑���(20000);
			if (turn==3) playerD.�����̑���(20000);
		}else if (eventNumber==1) {
			if (turn==0) playerA.�Y�����ɓ���();
			if (turn==1) playerB.�Y�����ɓ���();
			if (turn==2) playerC.�Y�����ɓ���();
			if (turn==3) playerD.�Y�����ɓ���();
		}else if (eventNumber==2) {
			if (turn==0) {
				//playerA.A=0;
				playerA.�����̑���(20000);
			}
			if (turn==1) {
				//playerB.�����̑���(20000);
				playerB.B=0;
			}
			if (turn==2) {
				//playerC.�����̑���(20000);
				playerC.C=0;
			}
			if (turn==3) {
				//playerD.D=0;
				playerD.�����̑���(20000);
			}
		}
		draw.eventCount++;
	}
}