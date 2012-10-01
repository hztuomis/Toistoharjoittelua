/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author hztuomis
 * 
 * @ sisältää Sanajoukkojen listan, joka on toteutettu HashMap:ina sekä
 * tiedon listalla kyseltävissä olevien Sanajoukkojen lukumäärästä. Huom.
 * oikeat vastaukset vähentävät kyseltävänä olevien sanojen (Sanajoukkojen)
 * määrää
 */
public class Sanajoukkolista {
    
    private HashMap<String,Sanajoukko> joukkoLista = new HashMap();

    private int kyseltaviaSanojaJaljella = 0; // kertoo, montako sellaista
        // sanaa on listassa, joille ei ole vielä saatu oikeaa vastausta;
        // kun kaikille on saatu oikea vastaus, ohjelma päättyy (tai sitten
        // palautetaan kaikki sanat uudelleen kyseltäviksi tms.)
            
    public HashMap<String,Sanajoukko> getJoukkoLista() {
        return joukkoLista;
    }
    
    public Sanajoukko getJoukkoListasta(String avain) {
        return joukkoLista.get(avain);
    }
    /**
     * Lisätään sanapari (Sanapari-)joukkolistaan
     * 
     * @param kysymys  talletettava kysymys
     * @param vastaus  talletettava vastaus
     */    
    public void lisaaSanapariJoukkolistaan (String kysymys, 
            String vastaus) {
        Sanajoukko j = new Sanajoukko();
        if (joukkoLista.containsKey(kysymys)) {
            j = joukkoLista.get(kysymys);
        }
        j.lisaaVastausSanajoukkoon(vastaus);
        joukkoLista.put(kysymys,j);
    }    
    /**
     * Sanaparilistan alkioiden lkm
     * 
     * @return alkioiden lkm
     */    
        public int listanAlkioidenLkm(){
        int i = 0; 
        for (String avain : joukkoLista.keySet()) {
            i++;
        }
        return i;
    }

    /**
     * Arvotaan luku 0:n ja listan Sanajoukkojen lukumäärä-1:n välillä
     *
     * @param lukumaara listan alkioiden määrä
     * @return arvottu luku
     */    
    public int arvottuListanAlkionJarjestysnumero(int lukumaara){
        int r = new Random().nextInt(lukumaara);
        return r;
    }
      
    public int getKyseltaviaSanojaJaljella() {
        return kyseltaviaSanojaJaljella;
    }
    
    public void setKyseltaviaSanojaJaljella(int lkm) {
        kyseltaviaSanojaJaljella = lkm;
    }
   
     /**
     * laskee, mikä on sanajoukkolistan alkioiden virhemäärän maksimiarvo
     */
    public int korkeinVirhemaaraSanajoukkolistanAlkiolla() {
        int maksimi = 0;
        for (String avain : joukkoLista.keySet()) {
            if ( getJoukkoListasta(avain).getVaarienVastaustenLukumaara()
                   > maksimi ) {
                maksimi = getJoukkoListasta(avain).
                        getVaarienVastaustenLukumaara();
            }     
        }
        return maksimi; 
    }
   
    /**
     * Tässä on hiukan kikkailtu, jotta loppuun ei tulisi rivinvaihtoa
     * 
     * @return merkkiesitys sanajoukkolistan sisällöstä
     */
    public String toString() { 
        String tulos = "";
        int i = 0;
        for (String avain : joukkoLista.keySet()) {
            if (i == 0) {
                tulos = avain + " --> " + 
                    joukkoLista.get(avain).toString();
            }    
            if (i > 0) {
                tulos = tulos + "\n" + avain + " --> " + 
                    joukkoLista.get(avain).toString();
            }
            ++i;
        }
        return tulos;
    }
}
