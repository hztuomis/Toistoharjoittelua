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
     private Sanajoukkolista jl;
  
    public Kayttoliittyma(){
//          sl = new Sanaparilista();
          jl = new Sanajoukkolista();
    }
    
/*
    public Sanajoukko getSanajoukko (String kysymys) {
        return sl.GetJoukkoListasta(kysymys);
    }
*/    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
    */    
        
    
    public void lueSanajoukotListaan() {
        while (true) {
            Sanajoukko lisattava = lueSanaparitJoukkoon();
            if (lisattava == null) {
                break;   // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            }
//            jl.LisaaSanajoukkoListaan(lisattava.getKysymys(), lisattava.getVastaukset());
            jl.LisaaSanajoukkoListaan(lisattava.getKysymys(), lisattava);
        }
    }
            
    
    public Sanajoukko lueSanaparitJoukkoon() {
        Sanajoukko sj = new Sanajoukko();
        while (true) {
            Sanapari sp = new Sanapari("","");
          //  Sanapari sp = new Sanapari ("","");
            //Sanapari sp = new Sanapari();
//            String vastine = this.lueSanapari().getVastaus();//(/*sj*/);
            sp = lueSanapari();
            if ( (sp.kysymysTyhja()) || sp.vastausTyhja() ) {
                System.out.println("Lopetetaan joukon sanojen syöttö!");
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
          sj.lisaaVastausJoukkoon(sj.getKysymys(),sp.getVastaus());
        }
        return sj;
    }

    public Sanapari lueSanapari (/*Sanajoukko sj*/) {    
        
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
//          Sanajoukko sj = new Sanajoukko(sana);
        
//          System.out.println("konstruktion jälkeen  " + sj);

          //=================================
          System.out.println(sana + "  vastaa  " + vastine);
//====================================
          
          Sanapari sp = new Sanapari(sana, vastine);
          
                
        return sp; 
    }
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanapariLista() {
        System.out.print(jl);
    }    

    /**
    * kysellään ja tarkastetaan
    */
    public void kyseleJaTarkastaSanapariLista() {
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