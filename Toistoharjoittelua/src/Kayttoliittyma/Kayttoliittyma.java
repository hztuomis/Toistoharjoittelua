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
 * Käyttöliittymätoiminnot:    
 * - tulostaminen standarditulostusvirtaan
 * - näppäimistöltä lukeminen
 *      Huom. tässä käytetään myös Sanapari- Sanajoukko- ja 
 *          Sanajoukkolista-tietorakenteita (kutakin kertaalleen) 
 *
 * @author hztuomis
 */
public class Kayttoliittyma {

    private Sanajoukkolista joukkoLista;

    public Kayttoliittyma(Sanajoukkolista joukkoLista) {
    }

    /**
     * Kysytään käyttäjältä, mistä syöte saadaan (tiedosto/näppäimistö)
     *
     * @return true=tiedosto, false=näppäimistö
     */
    public boolean syoteTiedostosta_EiNappaimistolta() {
        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.print("Syöte tiedostosta vai näppäimistöltä"
                    + " (t/n)?: ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("t")) {
                return true; // <<<<<<<< poistutaan
            }
            if (vastaus.equals("n")) {
                return false; // <<<<<<< poistutaan
            }
            System.out.println("Vastaus ei kelpaa, vastaa t tai n");
        }
    }

    /**
     * Opastetaan käyttäjää sanaparilistan manuaalisessa täyttämisessä
     */
    public void ohje_lueSanaparitJoukkolistaan() {
        System.out.println("Muodostetaan sanajoukkojen lista kyselemällä"
                + " sanapareja\n" + "Tyhjä arvo lopettaa");
    }

    /**
     * Kysyttävän sanan kyselyn kehote
     */
    public void ohje_annaKysyttavaSana() {
        System.out.print("Anna kysyttävä sana: ");
    }

    /**
     * Kehote vastauksen kysymiseksi
     */
    public void ohje_annaVastine() {
        System.out.print("Anna vastine: ");
    }

    /**
     * Sanan lukeminen näppäimistöltä
     *
     * @return luettu sana
     */
    public String getSana() {
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine().trim();
    }

    /**
     * Näytetään sanapari ***Sanapari***
     *
     * @param sp    käsiteltävä sanapari
     ***************************************
     * TÄSSÄ TARVITAAN Sanaparia 
     ***************************************
     */
    public void naytaSanapari(Sanapari sp) {
        System.out.println("Syötetty: " + sp);
    }

    /**
     *
     * Näytetään sanajoukkolistan sisältö ***Sanajoukkolista***
     *
     * @param jl        käsiteltävä sanajoukkolista
     *
     * ***********************************
     * TÄSSÄ TARVITAAN Sanajoukkolistaa !!!
     * ***********************************
     */
    public void tulostaSanajoukkoLista(Sanajoukkolista jl) {
        System.out.println("Listan sisältö");
        System.out.println(jl);
        System.out.println("Kyseltäviä sanoja: " + jl.listanAlkioidenLkm());
    }

    /**
     * Kehote vastaamaan kysymykseen, montako oikeaa vastausta vaaditaan 
     * ennen kuin kysymystä lakataan kysymästä
     */
    public void ohje_montakoOikeaaVastausta() {
        System.out.print("Montako peräkkäistä oikeaa vastausta "
                + "vaaditaan (luvut 1-3 kelpaavat)?: ");
    }

    /**
     * Montako oikeata vastausta vaaditaan?
     *
     * @return      vaadittava lukumäärä
     */
    public int annaRajalukumaara() {
        Scanner lukija = new Scanner(System.in);
        int maara = -1;
        try {
            maara = Integer.parseInt(lukija.nextLine());
        } catch (NumberFormatException e) {
            maara = -1; //dummy-arvo, joka jää kiinni alla testissä
        }
        return maara;
    }

    /**
     * Ilmoitus, että vastaus ei kelpaa
     */
    public void ohje_montakoOikeaaVastausta_VastausEiKelpaa() {
        System.out.println("Vastaus ei kelpaa, anna luku välillä 1-3");
    }

    /**
     * Opastetaan käyttäjää listan kysymyksiin vastaamisessa
     */
    public void ohje_kyseleJaTarkastaSanajoukkoLista() {
        System.out.println("Kysellään listan kysymyksiä \n"
                + "Tyhjä vastaus lopettaa");
    }

    /**
     * Virheellisten vastausten tilaston otsikko
     */
    public void otsikkoVirheellistenVastaustenLkm() {
        System.out.println("Virheellisten vastausten lkm/kysymys: ");
    }

    /**
     * Virheellisten vastausten tilaston rivi
     *
     * @param i         virheiden kappalemäärä
     * @param avain     kysymys, johon virheet liittyvät
     */
    public void naytaVirheellistenVastaustenLkm(int i, String avain) {
        System.out.println(i + "\t" + avain);
    }

    /**
     * Montako sanaa on vielä kyseltävänä?
     *
     * @param kpl       kyseltävien määrä
     */
    public void naytaKyseltaviaSanojaJaljella(int kpl) {
        System.out.println("Kyseltäviä sanoja jäljellä: " + kpl);
    }

    /**
     * Kerrotaan, että kaikkiin kysymksiin on vastattu
     *
     * @param perakkaisiaOikeitaVastauksiaVaaditaan     vähimmäisarvo
     */
    public void naytaEttaOikeatVastauksetSaatu(
            int perakkaisiaOikeitaVastauksiaVaaditaan) {
        System.out.println("Kaikkiin kysymyksiin on saatu "
                + perakkaisiaOikeitaVastauksiaVaaditaan
                + " peräkkäistä oikeata vastausta");
    }

    /**
     *
     * Kysytään, haluaako käyttäjä aloittaa uuden kyselykierroksen.
     *
     * @return      true, jos jatketaanko uudella kierroksella;
     *              muuten false
     */
    public boolean kysellaankoUusiKierros() {
        Scanner lukija = new Scanner(System.in);
        boolean uusiKierros = false;
        System.out.println("==================KIERROS PÄÄTTYI============="
                + "=====");
        System.out.println("============= JATKETAANKO? VASTAA k/e ========"
                + "=====");
        System.out.println("=============================================="
                + "=====");
        while (true) {
            System.out.print("Jatketaanko uudella kierroksella (k/e): ");
            String vastaus = lukija.nextLine();
            if (vastaus.equals("k")) {
                return true; // <<<<<<<<< poistutaan
            }
            if (vastaus.equals("e")/* || vastaus.isEmpty()*/) {
                return false; // <<<< poistutaan
            }
            System.out.println("Vastaus ei kelpaa, vastaa k tai e");
        }
    }

    /**
     * Ilmoitus oikeasta vastauksesta
     */
    public void ilmoitaOikeastaVastauksesta() {
        System.out.println("Oikein");
    }

    /**
     * Ilmoitus väärästä vastauksesta ***Sanajoukko***
     *
     * @param sj    käsiteltävä sanajoukko 
     ****************************************
     * HUOM. TÄSSÄ TARVITAAN Sanajoukkoa
     ****************************************
     */
    public void ilmoitaVaarastaVastauksesta(Sanajoukko sj) {
        System.out.println("Väärin");
        System.out.println("Oikeat vastaukset ovat: " + sj);
    }

    /**
     * Raportoidaan, montako oikeata ja väärää vastausta sanajoukkoon on
     * kirjattu
     *
     * @param oikeat    oikeiden vastausten lkm
     * @param vaarat    väärien vastausten lkm
     */
    public void ilmoitaOikeidenJaVaarienLukumaara(int oikeat, int vaarat) {
        System.out.println("Tämän sanajoukon oikeiden vastausten "
                + "lukumäärä: " + oikeat);
        System.out.println("Tämän sanajoukon väärien vastausten "
                + "lukumäärä:  " + vaarat);
    }

    /**
     * Esitetään käyttäjälle kysymys (sana) vastattavaksi
     *
     * @param avain     kysyttävä sana
     */
    public void kysy(String avain) {
        System.out.print(avain + " ?: ");
    }

    /**
     * Käyttäjän antaman vastauksen lukeminen
     *
     * @return          palauttaa käyttäjän antaman vastauksen
     */
    public String ehdotettuVastaus() {
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

//******************************************************************    
//  Tästä eteen päin tiedostokäsittelyn metodit    
//******************************************************************    
    /**
     * Pyydetään käyttäjää antamaan tiedoston nimi
     */
    public void ohje_annaTiedostonNimi() {
        System.out.print("Anna tiedoston nimi: ");
    }

    /**
     * Lukee tiedoston nimen näppäimistöltä
     *
     * @return          tiedoston nimi
     */
    public String getNykyTiedosto() {
        Scanner lukija = new Scanner(System.in);
        String nykytiedosto =
                //                "D:\\Omat Tiedostot\\GitHub\\Toistoharjoittelua\\" 
                //                + "Toistoharjoittelua\\src\\toistoharjoittelua\\" 
                lukija.nextLine();
        return nykytiedosto;
    }

    /**
     * Ilmoitetaan, että tiedostoa ei ole olemassa
     *
     * @param nykytiedosto      tiedosto, jota yritetään löytää
     */
    public void ohje_tiedostoaEiLoydy(String nykytiedosto) {
        System.out.println("Tiedostoa " + nykytiedosto + " ei löydy");;
    }

    /**
     * Ilmoitetaan, että tiedosto on olemassa
     *
     * @param nykytiedosto      tiedosto, jota yritetään löytää
     */
    public void ohje_tiedostoLoytyi(String nykytiedosto) {
        System.out.println("Tiedosto " + nykytiedosto + " löytyi");
    }

    /**
     * Ilmoitetaan, että syöttötiedoston avaus ei onnistunut
     */
    public void ohje_syottotiedostoaEiVoituAvata() {
        System.out.println("Syöttötiedostoa ei voitu avata");
    }

    /**
     * Ilmoitetaan, että syötettä ei ole saatu tiedostosta tai 
     * näppäimistöltä
     */
    public void ohje_ilmoitaTyhjastaSyotteesta() {
        System.out.println("==============================================");
        System.out.println("== Ohjelmalla ei ole syötettä, keskeytetään ==");
        System.out.println("==============================================");
    }
}