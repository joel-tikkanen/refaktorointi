
import org.junit.Before;
import org.junit.Test;

import com.refaktorointi.kivipaperisakset.Peli;
import com.refaktorointi.kivipaperisakset.Valinta;

import static org.junit.Assert.assertTrue;

/**
 * PeliTest-luokka testaa Peli-luokan toimintaa.
 */

public class PeliTest {

    private Peli peli;

    /**
     * Alustaa uuden peli-instanssin ennen jokaista testiä.
     */

    @Before
    public void setup() {
        peli = new Peli();
    }

    /**
     * Testaa, että peli päättyy kun toinen pelaajista saavuttaa kolme voittoa.
     * Tarkistaa, että pelin säännöt voittojen määrästä päättyvyyden suhteen
     * noudattavat määriteltyä logiikkaa.
     */

    @Test
    public void peliPaattyyKolmeenVoittoon() {
        peli.pelaa();

        assertTrue(
                "Pelin pitäisi päättyä, kun jompikumpi pelaajista saavuttaa kolme voittoa.",
                peli.getP1().getVoitot() == 3 || peli.getP2().getVoitot() == 3);
    }

    /**
     * Testaa, että kivi voittaa sakset. Tämä testi simuloitu pelitilanne, jossa
     * ensimmäinen pelaaja
     * valitsee kiven ja toinen sakset.
     */

    @Test
    public void kiviVoittaaSakset() {
        peli.tarkistaValinnat(Valinta.KIVI, Valinta.SAKSET);
        assertTrue("Kiven pitäisi voittaa sakset.", peli.getP1().getVoitot() == 1);
    }

    /**
     * Testaa, että sakset voittaa paperin. Tarkistaa pelilogiikan oikeellisuuden,
     * kun ensimmäinen pelaaja
     * valitsee sakset ja toinen paperin.
     */

    @Test
    public void saksetVoittaaPaperin() {
        peli.tarkistaValinnat(Valinta.SAKSET, Valinta.PAPERI);
        assertTrue("Saksien pitäisi voittaa paperi.", peli.getP1().getVoitot() == 1);
    }

    /**
     * Testaa, että paperi voittaa kiven. Suorittaa testin tilanteessa, jossa
     * ensimmäinen pelaaja valitsee
     * kiven ja toinen paperin, ja tarkistaa, että toisen pelaajan voitot kasvavat.
     */
    @Test
    public void paperiVoittaaKiven() {
        peli.tarkistaValinnat(Valinta.KIVI, Valinta.PAPERI);
        assertTrue("Paperin pitäisi voittaa kivi.", peli.getP2().getVoitot() == 1);
    }
}
