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
//        private HashMap<String,Sanajoukko> Sanajoukkolista = new HashMap();
//    private Sanaparilista sl;
     private Sanajoukkolista sl;
  
    public Kayttoliittyma(){
//          sl = new Sanaparilista();
          sl = new Sanajoukkolista();
    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
    */    
        
    public void lueSanaparitListaan() {
        while (true) {
          //  Sanapari sp = new Sanapari ("","");
            //Sanapari sp = new Sanapari();
            Sanajoukko sj = this.annaSanapari();
            if ( (sj.kysymysTyhja()) || sj.vastausTyhja(null) ) {
                System.out.println("Lopetetaan!");
                break; // <<<<<<<<<<<<< POISTUTAAN SILMUKASTA
            }
            /* samaa paria ei saa lisätä toiseen kertaan!
            if ( ! sl.kysymysOnListassa(kysymys) ) { 
                sl.LisaaPariJoukkoon(sj.getKysymys(),sj.getVastaus());
                System.out.println(sj);
            } else {
                System.out.println("Rivi on jo listassa, " + 
                        "sitä ei lisätä uudestaan");
            }  */  
        }
    }

    public Sanajoukko annaSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
        System.out.println("Sana oli: " + sana);

        System.out.print("Anna vastine: ");
        String vastine = lukija.nextLine();
        System.out.println("Vastine oli: " + vastine);
        
       // Sanapari sp = new Sanapari (sana, vastine);
//        Sanapari sp = new Sanapari(sana,vastine);
//        Sanajoukko sj = new Sanajoukko(sana,vastine);
          Sanajoukko sj = new Sanajoukko(sana);
          System.out.println("konstruktion jälkeen  " + sj);
                      System.out.println(sana + "  vastaa  " + vastine);
          sj.lisaaVastausJoukkoon(sana,vastine);

                
        return sj; 
    }
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanapariLista() {
        System.out.print(sl);
    }    

    /**
    * kysellään ja tarkastetaan
    */
    public void kyseleJaTarkastaSanapariLista() {
        for (String avain : sl.GetJoukkoLista().keySet()) {
            this.kyseleJaTarkastaSanapari(sl.GetJoukkoLista().get(avain));
        }
    }

/*            
            Sanapari sp = new Sanapari(
                    sl.AnnaSanajoukkoListasta(i).getKysymys(),
                    sl.AnnaSanajoukkoListasta(i).getVastaus());
            kyseleJaTarkastaSanapari(sp);
        }    
*/

    public void kyseleJaTarkastaSanapari(Sanajoukko sj) {
        kysy(sj); 
        String ehdotus = ehdotettuVastaus();
        if (sj.vastausOikein(sj.getKysymys(), ehdotus )) {
            System.out.println("Oikein");
        } else {
            System.out.println("Väärin");
            System.out.println("Oikea vastaus on: " + sj.getVastaus());
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