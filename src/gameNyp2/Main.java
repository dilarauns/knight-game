package gameNyp2;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Main {

	public static void main(String[] args) {
		int countaktif=0;
		int countid=0;
		Random rnd=new Random();
		// dosyalama i�lemi i�in olu�turulan obje
		CVOyunVerisi fileWriter = new CVOyunVerisi();
		
		//oyun verisi de�erlerini �ekmek i�in olusturulan obje
		OyunVerisi oyunverisi= new OyunVerisi();
		
		fileWriter.kayitVerileriniYukle("--------------------------------------Sovalyeler---------------------------------------------");
		
		for(int i=0;i<25;i++) {
			//sovalyelerin eklanmesi islemi
			Sovalye createdSovalye= new Sovalye(("Sovalye"+(i+1)), i+1);
			oyunverisi.sovalyeler.add(createdSovalye);
			
			//dosyaya yazdiiirma islemi
			fileWriter.kayitVerileriniYukle(createdSovalye.toString());
			
			
			
			if(createdSovalye.getaktifdurum().equals("sovalye aktif")) {
				
				if(createdSovalye.getid()==1) {
				
					//en az 1 en fazla 2 guclu aktifsovalyeler
					countid++;
						if(countid>2) {
							
							continue;
						}//id-if
					}//if-id
				countaktif++;
				
				//aktif sovalyerlin eklenme islemi
				oyunverisi.aktifSovalyeler.add(createdSovalye);	
				System.out.println("No:"+(countaktif+1)+"\t"+createdSovalye.toString());   //aktif sovalyeler

				if(countaktif==5) {
					break;
				}//if-breakaktif
			}//if		
		}//fori
		
		
		int countaktifdusman=0;
		int countiddusman=0;
		
		//dusman sayisi belirleme islemi
		int random= rnd.nextInt(oyunverisi.aktifSovalyeler.size()-2)+3;
		System.out.println("************"+random);
		fileWriter.kayitVerileriniYukle("--------------------------------------Dusmanlar---------------------------------------------");
		
		for(int i=0;i<25;i++) {
			//dusmanlar olusturuluyor
			Dusman createdDusman= new Dusman("Dusman"+(i+1));
			
			//olusturulan dusmanlar arraylist'e ekleniyor
			oyunverisi.dusmanlar.add(createdDusman);
			
			//dosyayay yazdiriliyor
			fileWriter.kayitVerileriniYukle(createdDusman.toString());
			
			if(createdDusman.getaktifdurum().equals("Dusman aktif")) {
				//en az 1 en fazla 2 guclu aktifdusmanlar
				if(createdDusman.getid()==1) {
					countiddusman++;
						if(countiddusman>2) {
							continue;
						}//id-if
					}//if-id
				countaktifdusman++;
				
				//aktifdusmanlara olusturulan dusmanlar ekleniyor
				oyunverisi.aktifDusmanlar.add(createdDusman);
				System.out.println(createdDusman.getname());
				
				
				if(countaktifdusman==random) {
					break;
				}//if-breakaktif
			}//if		
		}//fori
		
		//dosyaya yazmaya zorlama i�lemi. oyun bitti�inde dosyalara bilgilerin hemen yazdirilmasi i�in yapilan islem
		fileWriter.KayitveriFile.flush();
		
		//Sans icindeki metot icin olusturulan obje
		Sans Sanslisovalye = new Sans(oyunverisi);
		oyunverisi = Sanslisovalye.getluckystrike();
		
		//oyungorunumunun istedi�i atamalar yap�ld�
		OyunGorunumu oyungorunumu = new OyunGorunumu(oyunverisi, fileWriter);
		
		//dosya kapat�ld�
		fileWriter.DosyaKapat();
		
		
	
	
	}

}
