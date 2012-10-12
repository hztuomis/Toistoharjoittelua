/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*
 */
package toistoharjoittelua;

import java.util.ArrayList;

/**
 * Sanajoukko koostuu joukosta jonkin kysymyksen oikeita vastauksia; Sanajoukko
 * kytketään kysymykseen vasta Sanajoukkolistassa, ts. Sanajoukossa ei ole
 * kysymys-kenttää.
 *
 * Yksityiset kentät:
 * @ vastaukset Sanojen joukko (lista)
 * @ oikeidenVastaustenLukumaara montako oikeata vastausta joukolla
 * @ vaarienVastaustenLukumaara montako väärää vastausta joukolla
 */
public class Sanajoukko {

    private ArrayList<String> vastaukset = new ArrayList<String>();
    private int oikeidenVastaustenLukumaara = 0;
    private int vaarienVastaustenLukumaara = 0;

    public Sanajoukko() {
    }

    /**
     * Hakee yksittäisen vastauksen indeksiä käyttäen
     *
     * @param i vastauksen järjestysnumero arraylistissa
     * @return yksittäinen vastaus
     */
    public String getVastaus(int i) {
        return vastaukset.get(i);
    }

    /**
     * Tarkastaa, onko vastausten joukko tyhjä
     *
     * @return true, jos vastausjoukko on tyhjä; muuten false
     */
    public boolean vastauksetTyhja() {
        return vastaukset.isEmpty();
    }

    /**
     * Seuraava metodi tehty testejä varten: Palauttaa sanajoukon alkioiden
     * määrän
     *
     * @return alkioiden määrä sanajoukossa
     */
    public int vastaustenLukumaaraJoukossa() {
        return vastaukset.size();
    }

    /**
     * Lisätään vastaus joukkoon, jos sitä ei siellä vielä ole
     *
     * @param vastaus joukkoon lisättävä vastaus
     */
    public void lisaaVastausSanajoukkoon(String vastaus) {
        if (!trimmattuVastausOnJoukossa(vastaus)) {
            vastaukset.add(vastaus);
        }
    }

    /**
     * Kertoo, onko sana joukossa
     *
     * @param vastaus testattava vastaus
     * @return true, jos vastaus oli joukossa; muuten false
     */
    //  HUOM. SEURAAVASSA TRIM !!!!
    public boolean trimmattuVastausOnJoukossa(String vastaus) {
        return vastaukset.contains(vastaus.trim()); // LISÄTTY TRIM
    }

    /**
     * Palauttaa oikeiden vastausten lukumäärän sanajoukossa
     *
     * @return oikeiden vastausten määrä sanajoukkokohtaisesti
     */
    public int getOikeidenVastaustenLukumaara() {
        return oikeidenVastaustenLukumaara;
    }

    /**
     * Oikeiden vastausten määrän asettaminen sanajoukkokohtaisesti
     *
     * @return asetettu lukumäärä (esim. nollaus)
     */
    public void setOikeidenVastaustenLukumaara(int lkm) {
        oikeidenVastaustenLukumaara = lkm;
    }

    /**
     * Palauttaa väärien vastausten lukumäärän sanajoukossa
     *
     * @return väärien vastausten määrä sanajoukkokohtaisesti
     */
    public int getVaarienVastaustenLukumaara() {
        return vaarienVastaustenLukumaara;
    }

    /**
     * Väärien vastausten määrän asettaminen sanajoukkokohtaisesti
     *
     * @return asetettu lukumäärä (esim. nollaus)
     */
    public void setVaarienVastaustenLukumaara(int lkm) {
        vaarienVastaustenLukumaara = lkm;
    }

    /**
     * Sanajoukon merkkiesitys
     *
     * @return sanajoukon merkkiesitys muodossa [a,b,c]
     */
    public String toString() {
        String tulos = "[";
        if (!vastauksetTyhja()) {
            tulos = tulos + getVastaus(0);
        }
        for (int i = 1; i < vastaukset.size(); ++i) {
            tulos = tulos + "," + getVastaus(i);
        }
        return tulos + "]";
    }
}