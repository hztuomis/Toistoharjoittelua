/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hztuomis
 */
public class Sanajoukkolista {
    
    private HashMap<String,Sanajoukko> joukkoLista = new HashMap();
//    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
//            new HashMap();
        
    
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

        public String toString() { 
        String tulos = "";
        for (String avain : joukkoLista.keySet()) {
            tulos = tulos + avain + " --> " + 
                    joukkoLista.get(avain).toString() + "\n";
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
