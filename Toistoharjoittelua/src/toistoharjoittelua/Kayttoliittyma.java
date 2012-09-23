/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.Scanner;

/**
 *
 * @author hztuomis
 */
public class Kayttoliittyma {
    private Sanajoukkolista joukkoLista;
  
    public Kayttoliittyma(Sanajoukkolista joukkoLista){

    }
    
    /**
    * - listan sanaparien lukeminen
    * - lopetetaan, jos vähintään toinen sana on tyhjä
    * - jos rivi on jo talletettu, sitä ei viedä uudestaan
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
     * tulostetaan lista
     */
    
    public void tulostaSanajoukkoLista(Sanajoukkolista jl) {
        System.out.println(jl);
        System.out.println("Kyseltäviä sanoja: " + jl.listanAlkioidenLkm());
    }    

    /**
    * kysellään ja tarkastetaan
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
//        return aloitatkoUudenKyselykierroksen();
//        return false; // tässä vaiheessa suoritetaan tämä metodi vain kerran
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
    
    public int montakoPerakkaistaOikeaaVastaustaVaaditaan() {
        Scanner lukija = new Scanner(System.in);
        int maara = 1;
        while (true) {
            System.out.print("Montako peräkkäistä oikeaa vastausta " +
                "vaaditaan (luvut 1-3 kelpaavat)?: ");
            maara = lukija.nextInt();
            // ---------------
            if ((maara >= 1) && (maara <= 3) ) return maara; // <<<<<POIS
            //
            System.out.println("Vastaus ei kelpaa, anna luku välillä 1-3");
        }       
    }     
    
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
    
    public boolean kyseleJaTarkastaArvottuKysymys(Sanajoukkolista jl,
            int arvottuNro, int perakkaisiaOikeitaVastauksiaVaaditaan) {
        int i = 0;
        for (String avain : jl.getJoukkoLista().keySet()) {
            if ( (arvottuNro == i) 
               && (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara()
                     <= (perakkaisiaOikeitaVastauksiaVaaditaan - 1)) ) {
                
                boolean jatkuu = kyseleJaTarkastaVastaus(avain,
                    jl.getJoukkoListasta(avain));
                if (!jatkuu) {
                    return false; // <<<<<<<<<<< poistutaan                        
                }
                // tämä logiikka perustuu siihen, että oikeiden vastausten 
                // lukumäärä on aina korkeintaan 
                // 'perakkaisiaOikeitaVastauksiaVaaditaan';
                // VÄÄRÄ VASTAUS NOLLAA OIKEIDEN VASTAUSTEN LASKURIN,
                // KS. METODI kyseleJaTarkastaVastaus!!!
                if (jl.getJoukkoListasta(avain).
                        getOikeidenVastaustenLukumaara() >= 
                        perakkaisiaOikeitaVastauksiaVaaditaan) {
                    jl.setKyseltaviaSanojaJaljella(
                        jl.getKyseltaviaSanojaJaljella() - 1);
                }
// TESTIÄ
                System.out.println("Kyseltäviä sanoja jäljellä: " + 
                        jl.getKyseltaviaSanojaJaljella());
                
                if (jl.getKyseltaviaSanojaJaljella() <= 0) {
                    System.out.println("Kaikkiin kysymyksiin on saatu "+
                            perakkaisiaOikeitaVastauksiaVaaditaan +
                            " peräkkäistä oikeata vastausta");
                    return false; 
                }            
            }    
            i++;    
        }
        return true;
    }
    
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
    
    public void kysy(String avain) {
        System.out.print(avain + " ?: ");
    }

    public String ehdotettuVastaus() {      
        Scanner lukija = new Scanner(System.in);
        return lukija.nextLine();
    }

}