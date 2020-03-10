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

	public static void 家の購入処理(int turn,int masu) {
		if (turn==0) {
			playerA.家の追加(masu);
			playerA.お金の増減(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==1) {
			playerB.家の追加(masu);
			playerB.お金の増減(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==2) {
			playerC.家の追加(masu);
			playerC.お金の増減(con.housePrice[masu]*-1);
			game.mode=5;
		}
		else if (turn==3) {
			playerD.家の追加(masu);
			playerD.お金の増減(con.housePrice[masu]*-1);
			game.mode=5;
		}
	}
	public static void 通行料の支払い(int turn,int masu) {
		int playerNumber=家の所持者を確認(masu);
		if (turn==playerNumber); //"自分が所持している家です"
		else if (turn==0) {
			playerA.お金の増減(con.通行料[masu]*-1);
			if (playerNumber==1) playerB.お金の増減(con.通行料[masu]);
			if (playerNumber==2) playerC.お金の増減(con.通行料[masu]);
			if (playerNumber==3) playerD.お金の増減(con.通行料[masu]);
		}else if (turn==1) {
			playerB.お金の増減(con.通行料[masu]*-1);
			if (playerNumber==0) playerA.お金の増減(con.通行料[masu]);
			if (playerNumber==2) playerC.お金の増減(con.通行料[masu]);
			if (playerNumber==3) playerD.お金の増減(con.通行料[masu]);
		}else if (turn==2) {
			playerC.お金の増減(con.通行料[masu]*-1);
			if (playerNumber==0) playerA.お金の増減(con.通行料[masu]);
			if (playerNumber==1) playerB.お金の増減(con.通行料[masu]);
			if (playerNumber==3) playerD.お金の増減(con.通行料[masu]);
		}else if (turn==3) {
			playerD.お金の増減(con.通行料[masu]*-1);
			if (playerNumber==0) playerA.お金の増減(con.通行料[masu]);
			if (playerNumber==1) playerB.お金の増減(con.通行料[masu]);
			if (playerNumber==2) playerC.お金の増減(con.通行料[masu]);
		}
	}
	public static int 家の所持者を確認 (int masu) {
		boolean check=playerA.家の確認(masu);
		if (check==true) return 0;
		check=playerB.家の確認(masu);
		if (check==true) return 1;
		check=playerC.家の確認(masu);
		if (check==true) return 2;
		return 3;
	}
	public static boolean houseCheck(int masu) {
		boolean check=playerA.家の確認(masu);
		if (check==false) check=playerB.家の確認(masu);
		if (check==false) check=playerC.家の確認(masu);
		if (check==false) check=playerD.家の確認(masu);
		return check;
	}
	public static void イベント処理(int turn,int eventNumber) {
		
		if (eventNumber==0) {
			if (turn==0) playerA.お金の増減(30000);
			if (turn==1) playerB.お金の増減(30000);
			if (turn==2) playerC.お金の増減(30000);
			if (turn==3) playerD.お金の増減(30000);
		}else if (eventNumber==1) {
			if (turn==0) playerA.お金の増減(5000);
			if (turn==1) playerB.お金の増減(5000);
			if (turn==2) playerC.お金の増減(5000);
			if (turn==3) playerD.お金の増減(5000);
		}else if (eventNumber==2) {
			if (turn==0) playerA.お金の増減(100000);
			if (turn==1) playerB.お金の増減(100000);
			if (turn==2) playerC.お金の増減(100000);
			if (turn==3) playerD.お金の増減(100000);
		}else if (eventNumber==3) {
			if (turn==0) playerA.お金の増減(50000);
			if (turn==1) playerB.お金の増減(50000);
			if (turn==2) playerC.お金の増減(50000);
			if (turn==3) playerD.お金の増減(50000);
		}else if (eventNumber==4) {
			if (turn==0) playerA.お金の増減(-30000);
			if (turn==1) playerB.お金の増減(-30000);
			if (turn==2) playerC.お金の増減(-30000);
			if (turn==3) playerD.お金の増減(-30000);
		}else if (eventNumber==5) {
			if (turn==0) playerA.お金の増減(3000);
			if (turn==1) playerB.お金の増減(3000);
			if (turn==2) playerC.お金の増減(3000);
			if (turn==3) playerD.お金の増減(3000);
		}if (eventNumber==6) {
			if (turn==0) playerA.家のランダム減少();
			if (turn==1) playerB.家のランダム減少();
			if (turn==2) playerC.家のランダム減少();
			if (turn==3) playerD.家のランダム減少();
		}
		else if (eventNumber==7) {
			if (turn==0) playerA.お金の増減(-3000);
			if (turn==1) playerB.お金の増減(-3000);
			if (turn==2) playerC.お金の増減(-3000);
			if (turn==3) playerD.お金の増減(-3000);
		}else if (eventNumber==8) {
			if (turn==0) playerA.A=9;
			if (turn==1) playerB.B=9;
			if (turn==2) playerC.C=9;
			if (turn==3) playerD.D=9;
		}else if (eventNumber==9) {
			if (turn==0) playerA.休み();
			if (turn==1) playerB.休み();
			if (turn==2) playerC.休み();
			if (turn==3) playerD.休み();
		}else if (eventNumber==10) {
			if (turn==0) playerA.お金の増減(-3000);
			if (turn==1) playerB.お金の増減(-3000);
			if (turn==2) playerC.お金の増減(-3000);
			if (turn==3) playerD.お金の増減(-3000);
		}else if (eventNumber==11) {
			if (turn==0) playerA.株の増減(0,1);
			if (turn==1) playerB.株の増減(0,1);
			if (turn==2) playerC.株の増減(0,1);
			if (turn==3) playerD.株の増減(0,1);
		}else if (eventNumber==12) {
			if (turn==0) playerA.株の増減(1,1);
			if (turn==1) playerB.株の増減(1,1);
			if (turn==2) playerC.株の増減(1,1);
			if (turn==3) playerD.株の増減(1,1);
		}else if (eventNumber==13) {
			if (turn==0) playerA.株の増減(2,1);
			if (turn==1) playerB.株の増減(2,1);
			if (turn==2) playerC.株の増減(2,1);
			if (turn==3) playerD.株の増減(2,1);
		}else if (eventNumber==14) {
			if (turn==0) playerA.株の増減(3,1);
			if (turn==1) playerB.株の増減(3,1);
			if (turn==2) playerC.株の増減(3,1);
			if (turn==3) playerD.株の増減(3,1);
		}else if (eventNumber==15) {
			if (turn==0) playerA.お金の増減(1000);
			if (turn==1) playerB.お金の増減(1000);
			if (turn==2) playerC.お金の増減(1000);
			if (turn==3) playerD.お金の増減(1000);
		}else if (eventNumber==16) {
			playerA.お金の増減(-5000);
			playerB.お金の増減(-5000);
			playerC.お金の増減(-5000);
			playerD.お金の増減(-5000);
		}else if (eventNumber==17) {
			if (turn==0) playerA.お金の増減(-75000);
			if (turn==1) playerB.お金の増減(-75000);
			if (turn==2) playerC.お金の増減(-75000);
			if (turn==3) playerD.お金の増減(-75000);
		}else if (eventNumber==18) {
			if (turn==0) playerA.お金の増減(-20000);
			if (turn==1) playerB.お金の増減(-20000);
			if (turn==2) playerC.お金の増減(-20000);
			if (turn==3) playerD.お金の増減(-20000);
		}else if (eventNumber==19) {
			if (turn==0) playerA.A=9;
			if (turn==1) playerB.B=9;
			if (turn==2) playerC.C=9;
			if (turn==3) playerD.D=9;
		}else if (eventNumber==20) {
			if (turn==0) playerA.お金の増減(-10000);
			if (turn==1) playerB.お金の増減(-10000);
			if (turn==2) playerC.お金の増減(-10000);
			if (turn==3) playerD.お金の増減(-10000);
		}else if (eventNumber==21) {
			if (turn==0) playerA.お金の増減(-30000);
			if (turn==1) playerB.お金の増減(-30000);
			if (turn==2) playerC.お金の増減(-30000);
			if (turn==3) playerD.お金の増減(-30000);
		}else if (eventNumber==22) {
			if (turn==0) playerA.お金の増減(125000);
			if (turn==1) playerB.お金の増減(125000);
			if (turn==2) playerC.お金の増減(125000);
			if (turn==3) playerD.お金の増減(125000);
		}else if (eventNumber==23) {
			if (turn==0) playerA.お金の増減(-10000);
			if (turn==1) playerB.お金の増減(-10000);
			if (turn==2) playerC.お金の増減(-10000);
			if (turn==3) playerD.お金の増減(-10000);
		}else if (eventNumber==24) {
			if (turn==0) playerA.お金の増減(-30000);
			if (turn==1) playerB.お金の増減(-30000);
			if (turn==2) playerC.お金の増減(-30000);
			if (turn==3) playerD.お金の増減(-30000);
		}else if (eventNumber==25) {
			if (turn==0) playerA.お金の増減(-100000);
			if (turn==1) playerB.お金の増減(-100000);
			if (turn==2) playerC.お金の増減(-100000);
			if (turn==3) playerD.お金の増減(-100000);
		}else if (eventNumber==26) {
			if (turn==0) playerA.お金の増減(-20000);
			if (turn==1) playerB.お金の増減(-20000);
			if (turn==2) playerC.お金の増減(-20000);
			if (turn==3) playerD.お金の増減(-20000);
		}
		draw.eventCount++;
	}
	public static void 特別イベント処理(int turn,int eventNumber) {
		if (eventNumber==0) {
			if (turn==0) playerA.お金の増減(20000);
			if (turn==1) playerB.お金の増減(20000);
			if (turn==2) playerC.お金の増減(20000);
			if (turn==3) playerD.お金の増減(20000);
		}else if (eventNumber==1) {
			if (turn==0) playerA.刑務所に入る();
			if (turn==1) playerB.刑務所に入る();
			if (turn==2) playerC.刑務所に入る();
			if (turn==3) playerD.刑務所に入る();
		}else if (eventNumber==2) {
			if (turn==0) {
				//playerA.A=0;
				playerA.お金の増減(20000);
			}
			if (turn==1) {
				//playerB.お金の増減(20000);
				playerB.B=0;
			}
			if (turn==2) {
				//playerC.お金の増減(20000);
				playerC.C=0;
			}
			if (turn==3) {
				//playerD.D=0;
				playerD.お金の増減(20000);
			}
		}
		draw.eventCount++;
	}
}