/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *Sanaparilistaa ei kai tarvita lainkaan Toistoharjoittelussa
 * 
 * 
 * @author hztuomis
 * 
 */
public class Sanaparilista {
   
    private ArrayList<Sanapari> sanaParit = new ArrayList<Sanapari>();
    private ArrayList<String> kysymykset = new ArrayList<String>();
    ArrayList<String> vastine = new ArrayList<String>();
//    private ArrayList<String> sananKoiraParit = new ArrayList<String>();
    private HashMap<String,ArrayList<String>> sanaJoukot = new HashMap();
    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
            new HashMap();
    
    public void LisaaPariJoukkoon (String kysymys, 
            String vastaus) {
        vastine.add(vastaus);
        sanaJoukot.put(kysymys, vastine);
        if (! kysymysOnListassa(kysymys)){
            kysymykset.add(kysymys);
        }
    }
    
    public boolean kysymysOnListassa(String kysymys) {
       return kysymykset.contains(kysymys);
    }
                
//        Sanapari sp = new Sanapari( kysymys, vastaus);
//        sanaParit.add(sp);     
 

    public int SanaJoukonKoko (){
        return kysymykset.size();
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
      //      indeksi++;
    //        if (indeksi == arvottu) kysy(avain);
//        }
//        
//    }}
   
    
    public String toString() {
        String tulos = "";
        for (int i = 0; i < kysymykset.size(); ++i) {
            String k = kysymykset.get(i);
            tulos = tulos + k + " --> " +
                (sanaJoukot.get(k) + " ") +
                "\n";
        }
        return tulos;
    }    

    public Sanapari AnnaSanapariListasta (int i) {
        return sanaParit.get(i);
    }
/* tässä virhe, poistettu esteettisistä syistä 
 * Sanaparilistaa ei kai tarvita lainkaan Toistoharjoittelussa
    public boolean onJoListassa(Sanapari syoteRivi) {
        for (int i = 0; i < sanaParit.size(); ++i) {
           if (sanaParit.get(i).vastausOikein(syoteRivi.getKysymys(), 
                   syoteRivi.getVastaus() )) {
               return true;
           } 
        } // for
        return false;
    }    
---------------*/
}
    