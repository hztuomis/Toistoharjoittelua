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
 */
public class Sanajoukkolista {
    
    private HashMap<String,Sanajoukko> joukkoLista = new HashMap();
//    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
//            new HashMap();
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
    
    public void lisaaSanapariJoukkolistaan (String kysymys, String vastaus) {
        Sanajoukko j = new Sanajoukko();
        if (joukkoLista.containsKey(kysymys)) {
            j = joukkoLista.get(kysymys);
        }
        j.lisaaVastausSanajoukkoon(vastaus);
        joukkoLista.put(kysymys,j);
    }    
    
    public int listanAlkioidenLkm(){
        int i = 0; 
        for (String avain : joukkoLista.keySet()) {
            i++;
        }
        return i;
    }
    
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
    
    public String toString() { 
        String tulos = "";
        for (String avain : joukkoLista.keySet()) {
            tulos = tulos + avain + " --> " + 
                    joukkoLista.get(avain).toString() + "\n"; // lopussa ei tarvittaisi rivinvaihtoa!!
        }
        return tulos;
    }
}

    
//    public void testaillaanHashMappia() {
//        sananKissaParit.add("cat");
//        sananKissaParit.add("a cat");
//        sananKoiraParit.add("dog");
//        sananKissaParit.add("katten");
//        sanat.put("kissa", sananKissaParit);
//        sanat.put("koira", sananKoiraParit);
//        kuinkaMontaKertaaVastattuVaarin.put("kissa", 5);
//        int vanhaLkm = kuinkaMontaKertaaVastattuVaarin.get("kissa");
//        kuinkaMontaKertaaVastattuVaarin.put("kissa", (vanhaLkm + 1));
//        
//        System.out.println("Sanaa kissa arvattu väärin: " +
//             kuinkaMontaKertaaVastattuVaarin.get("kissa"));
//        System.out.println("Sanaa koira arvattu väärin: " +
//             kuinkaMontaKertaaVastattuVaarin.get("koira"));
//        
//        for (int i = 0; i < 1000; i++) {
//            sananKissaParit = new ArrayList();    
//        }
//                
//        int arvottu = Random.nextInt(0,sanat.getSize());
//        int indeksi = 0;  
//        for (String avain : sanat.keySet()) {
//            System.out.println(sanat.get(avain));
//            indeksi++;
//            if (indeksi == arvottu) kysy(avain);
//        }
