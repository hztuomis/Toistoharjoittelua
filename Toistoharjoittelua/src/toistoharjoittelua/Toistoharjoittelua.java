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
import java.util.Scanner;

/**
 * Ohjelma, jonka avulla voi opetella sanapareja, esim. vieraan kielen sanoja
 *
 * @author hztuomis
 */
public class Toistoharjoittelua {

    /**
     * Pääohjelma: - syötteen lukeminen - kysymys ja vastaus -listan
     * tulostaminen - kysely ja vastausten tarkastaminen, sisältää virheiden
     * raportoinnin kyselykierroksen lopuksi
     *
     * @param args the command line arguments, ei käytetä tässä ohjelmassa
     *
     */
    public static void main(String[] args) {
        Sanajoukkolista jl = new Sanajoukkolista();
        Ohjaus oh = new Ohjaus(jl);

        // syöte luetaan joko tiedostosta tai näppäimistöltä
        jl = oh.syotteenLukeminenTiedostostaTaiNappaimistolta();

        if (oh.syoteEiOleTyhja(jl)) {
            // tulostetaan listan sisältö
            oh.kaynnista_tulostaSanajoukkoLista(jl);

            // kyselyvaiheen toimintaohje
            oh.kaynnista_ohje_kyseleJaTarkastaSanajoukkoLista();
            // kyseleminen, tarkastaminen ja tilastointi
            while (oh.kyseleJaTarkastaSanajoukkoLista(jl)) {
            } // end while
        }
    }
}
