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
/* ArrayList<Tavara> tavarat = new ArrayList<Tavara>();*/    
    private ArrayList<Sanapari> sanaParit = new ArrayList<Sanapari>();
   
    public void lueSanaparitListaan() {
        while (true) {
            Sanapari syoteRivi = new Sanapari();
            syoteRivi.annaSanapari();
            if ( (syoteRivi.kysymysTyhja()) || syoteRivi.vastausTyhja() ) {
                System.out.println("Lopetetaan!");
                break; // <<<<<<<<<<<<< POISTUTAAN
            }
            sanaParit.add(syoteRivi);
            System.out.println(syoteRivi);
        }
    }
        
}
    