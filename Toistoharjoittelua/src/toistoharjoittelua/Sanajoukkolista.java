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
    
//    private ArrayList<Sanapari> sanaParit = new ArrayList<Sanapari>();
//    private ArrayList<String> kysymykset = new ArrayList<String>();
//    ArrayList<String> vastine = new ArrayList<String>();
//    private ArrayList<String> sananKoiraParit = new ArrayList<String>();
    private HashMap<String,Sanajoukko> jl/*joukkoLista*/ = new HashMap();
    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
            new HashMap();
        
    
    public HashMap<String,Sanajoukko> GetJoukkoLista() {
        return jl;
    }
    
    public Sanajoukko GetJoukkoListasta(String avain) {
        return jl.get(avain);
    }
    
    public void LisaaSanajoukkoListaan (String kysymys, Sanajoukko joukko) {
        jl.put(kysymys, joukko);
    }
    
    public boolean kysymysOnListassa(String kysymys) {
        return ! jl.keySet().isEmpty();
    }
 

    public int SanaJoukonKoko (){
        return jl.size();
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
//            
//        }
//        
//        
//        int arvottu = Random.nextInt(0,sanat.getSize());
//        int indeksi = 0;  
//        for (String avain : sanat.keySet()) {
//            System.out.println(sanat.get(avain));
//            indeksi++;
//            if (indeksi == arvottu) kysy(avain);
//        }
//        
//    
   
    
    public String toString() {
        String tulos = "listauksen alku\n";
        for (String avain : jl.keySet()) {
            tulos = tulos + avain + "  " + jl.get(avain).getVastaukset().toString();
        }
        return tulos;
    }
 
}    