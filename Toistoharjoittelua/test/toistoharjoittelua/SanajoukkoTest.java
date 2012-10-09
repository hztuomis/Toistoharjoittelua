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
public class SanajoukkoTest {
    
    public SanajoukkoTest() {
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
    public void vastauksenTallennusJoukkoonOnnistuu(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("A");
        assertEquals(sj.getVastaus(0),"A");
        sj.lisaaVastausSanajoukkoon("B");
        assertEquals(sj.getVastaus(1),"B");
    }

    @Test
    public void alkioidenMaaraOikein(){
        Sanajoukko sj = new Sanajoukko();
        assertEquals(sj.vastaustenLukumaaraJoukossa(),0);
        sj.lisaaVastausSanajoukkoon("A");
        assertEquals(sj.vastaustenLukumaaraJoukossa(),1);
        sj.lisaaVastausSanajoukkoon("B");
        assertEquals(sj.vastaustenLukumaaraJoukossa(),2);
    }
    
    @Test
    public void tuplatalletusEiKasvataAlkioidenMaaraa(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("A");
        assertEquals(sj.vastaustenLukumaaraJoukossa(),1);
        sj.lisaaVastausSanajoukkoon("A");
        assertEquals(sj.vastaustenLukumaaraJoukossa(),1);
    }
    
    @Test
    public void talletettuAlkioOnJoukossa(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("A");
        sj.lisaaVastausSanajoukkoon("B");
        assertEquals(sj.trimmattuVastausOnJoukossa("    A"),true);
        assertEquals(sj.trimmattuVastausOnJoukossa(" B  "),true);
    }
    
    @Test
    public void tallettamatonSanaEiOleJoukossa(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("A");
        assertEquals(sj.trimmattuVastausOnJoukossa("B"),false);
    }
    
    @Test
    public void sanajoukonToStringOikein(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("A");
        sj.lisaaVastausSanajoukkoon("B");
        assertEquals("[A,B]",sj.toString());
    }
    
/**
 *  huom. tyhjän kysymyksen ja/tai vastauksen tallennusta ei käytännössä
 *  esiinny, sillä tyhjä on keskeytyksen merkki. Kuitenkin Sanajoukko 
 *  yleisenä rakenteena sallii tyhjät merkkijonot.
 */
    @Test
    public void tyhjanVastauksenTallennusJoukkoonOnnistuu(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("");
        assertEquals(sj.getVastaus(0),"");
    }

    @Test
    public void alkioidenMaaraOikeinKunOnSyotettyTyhjaSana(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("");
        assertEquals(sj.vastaustenLukumaaraJoukossa(),1);
    }
    
    @Test
    public void sanaEiOleTyhjassaJoukossa(){
        Sanajoukko sj = new Sanajoukko();
        assertEquals(sj.trimmattuVastausOnJoukossa("A"),false);
    }
    
    @Test
    public void tyhjaSanaEiOleTyhjassaJoukossa(){
        Sanajoukko sj = new Sanajoukko();
        assertEquals(sj.trimmattuVastausOnJoukossa(""),false);
    }
    
    @Test
    public void tyhjaSanaOnJoukossaJohonOnSyotettyTyhjaSana(){
        Sanajoukko sj = new Sanajoukko();
        sj.lisaaVastausSanajoukkoon("");
        assertEquals(sj.trimmattuVastausOnJoukossa("     "),true);
    }

}
