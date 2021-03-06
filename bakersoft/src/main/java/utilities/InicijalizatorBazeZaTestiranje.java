package utilities;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

// TODO: Obrisati ovu klasu kada se zavrsi sa developmentom i izbaciti njeno pozivanje u main-u
public class InicijalizatorBazeZaTestiranje {
    public void popuniBazuPodacima() {
        Baza baza = Baza.getBaza();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        Tip tipKorisnika1 = new Tip();
        Tip tipKorisnika2 = new Tip();

        Status statusKorisnika1 = new Status();
        Status statusKorisnika2 = new Status();

        Korisnik korisnik1 = new Korisnik();
        Korisnik korisnik2 = new Korisnik();

        Klijent klijent1 = new Klijent();
        Klijent klijent2 = new Klijent();

        Dostava dostava1 = new Dostava();
        Dostava dostava2 = new Dostava();
        Dostava dostava3 = new Dostava();
        Dostava dostava4 = new Dostava();
        Racun racun1 = new Racun();
        Racun racun2 = new Racun();
        Pecivo pecivo1 = new Pecivo();
        Pecivo pecivo2 = new Pecivo();
        Pecivo pecivo3 = new Pecivo();
        Pecivo pecivo4 = new Pecivo();
        Pecivo pecivo5 = new Pecivo();
        
        ProdajnoMjesto prodajnoMjesto1 = new ProdajnoMjesto();
        ProdajnoMjesto prodajnoMjesto2 = new ProdajnoMjesto();
        ProdajnoMjesto prodajnoMjesto3 = new ProdajnoMjesto();
        PecivoUDostavi pecivoUDostavi1 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi2 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi11 = new PecivoUDostavi();
        PecivoUDostavi pecivoUDostavi22 = new PecivoUDostavi();

        // Tipovi korisnika
        tipKorisnika1.setTip(Tip.RACUNOVODJA);
        tipKorisnika2.setTip(Tip.DOSTAVLJAC);

        // Statusi korisnika
        statusKorisnika1.setStatus(Status.ZAPOSLEN);
        statusKorisnika2.setStatus(Status.NEZAPOSLEN);

        // Korisnici
        korisnik1.setIme("Mujo");
        korisnik1.setPrezime("Mujkic");
        korisnik1.setBrojMobitela("061222333");
        korisnik1.setBrojTelefona("033234345");
        korisnik1.setDatumRodjenja(new Date(1987, 9, 12));
        korisnik1.setKorisnickoIme("mujo");
        HashFunction hashFunkcija2 = Hashing.md5();
        HashCode hashKodLozinke2 = hashFunkcija2.newHasher().putString("m", Charsets.UTF_8).hash();
        korisnik1.setLozinka(new String(hashKodLozinke2.asBytes()));
        korisnik1.setEmail("mujomujkic@hotmail.com");
        korisnik1.setAdresa("Titova 11");
        korisnik1.setTip(tipKorisnika2);
        korisnik1.setStatus(statusKorisnika1);
        korisnik1.setDostave(new ArrayList<Dostava>());
        korisnik1.getDostave().add(dostava1);
        korisnik1.getDostave().add(dostava2);
        korisnik1.setObracunatiRacuni(new ArrayList<Racun>());
        korisnik1.getObracunatiRacuni().add(racun1);

        korisnik2.setIme("Fata");
        korisnik2.setPrezime("Fatimovic");
        korisnik2.setBrojMobitela("061456958");
        korisnik2.setBrojTelefona("033234345");
        korisnik2.setDatumRodjenja(new Date(1989, 6, 25));
        korisnik2.setKorisnickoIme("fata");
        HashFunction hashFunkcija = Hashing.md5();
        HashCode hashKodLozinke = hashFunkcija.newHasher().putString("f", Charsets.UTF_8).hash();
        korisnik2.setLozinka(new String(hashKodLozinke.asBytes()));
        korisnik2.setEmail("fatafatimovic@gmail.com");
        korisnik2.setAdresa("Marin Dvor 23");
        korisnik2.setTip(tipKorisnika1);
        korisnik2.setStatus(statusKorisnika1);
        korisnik2.setDostave(new ArrayList<Dostava>());
        korisnik2.setObracunatiRacuni(new ArrayList<Racun>());
        

        
        // Klijenti
        klijent1.setIme("Mesnica Kengur");
        klijent1.setTelefon("062274040");
        klijent1.setDostave(new ArrayList<Dostava>());
        klijent1.getDostave().add(dostava1);
        klijent1.getDostave().add(dostava2);
        klijent1.setProdajnaMjesta(new ArrayList<ProdajnoMjesto>());
        klijent1.getProdajnaMjesta().add(prodajnoMjesto1);

        klijent1.setRacuni(new ArrayList<Racun>());
        klijent1.getRacuni().add(racun1);

        klijent2.setIme("Mesnica Noj");
        klijent2.setTelefon("062225883");
        klijent2.setProdajnaMjesta(new ArrayList<ProdajnoMjesto>());
        klijent2.setDostave(new ArrayList<Dostava>());
        
        klijent2.setRacuni(new ArrayList<Racun>());
        klijent2.getRacuni().add(racun2);

        
        
        
        
        // Racuni
        racun1.setDatum(new Date());
        racun1.setKlijent(klijent1);
        racun1.setObracunao(korisnik2);
        try {
        	racun1.setPocetak(simpleDateFormat.parse("19/10/2013"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
        	racun1.setKraj(simpleDateFormat.parse("19/11/2013"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        racun1.setBroj(1);
        racun1.setJePlacen(true);
        racun1.setIznos(1845);

        racun2.setDatum(new Date());
        racun2.setKlijent(klijent2);
        racun2.setObracunao(korisnik1);
        try {
        	racun2.setPocetak(simpleDateFormat.parse("19/10/2013"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
        	racun2.setKraj(simpleDateFormat.parse("19/11/2013"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        racun2.setBroj(2);
        racun2.setJePlacen(true);
        racun2.setIznos(18451);
        
       
        // Peciva
        pecivo1.setNaziv("Kifla");
        pecivo1.setCijena(0.20);
        pecivo1.setJeUProdaji(true);
        pecivo1.setSifra("kifloni-11");
        pecivo1.setTezina(0.05);
        pecivo1.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        pecivo1.getPecivaUDostavi().add(pecivoUDostavi1);
        pecivo1.getPecivaUDostavi().add(pecivoUDostavi11);

        pecivo2.setNaziv("Krofna");
        pecivo2.setCijena(1.20);
        pecivo2.setJeUProdaji(true);
        pecivo2.setSifra("krofna-192");
        pecivo2.setTezina(0.10);
        pecivo2.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        pecivo2.getPecivaUDostavi().add(pecivoUDostavi22);

        pecivo3.setNaziv("Hljeb");
        pecivo3.setCijena(1.00);
        pecivo3.setJeUProdaji(true);
        pecivo3.setSifra("hljeb-123");
        pecivo3.setTezina(0.5);
        pecivo3.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        
        pecivo4.setNaziv("Lisnato");
        pecivo4.setCijena(1.20);
        pecivo4.setJeUProdaji(true);
        pecivo4.setSifra("lisnato-20");
        pecivo4.setTezina(0.2);
        pecivo4.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        
        pecivo5.setNaziv("Kolac");
        pecivo5.setCijena(2.00);
        pecivo5.setJeUProdaji(true);
        pecivo5.setSifra("kolac-102");
        pecivo5.setTezina(0.25);
        pecivo5.setPecivaUDostavi(new ArrayList<PecivoUDostavi>());
        
        // Peciva u dostavi
        pecivoUDostavi1.setDostava(dostava1);
        pecivoUDostavi1.setPecivo(pecivo1);
        pecivoUDostavi1.setKolicinaPreuzetogPeciva(132);
        pecivoUDostavi1.setKolicinaVracenogPeciva(30);
        pecivoUDostavi2.setDostava(dostava1);
        pecivoUDostavi2.setPecivo(pecivo2);
        pecivoUDostavi2.setKolicinaPreuzetogPeciva(92);
        pecivoUDostavi2.setKolicinaVracenogPeciva(0);

        pecivoUDostavi11.setDostava(dostava2);
        pecivoUDostavi11.setPecivo(pecivo1);
        pecivoUDostavi11.setKolicinaPreuzetogPeciva(20);
        pecivoUDostavi11.setKolicinaVracenogPeciva(0);
        pecivoUDostavi22.setDostava(dostava2);
        pecivoUDostavi22.setPecivo(pecivo2);
        pecivoUDostavi22.setKolicinaPreuzetogPeciva(45);
        pecivoUDostavi22.setKolicinaVracenogPeciva(5);

        // Dostave
        dostava1.setDatum(new Date());
        dostava1.setKlijent(klijent1);
        dostava1.setNaziv("Dostava krofne i kifle");
        dostava1.setPreuzeo(korisnik1);
        dostava1.setJeIsporuceno(false);
        dostava1.setPeciva(new ArrayList<PecivoUDostavi>());
        dostava1.getPeciva().add(pecivoUDostavi1);
        dostava1.getPeciva().add(pecivoUDostavi2);

        dostava2.setDatum(new Date());

        
        dostava3.setDatum(new Date());
        
        dostava4.setDatum(new Date());
        
        try {
            dostava2.setDatum(simpleDateFormat.parse("19/10/2013"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dostava2.setKlijent(klijent1);
        dostava2.setNaziv("Dostava krofne i kifle 2");
        dostava2.setPreuzeo(korisnik1);
        dostava2.setJeIsporuceno(true);
        dostava2.setPeciva(new ArrayList<PecivoUDostavi>());
        dostava2.getPeciva().add(pecivoUDostavi11);
        dostava2.getPeciva().add(pecivoUDostavi22);

        // Prodajna mjesta
        prodajnoMjesto1.setAdresa("Tunguzija 23");
        prodajnoMjesto1.setKlijent(klijent1);
        prodajnoMjesto1.setMjesto("Sisha han");
        prodajnoMjesto2.setAdresa("Kipar 554");
        prodajnoMjesto2.setKlijent(klijent2);
        prodajnoMjesto2.setMjesto("Tiru liru faktory");
        prodajnoMjesto3.setAdresa("Bam bam 25");
        prodajnoMjesto3.setKlijent(klijent1);
        prodajnoMjesto3.setMjesto("Vispak kinder jaje");

        // Spasavanje u bazu
        baza.spasiUBazu(tipKorisnika1);
        baza.spasiUBazu(tipKorisnika2);

        baza.spasiUBazu(statusKorisnika1);
        baza.spasiUBazu(statusKorisnika2);

        baza.spasiUBazu(korisnik1);
        baza.spasiUBazu(korisnik2);

        baza.spasiUBazu(klijent1);
        baza.spasiUBazu(klijent2);

        
        baza.spasiUBazu(racun1);
        baza.spasiUBazu(racun2);

        baza.spasiUBazu(pecivo1);
        baza.spasiUBazu(pecivo2);
        baza.spasiUBazu(pecivo3);
        baza.spasiUBazu(pecivo4);
        baza.spasiUBazu(pecivo5);
        
        baza.spasiUBazu(pecivoUDostavi1);
        baza.spasiUBazu(pecivoUDostavi2);
        baza.spasiUBazu(pecivoUDostavi11);
        baza.spasiUBazu(pecivoUDostavi22);

        baza.spasiUBazu(prodajnoMjesto1);
        baza.spasiUBazu(prodajnoMjesto2);
        baza.spasiUBazu(prodajnoMjesto3);

        baza.spasiUBazu(dostava1);

        baza.spasiUBazu(dostava2);
    }
}
