package gameNyp2;
import java.util.Random;

public class Dusman extends Karakterler{
	Random rnd= new Random();
	private boolean aktifdurum;
	private int  dusmantipi;
	
	public Dusman(String name) {
		super(name);
		setaktifdurum();
		setname(name);
		setdusmantipi();
		setid();
	}
	
	public void setname(String name) {
		super.setname(name);
		
	} 
	
	public String getname() {
		return super.getname();
	}
	
	public void  setaktifdurum() {
		this.aktifdurum=rnd.nextBoolean();
		
		}
	public String getaktifdurum() {
		if(this.aktifdurum==true) {return ("Dusman aktif");}//if
		else {return ("Dusman pasif");}//else
		
	}
	
	public void  setdusmantipi( ) {
		this.dusmantipi=rnd.nextInt(2);
		
		}
	public String  getdusmantipi() {
		if(dusmantipi == 0) {
			return ("zayif dusman");
			}//if
		else {
			return ("guclu dusman");
		}//else
		
	}//gtdusmantipi
	
	public void setid() {
		if(getdusmantipi().equals("guclu dusman")) {
			super.setid(1);}//if
		else {if(getdusmantipi().equals("zayif dusman")) {
			super.setid(2);}}//else
	}//setid
	
	public int getid() {
		return super.getid();
	}
	
	public String toString(){
		return "Isim: "+getname()+"   ID: "+getid()+"   Sovalye durumu: "+getdusmantipi()+"   Durum: "+getaktifdurum();		
	}
	
}