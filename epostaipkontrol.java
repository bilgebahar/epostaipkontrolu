public class EPostaVeIP {
public static boolean EPostaKontrol( String eposta ) {
//eposta adresi @ işareti, işaretin solunda 1, sağında . dahil en az 5 karakter
//koşulları için 7 karakterden uzun olmalı	
if( eposta.length() < 7 )
return false;
int atisareti = eposta.indexOf("@");
if( atisareti == -1 || atisareti != eposta.lastIndexOf("@") )
return false;
//@ işaretinin solunu ve sağını tanımlama
String sol = eposta.substring(0, atisareti); //@ isaretinin solu
String sag = eposta.substring(atisareti+1, eposta.length()); //@ işaretinin sağı
//solda en az 1 karakter
//sağda en az 5 karakter
//sağda . bulunması kontrolü
if( sol.length() < 1 || sag.length() < 5 || sag.indexOf(".") == -1 )
return false;
return true;
}
//IP Adresi kontrolü
public static boolean IPKontrol( String ipadresi ) {
int sayi, konum; String parca;
ipadresi += ".";
for( int i = 0; i < 4; i++ ) {
konum = ipadresi.indexOf(".");
if( konum == -1 )
return false;
parca = ipadresi.substring(0, konum );
ipadresi = ipadresi.substring(konum+1,ipadresi.length() );
sayi = Integer.valueOf(parca);
//IP adresinin 0-255 aralığında olup olmadığı kontrolü
if( sayi < 0 || sayi > 255 )
return false;
}
return true;
}
public static void main( String args[] ) {
//Verilen örneklerin girilmesi	
System.out.println(EPostaKontrol("alican@gmail.com"));
System.out.println(EPostaKontrol("a@b.com"));
System.out.println(EPostaKontrol("a@b.c"));
System.out.println(IPKontrol("123.45.67.8"));
System.out.println(IPKontrol("123.45.678.9"));
}
}
