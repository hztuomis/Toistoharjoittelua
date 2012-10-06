/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;

/**
 * Luokka, joka toteuttaa Ohjaus-luokalta saamiaan tehtäviä ja
 * välittää niitä Käyttöliittymäluokalle. Näppäimistö-luokalle rinnakkainen
 * on Tiedosto-luokka.
 * 
 * @author hztuomis
 */
public class Nappaimisto {
    private Sanajoukkolista joukkoLista;
    private Kayttoliittyma kl = new Kayttoliittyma(joukkoLista); 
  
    public Nappaimisto(Sanajoukkolista joukkoLista){
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