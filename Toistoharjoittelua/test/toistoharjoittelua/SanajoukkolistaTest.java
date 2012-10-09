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
    public void JoukkolistaanLisattySamaKysymysUudestaan_1() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("a", "c");
        assertEquals(jl.listanAlkioidenLkm(),1);    
    }
    
    @Test
    public void JoukkolistaanLisattySamaKysymysUudestaan_2() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("a", "c");
        assertEquals("c", jl.getJoukkoListasta("a").getVastaus(1));    
    }
    
    @Test
    public void joukkolistanMaksimiVirhemaara() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.getJoukkoListasta("a").setVaarienVastaustenLukumaara(5);
        jl.lisaaSanapariJoukkolistaan("b", "c");
        jl.getJoukkoListasta("b").setVaarienVastaustenLukumaara(2);       
        assertEquals(5,jl.korkeinVirhemaaraSanajoukkolistanAlkiolla());   
    }

    @Test
    public void JoukkolistanToStringOikein_1() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("a", "c");
        assertEquals("a --> [b,c]",jl.toString());    
    }
    
    @Test
    // huom. seuraavassa HashMapin antama järjestys on käänteinen
    public void JoukkolistanToStringOikein_2() {
        Sanajoukkolista jl = new Sanajoukkolista();
        jl.lisaaSanapariJoukkolistaan("a", "b");
        jl.lisaaSanapariJoukkolistaan("a", "c");
        jl.lisaaSanapariJoukkolistaan("b", "d");        
        assertEquals("b --> [d]\na --> [b,c]",jl.toString());
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