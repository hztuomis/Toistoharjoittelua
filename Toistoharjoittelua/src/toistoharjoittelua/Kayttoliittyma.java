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
    private Sanajoukkolista joukkoLista;
  
    public Kayttoliittyma(Sanajoukkolista joukkoLista){

    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
    */    

    public Sanajoukkolista lueSanaparitJoukkolistaan () {
        Sanapari sanapari = new Sanapari();
        Sanajoukkolista joukkoLista = new Sanajoukkolista();
        sanapari = lueSanapari();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = lueSanapari();   
        }   
        return joukkoLista;
    }

    public Sanapari lueSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        String vastine = "";
        // seuraaviin trim???
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
//        System.out.println("Sana oli: " + sana);
        if (! sana.equals("")) {
            System.out.print("Anna vastine: ");
            vastine = lukija.nextLine();
//            System.out.println("Vastine oli: " + vastine);
        } else {
            vastine = "";
        }
      
        Sanapari sp = new Sanapari(sana, vastine);
        System.out.println("Syötetty: " + sp);
                  
        return sp; 
    }
    
    /**
     * tulostetaan lista
     */
    
    public void tulostaSanajoukkoLista(Sanajoukkolista jl) {
        System.out.println(jl);
        System.out.println("Kyseltäviä sanoja: " + jl.listanAlkioidenLkm());
    }    

    /**
    * kysellään ja tarkastetaan
    */
    
    public boolean kyseleJaTarkastaSanajoukkoLista(Sanajoukkolista jl) {
        boolean jatkuu = true;
        int lkm = jl.listanAlkioidenLkm();
        jl.setKyseltaviaSanojaJaljella(lkm);
        while (jatkuu) {
            jatkuu = kyseleJaTarkastaArvottuKysymys(jl, 
                jl.arvottuListanAlkionJarjestysnumero(lkm));
        }
        return false;
    }
    
    public boolean kyseleJaTarkastaArvottuKysymys(Sanajoukkolista jl,
            int arvottuNro) {
        int i = 0;
        for (String avain : jl.getJoukkoLista().keySet()) {
            if ((arvottuNro == i) 
               && (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara()
                    == 0)) {
                
                boolean jatkuu = kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }
                // tämä logiikka perustuu siihen, että oikeiden vastausten 
                // lukumäärä on aina vain 0 tai 1 -- KORJATTAVA !!!
                if (jl.getJoukkoListasta(avain).
                        getOikeidenVastaustenLukumaara() > 0) {
                    jl.setKyseltaviaSanojaJaljella(
                        jl.getKyseltaviaSanojaJaljella() - 1);
                }
// TESTIÄ
                System.out.println("Kyseltäviä sanoja jäljellä: " + 
                        jl.getKyseltaviaSanojaJaljella());
                
                if (jl.getKyseltaviaSanojaJaljella() <= 0) {
                    System.out.println("Kaikkiin kysymyksiin saatu oikea vastaus");
                    return false; 
                }            
            }    
            i++;    
        }
        return true;
    }

    public boolean kyseleJaTarkastaVastaus(String avain, Sanajoukko sj) {
        kysy(avain); 
        String ehdotus = ehdotettuVastaus();
        if (!(ehdotus.equals(""))) {
            if (sj.vastausOnJoukossa(ehdotus)) {
                System.out.println("Oikein");
                sj.setOikeidenVastaustenLukumaara(
                    sj.getOikeidenVastaustenLukumaara() + 1);
            } else {
                System.out.println("Väärin");
                System.out.println("Oikeat vastaukset ovat: " + sj);
                sj.setVaarienVastaustenLukumaara(
                    sj.getVaarienVastaustenLukumaara() + 1);
// ========== MIETI TÄTÄ ================
//                sj.setOikeidenVastaustenLukumaara(0);
// ======================================               
            }
// TESTIÄ
            System.out.println("Tämän sanajoukon oikeiden vastausten lukumäärä: " + sj.getOikeidenVastaustenLukumaara());
            System.out.println("Tämän sanajoukon väärien vastausten lukumäärä:  " + sj.getVaarienVastaustenLukumaara());

            return true;
        }
        return false;
    }
    
    public void kysy(String avain) {
        System.out.print(avain + " ?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

}