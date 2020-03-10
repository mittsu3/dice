import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class PlayerA {
	
	static ArrayList<Integer> houseList=new ArrayList();		//所持している家の一覧
	static int A;
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean 刑務所=true;
	public static void お金の増減(int a){
		money+=a;
	}public static void 株の増減(int store,int number) {
		if (store==0) kabuOta+=number;
		else if (store==1) kabuFuku+=number;
		else if (store==2) kabuUchi+=number;
		else if (store==3) kabuTom+=number;
	}
	public static int getMoney() {
		return money;
	}
	public static boolean 家の確認(int masu) {
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void 家の追加(int masu) {
		houseList.add(masu);
	}public static void 家の減少(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void 刑務所に入る() {
		刑務所=true;
	}public void 休み() {
		sleep=true;
	}public void 家のランダム減少() {
		Collections.shuffle(houseList);			//リストのシャッフル
		int masu=houseList.get(0);				//リストの先頭を取得
		家の減少(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean 休みチェック() {
		return sleep;
	}public boolean 刑務所チェック() {
		return 刑務所;
	}public void 刑務所から出る() {
		刑務所=false;
	}
}
class PlayerB {
	static int B;
	static ArrayList<Integer> houseList=new ArrayList();		//所持している家の一覧
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean 刑務所;
	public static void お金の増減(int a){
		money+=a;
	}public static void 株の増減(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean 家の確認(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void 家の追加(int masu) {
		houseList.add(masu);
	}public static void 家の減少(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void 刑務所に入る() {
		刑務所=true;
	}public void 休み() {
		sleep=true;
	}public void 家のランダム減少() {
		Collections.shuffle(houseList);			//リストのシャッフル
		int masu=houseList.get(0);				//リストの先頭を取得
		家の減少(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean 休みチェック() {
		return sleep;
	}public boolean 刑務所チェック() {
		return 刑務所;
	}public void 刑務所から出る() {
		刑務所=false;
	}
}
class PlayerC {
	static int C;
	static ArrayList<Integer> houseList=new ArrayList();		//所持している家の一覧
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean 刑務所;
	public static void お金の増減(int a){
		money+=a;
	}public static void 株の増減(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean 家の確認(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void 家の追加(int masu) {
		houseList.add(masu);
	}public static void 家の減少(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void 刑務所に入る() {
		刑務所=true;
	}public void 休み() {
		sleep=true;
	}public void 家のランダム減少() {
		Collections.shuffle(houseList);			//リストのシャッフル
		int masu=houseList.get(0);				//リストの先頭を取得
		家の減少(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean 休みチェック() {
		return sleep;
	}public boolean 刑務所チェック() {
		return 刑務所;
	}public void 刑務所から出る() {
		刑務所=false;
	}
}
class PlayerD {
	static int D;
	static ArrayList<Integer> houseList=new ArrayList();		//所持している家の一覧
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean 刑務所;
	public static void お金の増減(int a){
		money+=a;
	}public static void 株の増減(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean 家の確認(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void 家の追加(int masu) {
		houseList.add(masu);
	}public static void 家の減少(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void 刑務所に入る() {
		刑務所=true;
	}public void 休み() {
		sleep=true;
	}public void 家のランダム減少() {
		Collections.shuffle(houseList);			//リストのシャッフル
		int masu=houseList.get(0);				//リストの先頭を取得
		家の減少(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean 休みチェック() {
		return sleep;
	}public boolean 刑務所チェック() {
		return 刑務所;
	}public void 刑務所から出る() {
		刑務所=false;
	}
}

class kabu {
	private static int kabukaOta=5000;			//株価
	private static int kabukaFuku=5000;
	private static int kabukaUchi=5000;
	private static int kabukaTom=5000;
	
	public static void 大田株の株価変動(int price) {
		kabukaOta+=price;
	}
	public static void 復光株の株価変動(int price) {
		kabukaFuku+=price;
	}
	public static void ウチクロ株の株価変動(int price) {
		kabukaUchi+=price;
	}
	public static void 末永株の株価変動(int price) {
		kabukaTom+=price;
	}
	
	public static int getKabukaOta() {
		return kabukaOta;
	}public static int getKabukaFuku() {
		return kabukaFuku;
	}public static int getKabukaUchi() {
		return kabukaUchi;
	}public static int getKabukaTom() {
		return kabukaTom;
	}
}