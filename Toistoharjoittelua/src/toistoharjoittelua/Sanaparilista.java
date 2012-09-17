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
public class Sanaparilista {
   
    private ArrayList<Sanapari> sanaParit = new ArrayList<Sanapari>();
    private ArrayList<String> sananKoiraParit = new ArrayList<String>();
    private HashMap<String,ArrayList<String>> sanat = new HashMap();
    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
            new HashMap();
    
    public void LisaaPariListaan (String kysymys, 
            String vastaus) {
        Sanapari sp = new Sanapari( kysymys, vastaus);
        sanaParit.add(sp);     
    }

    public int SanaPariListanKoko (){
        return sanaParit.size();
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
//        
//        for (String avain : sanat.keySet()) {
//            System.out.println(sanat.get(avain));
//        }
//        
//    }}
   
    
    public void tulostaSanapariLista() {
        for (int i = 0; i < sanaParit.size(); ++i) {
            System.out.println(sanaParit.get(i));
        }
    }    

    public Sanapari AnnaSanapariListasta (int i) {
        return sanaParit.get(i);
    }
    
    public boolean onJoListassa(Sanapari syoteRivi) {
        for (int i = 0; i < sanaParit.size(); ++i) {
           if (sanaParit.get(i).vastausOikein(syoteRivi.getKysymys(), 
                   syoteRivi.getVastaus() )) {
               return true;
           } 
        } // for
        return false;
    }    

}
    