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
        
        // seuraaviin trim???
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
//        System.out.println("Sana oli: " + sana);

        System.out.print("Anna vastine: ");
        String vastine = lukija.nextLine();
//        System.out.println("Vastine oli: " + vastine);
          
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
    
    public void kyseleJaTarkastaSanajoukkoLista(Sanajoukkolista jl) {
        for (String avain : jl.getJoukkoLista().keySet()) {
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