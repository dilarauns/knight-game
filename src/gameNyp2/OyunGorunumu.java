package gameNyp2;
import java.util.ArrayList;
import java.util.Scanner;




public class OyunGorunumu {
	private OyunVerisi oyunverisi;
	CVOyunVerisi fileWriter ;
	//private SavasMotoru savasMotoru;//savasmotoru class�
	 Scanner scanner = new Scanner(System.in);
	 int selection;
	 boolean a= true;
	
	 public OyunGorunumu(OyunVerisi oyunverisi, CVOyunVerisi fileWriter) {
		 //islem s�ras�na g�re constructor icerisnde metotlar�n �ag�r�lmasi
		 this.oyunverisi=oyunverisi;
		 this.fileWriter = fileWriter;
		
		while(a==true) {
			anaMenuyuGoster();
			menudenSecimYap();
		
		switch (this.selection){
		case 1:
			sovalyeleriGoster();
			break;
		
		case 2:
			aktifsovalyeleriGoster();
			break;

		case 3:
			adigirilensovalyeyigoster();
			break;
		
		case 4:
			adigirilensovalyeyidegistir();
			break;

		case 5:
			yardim();
			break;
			
		case 6:
			OyunuBaslat();
			break;
		case 7:
			
			//men�den cikilmasi i�in konulan boolean a �slemi sonucu
			a=false;
			OyundanCik();
			break;
			}//while
		}
		
	}//oyungorunumu
	
	public void baslangicEkrani() {
		System.out.println("*********************Oyuna ho� geldiniz*********************");
		
	}//baslangicekrani
	
	public void anaMenuyuGoster() {
		System.out.println("ANA MENU \n"
			+ "1.Tum sovalyeleri goster\n"
			+ "2.Aktif olan sovalyeleri goster\n"
			+ "3.Adi girilen sovalyeri goster\n"
			+ "4.Adi girilen sovalyeyi degisitir\n"
			+ "5.Yardim\n"
			+ "6.Oyunu baslat\n"
			+ "7.Oyundan cik\n");
		
		
			
		}//anaMenuyuGoster
	

	
	public void sovalyeleriGoster() {
		//sovalyelerin bastirilma islemi
		for(int i=0;i<oyunverisi.sovalyeler.size();i++) {
			
			System.out.println(oyunverisi.sovalyeler.get(i).toString());}
		
	}//sovalyeleriGoster
	
	public void aktifsovalyeleriGoster() {
		//aktif sovalyelerin bastiriilma islemi
		
			for(int i=0;i<oyunverisi.aktifSovalyeler.size();i++) {
			System.out.println("NO:"+(i+1)+oyunverisi.aktifSovalyeler.get(i).toString());}//for
				
	}//aktifsovalyeleriGoster

	public void menudenSecimYap() {
		//men� secim islemi
		
		System.out.println("Lutfen seciminizi girin:");
		this.selection=scanner.nextInt();}//menudenSecimYap
		
	public void adigirilensovalyeyigoster() {
		
	//istenilen sovalyenin gosterilme islemi
		System.out.println("ozelliklerini gormek isterdiginiz sovalyenin numarasini giriniz:");
		int i=scanner.nextInt()-1;
		System.out.println(oyunverisi.sovalyeler.get(i).toString());}//adigirilensovalyeyigoster
	
	public void adigirilensovalyeyidegistir() {
		//2 gucluden birini 2 zay�fa donusturme islemi
		int count=0;
		for(int i=0;i<oyunverisi.aktifSovalyeler.size();i++) {
			boolean dogruluk =oyunverisi.aktifSovalyeler.get(i).getid()==1;
			if(dogruluk==true) {
				count++;
				
				System.out.println("No : "+(i+1)+" "+oyunverisi.aktifSovalyeler.get(i));
			}//ifdogruluk
			
			
			if(count==2) {
				
				//2 guclu sovalye varsa secilen sovalyenin arrayden kaldiriliyor
					
				System.out.println("ozelliklerini de�i�tirmek istediginiz sovalyenin numarasini(No) giriniz:");
				int j=scanner.nextInt()-1;
				oyunverisi.aktifSovalyeler.remove(j);
				
				
				int k;
				for(k=0;k<2;k++) {
					
					//2 zayif sovalye olusturuluyor
					Sovalye createdgucsuz=new Sovalye("Sovalye"+(oyunverisi.sovalyeler.size()+k+1), oyunverisi.aktifSovalyeler.size()+ k + 1);//BURADA SOVALYE �SM�NDE HATA OLAB�L�R!
					//createdgucsuze add islemi 2 yeni zay�f sovalye icin yapiliyor
					if(createdgucsuz.getsovalyetipi().equals("zayif sovalye")) {
						oyunverisi.aktifSovalyeler.add(createdgucsuz);
					}//if
					else {k--;}//else- GUCLUYSE K YI B�R AZALT K� SADECE 2 TANE YAZDIRSIN
				
				}//for
				break;
				//}
				}//ifcount

			}//FOR
		if(count<2) {
			System.out.println("sadece 1 tane guclu sovalyeniz bulunmakta.");
			
		}//
		
	}//adigirilensovalyeyidegistir
	
	public void yardim() {
		System.out.println("*******Oyun Bilgisi*********\n"
				+"Oyunun ba�lang�c�nda rastgele se�ilen 5 adet ��valye aktifle�tirilir. Bunlardan en az biri, en �ok ikisi g��l� ��valye olmal�d�r.\n"
				+"G��l� ��valyeler: G��l� ��valye, hem g��l� hem de zay�f d��man� vurdu�unda onu yok edebilir.\n"
				+"Zay�f ��valyeler: Zay�f ��valye yaln�zca zay�f d��mana vurdu�unda yok edebilir. G��l� d��mana vurdu�unda kendisi yok olur ancak d��mana bir zarar veremez.\n"
				+"D��manlar�n g��l� m� zay�f m� oldu�u rastgele belirlenir. Oyun s�ras�nda oyuncu kar��s�ndaki d��manlar�n g��l� m� zay�f m� oldu�unu, hangisinin g��l� hangisinin "
				+ "zay�f oldu�unu bilinemez.\n"
				+"G��l� D��manlar: Yaln�zca g��l� ��valyeler taraf�ndan yok edilebilirler.\n"
				+ "Zay�f D��manlar: Hem g��l� hem de zay�f ��valyeler taraf�ndan yok edilebilirler.");
		
		
		
	}
	
	public void OyunuBaslat() {
		//baslat�lmas� durumunda motorun cagrilma islemi
		SavasMotoru savasanlar= new SavasMotoru(oyunverisi, fileWriter);
		
	}
	
	public void OyundanCik() {
		System.out.println("Cikiliyor.");
	}
	
	
	
	public void oyunDurumunuGoster(ArrayList<Dusman>getdusmanlar, ArrayList<Sovalye>sovalyeler) {
		
	}//menudenSecimYap
	
	

}
