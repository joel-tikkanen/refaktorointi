
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.refaktorointi.kivipaperisakset.Pelaaja;
import com.refaktorointi.kivipaperisakset.Valinta;

/**
 * Testiluokka Pelaaja-luokan toiminnallisuuden varmistamiseksi.
 * Tämä luokka sisältää testejä, jotka varmistavat pelaajan voittojen lisäyksen
 * toiminnan ja pelaajan
 * kyvyn tehdä valintoja pelissä.
 */

public class PelaajaTest {

    private Pelaaja pelaaja;

    /**
     * Alustaa Pelaaja-olion ennen jokaista testiä.
     */
    @Before
    public void setup() {
        pelaaja = new Pelaaja();
    }

    /**
     * Testaa, että pelaajan voittojen määrä alkaa nollasta ja kasvaa oikein,
     * kun pelaaja saavuttaa voittoja.
     */
    @Test
    public void voittojenLisaysToimii() {
        assertEquals("Alussa voittoja pitäisi olla 0.", pelaaja.getVoitot(), 0);
        pelaaja.setVoitot();
        pelaaja.setVoitot();
        assertEquals("Voittojen määrä ei täsmää odotettuun.", pelaaja.getVoitot(), 2);
    }

    /**
     * Testaa, että pelaajanValinta-metodi palauttaa validin Valinta-enum arvon.
     * Tarkistaa, että palautettu arvo kuuluu määriteltyihin enum arvoihin (KIVI,
     * PAPERI tai SAKSET).
     */
    @Test
    public void pelaajanValintaToimii() {
        Valinta v = pelaaja.pelaajanValinta();
        assertTrue("Pelaajan valinnan pitäisi olla Valinta-enumin arvo.", v instanceof Valinta);
    }
}