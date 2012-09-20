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
  
    public Kayttoliittyma(){
          jl = new Sanajoukkolista();
    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
    */    
        
    
    public Sanajoukkolista lueSanajoukotListaan() {
        while (true) {
            Sanajoukko lisattava = lueSanaparitJoukkoon();
            if (lisattava.getKysymys() == "" || lisattava == null) {
                break;   // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            }
            jl.LisaaSanajoukkoListaan(lisattava.getKysymys(), lisattava);
        }
        return jl;
    }
            
    
    public Sanajoukko lueSanaparitJoukkoon(String edellinenKysymys) {
        Sanajoukko sj = new Sanajoukko();
        while (true) {
            Sanapari sp = new Sanapari();
            sp = lueSanapari();
            if ( (sp.kysymysTyhja()) || sp.vastausTyhja() ) {
                System.out.println("Lopetetaan joukon sanojen syöttö!");
                break; // <<<<<<<<<<<<< POISTUTAAN SILMUKASTA
            }
            if (sp.getKysymys() == edellinenKysymys) {
                // sanajoukko vaihtuu
                // ?????????
            }
            
            /* TÄHÄN:samaa paria ei saa lisätä toiseen kertaan! */ 

            sj.lisaaVastausJoukkoon(sj.getKysymys(),sp.getVastaus());
        }
        return sj;
    }

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
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanapariLista(Sanajoukkolista jl) {
        System.out.print(jl);
    }    

    /**
    * kysellään ja tarkastetaan
    */
    public void kyseleJaTarkastaSanapariLista(Sanajoukkolista jl) {
        for (String avain : jl.GetJoukkoLista().keySet()) {
            this.kyseleJaTarkastaVastaus(jl.GetJoukkoListasta(avain));//GetJoukkoLista().get(avain)
        }
    }

/*            
            Sanapari sp = new Sanapari(
                    sl.AnnaSanajoukkoListasta(i).getKysymys(),
                    sl.AnnaSanajoukkoListasta(i).getVastaus());
            kyseleJaTarkastaSanapari(sp);
        }    
*/

    public void kyseleJaTarkastaVastaus(Sanajoukko sj) {
        kysy(sj); 
        String ehdotus = ehdotettuVastaus();
        if (sj.vastausOikein(sj.getKysymys(), ehdotus )) {
            System.out.println("Oikein");
        } else {
            System.out.println("Väärin");
            System.out.println("Oikeat vastaukset ovat: " + sj.getVastaukset());
        }
    }
    
    public void kysy(Sanajoukko sj) {
        System.out.print(sj.getKysymys() + "?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }
}