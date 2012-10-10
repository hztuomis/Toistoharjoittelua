/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hztuomis
 */
public class OhjausTest {
    
    public OhjausTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    Sanajoukkolista jl = new Sanajoukkolista(); 
    Ohjaus oh = new Ohjaus(jl); 
/**
 * ***********************
 *  vrt. seuraava testi  *
 * ***********************
 * @param jl
 * @param avain
 * @param perakkaisiaOikeitaVastauksiaVaaditaan 
 *
    public void paivitaJaljellaOlevienKyseltavienSanojenMaara(
        Sanajoukkolista jl, String avain, 
        int perakkaisiaOikeitaVastauksiaVaaditaan){
                
        if (jl.getJoukkoListasta(avain).getOikeidenVastaustenLukumaara() 
                       >= perakkaisiaOikeitaVastauksiaVaaditaan){                    
            jl.setKyseltaviaSanojaJaljella(
                    jl.getKyseltaviaSanojaJaljella() - 1);
        }
    }
 */  
    
    @Test
    public void KyseltaviaSanojaJaljellaAsetus(){
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.getJoukkoListasta("a").setOikeidenVastaustenLukumaara(1);
        jl.setKyseltaviaSanojaJaljella(1);
        oh.paivitaJaljellaOlevienKyseltavienSanojenMaara(jl,"a",1);
        assertEquals(jl.getKyseltaviaSanojaJaljella(),0);        
    }

}
