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
    private Sanajoukkolista jl;
  
    public Kayttoliittyma(Sanajoukkolista jl){
//          jl = new Sanajoukkolista();
    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan*
    */    
        
    
/*
    public Sanajoukkolista lisaaSanajoukotListaan(Sanajoukkolista jl) {
        Sanajoukko sj = new Sanajoukko();
        Sanapari s = new Sanapari();
        s = lueSanapari();
        sj.setAloittavaSanapari(s.getKysymys(),s.getVastaus());
        while ((! sj.getAloittavaSanapari().getKysymys().trim().equals("")) && 
               (! sj.getAloittavaSanapari().getVastaus().trim().equals("")) &&
               (! sj.getAloittavaSanapari().getVastaus().isEmpty())  &&
               (! sj.getAloittavaSanapari().getVastaus().isEmpty())) {
            sj = lueSanaparitJoukkoon(sj);
            jl.LisaaSanajoukkoListaan(sj.getKysymys(), sj);
            System.out.println("TESTI: sanajoukko tallennettu");
        }
        System.out.println("Lopetetaan joukkojen syöttö!");
        return jl;
    }
*/            
    
    /*
    public Sanajoukko lueSanaparitJoukkoon(Sanajoukko sj) {
        sj.lisaaVastausJoukkoon(sj.getAloittavaSanapari().getKysymys(),
                sj.getAloittavaSanapari().getVastaus());
        while (true) {
            Sanapari sp = new Sanapari();
            sp = lueSanapari();
            if ( (sp.kysymysTyhja()) || sp.vastausTyhja() ) {
                sj.setAloittavaSanapari(sp.getKysymys(),sp.getVastaus());
                
                System.out.println("Lopetetaan joukon sanojen syöttö!");
                System.out.println("TESTI: kysymys tai vastaus tyhjä");
                break; // <<<<<<<<<<<<< POISTUTAAN SILMUKASTA
            }
            if (! sp.getKysymys().equals(sj.getAloittavaSanapari().getKysymys())) {
                sj.setAloittavaSanapari(sp.getKysymys(), sp.getVastaus());
                break; // <<<<<<<<<<<<<<<<<<<< POISTUTAAN
            }
// -------------------------------------------            
            if (sp.getKysymys() != aloittavaSanapari.getKysymys()) {
                // sanajoukko vaihtuu
                aloittavaSanapari.setKysymys(sp.getKysymys());
                aloittavaSanapari.setVastaus(sp.getVastaus());
            }
/ -------------------------------------------------
            
//TÄHÄN LISÄTTÄVÄ:samaa paria ei saa lisätä toiseen kertaan! 

            sj.lisaaVastausJoukkoon(sp.getKysymys(),sp.getVastaus());
        }
        return sj;
    }

*/

    public Sanapari lueSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
        System.out.println("Sana oli: " + sana);

        System.out.print("Anna vastine: ");
        String vastine = lukija.nextLine();
        System.out.println("Vastine oli: " + vastine);
          
        Sanapari sp = new Sanapari(sana, vastine);
                  
        return sp; 
    }
    
    public Sanajoukkolista lueSanaparitJoukkolistaan () {
            System.out.println("lueSanaparitJoukkolistaan 1 alussa");
        Sanapari sanapari = new Sanapari();
        Sanajoukkolista joukkoLista = new Sanajoukkolista();
        sanapari = lueSanapari();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = lueSanapari();   
            System.out.println("lueSanaparitJoukkolistaan 2 silmukassa");
        }   
        return joukkoLista;
    }
    
    
    
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanajoukkoLista(Sanajoukkolista jl) {
        System.out.println(jl);
    }    

    /**
    * kysellään ja tarkastetaan
    */
    
    public void kyseleJaTarkastaSanajoukkoLista(Sanajoukkolista jl) {
        for (String avain : jl.GetJoukkoLista().keySet()) {
            kyseleJaTarkastaVastaus(avain,jl.getJoukkoListasta(avain));
        }
    }

    public void kyseleJaTarkastaVastaus(String avain, Sanajoukko sj) {
        kysy(avain); 
        String ehdotus = ehdotettuVastaus();
        if (sj.vastausOnJoukossa(ehdotus)) {
            System.out.println("Oikein");
        } else {
            System.out.println("Väärin");
            System.out.println("Oikeat vastaukset ovat: " + sj);
        }
    }
    
    public void kysy(String avain) {
        System.out.print(avain + "?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

}