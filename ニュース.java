import java.util.*;

public class ニュース {
	
	public static String NewsA(int Number) {
		String[] eventA={"日本とA国との間で関税0で輸出入ができる",
						"A国が国内の自動車産業保護を明確にし、",
						"B自動車会社との関係が深いC国の",
						"原発再稼働",
						"選挙により原発反対派に党が政権を握る。",
						"火力燃料の輸入価格上昇",
						"この年の夏は比較的涼しかった",
						"エコブーム",
						"この年の冬は超極寒の影響で床暖房が普及する",
						"ユ○クロと契約を結ぶ錦○圭がグランドスラムの",
						"迷走するユニクロ、値上げをしてしまう。",
						"消費税の上昇",
						"政府と日銀が円安誘導政策を取る",
						"オリンピックの開催",
						"○○神社が世界遺産に登録され、注目を浴びる",
						"景気が良くなった",
						"金利が上がった",
						"円高",
						"日本銀行が異次元緩和策としてETF（上場投資信託）や",
						"金融緩和政策を行う",
						"世界各国で異常気象が目立つ",
						"マツダ自動車会社がBMW自動車を",
						"そろそろGW",
						"桐谷さんが某番組内で旅行会社株の"};
		
		return eventA[Number];
	}
	public static String NewsB(int Number) {
		String[] eventB={
			"貿易協定ができた。",
			"いろいろな国内産業保護政策をとった。",
			"経済成長が止まる。",
			"",
			"",
			"",
			"",
			"",
			"",
			"タイトルを取り、世界にユニクロの名が響き渡る",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"J-REIT（日本の上場不動産投資信託）を大量購入",
			"",
			"",
			"子会社化する",
			"",
			"優待券を紹介し、話題になる"};
		
		return eventB[Number];
	}
	public void ニュースイベント処理(int eventNumber) {
		
		if (eventNumber==0) kabu.大田株の株価変動(15000);
		if (eventNumber==1) kabu.大田株の株価変動(10000);
		if (eventNumber==2) kabu.大田株の株価変動(15000);
		if (eventNumber==3) kabu.復光株の株価変動(15000);
		if (eventNumber==4) kabu.復光株の株価変動(-5000);
		if (eventNumber==5) {
			kabu.復光株の株価変動(-10000);
			kabu.大田株の株価変動(-3000);
		}if (eventNumber==6) kabu.復光株の株価変動(-3000);
		if (eventNumber==7) kabu.復光株の株価変動(-3000);
		if (eventNumber==8) {
			kabu.復光株の株価変動(2000);
			kabu.ウチクロ株の株価変動(5000);
		}if (eventNumber==9) kabu.ウチクロ株の株価変動(2000);
		if (eventNumber==10) {
			kabu.大田株の株価変動(10000);
			kabu.ウチクロ株の株価変動(-5000);
		}if (eventNumber==11) kabu.ウチクロ株の株価変動(-4000);
		if (eventNumber==12) {
			kabu.大田株の株価変動(-3000);
			kabu.復光株の株価変動(-3000);
			kabu.ウチクロ株の株価変動(-3000);
			kabu.末永株の株価変動(-3000);
		}if (eventNumber==13) kabu.大田株の株価変動(5000);
		if (eventNumber==14) kabu.末永株の株価変動(10000);
		if (eventNumber==15) kabu.末永株の株価変動(5000);
		if (eventNumber==16) {
			kabu.大田株の株価変動(-3000);
			kabu.復光株の株価変動(-3000);
			kabu.ウチクロ株の株価変動(5000);
			kabu.末永株の株価変動(5000);
		}if (eventNumber==17) {
			kabu.大田株の株価変動(-5000);
			kabu.復光株の株価変動(-5000);
		}
		if (eventNumber==18) {
			kabu.復光株の株価変動(5000);
			kabu.ウチクロ株の株価変動(5000);
		}if (eventNumber==19) {
			kabu.大田株の株価変動(10000);
			kabu.復光株の株価変動(10000);
			kabu.ウチクロ株の株価変動(10000);
			kabu.末永株の株価変動(10000);
		}if (eventNumber==20) {
			kabu.大田株の株価変動(5000);
			kabu.復光株の株価変動(5000);
		}if (eventNumber==21) kabu.ウチクロ株の株価変動(-3000);
		if (eventNumber==22) kabu.大田株の株価変動(5000);
		if (eventNumber==23) kabu.末永株の株価変動(2000);
		if (eventNumber==24) kabu.末永株の株価変動(1000);
	}
}