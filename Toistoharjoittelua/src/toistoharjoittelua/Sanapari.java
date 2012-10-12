/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.Scanner;

/**
 * Sanaparien käsittely
 * Yksityisinä muuttujina merkkijonot "kysymys" ja "vastaus"
 */
public class Sanapari {
    private String kysymys;
    private String vastaus; 

    public Sanapari() {        
    }
    
    /**
     * Luo sanapari
     * @param kysymys
     * @param vastaus 
     */
    public Sanapari (String kysymys, String vastaus) {
        this.kysymys = kysymys;
        this.vastaus = vastaus;        
    }
    
    /**
     * Palautetaan kysymys-kentän arvo
     * 
     * @return kysymys-kentän arvo
     */
    public String getKysymys() {
        return kysymys;
    }

    /**
     * Palautetaan vastaus-kentän arvo
     * @return vastaus-kentän arvo
     */
    public String getVastaus() {
        return vastaus;
    }

    // seuraavat kaksi on tehty testejä varten    
    /**
     * Asetetaan kysymys-kentän arvo
     * 
     * @param kysymys asetettava arvo 
     */    
    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    /**
     * Asetetaan vastaus-kentän arvo
     * 
     * @param vastaus asetettava arvo
     */
    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }
    // end "testejä varten"

    /**
     * Testataan kysymys-kenttää
     * 
     * @return true, jos kysymys on tyhjä, muuten false
     */
    public boolean kysymysTyhja() {
        return kysymys.equals("");
    }
    
    /**
     * Testataan vastaus-kenttää
     * 
     * @return true, jos vastaus on tyhjä, muuten false
     */
    public boolean vastausTyhja() {
        return vastaus.equals("");
    }

    /**
     * Sanaparin merkkiesitys
     * 
     * @return merkkiesitys 
     */
    public String toString() {
        return kysymys + "  ->  " + vastaus;
    }
    
}
