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
    private HashMap<String,Sanajoukko> joukkoLista = new HashMap();
    private HashMap<String,Integer> kuinkaMontaKertaaVastattuVaarin = 
            new HashMap();
        
    
    public HashMap<String,Sanajoukko> GetJoukkoLista() {
        return joukkoLista;
    }
    
    public void LisaaSanajoukkoListaan (String kysymys, 
            String vastaus) {
        if (kysymysOnListassa(kysymys)) {
            Sanajoukko sj = new Sanajoukko(kysymys);
            sj.lisaaVastausJoukkoon(kysymys, vastaus);
            this.joukkoLista.put(kysymys, sj);
        } else { 
/*            Sanajoukko sj = new Sanajoukko(kysymys, vastaus); */
            Sanajoukko sj = new Sanajoukko(kysymys);
            sj.lisaaVastausJoukkoon(kysymys, vastaus);
        }
    }
    
    public boolean kysymysOnListassa(String kysymys) {
        return ! joukkoLista.keySet().isEmpty();
    }

    /*
    public boolean kysymysOnListassa(String kysymys) {
            for (String avain : sanaJoukot.keySet()) {
                if (sanaJoukot.containsKey(kysymys)) {
                    return true;
                }
            }
            return false;
    }
*/
                
//        Sanapari sp = new Sanapari( kysymys, vastaus);
//        sanaParit.add(sp);     
 

    public int SanaJoukonKoko (){
        return joukkoLista.size();
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
        for (String avain : joukkoLista.keySet()) {
            tulos = joukkoLista.get(avain).getVastaus().toString();
        }
        return tulos;
    }
 
/*
    public Sanapari AnnaSanapariListasta (int i) {
        return sanaParit.get(i);
    }  
*/

}
    
