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
    private String vastaus; //ArrayList

    public Sanapari (String kysymys, String vastaus) {
        this.kysymys = kysymys;
        this.vastaus = vastaus;        
    }
    
    public Sanapari() {
        
    }
    
    public String getKysymys() {
        return this.kysymys;
    }

    public String getVastaus() {
        return this.vastaus;
    }
    
    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }
    
    public boolean kysymysTyhja() {
        return kysymys.equals("");
    }
    
    public boolean vastausTyhja() {
        return vastaus.equals("");
    }

    public boolean vastausOikein (String kysymys, 
            String ehdotettuVastaus) {
         return this.kysymys.equals(kysymys) && 
                 this.vastaus.equals(ehdotettuVastaus);
    }
        
    public String toString() {
        return kysymys + "  ->  " + vastaus;
    }
    
}
