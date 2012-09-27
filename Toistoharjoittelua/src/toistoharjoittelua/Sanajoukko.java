/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*
 */
package toistoharjoittelua;

import java.util.ArrayList;
//import java.util.HashMap;

/**
 *
 * @author hztuomis
 */

public class Sanajoukko {
/**
 * Sanajoukko koostuu joukosta jonkin kysymyksen oikeita vastauksia;
 * Sanajoukko kytketään kysymykseen vasta Sanajoukkolistassa, ts.
 * Sanajoukossa ei ole kysymys-kenttää.
 * 
 * Yksityiset kentät:
 * @ vastaukset  Sanojen joukko (lista)
 * @ oikeidenVastaustenLukumaara
 * @ vaarienVastaustenLukumaara
 */    
    private ArrayList<String> vastaukset = new ArrayList<String>();
    private int oikeidenVastaustenLukumaara = 0;    
    private int vaarienVastaustenLukumaara = 0;
    
    public Sanajoukko() {    
    }

    public String getVastaus(int i) {
        return vastaukset.get(i);
    }

    public boolean vastauksetTyhja() {
        return vastaukset.isEmpty(); 
    }

/** seuraava metodi tehty testejä varten:
 * Palauttaa sanajoukon alkioiden määrän
 * 
 * @return - alkioiden määrä
 */
    public int vastaustenLukumaaraJoukossa() {
        return vastaukset.size();
    }
        
/**
 * Lisätään vastaus joukkoon, jos sitä ei siellä vielä ole
 * 
 * @param vastaus - joukkoon lisättävä vastaus
 */
    public void lisaaVastausSanajoukkoon (String vastaus) {
        if (! vastausOnJoukossa(vastaus)) {
            vastaukset.add(vastaus);
        }    
    }    
/**
 * Kertoo, onko sana joukossa
 * 
 * @param vastaus  - testattava vastaus  
 * @return  true, jos vastaus oli joukossa, muuten false 
 */
// huom. seuraavassa voisi olla isojen ja pienien kirjainten samaistaminen
    public boolean vastausOnJoukossa (String vastaus) {
         return vastaukset.contains(vastaus);
    }
        
    public int getOikeidenVastaustenLukumaara() {
        return oikeidenVastaustenLukumaara;
    }
    
    public void setOikeidenVastaustenLukumaara(int lkm) {
        oikeidenVastaustenLukumaara = lkm;
    }
    
    public int getVaarienVastaustenLukumaara() {
        return vaarienVastaustenLukumaara;
    }
    
    public void setVaarienVastaustenLukumaara(int lkm) {
        vaarienVastaustenLukumaara = lkm;
    }
    
    public String toString() {
        String tulos = "[";
        if (! vastauksetTyhja() ) {
            tulos = tulos + getVastaus(0); 
        }
        for (int i = 1; i < vastaukset.size(); ++i) {
            tulos = tulos + "," + getVastaus(i);
        }
        return tulos + "]";
    }   
}