/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.ArrayList;

/**
 *
 * @author hztuomis
 */
public class Sanaparilista {
   
    private ArrayList<Sanapari> sanaParit = new ArrayList<Sanapari>();
   
    public void lueSanaparitListaan() {
        while (true) {
            Sanapari syoteRivi = new Sanapari("","");
            syoteRivi.annaSanapari();
            if ( (syoteRivi.kysymysTyhja()) || syoteRivi.vastausTyhja() ) {
                System.out.println("Lopetetaan!");
                break; // <<<<<<<<<<<<< POISTUTAAN
            }
            /* samaa paria ei saa lisätä toiseen kertaan!*/
            if ( ! onJoListassa ( syoteRivi) ) { 
                sanaParit.add(syoteRivi);
                System.out.println(syoteRivi);
            } else {
                System.out.println("Rivi on jo listassa, " + 
                        "sitä ei lisätä uudestaan");
            }    
        }
    }
    
    public void tulostaSanapariLista() {
        for (int i = 0; i < sanaParit.size(); ++i) {
            System.out.println(sanaParit.get(i));
        }
    }    

    public void kyseleJaTarkastaSanapariLista() {
        for (int i = 0; i < sanaParit.size(); ++i) {
            sanaParit.get(i).kyseleJaTarkastaSanapari();
        }
    }

    public boolean onJoListassa(Sanapari syoteRivi) {
        for (int i = 0; i < sanaParit.size(); ++i) {
           if (sanaParit.get(i).vastausOikein(syoteRivi.getKysymys(), 
                   syoteRivi.getVastaus() )) {
               return true;
           } 
        } // for
        return false;
    }    

}
    