package ohtu;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;
    Tuote maito;


    @Before
    public void setUp() {
        kori = new Ostoskori();
        maito = new Tuote("maito", 3);
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
 
        assertEquals(0, kori.tavaroitaKorissa());
    }

    // step 2
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() { 
        kori.lisaaTuote(maito);

        assertEquals(1, kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaaminenKasvattaaOstoskorinHintaa() {
        kori.lisaaTuote(maito);

        assertEquals(3, kori.hinta());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaOnKaksiTuotetta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(new Tuote("mehu", 5));

        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorinHintaOnOikea() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(new Tuote("mehu", 5));

        assertEquals(8, kori.hinta());
    }

    @Test
    public void kahdenSamanTuotteenLisaaminenKasvattaaKorinKokoaOikein() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenSamanTuotteenLisaaminenKasvattaaHintaaOikein() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(6, kori.hinta());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(maito);
 
        List<Ostos> ostokset = kori.ostokset();
 
        assertEquals(1, ostokset.size());
    }

    // step 9
    @Test
    public void yhdenTuotteenLisaamisenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        kori.lisaaTuote(maito);
        
        Ostos ostos = kori.ostokset().get(0);
 
        // testaa täällä, että palautetun listan ensimmäinen ostos on halutunkaltainen.
        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(1, ostos.lukumaara());
    }
    
    @Test
    public void kahdenEriTuotteenLisaaminenLisaaKoriinKaksiOstosta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(new Tuote("mehu", 5));
 
        List<Ostos> ostokset = kori.ostokset();
 
        assertEquals(2, ostokset.size());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaOnYksiOstos() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        List<Ostos> ostokset = kori.ostokset();
 
        assertEquals(1, ostokset.size());
    }
}
