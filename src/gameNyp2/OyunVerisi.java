package gameNyp2;
import java.util.ArrayList;
import java.util.List;

public class  OyunVerisi {
	ArrayList<Sovalye> sovalyeler= new ArrayList<Sovalye>();
	ArrayList<Sovalye>aktifSovalyeler=new ArrayList<Sovalye>();
	ArrayList<Dusman>dusmanlar= new ArrayList<Dusman>();
	ArrayList<Dusman>aktifDusmanlar=new ArrayList<Dusman>();
	
	
	public OyunVerisi() {}
	
	
	public ArrayList<Sovalye> getSovalyeler(){
	
		return sovalyeler;
	}//SOVALYE
	public ArrayList<Sovalye> getAktifSovalyeler(){
		return aktifSovalyeler;
	}//ARRAYAKTÝFSOV
	public ArrayList<Dusman> getDusmanlar(){
		return dusmanlar;
	}//ARRAYDUSMAN
	

}//class
