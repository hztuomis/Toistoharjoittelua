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

public class Tiedosto {
    private Scanner lukija = new Scanner(System.in);
    private Sanajoukkolista joukkolista = new Sanajoukkolista();
    private Kayttoliittyma kl = new Kayttoliittyma(joukkolista);
    
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
        
        String nykytiedosto = kl.getNykyTiedosto();           
        File nykytiedostokahva = new File (nykytiedosto);
        if (!nykytiedostokahva.exists()) {
            kl.ohje_tiedostoaEiLoydy(nykytiedosto);
            return null;
        } else {
            kl.ohje_tiedostoLoytyi(nykytiedosto);
            return nykytiedostokahva;
        }    
    }

    /**
     * käy läpi tiedoston rivit 
     * virhetilanne, jos tiedostoa ei saada avatuksi
     * 
     * @return palauttaa valmiiksi päivitetyn sanajoukkolistan 
     *  kutsuvalle ohjelmalle
     * 
     * ***************************************************************
     * HUOM. SYÖTE LUETAAN TIEDOSTOSTA, EI KAI KUULU KÄYTTÖLIITTYMÄÄN?
     * ***************************************************************
     */
    public Sanajoukkolista lueJaKasitteleTiedostonRivit() {
        Sanajoukkolista joukkolista = new Sanajoukkolista();

        File nykytiedostokahva = null;
        try {
            nykytiedostokahva = lueTiedostoJaEtsi();
        } catch (FileNotFoundException e) {
            kl.ohje_syottotiedostoaEiVoituAvata();
            return null;
        }    

        if (nykytiedostokahva != null) {
            try {
                Scanner syottotiedosto = new Scanner(nykytiedostokahva);
                    
                while ( syottotiedosto.hasNextLine() ) {
                    String rivi = syottotiedosto.nextLine();
                    joukkolista = 
                        lisaaTiedostonSanapariTrimmattunaSanajoukkoon(rivi);
                }    
                syottotiedosto.close();
                return joukkolista;
                    
            } catch (FileNotFoundException e) {
                kl.ohje_syottotiedostoaEiVoituAvata();
                return null;
            }    
        }
        return joukkolista;
    }

    /**
     * Lisää tiedostosta luetun yksittäisen rivin tiedot 
     * sanajoukkolistaan ***Sanapari***
     * 
     * @param rivi tiedostosta luettu rivi
     * @return päivitetty sanajoukkolista
     */
    public Sanajoukkolista lisaaTiedostonSanapariTrimmattunaSanajoukkoon(
            String rivi) {     
        int pos = rivi.indexOf("/"); // (ensimmäisen) kauttaviivan positio
        if (pos < 0) return joukkolista; // <<<<<<<< virhe, poistutaan!

        // HUOM. TRIM SEURAAVASSA
        String kysymys = rivi.substring(0, pos).trim();
        String vastaus = rivi.substring(pos + 1).trim();
        
        Sanapari sanapari = new Sanapari(kysymys, vastaus);
                    
        if ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkolista.lisaaSanapariJoukkolistaan(/*sanapari.getKysymys(), 
                    sanapari.getVastaus()*/ kysymys, vastaus);
        }
        return joukkolista;   
    }
}
