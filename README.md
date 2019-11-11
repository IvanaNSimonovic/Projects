# Projekat-Prodavnica-Muzike
Napravite prodavnicu albuma koristeći klase iz prethodnog domaćeg. Dat je dijagram implementacije kako bi rešenje lakše vizuelizovali kao
i detaljan tekst implementacije.

Prodavnica
Prodavnica je opisana imenom i lokacijom. Sadrži listu svih artikala koji se prodaju. Prodavnica nudi mogućnost pretrage artikla po imenu
pri čemu vraća novu listu artikla koji zadovoljavaju kriterijum pretrage. Metoda dodaj omogućava dodavanje novog artikla u inventar. Sva
polja osim inventara mogu se dohvatiti. Prodavnica ima metodu toString koja vraća string u formatu ime: lokacija
[\n\t(Artikal)\n\t(Artikal)...\n] , gde su ime i lokacija polja koje kreira konstruktor Prodavnice a Artikal je rezultat pozivanja
toString() metode svakog artikla iz inventara.
Sugstija: Za potrebe pretrage najpre kreirajte novu praznu listu. Potom prodjite kroz svaki artikal iz inventara i proveravajte da li
se u imenu artikla (ime dobijate pozivom apstraktne metode ime()) nalazi traženi tekst. Korisite metodu
String.contains(CharSequence) i pre poziva ubijte sva velika slova uporednih stringova pozivom
String.toLowerCase() kako bi pretraga bila nezavisna od kapitalizacije.

Artikal
Artikal je apstraktna klasa koja je opisana jedinstvenim celobrojnim identifikator id koji se uvećava pri kreiranju svakog objekta, cenom
koja je realan broj i celobrojnom količinom (trenutno stanje na lageru). Sva polja mogu se dohvatiti. Artikal se može kupiti pozivanjem
metode kupi koja vraća boolean i umanjuje količinski brojač shodno mogućnosti izvršenja operacije (ukoliko aritkla ima na stanju). Artikal
ima metodu toString koja vraća string u formatu #id: ime - cena [kol: kolicina] , gde su id, cena i kolicina polja koje kreira

konstruktor artikla a ime je rezultat pozivanja apstraktne metode ime().

AlbumArtikal
AlbumArtikal je apstraktna klasa koja nasleđuje klasu Artikal i opisana je albumom i izdavačem tipa string.

LP
LP nasleđuje klasu AlbumArtikal i implementira nasleđenu apstraktnu metodu ime() koja vraća String u formatuizvodjac - naziv
(tezina[g] LP) , gde su izvоđač i naziv rezultati poziva odgovarujće get metode albuma, atezina je polje koje namešta konstruktor pri
kreiranju objekta.

CD
CD nasleđuje klasu AlbumArtikal i implementira nasleđenu apstraktnu metodu ime() koja vraća String u formatuizvodjac - naziv
(CD) , gde su izvоđač i naziv rezultati poziva odgovarujće get metode albuma.

Kod metoda za potrebe testiranja koda i dobijanja ispisa koji ne treba dirati:
public static void main(String[] args) {
Album love_supreme = new Album("A Love Supreme", "John Coltrane", new Date(1965,1,12));
love_supreme.dodaj("Part I: Acknowledgement", "7:42");
love_supreme.dodaj("Part II: Resolution", "7:19");
love_supreme.dodaj("Part III: Pursuance", "10:41");
love_supreme.dodaj("Part IV: Psalm", "7:02");
Album animals = new Album("Animals", "Pink Floyd", new Date(1977,1,23));
animals.dodaj("Pigs on the wing 1","1:25");
animals.dodaj("Dogs", "17:05");
animals.dodaj("Pigs (Three diffrent ones)","11:26");
animals.dodaj("Sheep","10:18");
animals.dodaj("Pigs on the wing 2","1:28");
Prodavnica p = new Prodavnica("MusicShop", "Koltrejnova 7");
p.dodaj(new LP(love_supreme,"Imuplse! Records",2750, 0, 120));
p.dodaj(new LP(love_supreme,"Imuplse! Records",3110, 7, 180));
p.dodaj(new CD(love_supreme,"Imuplse! Records",1500, 40));
p.dodaj(new LP(animals,"Pink Floyd Records",2500, 7, 120));
p.dodaj(new CD(animals,"Pink Floyd Records",1250, 30));
System.out.println(p+"");
simulacija(p, "Pink Floyd");

simulacija(p, "David Bowie");
simulacija(p, "colTrane");
System.out.println(p);
}
public static void simulacija(Prodavnica p, String zelja) {
System.out.println("-- Kupac ulazi u radnju --");
System.out.println("Kupac: Dobar dan! Želeo bih da kupim nesto od " + zelja + "-a!");
List<Artikal> ponuda = p.pretrazi(zelja);
if(ponuda.size()==0) {
System.out.println("Prodavac: Nažalost nemamo to u ponudi :(");
System.out.println("Kupac: Ih prava šteta, vidimo se neki drugi put!");
}else {
System.out.println("Prodavac: Pozdrav, od " + zelja + "-a imamo u ponudi: ");
for(int i=0;i<ponuda.size();i++)
System.out.println(" " + ponuda.get(i));
boolean kupio = false;
while(ponuda.size()>0 && !kupio) {
System.out.println("Kupac: Kupiću -- " + ponuda.get(0).ime());
kupio = ponuda.get(0).kupi();
if(!kupio) {
System.out.print("Prodavac: ");
System.err.println("Nažalost nemamo traženi artikal trenutno :(");
ponuda.remove(0);
}
}
if(kupio) {
System.out.println("Prodavac: Izvolite!");
System.out.println("Kupac: Hvala lepo! Vidimo se sledeceg meseca kad legne plata!");
}else {
System.out.println("Kupac: Ih baš šteta! Vidimo se za nedelju dana!");
}
}
System.out.println();
}

Ispis koji se dobija:

MusicShop: Koltrejnova 7 [
#1: John Coltrane - A Love Supreme (120g LP) - 2750.00 [kol: 0]
#2: John Coltrane - A Love Supreme (180g LP) - 3110.00 [kol: 7]
#3: John Coltrane - A Love Supreme (CD) - 1500.00 [kol: 40]
#4: Pink Floyd - Animals (120g LP) - 2500.00 [kol: 7]
#5: Pink Floyd - Animals (CD) - 1250.00 [kol: 30]
]
-- Kupac ulazi u radnju --
Kupac: Dobar dan! Želeo bih da kupim nesto od Pink Floyd-a!
Prodavac: Pozdrav, od Pink Floyd-a imamo u ponudi:
#4: Pink Floyd - Animals (120g LP) - 2500.00 [kol: 7]
#5: Pink Floyd - Animals (CD) - 1250.00 [kol: 30]
Kupac: Kupiću -- Pink Floyd - Animals (120g LP)
Prodavac: Izvolite!
Kupac: Hvala lepo! Vidimo se sledeceg meseca kad legne plata!
-- Kupac ulazi u radnju --
Kupac: Dobar dan! Želeo bih da kupim nesto od David Bowie-a!
Prodavac: Nažalost nemamo to u ponudi :(
Kupac: Ih prava šteta, vidimo se neki drugi put!
-- Kupac ulazi u radnju --
Kupac: Dobar dan! Želeo bih da kupim nesto od colTrane-a!
Prodavac: Pozdrav, od colTrane-a imamo u ponudi:
#1: John Coltrane - A Love Supreme (120g LP) - 2750.00 [kol: 0]
#2: John Coltrane - A Love Supreme (180g LP) - 3110.00 [kol: 7]
#3: John Coltrane - A Love Supreme (CD) - 1500.00 [kol: 40]
Kupac: Kupiću -- John Coltrane - A Love Supreme (120g LP)
Prodavac: Nažalost nemamo traženi artikal trenutno :(
Kupac: Kupiću -- John Coltrane - A Love Supreme (180g LP)
Prodavac: Izvolite!
Kupac: Hvala lepo! Vidimo se sledeceg meseca kad legne plata!
MusicShop: Koltrejnova 7 [
#1: John Coltrane - A Love Supreme (120g LP) - 2750.00 [kol: 0]
#2: John Coltrane - A Love Supreme (180g LP) - 3110.00 [kol: 6]
#3: John Coltrane - A Love Supreme (CD) - 1500.00 [kol: 40]
#4: Pink Floyd - Animals (120g LP) - 2500.00 [kol: 6]
#5: Pink Floyd - Animals (CD) - 1250.00 [kol: 30]
]
