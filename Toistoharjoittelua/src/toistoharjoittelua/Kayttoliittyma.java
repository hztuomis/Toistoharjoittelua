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
    }    

    /**
    * kysellään ja tarkastetaan
    */
    
    public boolean kyseleJaTarkastaSanajoukkoLista(Sanajoukkolista jl) {
        boolean jatkuu = true;
        int lkm = jl.listanAlkioidenLkm();
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
            if (arvottuNro == i) {
                boolean jatkuu = kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
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
            } else {
                System.out.println("Väärin");
                System.out.println("Oikeat vastaukset ovat: " + sj);
            }
            return true;
        }
        return false;
    }
    
    public void kysy(String avain) {
        System.out.print(avain + "?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

}