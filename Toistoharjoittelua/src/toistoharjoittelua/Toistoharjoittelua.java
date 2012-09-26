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
        
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja \n" + "Tyhjä arvo lopettaa");
        jl = kl.lueSanaparitJoukkolistaan();
        
        System.out.println("Listan sisältö");
        kl.tulostaSanajoukkoLista(jl);
        
        System.out.println("Kysellään listan kysymyksiä \n" +
                "Tyhjä vastaus lopettaa");
        while (kl.kyseleJaTarkastaSanajoukkoLista(jl)) {} // end while
    }
}
