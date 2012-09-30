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
        Sanajoukkolista jl = new Sanajoukkolista(); // huom. selvitä tämä!!!
        Kayttoliittyma kl = new Kayttoliittyma(jl);
        

        kl.ohje_LueSanaparitJoukkolistaan(); // toimintaohje
        // sanajoukkolistan kyseleminen
        jl = kl.lueSanaparitJoukkolistaan();
        
//        System.out.println("Listan sisältö");
        // tulostetaan listan sisältö
        kl.tulostaSanajoukkoLista(jl);
        
        kl.ohje_kyseleJaTarkastaSanajoukkoLista(); // toimintaohje
        // kyseleminen ja tarkastaminen
        while (kl.kyseleJaTarkastaSanajoukkoLista(jl)) {} // end while
    }
}
