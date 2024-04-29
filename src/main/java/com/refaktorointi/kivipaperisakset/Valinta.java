package com.refaktorointi.kivipaperisakset;

/**
 * Valinta-enum määrittelee kivi-paperi-sakset -pelin kolme mahdollista
 * valintaa:
 * kivi, paperi ja sakset. Näitä käytetään pelaajien valintoina pelin
 * logiikassa.
 */
public enum Valinta {
    /** Valinta kivelle */
    KIVI,
    /**
     * Valinta paperille
     */
    PAPERI,
    /**
     * Valinta saksille
     */
    SAKSET;

    /**
     * Arpoo ja palauttaa yhden kolmesta Valinnasta.
     * 
     * @return Satunnaisesti valittu Valinta.
     */
    public static Valinta arvo() {
        return values()[(int) (Math.random() * values().length)];
    }
}
