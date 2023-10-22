package gameNyp2;

import java.util.Random;
	
public class Sans {
	private int sans;
	Random rnd = new Random();
	OyunVerisi S = new OyunVerisi();
	Sans(OyunVerisi S){
		
		this.S = S;
		
		
	}
	
	public OyunVerisi getluckystrike() {
		//aktif sovalyelerinden birine vurs hakký tanýma islemi
		int a= rnd.nextInt(S.aktifSovalyeler.size());
		int randomhit= rnd.nextInt(3);
		this.S.aktifSovalyeler.get(a).setvurus(1 + randomhit);
		return this.S; 
		
	}
		
}//sans

