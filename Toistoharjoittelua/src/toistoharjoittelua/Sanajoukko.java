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
    
    private String kysymys;
    private ArrayList<String> vastaus;
//    private HashMap<String,ArrayList<String>> sanaJoukot = new HashMap();
    
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
            this.vastaus.add(vastaus);
        }    
    }

    public void lisaaVastausJoukkoon (String kysymys, String vastausx) {
//        if( (! this.vastaus.isEmpty() ) && this.kysymys.equals(kysymys)) {
            System.out.println("printataan lisaa-metodista " + kysymys + "   " + vastausx);
ArrayList<String> x = new ArrayList<String>();
//            boolean b = this.vastaus.add(vastausx);            
            boolean b = x.add(vastausx);
//       }
    }
      
    public String getKysymys() {
        return this.kysymys;
    }
    
    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }
    
    public ArrayList<String> getVastaus() {
        return this.vastaus;
    }
    
    public boolean kysymysTyhja() {
        return kysymys.equals("");
    }
    
    public boolean vastausTyhja(String vastaus) {
//        return vastaus.equals("");  // MIKSI EI ANNA VIRHEILMOITUSTA???
        return this.vastaus.isEmpty(); 
    }

    public boolean vastausOikein (String kysymys, 
            String ehdotettuVastaus) {
         return this.kysymys.equals(kysymys) && 
                 this.vastaus.contains(ehdotettuVastaus);
    }
        
    @Override
    public String toString() {
        return kysymys + "  ->  " + vastaus;
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
