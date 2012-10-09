/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toistoharjoittelua;

import junit.framework.Assert;
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
public class TiedostoTest {
    Tiedosto tiedosto;
    
    public TiedostoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tiedosto = new Tiedosto();
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
    public void lisaysTiedostoonToimii_1(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a / b  ");
        Assert.assertEquals(1,jl.listanAlkioidenLkm());
        Assert.assertEquals("b",jl.getJoukkoListasta("a").getVastaus(0));
    }
    
    @Test
    public void lisaysTiedostoonToimii_2(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a / b  ");
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a / c  ");
        Assert.assertEquals(1,jl.listanAlkioidenLkm());
        Assert.assertEquals("c",jl.getJoukkoListasta("a").getVastaus(1));
    }
    
    @Test
    public void lisaysTiedostoonToimii_3(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a /      b");
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a /c  ");
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "d/e");
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   e / f        ");
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "e/ g  ");
        Assert.assertEquals(3,jl.listanAlkioidenLkm());
        Assert.assertEquals("e",jl.getJoukkoListasta("d").getVastaus(0));
        Assert.assertEquals("f",jl.getJoukkoListasta("e").getVastaus(0));
        Assert.assertEquals("g",jl.getJoukkoListasta("e").getVastaus(1));
    }
    
    @Test
    public void lisaysTiedostoonEiLisää_1(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "   a / ");
        Assert.assertEquals(0,jl.listanAlkioidenLkm());
    }

    @Test
    public void lisaysTiedostoonEiLisää_2(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "  / a  ");
        Assert.assertEquals(0,jl.listanAlkioidenLkm());
    }

    @Test
    public void lisaysTiedostoonEiLisää_3(){  
        Sanajoukkolista jl = new Sanajoukkolista();
        jl = tiedosto.lisaaTiedostonSanapariTrimmattunaJoukkolistaan(
                "  a  ");
        Assert.assertEquals(0,jl.listanAlkioidenLkm());
    }
}
