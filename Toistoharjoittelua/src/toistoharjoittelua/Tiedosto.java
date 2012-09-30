/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

/**
 *
 * @author Heikki Tuomisto
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class Tiedosto {
    private Scanner lukija = new Scanner(System.in);
    private Sanajoukkolista joukkoLista = new Sanajoukkolista();
    
    Tiedosto() {        
    }
    
    /**
     * kysyy syöttötiedoston nimen ja tutkii, löytyykö tiedostoa
     * 
     * @return tiedostokahva
     * @throws FileNotFoundException tiedostoa ei löydy 
     */
//============================================
//============= testisyötetiedosto eka.txt
//============================================ 
    public File lue() throws FileNotFoundException {
        System.out.print("Anna tiedoston nimi: ");  // anna: eka.txt
        String nykytiedosto = 
                "D:\\Omat Tiedostot\\GitHub\\Toistoharjoittelua\\" 
                + "Toistoharjoittelua\\src\\toistoharjoittelua\\" 
                + lukija.nextLine();        
               
        File nykytiedostoKahva = new File (nykytiedosto);
        if (!nykytiedostoKahva.exists()) {
            System.out.println("Tiedostoa " + nykytiedosto + " ei löydy");
            return null;
        } else {
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
    public Sanajoukkolista lueTiedostonRivit() {
        Sanajoukkolista joukkoLista = new Sanajoukkolista();

        File nykytiedostoKahva = null;
        try {
            nykytiedostoKahva = lue();
        } catch (FileNotFoundException e) {
            System.out.println("Syöttötiedostoa ei voitu avata");
            return null;
        }    

        if (nykytiedostoKahva != null) {
            try {
                Scanner syottotiedosto = new Scanner(nykytiedostoKahva);
                    
                while ( syottotiedosto.hasNextLine() ) {
                    String r = syottotiedosto.nextLine();
                    // tallenna tai laita muistiin
//                    inTempFile.add(r);
                    joukkoLista = lisaaTiedostonSanapariSanajoukkoon(r);                }    
                syottotiedosto.close();
                return joukkoLista;
                    
            } catch (FileNotFoundException e) {
                System.out.println("Syöttötiedostoa ei voitu avata");
                return null;
            }    
        }
        return joukkoLista;
    }

    /**
     * Lisää tiedostosta luetun yksittäisen rivin tiedot sanajoukkolistaan
     * 
     * @param r tiedostosta luettu rivi
     * @return päivitetty sanajoukkolista
     */
    public Sanajoukkolista lisaaTiedostonSanapariSanajoukkoon(String r){     
        int pos = r.indexOf("/");
        if (pos < 0) return joukkoLista; // <<<<<<<< virhe, poistutaan!
        
        String kysymys = r.substring(0, pos);
        String vastaus = r.substring(pos + 1);
        
        Sanapari sanapari = new Sanapari(kysymys, vastaus);
                    
        if ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(), 
                    sanapari.getVastaus());
        }
        return joukkoLista;   
    }
}
