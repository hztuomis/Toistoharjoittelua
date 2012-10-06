/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import Kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;
import toistoharjoittelua.Sanapari;
import toistoharjoittelua.Sanajoukko;
import toistoharjoittelua.Sanajoukkolista;

/**
 *
 * @author hztuomis
 */
public class Nappaimisto {
    private Sanajoukkolista joukkoLista;
    private Kayttoliittyma kl = new Kayttoliittyma(joukkoLista); 
  
    public Nappaimisto(Sanajoukkolista joukkoLista){
    }

    /**
    * Opastetaan käyttäjää sanaparilistan manuaalisessa täyttämisessä
    *    
    public void ohje_lueSanaparitJoukkolistaan(){
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja\n" + "Tyhjä arvo lopettaa");
    }
    */
    
    /**
     * Yksittäisen sanaparin lukeminen ja tulostaminen näkyviin
     * 
     * @return  luettu sanapari
     */
    public Sanapari lueSanapariTrimmaten () {    
        
        Scanner lukija = new Scanner(System.in);
        String vastine = "";
        kl.ohje_annaKysyttavaSana();
//        System.out.print("Anna kysyttävä sana: ");
        String sana = kl.getSana(); // lukija.nextLine().trim();
        if (! sana.equals("")) {
            kl.ohje_annaVastine();
            //System.out.print("Anna vastine: ");
            vastine = kl.getSana(); //lukija.nextLine().trim();
        } else {
            vastine = "";
        }
      
        Sanapari sp = new Sanapari(sana, vastine);
        System.out.println("Syötetty: " + sp);
        
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
            try {
                maara = Integer.parseInt(lukija.nextLine());
            }
            catch (NumberFormatException e) {
                maara = -1; //dummy-arvo, joka jää kiinni alla testissä
            }
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
//        System.out.println("Virheellisten vastausten lkm/kysymys: ");
        kl.otsikkoVirheellistenVastaustenLkm();
        for (int i = jl.korkeinVirhemaaraSanajoukkolistanAlkiolla();
                i > 0; --i) {
            for (String avain : jl.getJoukkoLista().keySet()) {
                if (jl.getJoukkoListasta(avain).
                        getVaarienVastaustenLukumaara() == i) {
//                    System.out.println(i + "\t" + avain);
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
                System.out.println("Kyseltäviä sanoja jäljellä: " + 
                        jl.getKyseltaviaSanojaJaljella());
                
                if (jl.getKyseltaviaSanojaJaljella() <= 0) {
                    System.out.println("Kaikkiin kysymyksiin on saatu "+
                            perakkaisiaOikeitaVastauksiaVaaditaan +
                            " peräkkäistä oikeata vastausta");
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
        kysy(avain); 
        String ehdotus = ehdotettuVastaus();
        if (!(ehdotus.equals(""))) {
            if (sj.trimmattuVastausOnJoukossa(ehdotus)) {
                System.out.println("Oikein");
                sj.setOikeidenVastaustenLukumaara(
                    sj.getOikeidenVastaustenLukumaara() + 1);
            } else {
                System.out.println("Väärin");
                System.out.println("Oikeat vastaukset ovat: " + sj);
                sj.setVaarienVastaustenLukumaara(
                    sj.getVaarienVastaustenLukumaara() + 1);
//              === HUOM. KO. KYSYMYKSEN OIKEIDEN VASTAUSTEN KERÄILY 
//                          ALOITETAAM ALUSTA ELI LASKURI --> 0
                sj.setOikeidenVastaustenLukumaara(0);              
            }
            
            ilmoitaOikeidenJaVaarienLukumaara(sj);

            return true;
        }
        return false;
    }
    
    /**
    * raportoidaan, montako oikeata ja väärää vastausta sanajoukkoon on
    *  kirjattu
    * 
    * @param sj tarkasteltava sanajoukko
    */    
    public void ilmoitaOikeidenJaVaarienLukumaara(Sanajoukko sj){
        System.out.println("Tämän sanajoukon oikeiden vastausten "+
                "lukumäärä: " + sj.getOikeidenVastaustenLukumaara());
        System.out.println("Tämän sanajoukon väärien vastausten "+
                "lukumäärä:  " + sj.getVaarienVastaustenLukumaara());
    }

    /**
    * Esitetään käyttäjälle kysymys (sana) vastattavaksi
    * 
    * @param avain kysyttävä sana
    */
    public void kysy(String avain) {
        System.out.print(avain + " ?: ");
    }

    /**
    * Käyttäjän antaman vastauksen lukeminen
    * 
    * @return palauttaa käyttäjän antaman vastauksen
    */
    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

}