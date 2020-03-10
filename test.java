

public class test {
	public static void main(String[] args) {
		/*
		PlayerA playerA=new PlayerA();
		Object player=playerA;
		int money=player.money;
		System.out.println(money);
		playerA.money=10000;
		System.out.println(playerA.capital);
		int capital=playerA.money+playerA.ota+playerA.fuku+playerA.uchi+playerA.tom;
		System.out.println(capital);*/
		
		
		PlayerA playerA=new PlayerA();
		PlayerB playerB=new PlayerB();
		PlayerC playerC=new PlayerC();
		PlayerD playerD=new PlayerD();
		Player player;
		player=playerA;
		int money=player.capital;
		System.out.println(money);
		/*
		Player Player =new Player();
		Player player=new PlayerA();
		*/
		//check(player);
	}/*
	public static void check(Player player) {
		int money=player.money;
		System.out.println(money);
	}*/
}