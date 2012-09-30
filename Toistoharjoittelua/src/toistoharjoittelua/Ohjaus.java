/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import Kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author Heikki Tuomisto
 */
public class Ohjaus {
    private Sanajoukkolista jl;
    Kayttoliittyma kl = new Kayttoliittyma(jl);

    public Ohjaus(Sanajoukkolista jl) {
    }
    
    /**
     * käynnistetään sanaparien syötön ohjeiden antaminen käyttöliittymässä
     */
    public void kaynnista_ohje_lueSanaparitJoukkolistaan(){
        kl.ohje_lueSanaparitJoukkolistaan();
    }
       
    /**
     * käynnistetään sanojen kyselyn ohjeiden antaminen käyttöliittymässä
     */
    public void kaynnista_ohje_kyseleJaTarkastaSanajoukkoLista(){
        kl.ohje_kyseleJaTarkastaSanajoukkoLista();
    } 
    
    /**
     * käynnistetään sanajoukon listaus käyttöliittymässä
     */
    public void kaynnista_tulostaSanajoukkoLista(Sanajoukkolista jl){
        kl.tulostaSanajoukkoLista(jl);
    }
        
    /**
    *   Ohjelmasilmukka sanajoukkolistan tietojen syöttämiseksi.
    *   Lopetetaan, jos annetaan tyhjä kysymys tai vastaus
    */    
    public Sanajoukkolista lueSanaparitJoukkolistaan () {
        Sanapari sanapari = new Sanapari();
        Sanajoukkolista joukkoLista = new Sanajoukkolista();
        sanapari = kl.lueSanapari();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = kl.lueSanapari();   
        }   
        return joukkoLista;
    }
        /**
     * 
     * Toteutetaan sanajoukkolistan sanojen kyselykierros. Otetaan  
     * huomioon käyttäjän antama tieto siitä, montako sanakohtaista oikeaa 
     * vastausta vaaditaan, jotta sana katsottaisiin osatuksi.
     * 
     * @param jl (Sanajoukkolista)
     * 
     * @return palauttaa tiedon, jatketaanko uudella kierroksella
     */    
    public boolean kyseleJaTarkastaSanajoukkoLista(Sanajoukkolista jl) {
        boolean jatkuu = true;
        int lkm = jl.listanAlkioidenLkm();
        
        jl.setKyseltaviaSanojaJaljella(lkm);
        int perakkaisiaOikeitaVastauksiaVaaditaan =
                kl.montakoPerakkaistaOikeaaVastaustaVaaditaan();

        while (jatkuu) {
            jatkuu = kyseleJaTarkastaArvottuKysymys(jl, 
                jl.arvottuListanAlkionJarjestysnumero(lkm),
                perakkaisiaOikeitaVastauksiaVaaditaan);
        }

        for (String avain : jl.getJoukkoLista().keySet()) {
            jl.getJoukkoListasta(avain).setOikeidenVastaustenLukumaara(0);
            jl.getJoukkoListasta(avain).setVaarienVastaustenLukumaara(0);
        }    
        return kl.kysellaankoUusiKierros();
    }
   
        
    /**
     * Arvotun kysymyksen kyseleminen ja vastauksen tarkastaminen.
     * (Arpomista ei suoriteta tässä metodissa vaan arvottu järjestysnumero
     * tulee parametrina.)
     * 
     *------------
     * TÄMÄ ALGORITMI TÄYTYY VIELÄ TARKISTAA: TEHDÄÄNKÖ TURHAA TYÖTÄ?
     * LISÄKSI TÄMÄ METODI ON AIVAN LIIAN PITKÄ
     * -----------
     * 
     * @param jl   käsiteltävä sanajoukkolista, josta kysymys valitaan
     * @param arvottuNro    kysymyksen järjestysnumero listassa    
     * @param perakkaisiaOikeitaVastauksiaVaaditaan montako peräkkäistä
     *          oikeaa vastausta täytyy saada ennen kuin kysymys katsotaan 
     *          osatuksi?
     * 
     * @return false, jos käsittely lopetetaan, muuten true
     */
    public boolean kyseleJaTarkastaArvottuKysymys(Sanajoukkolista jl,
            int arvottuNro, int perakkaisiaOikeitaVastauksiaVaaditaan) {
        int i = 0; // laskuri, joka kertoo, monennellako joukkolistan
                    // "rivillä" ollaan;
                    // joukkolistasta etsitään aina näin se alkio, jolla
                    // järjestysluku i = parametrina annettu
                    // arvottu järjestysluku, ks. alla   
        for (String avain : jl.getJoukkoLista().keySet()) {
            if ( (arvottuNro == i)  // huom. !!! ks. yllä
               && (jl.getJoukkoListasta(avain).
                                    getOikeidenVastaustenLukumaara()
                     < perakkaisiaOikeitaVastauksiaVaaditaan) ) {
                
                boolean jatkuu = kl.kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }

                paivitaJaljellaOlevienKyseltavienSanojenMaara(jl, avain,
                        perakkaisiaOikeitaVastauksiaVaaditaan);

                if (! kl.onVielaKyseltaviaSanoja(jl,
                        perakkaisiaOikeitaVastauksiaVaaditaan)) {
                    return false;
                }    
            }  // end if "(arvottuNro == i) ..."  
            i++; // onko seuraava "rivin" järjestysnumero = arvottu? 
        }
        return true;
    }

    /**
    * Päivittää vielä kyseltävien sanojen lukumäärän
    * 
    * Huom. oikeiden vastausten lukumäärä sanakohtaisesti on aina 
    *       korkeintaan 'perakkaisiaOikeitaVastauksiaVaaditaan'
    */ 
    public void paivitaJaljellaOlevienKyseltavienSanojenMaara(
        Sanajoukkolista jl, String avain, 
        int perakkaisiaOikeitaVastauksiaVaaditaan){
                
        if (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara() 
                       >= perakkaisiaOikeitaVastauksiaVaaditaan){                    
            jl.setKyseltaviaSanojaJaljella(
                    jl.getKyseltaviaSanojaJaljella() - 1);
        }
    }
    
}
