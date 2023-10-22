package gameNyp2;

public class Karakterler {
	private String name;
	private int id;
	private boolean aktif;
	
	public Karakterler(String name){
		
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public String getname() {
		return name;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	public int getid() {
		return id;
	}
	
	
	public boolean getaktif() {
		return aktif;
	}
	public void setaktif(boolean aktif) {
		
		this.aktif=aktif;
	}

}
