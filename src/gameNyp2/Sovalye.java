package gameNyp2;
import java.util.Random;

public class Sovalye extends Karakterler{
	Random rnd= new Random();
	private boolean aktifdurum= true;
	private int vurus=1;
	private int sovalyetipi; // this.sovalyetipi
	private int id ; // this.id
	private int no;
	
	//Sans sans= new Sans();
	
	public Sovalye(String name, int no){
		super(name);
		setname(name);
		setsovalyetipi();
		setaktifdurum();
		setid();
	}

	
	public void setname(String name) {
		super.setname(name);
		
	}//setname
	
	public String getname() {
		return super.getname();
	}//name
	
	public void  setaktifdurum() {
		//random aktiflik durumu atama islemi
		this.aktifdurum=rnd.nextBoolean();
		
		}//setaktifdurum
	
	public String getaktifdurum() {
		//aktiflik durumuna gore sovalyelrin durumunu yazdiriliyor
		if(this.aktifdurum==true) {return ("sovalye aktif");}//if
		else {return ("Sovalye pasif");}//else 
			
		
		
	}//getaktifdurum
	
	
	public void  setsovalyetipi( ) {
		//sovalyelerin guc durumu atamasi icin  0-1 durumu olusturup getsovalyede atamalarini yapildi
		this.sovalyetipi= rnd.nextInt(2);
		//sovalyetipi=rnd.nextInt(1);
	
	}
	public String  getsovalyetipi() {
		if(this.sovalyetipi == 0) {
			return ("zayif sovalye");
			}//if
		else {
			return ("guclu sovalye");
		}//else
	}
	
	public int getvurus() {
		 return vurus;
	 }//getvurus
	
	public void setvurus( ) {
		//vurus sayisi islendi
		//her vurus isleminden sonra vurus sayisinin bir azaltilma islemi yapildi
		 this.vurus -=1;
		
	 }//setvurus
	public void setvurus(int hit) {
		//sansdan sonra vurusun islenmesi
		this.vurus = hit; 
	}//setvurus


	public void setid () {
		
		if(getsovalyetipi().equals("guclu sovalye")) {
			this.id = 1;}//if
		
		else if(getsovalyetipi().equals("zayif sovalye")) {
			this.id = 2;}//else
	}//public
	
	public int getid() {
		return id;
	}//getid
	
	
	public String toString(){
		return "Isim: "+getname()+"   ID: "+getid()+"   Sovalye durumu: "+getsovalyetipi()+"   Vurus sayisi: "+getvurus()+"   Durum: "+getaktifdurum();		
	}
	
	
	
	//bu kýsýma toString ve dusman eklenmiþ??
	/*if(sans.getiyisans(1)){
		sans.sans=rnd.nextInt(3);
		
	}//ifsans*/
	
}

