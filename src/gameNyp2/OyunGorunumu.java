package gameNyp2;
import java.util.ArrayList;
import java.util.Scanner;




public class OyunGorunumu {
	private OyunVerisi oyunverisi;
	CVOyunVerisi fileWriter ;
	//private SavasMotoru savasMotoru;//savasmotoru classý
	 Scanner scanner = new Scanner(System.in);
	 int selection;
	 boolean a= true;
	
	 public OyunGorunumu(OyunVerisi oyunverisi, CVOyunVerisi fileWriter) {
		 //islem sýrasýna göre constructor icerisnde metotlarýn çagýrýlmasi
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
			
			//menüden cikilmasi için konulan boolean a ýslemi sonucu
			a=false;
			OyundanCik();
			break;
			}//while
		}
		
	}//oyungorunumu
	
	public void baslangicEkrani() {
		System.out.println("*********************Oyuna hoþ geldiniz*********************");
		
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
		//menü secim islemi
		
		System.out.println("Lutfen seciminizi girin:");
		this.selection=scanner.nextInt();}//menudenSecimYap
		
	public void adigirilensovalyeyigoster() {
		
	//istenilen sovalyenin gosterilme islemi
		System.out.println("ozelliklerini gormek isterdiginiz sovalyenin numarasini giriniz:");
		int i=scanner.nextInt()-1;
		System.out.println(oyunverisi.sovalyeler.get(i).toString());}//adigirilensovalyeyigoster
	
	public void adigirilensovalyeyidegistir() {
		//2 gucluden birini 2 zayýfa donusturme islemi
		int count=0;
		for(int i=0;i<oyunverisi.aktifSovalyeler.size();i++) {
			boolean dogruluk =oyunverisi.aktifSovalyeler.get(i).getid()==1;
			if(dogruluk==true) {
				count++;
				
				System.out.println("No : "+(i+1)+" "+oyunverisi.aktifSovalyeler.get(i));
			}//ifdogruluk
			
			
			if(count==2) {
				
				//2 guclu sovalye varsa secilen sovalyenin arrayden kaldiriliyor
					
				System.out.println("ozelliklerini deðiþtirmek istediginiz sovalyenin numarasini(No) giriniz:");
				int j=scanner.nextInt()-1;
				oyunverisi.aktifSovalyeler.remove(j);
				
				
				int k;
				for(k=0;k<2;k++) {
					
					//2 zayif sovalye olusturuluyor
					Sovalye createdgucsuz=new Sovalye("Sovalye"+(oyunverisi.sovalyeler.size()+k+1), oyunverisi.aktifSovalyeler.size()+ k + 1);//BURADA SOVALYE ÝSMÝNDE HATA OLABÝLÝR!
					//createdgucsuze add islemi 2 yeni zayýf sovalye icin yapiliyor
					if(createdgucsuz.getsovalyetipi().equals("zayif sovalye")) {
						oyunverisi.aktifSovalyeler.add(createdgucsuz);
					}//if
					else {k--;}//else- GUCLUYSE K YI BÝR AZALT KÝ SADECE 2 TANE YAZDIRSIN
				
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
				+"Oyunun baþlangýcýnda rastgele seçilen 5 adet þövalye aktifleþtirilir. Bunlardan en az biri, en çok ikisi güçlü þövalye olmalýdýr.\n"
				+"Güçlü Þövalyeler: Güçlü þövalye, hem güçlü hem de zayýf düþmaný vurduðunda onu yok edebilir.\n"
				+"Zayýf Þövalyeler: Zayýf þövalye yalnýzca zayýf düþmana vurduðunda yok edebilir. Güçlü düþmana vurduðunda kendisi yok olur ancak düþmana bir zarar veremez.\n"
				+"Düþmanlarýn güçlü mü zayýf mý olduðu rastgele belirlenir. Oyun sýrasýnda oyuncu karþýsýndaki düþmanlarýn güçlü mü zayýf mý olduðunu, hangisinin güçlü hangisinin "
				+ "zayýf olduðunu bilinemez.\n"
				+"Güçlü Düþmanlar: Yalnýzca güçlü þövalyeler tarafýndan yok edilebilirler.\n"
				+ "Zayýf Düþmanlar: Hem güçlü hem de zayýf þövalyeler tarafýndan yok edilebilirler.");
		
		
		
	}
	
	public void OyunuBaslat() {
		//baslatýlmasý durumunda motorun cagrilma islemi
		SavasMotoru savasanlar= new SavasMotoru(oyunverisi, fileWriter);
		
	}
	
	public void OyundanCik() {
		System.out.println("Cikiliyor.");
	}
	
	
	
	public void oyunDurumunuGoster(ArrayList<Dusman>getdusmanlar, ArrayList<Sovalye>sovalyeler) {
		
	}//menudenSecimYap
	
	

}
