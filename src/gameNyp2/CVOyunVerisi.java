package gameNyp2;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
public class CVOyunVerisi extends OyunVerisi{


//referans degerler olusturuldu
PrintWriter OyunveriFile ;
PrintWriter KayitveriFile;
	CVOyunVerisi(){
//dosya olu�turuldu
		try {
			OyunveriFile = new PrintWriter("OyunveriFile.txt");
			KayitveriFile = new PrintWriter("KayitveriFile.txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	//sovalye ve dusman verileri str olarak mainden al�nd�
	public void kayitVerileriniYukle(String str) {

	//yazd�r�ld�	
		KayitveriFile.println(str);
	   
		
	}	
	//sovalye ve dusman kar�ilasmasi verileri str olarak savas motorundan al�nd�
	public void oyunVerileriniY�kle(String str) {
		OyunveriFile.println(str);
		
	}//oyunverileri

	// Dosya kapatildi.
	public void DosyaKapat() {
		OyunveriFile.close();
		KayitveriFile.close();
		
		
	}
}


