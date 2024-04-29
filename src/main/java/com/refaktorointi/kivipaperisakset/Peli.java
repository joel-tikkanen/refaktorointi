package com.refaktorointi.kivipaperisakset;

/*
 * Refaktorointi:
 * Pelin logiikka jaettu metodeiksi.
 * Voiton tarkistusta selvennetty.
 * Tieto pelaajien voitoista siirretty pelaaja-luokkaan.
 * Kovakoodatut arvot siirretty final muuttujiksi.
 * Valinnat muutettu enumeiksi.
 */

/**
 * Peli-luokka mallintaa kivi-paperi-sakset -peliä. Peli koostuu kahdesta
 * pelaajasta, jotka pelaavat toisiaan vastaan. Peli päättyy, kun jompikumpi
 * pelaajista saavuttaa kolme voittoa.
 */

public class Peli {

    /** Ensimmäinen pelaaja. */
    private final Pelaaja p1 = new Pelaaja();

    /** Toinen pelaaja. */
    private final Pelaaja p2 = new Pelaaja();

    /** Voittojen määrä, jonka saavuttamisella peli päättyy. */
    private final int voittojenRaja = 3;

    /** Pelattujen pelien / erien kokonaismäärä . */
    private int pelatutPelit = 1;

    /** Tasapelien määrä. */
    private int tasapelit = 0;

    /** Tieto siitä, onko peli päättynyt. */
    private boolean peliLoppui = false;

    /**
     * Tarkistaa kunkin pelikierroksen valinnat ja määrittää niiden perusteella
     * voittajan.
     * Tasapelin sattuessa kasvattaa tasapelien määrää.
     * 
     * @param p1Valinta Ensimmäisen pelaajan valinta.
     * @param p2Valinta Toisen pelaajan valinta.
     */
    public void tarkistaValinnat(Valinta p1Valinta, Valinta p2Valinta) {
        if (p1Valinta == p2Valinta) {
            System.out.println("\n\tTasapeli! \n");
            tasapelit++;
        } else if (voittaa(p1Valinta, p2Valinta)) {
            System.out.println("\n\tPelaaja 1 " + "voittaa!");
            p1.setVoitot();
        } else {
            System.out.println("\n\tPelaaja 2 " + "voittaa!");
            p2.setVoitot();
        }
    }

    /**
     * Apumetodi, joka määrittää, voittaako ensimmäisen pelaajan valinta toisen
     * pelaajan valinnan.
     *
     * @param p1Valinta Ensimmäisen pelaajan valinta.
     * @param p2Valinta Toisen pelaajan valinta.
     * @return true, jos ensimmäinen pelaaja voittaa, muuten false.
     */
    private boolean voittaa(Valinta p1Valinta, Valinta p2Valinta) {
        return (p1Valinta == Valinta.KIVI && p2Valinta == Valinta.SAKSET) ||
                (p1Valinta == Valinta.PAPERI && p2Valinta == Valinta.KIVI) ||
                (p1Valinta == Valinta.SAKSET && p2Valinta == Valinta.PAPERI);
    }

    /**
     * Tarkistaa, onko pelin voittoraja saavutettu, ja asettaa pelin loppumistilan
     * tarvittaessa.
     */
    private void peliLoppui() {
        if (p1.getVoitot() >= voittojenRaja || p2.getVoitot() >= voittojenRaja) {
            peliLoppui = true;
        }
    }

    /**
     * Käynnistää pelin ja suorittaa pelikierroksia, kunnes peli päättyy.
     * Tulostaa kunkin pelikierroksen alussa pelin tilanteen ja päättyessä
     * lopputuloksen.
     */
    public void pelaa() {
        do {
            System.out.println("\nErä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lkm: " + tasapelit + "\n");
            System.out.println("Pelaaja 1: " + p1.getVoitot() + " voittoa");
            System.out.println("Pelaaja 2: " + p2.getVoitot() + " voittoa\n");

            Valinta p1Valinta = p1.pelaajanValinta();
            Valinta p2Valinta = p2.pelaajanValinta();

            System.out.println("\tPelaaja 1: " + p1Valinta);
            System.out.println("\tPelaaja 2: " + p2Valinta);

            tarkistaValinnat(p1Valinta, p2Valinta);
            peliLoppui();
            pelatutPelit++;
        } while (!peliLoppui);

        System.out.println("\nKOLME VOITTOA - PELI PÄÄTTYY");

    }

    /**
     * Palauttaa ensimmäisen pelaajan.
     * 
     * @return Ensimmäinen pelaaja.
     */
    public Pelaaja getP1() {
        return p1;
    }

    /**
     * Palauttaa toisen pelaajan.
     * 
     * @return Toinen pelaaja.
     */

    public Pelaaja getP2() {
        return p2;
    }
}
