/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author hztuomis
 *
 * 
 * HUOM. ohjelma ei (toistaiseksi?) tue vastaussynonyymien käsittelyä. 
 *      VIRHE 1: Ei ole estetty syöttämästä seuraavankaltaisia pareja:
 *          1 -> 11
 *          1 -> 111
 *          ...
 *      VIRHE 2: Kysytään '1' kahteen kertaan. 
 *      VIRHE 3: Ensimmäisellä kerralla odotetaan vastausta '11',
 *      toisella '111'. Oikeaksi vastaukseksi pitäisi hyväksyä kumpi 
 *      tahansa arvo. Virhetilanteessa pitäisi näyttää kaikki oikeat 
 *      synonyymiset arvot.
 * HUOM. seuraava syöte ei aiheuta ongelmia, so. eri kysymyksillä voi olla 
 *      sama vastaus:
 *          1 -> 11
 *          2 -> 11
 *          ...
 */
import java.util.Scanner;




public class Toistoharjoittelua {

    /**
     * Tämä on pääohjelma
     * 
     * 
     * @param args the command line arguments
     */ 
    
    public static void main(String[] args) {
//        Sanaparilista sanaPariLista = new Sanaparilista();
     //   kayttoliittyma.kaynnista();
//        sanaPariLista.testaillaanHashMappia();
        Sanajoukkolista jl = new Sanajoukkolista();
        Kayttoliittyma kl = new Kayttoliittyma();
        
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja");
        jl = kl.lueSanajoukotListaan();
        
        System.out.println("Listan sisältö");
        kl.tulostaSanapariLista(jl);
        
        System.out.println("Kysellään listan kysymykset kertaalleen");
        kl.kyseleJaTarkastaSanapariLista(jl);
    }

}
