/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author hztuomis
 */

import java.util.Scanner;

public class Sanapari {
    private String kysymys;
    private String vastaus; 

    public Sanapari() {        
    }
    
    public Sanapari (String kysymys, String vastaus) {
        this.kysymys = kysymys;
        this.vastaus = vastaus;        
    }
    
    public String getKysymys() {
        return kysymys;
    }

    public String getVastaus() {
        return vastaus;
    }

    public boolean kysymysTyhja() {
        return kysymys.equals("");
    }
    
    public boolean vastausTyhja() {
        return vastaus.equals("");
    }

    public String toString() {
        return kysymys + "  ->  " + vastaus;
    }
    
}
