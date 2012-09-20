/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.ArrayList;
//import java.util.HashMap;

/**
 *
 * @author hztuomis
 */
public class Sanajoukko {
    
    private String kysymys = "";
    private ArrayList<String> vastaukset = new ArrayList<String>();
    private Sanapari aloittavaSanapari = new Sanapari("","");
    
    public Sanajoukko() {    
    }
    
    public Sanajoukko (String kysymys) {
        if ( ! kysymys.isEmpty()) {
            this.kysymys = kysymys;
        }    
    }    
    
    public Sanajoukko (String kysymys, String vastaus) {
        if ( ! kysymys.isEmpty()) {
            this.kysymys = kysymys;
            this.vastaukset.add(vastaus);
        }    
    }

    public void lisaaVastausJoukkoon (String kysymys, String vastaus) {
        if( (! vastaus.isEmpty() ) && this.kysymys.equals(kysymys)) {
            this.kysymys = kysymys;
            this.vastaukset.add(vastaus);
        }
      
//ArrayList<String> x = new ArrayList<String>();
//            boolean b = this.vastaus.add(vastausx);            
//            boolean b = x.add(vastaus);
//       }
    }
      
    public String getKysymys() {
        return this.kysymys;
    }
    
    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }
    
    public Sanapari getAloittavaSanapari() {
        return this.aloittavaSanapari;
    }
    
    public void setAloittavaSanapari(String kysymys, String vastaus) {
        this.aloittavaSanapari.setKysymys(kysymys);
        this.aloittavaSanapari.setVastaus(vastaus);
    }
    
    public ArrayList<String> getVastaukset() {
        return this.vastaukset;
    }
    
    public boolean kysymysTyhja() {
        return kysymys.equals(""); // isEmpty, length, ...
    }
    
    public boolean vastauksetTyhja(String vastaus) {
//        return vastaus.equals("");  // MIKSI EI ANNA VIRHEILMOITUSTA???
        return this.vastaukset.isEmpty(); 
    }

    public boolean vastausOikein (String kysymys, 
            String vastaus) {
         return this.kysymys.equals(kysymys) && 
                 this.vastaukset.contains(vastaus);
    }
        
    @Override
    public String toString() {
        return kysymys + "  ->  " + vastaukset;
    }

    /*
    public String toString() {
       String tulos = "";
//        for (int i = 0; i < kysymykset.size(); ++i) {
//            String k = kysymykset.get(i);
        
        tulos = this.getKysymys() + " --> " + vastaus + "\n";
        
        return tulos;
    } */   
}
