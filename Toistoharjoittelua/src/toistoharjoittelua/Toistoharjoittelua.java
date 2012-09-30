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
import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;

public class Toistoharjoittelua {

    /**
     * Tämä on pääohjelma
     * 
     * @param args the command line arguments
     *
     */ 
    
    public static void main(String[] args) {
        Sanajoukkolista jl = new Sanajoukkolista();
        Ohjaus oh = new Ohjaus(jl); // <<<<<        

        oh.kaynnista_ohje_lueSanaparitJoukkolistaan(); // toimintaohje
        // sanajoukkolistan kyseleminen
        jl = oh.lueSanaparitJoukkolistaan(); // <<<<<<<<<<
        
        // tulostetaan listan sisältö
        oh.kaynnista_tulostaSanajoukkoLista(jl);
        
        oh.kaynnista_ohje_kyseleJaTarkastaSanajoukkoLista(); // toimintaohje
        // kyseleminen ja tarkastaminen
        while (oh.kyseleJaTarkastaSanajoukkoLista(jl)) {} // end while
    }
}
