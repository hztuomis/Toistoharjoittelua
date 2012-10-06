/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import Kayttoliittyma.Kayttoliittyma;
import toistoharjoittelua.Nappaimisto;
/**
 *
 * @author Heikki Tuomisto
 */
public class Ohjaus {
    private Sanajoukkolista jl;
    Nappaimisto na = new Nappaimisto(jl);
    Kayttoliittyma kl = new Kayttoliittyma(jl);
    Tiedosto ti = new Tiedosto();

    public Ohjaus(Sanajoukkolista jl) {
    }
    
    /**
     * Hakee syötteen joko tiedostosta tai näppäimistöltä
     * 
     * @return sanajoukkolista tai null
     */
    public Sanajoukkolista syotteenLukeminen() {
        if (kl.syoteTiedostosta_EiNappaimistolta()) {
            jl = ti.lueJaKasitteleTiedostonRivit();
        } else {
            kaynnista_ohje_lueSanaparitJoukkolistaan(); // toimintaohje
            // sanajoukkolistan kyseleminen
            jl = lueSanaparitJoukkolistaan();
        }
        return jl; // palauttaa null:in, jos syötettä ei saada
    }

    /**
     * Ilmoittaa, onko käsiteltävä sanalista tyhjä
     * 
     * @param jl tarkasteltava sanajoukkolista
     * @return true, jos listassa on alkioita, muuten false
     */
    public boolean syoteEiOleTyhja(Sanajoukkolista jl){
        if (jl.listanAlkioidenLkm() > 0){
            return true;
        } else {
            na.ohje_ilmoitaTyhjastaSyotteesta();
            return false;
        }
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
        sanapari = na.lueSanapariTrimmaten();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = na.lueSanapariTrimmaten();   
        }   
        return joukkoLista;
    }
    
    
    /**
     * Toteutetaan sanajoukkolistan sanojen kyselykierros. Otetaan  
     * huomioon käyttäjän antama tieto siitä, montako sanakohtaista oikeaa 
     * vastausta vaaditaan, jotta sana katsottaisiin osatuksi.
     * Käynnistetään myös virheiden tilastointi ennen uutta kyselykierrosta
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
            na.montakoPerakkaistaOikeaaVastaustaVaaditaan();

        while (jatkuu) {
            jatkuu = kyseleJaTarkastaArvottuKysymys(jl, 
                jl.arvottuListanAlkionJarjestysnumero(lkm),
                perakkaisiaOikeitaVastauksiaVaaditaan);
        }

        // päättyneen kierroksen tilastointi
        na.listaaVirheidenMaaratKysymyskohtaisesti(jl);
        
        // laskurien nollaus
        for (String avain : jl.getJoukkoLista().keySet()) {
            jl.getJoukkoListasta(avain).setOikeidenVastaustenLukumaara(0);
            jl.getJoukkoListasta(avain).setVaarienVastaustenLukumaara(0);
        } 
             
        return na.kysellaankoUusiKierros();
    }
   
    /**
     * Arvotun kysymyksen kyseleminen ja vastauksen tarkastaminen.
     * (Arpomista ei suoriteta tässä metodissa vaan arvottu järjestysnumero
     * tulee parametrina.)
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
                    // järjestysluku i on yhtä kuin parametrina annettu
                    // arvottu järjestysluku; huom. jos arvottu kysymys
                    // on jo "vastattu valmiiksi", sitä ei kysytä, vaan
                    // mennään arpomaan seuraava; TARKASTA TÄTÄ VIELÄ!!!
                    // arvonta ks. arvottuListanAlkionJarjestysnumero
                    // luokassa Sanajoukkolista    
        for (String avain : jl.getJoukkoLista().keySet()) {
            if ( (arvottuNro == i) && 
               (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara()
                     < perakkaisiaOikeitaVastauksiaVaaditaan) ) {
                
                boolean jatkuu = na.kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }

                paivitaJaljellaOlevienKyseltavienSanojenMaara(jl, avain,
                        perakkaisiaOikeitaVastauksiaVaaditaan);

                if (! na.onVielaKyseltaviaSanoja(jl,
                        perakkaisiaOikeitaVastauksiaVaaditaan)) {
                    return false;
                }    
            }  // end if "(arvottuNro == i) ..."  
            i++; // 
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
