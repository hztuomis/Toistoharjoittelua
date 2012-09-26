/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import toistoharjoittelua.Sanajoukko;
import toistoharjoittelua.Sanajoukkolista;
import toistoharjoittelua.Sanapari;

/**
 *
 * @author hztuomis
 */
public class Kayttoliittyma {
    private Sanajoukkolista joukkoLista;
  
    public Kayttoliittyma(Sanajoukkolista joukkoLista){

    }
    
    /**
     *   Ohjelmasilmukka sanajoukkolistan päivittämiseksi.
     *   Lopetetaan, jos annetaan tyhjä kysymys tai vastaus
     *
     */    

    public Sanajoukkolista lueSanaparitJoukkolistaan () {
        Sanapari sanapari = new Sanapari();
        Sanajoukkolista joukkoLista = new Sanajoukkolista();
        sanapari = lueSanapari();
        while ((!sanapari.kysymysTyhja()) && (!sanapari.vastausTyhja())) {
            joukkoLista.lisaaSanapariJoukkolistaan(sanapari.getKysymys(),
                    sanapari.getVastaus());
            sanapari = lueSanapari();   
        }   
        return joukkoLista;
    }

    /**
     * 
     * Yksittäisen sanaparin lukeminen ja tulostaminen näkyviin
     * 
     * @return  luettu sanapari
     * 
     */
    public Sanapari lueSanapari () {    
        
        Scanner lukija = new Scanner(System.in);
        String vastine = "";
        // seuraaviin trim???
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine();
//        System.out.println("Sana oli: " + sana);
        if (! sana.equals("")) {
            System.out.print("Anna vastine: ");
            vastine = lukija.nextLine();
//            System.out.println("Vastine oli: " + vastine);
        } else {
            vastine = "";
        }
      
        Sanapari sp = new Sanapari(sana, vastine);
        System.out.println("Syötetty: " + sp);
                  
        return sp; 
    }
    
    /**
     * 
     * Näytetään sanajoukkolistan sisältö
     * 
     * @param  jl   käsiteltävä sanajoukkolista
     */
    
    public void tulostaSanajoukkoLista(Sanajoukkolista jl) {
        System.out.println(jl);
        System.out.println("Kyseltäviä sanoja: " + jl.listanAlkioidenLkm());
    }    

    /**
     * 
     * Toteutetaan sanajoukkolistan sanojen kyselykierros. Otetaan huomioon 
     * käyttäjän antama tieto siitä, montako sanakohtaista oikeaa 
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
                montakoPerakkaistaOikeaaVastaustaVaaditaan();

        while (jatkuu) {
            jatkuu = kyseleJaTarkastaArvottuKysymys(jl, 
                jl.arvottuListanAlkionJarjestysnumero(lkm),
                perakkaisiaOikeitaVastauksiaVaaditaan);
        }

        System.out.println("==================KIERROS PÄÄTTYI================"+
                "==");
        System.out.println("============= JATKETAANKO? VASTAA k/e ==========="+
                "==");
        System.out.println("================================================="+
                "==");
        for (String avain : jl.getJoukkoLista().keySet()) {
            jl.getJoukkoListasta(avain).setOikeidenVastaustenLukumaara(0);
            jl.getJoukkoListasta(avain).setVaarienVastaustenLukumaara(0);
        }    
        return kysellaankoUusiKierros();
    }
    
    /**
     *  Kysytään käyttäjältä ohjaava paramentriarvo, montako peräkkäistä
     *  oikeaa vastausta kysymykseen on saatava, ennen kuin se katsotaan 
     *  osatuksi. Luvut 1 - 3 kelpaavat.
     * 
     * @return   oikeiden vastausten määrä
     */
    
    public int montakoPerakkaistaOikeaaVastaustaVaaditaan() {
        Scanner lukija = new Scanner(System.in);
        int maara = 1;
        while (true) {
            System.out.print("Montako peräkkäistä oikeaa vastausta " +
                "vaaditaan (luvut 1-3 kelpaavat)?: ");
            maara = lukija.nextInt();
            if ((maara >= 1) && (maara <= 3) ) return maara;
            System.out.println("Vastaus ei kelpaa, anna luku välillä 1-3");
        }       
    }     
    
    /**
     * 
     * Kysytään, haluaako käyttäjä aloittaa uuden kyselykierroksen.
     * 
     * @return jatketaanko uudella kierroksella?
     */
    public boolean kysellaankoUusiKierros() {
        Scanner lukija = new Scanner(System.in);
        boolean uusiKierros = false;
        while (true) {
            System.out.print("Jatketaanko uudella kierroksella (k/e): ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("k")) return true; // <<<<<<<<<<< poistutaan
            if (vastaus.equals("e")) return false; // <<<<<<<<<<< poistutaan
            System.out.println("Vastaus ei kelpaa, vastaa k tai e");
        }       
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
     * @param perakkaisiaOikeitaVastauksiaVaaditaan montako peräkkäistä oikeaa
     *          vastausta täytyy saada ennen kuin kysymys katsotaan osatuksi?
     * 
     * @return false, jos käsittely lopetetaan, muuten true
     */
    public boolean kyseleJaTarkastaArvottuKysymys(Sanajoukkolista jl,
            int arvottuNro, int perakkaisiaOikeitaVastauksiaVaaditaan) {
        int i = 0; // laskuri, joka kertoo, kuinka monennella "rivillä" ollaan
        for (String avain : jl.getJoukkoLista().keySet()) {
            if ( (arvottuNro == i)  // huom. !!!
               && (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara()
                     <= (perakkaisiaOikeitaVastauksiaVaaditaan - 1)) ) {
                
                boolean jatkuu = kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }
                // oikeiden vastausten lukumäärä on aina korkeintaan 
                // 'perakkaisiaOikeitaVastauksiaVaaditaan';
                // VÄÄRÄ VASTAUS NOLLAA OIKEIDEN VASTAUSTEN LASKURIN,
                // ks. metodi kyseleJaTarkastaVastaus!!!
                if (jl.getJoukkoListasta(avain).
                        getOikeidenVastaustenLukumaara() >= 
                        perakkaisiaOikeitaVastauksiaVaaditaan) {
                    jl.setKyseltaviaSanojaJaljella(
                        jl.getKyseltaviaSanojaJaljella() - 1);
                }

                System.out.println("Kyseltäviä sanoja jäljellä: " + 
                        jl.getKyseltaviaSanojaJaljella());
                
                if (jl.getKyseltaviaSanojaJaljella() <= 0) {
                    System.out.println("Kaikkiin kysymyksiin on saatu "+
                            perakkaisiaOikeitaVastauksiaVaaditaan +
                            " peräkkäistä oikeata vastausta");
                    return false; 
                }            
            }  // end if "(arvottuNro == i) ..."  
            i++;    
        }
        return true;
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
            if (sj.vastausOnJoukossa(ehdotus)) {
                System.out.println("Oikein");
                sj.setOikeidenVastaustenLukumaara(
                    sj.getOikeidenVastaustenLukumaara() + 1);
            } else {
                System.out.println("Väärin");
                System.out.println("Oikeat vastaukset ovat: " + sj);
                sj.setVaarienVastaustenLukumaara(
                    sj.getVaarienVastaustenLukumaara() + 1);
// ========== HUOM. OIKEIDEN VASTAUSTEM KERÄILY ALOITETAAM ALUSTA ================
                sj.setOikeidenVastaustenLukumaara(0);
// ======================================               
            }
// TESTIÄ
            System.out.println("Tämän sanajoukon oikeiden vastausten "+
                    "lukumäärä: " + sj.getOikeidenVastaustenLukumaara());
            System.out.println("Tämän sanajoukon väärien vastausten "+
                    "lukumäärä:  " + sj.getVaarienVastaustenLukumaara());

            return true;
        }
        return false;
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