/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import toistoharjoittelua.Sanapari;
import toistoharjoittelua.Sanajoukko;
import toistoharjoittelua.Sanajoukkolista;

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
    public void ohje_lueSanaparitJoukkolistaan(){
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja\n" + "Tyhjä arvo lopettaa");
    }
    */
    
    /**
     * Kysytään käyttäjältä, mistä syöte saadaan (tiedosto/näppäimistö)
     * 
     * @return true=tiedosto, false=näppäimistö 
     */
    public boolean syoteTiedostosta_EiNappaimistolta() {
        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.print("Syöte tiedostosta vai näppäimistöltä" +
                    " (t/n)?: ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("t")) return true; // <<<<<<<< poistutaan
            if (vastaus.equals("n")) return false; // <<<<<<< poistutaan
            System.out.println("Vastaus ei kelpaa, vastaa t tai n");
        }       
    }
    
    /**
    * Opastetaan käyttäjää sanaparilistan manuaalisessa täyttämisessä
    */    
    public void ohje_lueSanaparitJoukkolistaan(){
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä" +
                " sanapareja\n" + "Tyhjä arvo lopettaa");
    }
       
    /**
     * Yksittäisen sanaparin lukeminen ja tulostaminen näkyviin
     * 
     * @return  luettu sanapari
     *
    public Sanapari lueSanapariTrimmaten () {    
        
        Scanner lukija = new Scanner(System.in);
        String vastine = "";
        System.out.print("Anna kysyttävä sana: ");
        String sana = lukija.nextLine().trim();
        if (! sana.equals("")) {
            System.out.print("Anna vastine: ");
            vastine = lukija.nextLine().trim();
        } else {
            vastine = "";
        }
      
        Sanapari sp = new Sanapari(sana, vastine);
        System.out.println("Syötetty: " + sp);
                  
        return sp; 
    }
    */
    
        public void ohje_annaKysyttavaSana() {
            System.out.print("Anna kysyttävä sana: ");
        }    
            
        public void ohje_annaVastine() {
            System.out.print("Anna vastine: ");
        }
      
        public void naytaSyotettySanapari(Sanapari sp){
            System.out.println("Syötetty: " + sp);
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
     *  Kysytään käyttäjältä ohjaava parametriarvo, montako
     *  peräkkäistä oikeaa vastausta kysymykseen on saatava, ennen 
     *  kuin se katsotaan osatuksi. Luvut 1 - 3 kelpaavat.
     * 
     * @return   oikeiden vastausten määrä
    public int montakoPerakkaistaOikeaaVastaustaVaaditaan() {
        Scanner lukija = new Scanner(System.in);
        int maara = 1;
        while (true) {
            System.out.print("Montako peräkkäistä oikeaa vastausta " +
                "vaaditaan (luvut 1-3 kelpaavat)?: ");
            try {
                maara = Integer.parseInt(lukija.nextLine());
            }
            catch (NumberFormatException e) {
                maara = -1; //dummy-arvo, joka jää kiinni alla testissä
            }
            if ((maara >= 1) && (maara <= 3) ) return maara;
            System.out.println("Vastaus ei kelpaa, anna luku välillä 1-3");
        }       
    }
    */
    
    public void ohje_montakoOikeaaVastausta(){
        System.out.print("Montako peräkkäistä oikeaa vastausta " +
            "vaaditaan (luvut 1-3 kelpaavat)?: ");
    }    
    
    public void ohje_montakoOikeaaVastausta_VastausEiKelpaa() {
        System.out.println("Vastaus ei kelpaa, anna luku välillä 1-3");
    }    
  
    /**
    * opastetaan käyttäjää listan kysymyksiin vastaamisessa
    */       
    public void ohje_kyseleJaTarkastaSanajoukkoLista(){
        System.out.println("Kysellään listan kysymyksiä \n" +
                "Tyhjä vastaus lopettaa");
    }    

    /**
     * Tulostetaan lista kysymyksistä, joihin on vastattu virheellisesti.
     * Listalla on myös virheiden lukumäärä. Listan järjestys on käänteinen, 
     * ts. eniten virheellisiä vastauksia saanut kysymys on listan
     * alussa.
     * @param  jl   käsiteltävä sanajoukkolista
     *
    public void listaaVirheidenMaaratKysymyskohtaisesti(
            Sanajoukkolista jl) {
        System.out.println("Virheellisten vastausten lkm/kysymys: ");
        for (int i = jl.korkeinVirhemaaraSanajoukkolistanAlkiolla();
                i > 0; --i) {
            for (String avain : jl.getJoukkoLista().keySet()) {
                if (jl.getJoukkoListasta(avain).
                        getVaarienVastaustenLukumaara() == i) {
                    System.out.println(i + "\t" + avain);
                }
            }
        }
    }
    */
    
    public void otsikkoVirheellistenVastaustenLkm() {    
        System.out.println("Virheellisten vastausten lkm/kysymys: ");
    }
    
    public void naytaVirheellistenVastaustenLkm(int i, String avain) {
        System.out.println(i + "\t" + avain);
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
            if (vastaus.equals("k")) return true; // <<<<<<<<< poistutaan
            if (vastaus.equals("e")/* || vastaus.isEmpty()*/) 
                return false; // <<<< poistutaan
            System.out.println("Vastaus ei kelpaa, vastaa k tai e");
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

    
//******************************************************************    
//  Tästä eteen päin tiedostokäsittelyn metodit    
//******************************************************************    

 /**
 *  pyydetään käyttäjää antamaan tiedoston nimi
 */
    public void ohje_annaTiedostonNimi() {
        System.out.print("Anna tiedoston nimi: ");
    }

/**
 * ilmoitetaan, että tiedostoa ei ole olemassa
 * @param nykytiedosto tiedosto, jota yritetään löytää
 */    
    public void ohje_tiedostoaEiLoydy(String nykytiedosto) {
        System.out.println("Tiedostoa " + nykytiedosto + " ei löydy");;
    }

/**
 * ilmoitetaan, että tiedosto on olemassa
 * @param nykytiedosto tiedosto, jota yritetään löytää
 */    
    public void ohje_tiedostoLoytyi(String nykytiedosto) {
        System.out.println("Tiedosto " + nykytiedosto + " löytyi");
    }

    /**
     *  ilmoitetaan, että syöttötiedoston avaus ei onnistunut
     */
    public void ohje_syottotiedostoaEiVoituAvata() {
        System.out.println("Syöttötiedostoa ei voitu avata");
    }

    /**
     * ilmoitetaan, että syötettä ei ole saatu tiedostosta tai 
     *      näppäimistöltä
     */
    public void ohje_ilmoitaTyhjastaSyotteesta() {
        System.out.println("==============================================");
        System.out.println("== Ohjelmalla ei ole syötettä, keskeytetään ==");
        System.out.println("==============================================");
    }

/**
 * lukee tiedoston nimen näppäimistöltä
 * @return tiedoston nimi
 */
    public String getNykyTiedosto() { 
        Scanner lukija = new Scanner(System.in);
        String nykytiedosto = 
//                "D:\\Omat Tiedostot\\GitHub\\Toistoharjoittelua\\" 
//                + "Toistoharjoittelua\\src\\toistoharjoittelua\\" 
                lukija.nextLine();
        return nykytiedosto;
    }
    
}