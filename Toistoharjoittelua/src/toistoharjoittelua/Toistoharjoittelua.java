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
        // TODO code application logic here
     
        Scanner lukija = new Scanner(System.in);
    
        Sanapari sanapari = new Sanapari();
        sanapari.annaSanapari();
    
        System.out.print("Anna vastaus: ");
        String vastaus = lukija.nextLine();

        if ( sanapari.vastausOikein(sanapari.getKysymys(),
            vastaus) ) {
            System.out.println("Oikein");
        } else {
            System.out.println("Väärin");
        }    
        /*
        System.out.println(" --> " + sanapari.getKysymys() + " - " + 
        *       sanapari.getVastaus());
        */    
        Sanaparilista sanaPariLista = new Sanaparilista();
        sanaPariLista.lueSanaparitListaan();
    }

}
