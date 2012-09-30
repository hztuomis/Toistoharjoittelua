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
    * Opastetaan käyttäjää sanaparilistan manuaalisessa täyttämisessä
    */    
    public void ohje_lueSanaparitJoukkolistaan(){
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja\n" + "Tyhjä arvo lopettaa");
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
        System.out.println("Listan sisältö");
        System.out.println(jl);
        System.out.println("Kyseltäviä sanoja: " + jl.listanAlkioidenLkm());
    }    

    /**
     *  Kysytään käyttäjältä ohjaava paramentriarvo, montako
     *  peräkkäistä oikeaa vastausta kysymykseen on saatava, ennen 
     *  kuin se katsotaan osatuksi. Luvut 1 - 3 kelpaavat.
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
    * opastetaan käyttäjää listan kysymyksiin vastaamisessa
    */       
    public void ohje_kyseleJaTarkastaSanajoukkoLista(){
        System.out.println("Kysellään listan kysymyksiä \n" +
                "Tyhjä vastaus lopettaa");
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
        System.out.println("==================KIERROS PÄÄTTYI============="+
                "=====");
        System.out.println("============= JATKETAANKO? VASTAA k/e ========"+
                "=====");
        System.out.println("=============================================="+
                "=====");
        while (true) {
            System.out.print("Jatketaanko uudella kierroksella (k/e): ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("k")) return true; // <<<<<<<<<<< poistutaan
            if (vastaus.equals("e")) return false; // <<<<<<<<<<< poistutaan
            System.out.println("Vastaus ei kelpaa, vastaa k tai e");
        }       
    }     
    
    
    /**
    * Raportoidaan, oko kyseltäviä sanoja vielä listassa ottaen huomioon,
    * montako oikeaa perättäistä vastausta vaaditaan
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
            if (sj.vastausOnJoukossa(ehdotus)) {
                System.out.println("Oikein");
                sj.setOikeidenVastaustenLukumaara(
                    sj.getOikeidenVastaustenLukumaara() + 1);
            } else {
                System.out.println("Väärin");
                System.out.println("Oikeat vastaukset ovat: " + sj);
                sj.setVaarienVastaustenLukumaara(
                    sj.getVaarienVastaustenLukumaara() + 1);
//              === HUOM. KO. KYSYMYKSEN OIKEIDEN VASTAUSTEM KERÄILY 
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