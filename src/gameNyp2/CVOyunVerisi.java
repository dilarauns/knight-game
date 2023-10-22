package gameNyp2;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class CVOyunVerisi extends OyunVerisi{


//referans degerler olusturuldu
PrintWriter OyunveriFile ;
PrintWriter KayitveriFile;
	CVOyunVerisi(){
//dosya oluþturuldu
		try {
			OyunveriFile = new PrintWriter("OyunveriFile.txt");
			KayitveriFile = new PrintWriter("KayitveriFile.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	//sovalye ve dusman verileri str olarak mainden alýndý
	public void kayitVerileriniYukle(String str) {

	//yazdýrýldý	
		KayitveriFile.println(str);
	   
		
	}	
	//sovalye ve dusman karþilasmasi verileri str olarak savas motorundan alýndý
	public void oyunVerileriniYükle(String str) {
		OyunveriFile.println(str);
		
	}//oyunverileri

	// Dosya kapatildi.
	public void DosyaKapat() {
		OyunveriFile.close();
		KayitveriFile.close();
		
		
	}
}


