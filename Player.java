import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


class PlayerA {
	
	static ArrayList<Integer> houseList=new ArrayList();		//�������Ă���Ƃ̈ꗗ
	static int A;
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean �Y����=true;
	public static void �����̑���(int a){
		money+=a;
	}public static void ���̑���(int store,int number) {
		if (store==0) kabuOta+=number;
		else if (store==1) kabuFuku+=number;
		else if (store==2) kabuUchi+=number;
		else if (store==3) kabuTom+=number;
	}
	public static int getMoney() {
		return money;
	}
	public static boolean �Ƃ̊m�F(int masu) {
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void �Ƃ̒ǉ�(int masu) {
		houseList.add(masu);
	}public static void �Ƃ̌���(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void �Y�����ɓ���() {
		�Y����=true;
	}public void �x��() {
		sleep=true;
	}public void �Ƃ̃����_������() {
		Collections.shuffle(houseList);			//���X�g�̃V���b�t��
		int masu=houseList.get(0);				//���X�g�̐擪���擾
		�Ƃ̌���(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean �x�݃`�F�b�N() {
		return sleep;
	}public boolean �Y�����`�F�b�N() {
		return �Y����;
	}public void �Y��������o��() {
		�Y����=false;
	}
}
class PlayerB {
	static int B;
	static ArrayList<Integer> houseList=new ArrayList();		//�������Ă���Ƃ̈ꗗ
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean �Y����;
	public static void �����̑���(int a){
		money+=a;
	}public static void ���̑���(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean �Ƃ̊m�F(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void �Ƃ̒ǉ�(int masu) {
		houseList.add(masu);
	}public static void �Ƃ̌���(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void �Y�����ɓ���() {
		�Y����=true;
	}public void �x��() {
		sleep=true;
	}public void �Ƃ̃����_������() {
		Collections.shuffle(houseList);			//���X�g�̃V���b�t��
		int masu=houseList.get(0);				//���X�g�̐擪���擾
		�Ƃ̌���(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean �x�݃`�F�b�N() {
		return sleep;
	}public boolean �Y�����`�F�b�N() {
		return �Y����;
	}public void �Y��������o��() {
		�Y����=false;
	}
}
class PlayerC {
	static int C;
	static ArrayList<Integer> houseList=new ArrayList();		//�������Ă���Ƃ̈ꗗ
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean �Y����;
	public static void �����̑���(int a){
		money+=a;
	}public static void ���̑���(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean �Ƃ̊m�F(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void �Ƃ̒ǉ�(int masu) {
		houseList.add(masu);
	}public static void �Ƃ̌���(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void �Y�����ɓ���() {
		�Y����=true;
	}public void �x��() {
		sleep=true;
	}public void �Ƃ̃����_������() {
		Collections.shuffle(houseList);			//���X�g�̃V���b�t��
		int masu=houseList.get(0);				//���X�g�̐擪���擾
		�Ƃ̌���(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean �x�݃`�F�b�N() {
		return sleep;
	}public boolean �Y�����`�F�b�N() {
		return �Y����;
	}public void �Y��������o��() {
		�Y����=false;
	}
}
class PlayerD {
	static int D;
	static ArrayList<Integer> houseList=new ArrayList();		//�������Ă���Ƃ̈ꗗ
	private static kabu Kabu=new kabu();
	private static boolean sleep=false;
	private static int money=500000000;
	private static int kabuOta=0;
	private static int kabuFuku=0;
	private static int kabuUchi=0;
	private static int kabuTom=0;
	static boolean �Y����;
	public static void �����̑���(int a){
		money+=a;
	}public static void ���̑���(int store,int number) {
		if (store==0) kabuOta+=number;
		if (store==1) kabuFuku+=number;
		if (store==2) kabuUchi+=number;
		if (store==3) kabuTom+=number;
	}public static int getMoney() {
		return money;
	}public static boolean �Ƃ̊m�F(int masu) {
		
		for (int x:houseList) {
			if (x==masu) return true;
		}return false;
	}public static void �Ƃ̒ǉ�(int masu) {
		houseList.add(masu);
	}public static void �Ƃ̌���(int masu) {
		for (int num:houseList) {
			if (num==masu) 
				houseList.remove(num);
		}
	}public void �Y�����ɓ���() {
		�Y����=true;
	}public void �x��() {
		sleep=true;
	}public void �Ƃ̃����_������() {
		Collections.shuffle(houseList);			//���X�g�̃V���b�t��
		int masu=houseList.get(0);				//���X�g�̐擪���擾
		�Ƃ̌���(masu);
	}public static int getKabuOta() {
		return kabuOta;
	}public static int getKabuFuku() {
		return kabuFuku;
	}public static int getKabuUchi() {
		return kabuUchi;
	}public static int getKabuTom() {
		return kabuTom;
	}public boolean �x�݃`�F�b�N() {
		return sleep;
	}public boolean �Y�����`�F�b�N() {
		return �Y����;
	}public void �Y��������o��() {
		�Y����=false;
	}
}

class kabu {
	private static int kabukaOta=5000;			//����
	private static int kabukaFuku=5000;
	private static int kabukaUchi=5000;
	private static int kabukaTom=5000;
	
	public static void ��c���̊����ϓ�(int price) {
		kabukaOta+=price;
	}
	public static void �������̊����ϓ�(int price) {
		kabukaFuku+=price;
	}
	public static void �E�`�N�����̊����ϓ�(int price) {
		kabukaUchi+=price;
	}
	public static void ���i���̊����ϓ�(int price) {
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