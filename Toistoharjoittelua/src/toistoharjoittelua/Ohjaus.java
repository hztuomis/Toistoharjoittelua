/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;
/**
 * Ottaa ohjeet Toistoharjoittelua-pääohjelmalta ja välittää ne 
 *      Nappaimisto- ja Kayttoliittyma-luokille
 * @author Heikki Tuomisto
 */
public class Ohjaus {
    private Sanajoukkolista jl;
    Kayttoliittyma kl = new Kayttoliittyma(jl);
    Tiedosto ti = new Tiedosto();

    public Ohjaus(Sanajoukkolista jl) {
    }
    
    /**
     * Hakee syötteen joko tiedostosta tai näppäimistöltä
     * 
     * @return sanajoukkolista tai null
     */
    public Sanajoukkolista 
                syotteenLukeminenTiedostostaTaiNappaimistolta(){
        if (kl.syoteTiedostosta_EiNappaimistolta()) {
            jl = ti.lueJaKasitteleTiedostonRivit();
        } else {
            kl.ohje_lueSanaparitJoukkolistaan(); // toimintaohje
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
            kl.ohje_ilmoitaTyhjastaSyotteesta();
            return false;
        }
    }
    
    /**
     * käynnistetään sanakyselyn ohjeiden antaminen käyttöliittymässä
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
        sanapari = lueSanapariTrimmaten();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = lueSanapariTrimmaten();   
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
            montakoPerakkaistaOikeaaVastaustaVaaditaan();

        while (jatkuu) {
            jatkuu = kyseleJaTarkastaArvottuKysymys(jl, 
                jl.arvottuListanAlkionJarjestysnumero(lkm),
                perakkaisiaOikeitaVastauksiaVaaditaan);
        }

        // päättyneen kierroksen tilastointi
        listaaVirheidenMaaratKysymyskohtaisesti(jl);
        
        // laskurien nollaus
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
                
                boolean jatkuu = kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }

                paivitaJaljellaOlevienKyseltavienSanojenMaara(jl, avain,
                        perakkaisiaOikeitaVastauksiaVaaditaan);

                if (! onVielaKyseltaviaSanoja(jl,
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
    
     /**
     * Yksittäisen sanaparin lukeminen ja tulostaminen näkyviin
     * 
     * @return  luettu sanapari
     */
    public Sanapari lueSanapariTrimmaten () {    
        
        Scanner lukija = new Scanner(System.in);
        String vastine = "";
        kl.ohje_annaKysyttavaSana();
        String sana = kl.getSana(); 
        if (! sana.equals("")) {
            kl.ohje_annaVastine();
            vastine = kl.getSana();
        } else {
            vastine = "";
        }
      
        Sanapari sp = new Sanapari(sana, vastine);
        kl.naytaSanapari(sp);
        
        return sp; 
    }
    
    /**
     *  Kysytään käyttäjältä ohjaava parametriarvo, montako
     *  peräkkäistä oikeaa vastausta kysymykseen on saatava, ennen 
     *  kuin se katsotaan osatuksi. Luvut 1 - 3 kelpaavat.
     * 
     * @return   oikeiden vastausten määrä
     */   
    public int montakoPerakkaistaOikeaaVastaustaVaaditaan() {
        Scanner lukija = new Scanner(System.in);
        int maara = 0;
        while (true) {
            kl.ohje_montakoOikeaaVastausta();
            maara = kl.annaRajalukumaara();
            if ((maara >= 1) && (maara <= 3) ) return maara;
            kl.ohje_montakoOikeaaVastausta_VastausEiKelpaa();
        }       
    }     
    
    /**
     * Tulostetaan lista kysymyksistä, joihin on vastattu virheellisesti.
     * Listalla on myös virheiden lukumäärä. Listan järjestys on käänteinen, 
     * ts. eniten virheellisiä vastauksia saanut kysymys on listan
     * alussa.
     * @param  jl   käsiteltävä sanajoukkolista
     */
    public void listaaVirheidenMaaratKysymyskohtaisesti(
            Sanajoukkolista jl) {
        kl.otsikkoVirheellistenVastaustenLkm();
        for (int i = jl.korkeinVirhemaaraSanajoukkolistanAlkiolla();
                i > 0; --i) {
            for (String avain : jl.getJoukkoLista().keySet()) {
                if (jl.getJoukkoListasta(avain).
                        getVaarienVastaustenLukumaara() == i) {
                    kl.naytaVirheellistenVastaustenLkm(i,avain);
                }
            }
        }
    }
        
    /**
    * Raportoidaan, onko kyseltäviä sanoja vielä listassa ottaen huomioon,
    * montako perättäistä oikeaa vastausta vaaditaan
    * 
    * @param jl    käsiteltävä joukkolista
    * @param perakkaisiaOikeitaVastauksiaVaaditaan 
    *          peräkkäisten oikeiden vastausten vaadittu minimilukumäärä.
    *          huom. väärä vastaus nollaa oikeiden vastausten laskurin ja
    *          minimilukumäärää täytyy alkaa tavoitella alusta alkaen
    * @return true, jos vielä on kyseltäviä sanoja, false jos lista on tyhjä
    */      
    public boolean onVielaKyseltaviaSanoja(Sanajoukkolista jl,
             int perakkaisiaOikeitaVastauksiaVaaditaan) {
        kl.naytaKyseltaviaSanojaJaljella(
            jl.getKyseltaviaSanojaJaljella());
        if (jl.getKyseltaviaSanojaJaljella() <= 0) {
            kl.naytaEttaOikeatVastauksetSaatu(
                    perakkaisiaOikeitaVastauksiaVaaditaan);
            return false; 
        } else {
            return true;
        }
    }
    
    /**
    * Kysytään käyttäjältä sanan vastinetta ja tarkastetaan, 
    * menikö oikein
    * 
    * @param avain kysyttävä sana
    * @param sj    vastineiden joukko
    * 
    * @return  palautetaan tieto siitä, osuiko kohdalleen
    */
    public boolean kyseleJaTarkastaVastaus(String avain, Sanajoukko sj) {
        kl.kysy(avain); 
        String ehdotus = kl.ehdotettuVastaus();
        if (!(ehdotus.equals(""))) {
            if (sj.trimmattuVastausOnJoukossa(ehdotus)) {
                kl.ilmoitaOikeastaVastauksesta();
                sj.setOikeidenVastaustenLukumaara(
                    sj.getOikeidenVastaustenLukumaara() + 1);
            } else {
                kl.ilmoitaVaarastaVastauksesta(sj);
                sj.setVaarienVastaustenLukumaara(
                    sj.getVaarienVastaustenLukumaara() + 1);
//              === HUOM. KO. KYSYMYKSEN OIKEIDEN VASTAUSTEN KERÄILY 
//                          ALOITETAAM ALUSTA ELI LASKURI --> 0
                sj.setOikeidenVastaustenLukumaara(0);              
            }
            
            kl.ilmoitaOikeidenJaVaarienLukumaara(
                    sj.getOikeidenVastaustenLukumaara(),
                    sj.getVaarienVastaustenLukumaara());

            return true;
        }
        return false;
    }
 
}
