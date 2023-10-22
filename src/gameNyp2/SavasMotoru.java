package gameNyp2;
import java.util.Scanner;
import java.util.Random;

public class SavasMotoru {
	Scanner scanner=new Scanner(System.in);
	Random rnd=new Random();
	CVOyunVerisi fileWriter;
	SavasMotoru(OyunVerisi MotorVerisi, CVOyunVerisi fileWriter){
		//oyunverisindeki bilgiler icin obje olu�turuldu
		//dosya i�lemi icin obje olusturuldu
		this.fileWriter = fileWriter;
		
		//aktif dusam veya aktif sovalyelerden herhangi birinde oyunucu bitme durumu
		while(MotorVerisi.aktifDusmanlar.size()!=0 && MotorVerisi.aktifSovalyeler.size()!=0) {
			
			for(int k=0;k<MotorVerisi.aktifSovalyeler.size();k++) {
				//aktif sovalyerlin yazdirilma asamasi
				System.out.println("No : "+(k+1)+" "+MotorVerisi.aktifSovalyeler.get(k));
				
			}//foryeniarray
			fileWriter.oyunVerileriniY�kle("-----------------------------------------------------------");
			//savascak sovalye secimi
			System.out.println("sovalye numaran�z�(no) se�iniz (��kmak i�in -1 tu�lay�n�z.):");
			int i=scanner.nextInt()-1;
			if ( i != -1)
			{
				//secilen sovalye asovalye referans�na atandi
				Sovalye Asovalye =MotorVerisi.aktifSovalyeler.get(i);
				
				
				//random dusman.
				int j=rnd.nextInt(MotorVerisi.aktifDusmanlar.size());
				//random secilen dusman adusman referansina atandi
				Dusman Adusman= MotorVerisi.aktifDusmanlar.get(j);
				
				//savass durumu hakkinda dosyaya girilen bilgi
				fileWriter.oyunVerileriniY�kle(Asovalye.getname()+" ile "+Adusman.getname()+ " savasiyor. ");
				if(Asovalye.getid()<=Adusman.getid()) {
					System.out.println("dusman yok edildi.");
					fileWriter.oyunVerileriniY�kle(Asovalye.getname() + " kazandi.");
					Asovalye.setvurus();
					
					//getvurus metodu �zerinden azalatma islemi ile vrusun 0 olamsi durumunun islenmesi
					if(Asovalye.getvurus()==0) {
						MotorVerisi.aktifSovalyeler.remove(i);
						fileWriter.oyunVerileriniY�kle(Asovalye.getname() + "'nin " + Asovalye.getvurus() + " hakki kaldi. Sovalye silindi.");
						}
					else {
						fileWriter.oyunVerileriniY�kle(Asovalye.getname() + "'nin " + Asovalye.getvurus() + " hakki daha var.");
					}
					MotorVerisi.aktifDusmanlar.remove(j);
					fileWriter.oyunVerileriniY�kle(Adusman.getname() + " silindi.");
					}//�F
				else {
					System.out.println("yok edildiniz.");
					MotorVerisi.aktifSovalyeler.remove(i);
					MotorVerisi.aktifDusmanlar.remove(j);
					fileWriter.oyunVerileriniY�kle(Adusman.getname() + " kazandi. Dusman da Sovalye de siliniyor.");
						
				}//
				fileWriter.oyunVerileriniY�kle("-----------------------------------------------------------");
			} // if i
			
			
			else {
				break;
			}

		}//while
		
		//Klan dusman ve sovalye sayisina gore dosyayay yazd�rma asamasi
		//flush islemi ile oyundan cikilmasi sarti ile yazdirilan bilgileri oyun bittikten sonra yazdirdim.
		
		if (MotorVerisi.aktifSovalyeler.size() == 0) {
			System.out.println("D��manlar kazand�.");
			fileWriter.oyunVerileriniY�kle("Dusmanlar kazandi.");
			fileWriter.OyunveriFile.flush();
		}else if(MotorVerisi.aktifDusmanlar.size() == 0) {
			System.out.println("��valyeler kazand�.");
			fileWriter.oyunVerileriniY�kle("Sovalyeler kazandi.");
			fileWriter.OyunveriFile.flush();
		}
	
			
	}//Savasmotoru const.
	
	
}
