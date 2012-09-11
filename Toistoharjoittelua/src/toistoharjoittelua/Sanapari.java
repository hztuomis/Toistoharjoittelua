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

    Sanapari () {
        
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

    public void annaSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
        System.out.println("Sana oli: " + sana);
        /* tähän mahdollisia tarkastuksia */
        this.kysymys = sana;

        System.out.print("Anna vastine: ");
        String vastine = lukija.nextLine();
        System.out.println("Vastine oli: " + vastine);
        /* tähän mahdollisia tarkastuksia */
        this.vastaus = vastine;
        /* hyväksytkö vai hylkäätkö sanaparin?*/
    }
    
    public boolean vastausOikein (String kysymys, 
            String ehdotettuVastaus) {
         return this.kysymys.equals(kysymys) && 
                 this.vastaus.equals(ehdotettuVastaus);
    }
    
    public void kysy() {
        System.out.print(this.kysymys + "?: ");
    }
    
    public String ehdotettuVastaus() {
        kysy();
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }
    
    public void kyseleJaTarkastaSanapari() {
       String ehdotus = ehdotettuVastaus();
       if (vastausOikein(getKysymys(), ehdotus )) {
          System.out.println("Oikein");
       } else {
           System.out.println("Väärin");
       }
    }

    
    public String toString() {
        return kysymys + "  ->  " + vastaus;
    }
    
}
