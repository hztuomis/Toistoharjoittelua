/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author Heikki Tuomisto
 */
import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class Tiedosto {
    private Scanner lukija = new Scanner(System.in);
    private Sanajoukkolista joukkoLista = new Sanajoukkolista();
    private Kayttoliittyma kl = new Kayttoliittyma(joukkoLista);
    
    Tiedosto() {        
    }
    
    /**
     * kysyy syöttötiedoston nimen ja tutkii, löytyykö tiedostoa
     * 
     * @return tiedostokahva
     * @throws FileNotFoundException tiedostoa ei löydy 
     */
//=====================================================
//============= käytä testisyötetiedostoa eka.txt  ====
//===================================================== 
    public File lueTiedostoJaEtsi() throws FileNotFoundException {
        kl.ohje_annaTiedostonNimi();  // anna: eka.txt
        String nykytiedosto =
//                "D:\\Omat Tiedostot\\GitHub\\Toistoharjoittelua\\" 
//                + "Toistoharjoittelua\\src\\toistoharjoittelua\\" 
                lukija.nextLine();                       
        File nykytiedostoKahva = new File (nykytiedosto);
        if (!nykytiedostoKahva.exists()) {
            kl.ohje_tiedostoaEiLoydy(nykytiedosto);
            return null;
        } else {
            kl.ohje_tiedostoLoytyi(nykytiedosto);
            return nykytiedostoKahva;
        }    
    }

    /**
     * käy läpi tiedoston rivit 
     * virhetilanne, jos tiedostoa ei saada avatuksi
     * 
     * @return palauttaa valmiiksi päivitetyn sanajoukkolistan 
     *  kutsuvalle ohjelmalle
     */
    public Sanajoukkolista lueJaKasitteleTiedostonRivit() {
        Sanajoukkolista joukkoLista = new Sanajoukkolista();

        File nykytiedostoKahva = null;
        try {
            nykytiedostoKahva = lueTiedostoJaEtsi();
        } catch (FileNotFoundException e) {
            kl.ohje_syottoTiedostoaEiVoituAvata();
            return null;
        }    

        if (nykytiedostoKahva != null) {
            try {
                Scanner syottotiedosto = new Scanner(nykytiedostoKahva);
                    
                while ( syottotiedosto.hasNextLine() ) {
                    String rivi = syottotiedosto.nextLine();
                    joukkoLista = 
                        lisaaTiedostonSanapariTrimmattunaSanajoukkoon(rivi);
                }    
                syottotiedosto.close();
                return joukkoLista;
                    
            } catch (FileNotFoundException e) {
                kl.ohje_syottoTiedostoaEiVoituAvata();
                return null;
            }    
        }
        return joukkoLista;
    }

    /**
     * Lisää tiedostosta luetun yksittäisen rivin tiedot 
     * sanajoukkolistaan
     * 
     * @param rivi tiedostosta luettu rivi
     * @return päivitetty sanajoukkolista
     */
    public Sanajoukkolista lisaaTiedostonSanapariTrimmattunaSanajoukkoon(
            String rivi) {     
        int pos = rivi.indexOf("/");
        if (pos < 0) return joukkoLista; // <<<<<<<< virhe, poistutaan!

        // HUOM. TRIM SEURAAVASSA
        String kysymys = rivi.substring(0, pos).trim();
        String vastaus = rivi.substring(pos + 1).trim();
        
        Sanapari sanapari = new Sanapari(kysymys, vastaus);
                    
        if ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(/*sanapari.getKysymys(), 
                    sanapari.getVastaus()*/ kysymys, vastaus);
        }
        return joukkoLista;   
    }
}
