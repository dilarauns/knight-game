package gameNyp2;
import java.util.Scanner;
import java.util.Random;

public class SavasMotoru {
	Scanner scanner=new Scanner(System.in);
	Random rnd=new Random();
	CVOyunVerisi fileWriter;
	SavasMotoru(OyunVerisi MotorVerisi, CVOyunVerisi fileWriter){
		//oyunverisindeki bilgiler icin obje oluþturuldu
		//dosya iþlemi icin obje olusturuldu
		this.fileWriter = fileWriter;
		
		//aktif dusam veya aktif sovalyelerden herhangi birinde oyunucu bitme durumu
		while(MotorVerisi.aktifDusmanlar.size()!=0 && MotorVerisi.aktifSovalyeler.size()!=0) {
			
			for(int k=0;k<MotorVerisi.aktifSovalyeler.size();k++) {
				//aktif sovalyerlin yazdirilma asamasi
				System.out.println("No : "+(k+1)+" "+MotorVerisi.aktifSovalyeler.get(k));
				
			}//foryeniarray
			fileWriter.oyunVerileriniYükle("-----------------------------------------------------------");
			//savascak sovalye secimi
			System.out.println("sovalye numaranýzý(no) seçiniz (Çýkmak için -1 tuþlayýnýz.):");
			int i=scanner.nextInt()-1;
			if ( i != -1)
			{
				//secilen sovalye asovalye referansýna atandi
				Sovalye Asovalye =MotorVerisi.aktifSovalyeler.get(i);
				
				
				//random dusman.
				int j=rnd.nextInt(MotorVerisi.aktifDusmanlar.size());
				//random secilen dusman adusman referansina atandi
				Dusman Adusman= MotorVerisi.aktifDusmanlar.get(j);
				
				//savass durumu hakkinda dosyaya girilen bilgi
				fileWriter.oyunVerileriniYükle(Asovalye.getname()+" ile "+Adusman.getname()+ " savasiyor. ");
				if(Asovalye.getid()<=Adusman.getid()) {
					System.out.println("dusman yok edildi.");
					fileWriter.oyunVerileriniYükle(Asovalye.getname() + " kazandi.");
					Asovalye.setvurus();
					
					//getvurus metodu üzerinden azalatma islemi ile vrusun 0 olamsi durumunun islenmesi
					if(Asovalye.getvurus()==0) {
						MotorVerisi.aktifSovalyeler.remove(i);
						fileWriter.oyunVerileriniYükle(Asovalye.getname() + "'nin " + Asovalye.getvurus() + " hakki kaldi. Sovalye silindi.");
						}
					else {
						fileWriter.oyunVerileriniYükle(Asovalye.getname() + "'nin " + Asovalye.getvurus() + " hakki daha var.");
					}
					MotorVerisi.aktifDusmanlar.remove(j);
					fileWriter.oyunVerileriniYükle(Adusman.getname() + " silindi.");
					}//ÝF
				else {
					System.out.println("yok edildiniz.");
					MotorVerisi.aktifSovalyeler.remove(i);
					MotorVerisi.aktifDusmanlar.remove(j);
					fileWriter.oyunVerileriniYükle(Adusman.getname() + " kazandi. Dusman da Sovalye de siliniyor.");
						
				}//
				fileWriter.oyunVerileriniYükle("-----------------------------------------------------------");
			} // if i
			
			
			else {
				break;
			}

		}//while
		
		//Klan dusman ve sovalye sayisina gore dosyayay yazdýrma asamasi
		//flush islemi ile oyundan cikilmasi sarti ile yazdirilan bilgileri oyun bittikten sonra yazdirdim.
		
		if (MotorVerisi.aktifSovalyeler.size() == 0) {
			System.out.println("Düþmanlar kazandý.");
			fileWriter.oyunVerileriniYükle("Dusmanlar kazandi.");
			fileWriter.OyunveriFile.flush();
		}else if(MotorVerisi.aktifDusmanlar.size() == 0) {
			System.out.println("Þövalyeler kazandý.");
			fileWriter.oyunVerileriniYükle("Sovalyeler kazandi.");
			fileWriter.OyunveriFile.flush();
		}
	
			
	}//Savasmotoru const.
	
	
}
