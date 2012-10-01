/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author hztuomis
 *
 */
//import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;

public class Toistoharjoittelua {

    /**
     * Pääohjelma:
     *      - syötteen lukeminen
     *      - kysymys ja vastaus -listan tulostaminen
     *      - kysely ja vastausten tarkastaminen
     * 
     * @param args the command line arguments, ei käytetä tässä ohjelmassa
     *
     */ 
    
    public static void main(String[] args) {
        Sanajoukkolista jl = new Sanajoukkolista();
        Ohjaus oh = new Ohjaus(jl);
        
        // syöte luetaan joko tiedostosta tai näppäimistöltä
        jl = oh.syotteenLukeminen();
        
        if (oh.syoteEiOleTyhja(jl)) {
            // tulostetaan listan sisältö
            oh.kaynnista_tulostaSanajoukkoLista(jl);
        
            // kyselyvaiheen toimintaohje
            oh.kaynnista_ohje_kyseleJaTarkastaSanajoukkoLista(); 
            // kyseleminen, tarkastaminen ja tilastointi
            while (oh.kyseleJaTarkastaSanajoukkoLista(jl)) {} // end while
        }
    }
}
