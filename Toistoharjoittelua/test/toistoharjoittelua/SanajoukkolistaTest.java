package toistoharjoittelua;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hztuomis
 */
public class SanajoukkolistaTest {
    
    public SanajoukkolistaTest() {
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
    
    @Test
    public void KyseltaviaSanojaJaljellaAsetus(){
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.setKyseltaviaSanojaJaljella(5);
        assertEquals(jl.getKyseltaviaSanojaJaljella(),5);
    }

    @Test
    public void ListanAlkioitaAluksiNolla(){
        Sanajoukkolista jl = new Sanajoukkolista();
        assertEquals(jl.listanAlkioidenLkm(),0);
    }
    
    @Test
    public void JoukkolistaanLisattySanapari() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.setKyseltaviaSanojaJaljella(1);
        assertEquals(jl.getKyseltaviaSanojaJaljella(),1);
        assertEquals(jl.listanAlkioidenLkm(),1);    
    }
    
    @Test
    public void JoukkolistaanLisattyEriSanapari() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("b", "c");
        assertEquals(jl.listanAlkioidenLkm(),2);    
    }
    
    @Test
    public void JoukkolistaanLisattySamaKysymysUudestaan() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("a", "c");
        assertEquals(jl.listanAlkioidenLkm(),1);    
    }
    
    @Test
    public void TarkastaEttaRandomLukuvaliEiYlity() {
        Sanajoukkolista jl = new Sanajoukkolista();
        int rmax = 0, rmin=999;
        for (int i = 0; i<1000; ++i) {
           int r = jl.arvottuListanAlkionJarjestysnumero(20);
           if (r < rmin) rmin = r;
           if (r > rmax) rmax = r;
        }
        assertEquals(rmin, 0);
        assertEquals(rmax, 19);
    }    
        
               
}    