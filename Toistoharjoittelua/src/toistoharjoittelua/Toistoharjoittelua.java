/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author hztuomis
 */
import java.util.Scanner;

public class Toistoharjoittelua {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sanaparilista sanaPariLista = new Sanaparilista();
        
        System.out.println("Kysellään listan sanaparit");
/*        System.out.println("Samaa ensimmäistä sanaa ei saa esiintyä.");*/
        /* myöhemmin muutetaan: samaa sanaparia ei saa esiintyä);*/
        sanaPariLista.lueSanaparitListaan();
        
        System.out.println("Listan sisältö");
        sanaPariLista.tulostaSanapariLista();
        
        System.out.println("Kysellään listan kysymykset kertaalleen");
        sanaPariLista.kyseleJaTarkastaSanapariLista();
    }

}
