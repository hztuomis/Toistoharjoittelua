/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.Scanner;

/**
 *
 * @author hztuomis
 */
public class Kayttoliittyma {
    private Sanaparilista sl;
    
    public Kayttoliittyma(){
          sl = new Sanaparilista();
    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
    */    
        
    public void lueSanaparitListaan() {
        while (true) {
            Sanapari sp = new Sanapari ("","");
            sp = annaSanapari();
            if ( (sp.kysymysTyhja()) || sp.vastausTyhja() ) {
                System.out.println("Lopetetaan!");
                break; // <<<<<<<<<<<<< POISTUTAAN SILMUKASTA
            }
            /* samaa paria ei saa lisätä toiseen kertaan!*/
            if ( ! sl.onJoListassa(sp) ) { 
                sl.LisaaPariListaan(sp.getKysymys(),sp.getVastaus());
                System.out.println(sp);
            } else {
                System.out.println("Rivi on jo listassa, " + 
                        "sitä ei lisätä uudestaan");
            }    
        }
    }

    public Sanapari annaSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
        System.out.println("Sana oli: " + sana);

        System.out.print("Anna vastine: ");
        String vastine = lukija.nextLine();
        System.out.println("Vastine oli: " + vastine);
        
        Sanapari sp = new Sanapari (sana, vastine);
        return sp; 
    }
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanapariLista() {
        for (int i = 0; i < sl.SanaPariListanKoko(); ++i) {
            System.out.println(sl.AnnaSanapariListasta(i));
        }
    }    

    /**
    * kysellään ja tarkastetaan
    */
    public void kyseleJaTarkastaSanapariLista() {
        for (int i = 0; i < sl.SanaPariListanKoko(); ++i) {
            Sanapari sp = new Sanapari(
                    sl.AnnaSanapariListasta(i).getKysymys(),
                    sl.AnnaSanapariListasta(i).getVastaus());
            kyseleJaTarkastaSanapari(sl.AnnaSanapariListasta(i));
        }    
    }

    public void kyseleJaTarkastaSanapari(Sanapari sp) {
        kysy(sp); 
        String ehdotus = ehdotettuVastaus();
        if (sp.vastausOikein(sp.getKysymys(), ehdotus )) {
            System.out.println("Oikein");
        } else {
            System.out.println("Väärin");
            System.out.println("Oikea vastaus on: " + sp.getVastaus());
        }
    }
    
    public void kysy(Sanapari sp) {
        System.out.print(sp.getKysymys() + "?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }
}