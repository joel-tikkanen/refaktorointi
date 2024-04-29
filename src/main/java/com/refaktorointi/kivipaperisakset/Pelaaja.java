
package com.refaktorointi.kivipaperisakset;

/*
 * Refakrotointi:
   * Valinnat muutettu enumeiksi.
   * Arvonta siirretty Valinta-enumiin.
 */

/**
 * Pelaaja-luokka mallintaa yksittäistä pelaajaa kivi-paperi-sakset -pelissä.
 * Pelaaja pitää tietoa omista voitoista.
 */

public class Pelaaja {

    /** Pelaajan tähän mennessä saavuttamien voittojen määrä. */
    private int voitot = 0;

    /**
     * Suorittaa pelaajan valinnan kivi-paperi-sakset -pelissä.
     * Valinta arvotaan satunnaisesti Valinta-enumin avulla.
     *
     * @return Arvottu Valinta-enumin arvo.
     */
    public Valinta pelaajanValinta() {
        Valinta valinta = Valinta.arvo();
        return valinta;
    }

    /**
     * Kasvattaa pelaajan voittojen määrää yhdellä.
     *
     * @return Uusi voittojen lukumäärä.
     */
    public int setVoitot() {
        return voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen määrän.
     *
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return voitot;
    }

}
