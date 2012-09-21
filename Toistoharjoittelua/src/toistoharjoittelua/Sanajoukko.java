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
    
    private ArrayList<String> vastaukset = new ArrayList<String>();
    
    public Sanajoukko() {    
    }

    public String getVastaus(int i) {
        return vastaukset.get(i);
    }

    public boolean vastauksetTyhja() {
        return vastaukset.isEmpty(); 
    }
        
    public void lisaaVastausSanajoukkoon (String vastaus) {
        if (! vastausOnJoukossa(vastaus)) {
            vastaukset.add(vastaus);
        }    
    }    

// huom. seuraavassa voisi olla isojen ja pienien kirjainten samaistaminen
    public boolean vastausOnJoukossa (String vastaus) {
         return vastaukset.contains(vastaus);
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