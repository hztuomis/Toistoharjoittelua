/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import toistoharjoittelua.Sanapari;

/**
 *
 * @author hztuomis
 */
public class SanapariTest {
    Sanapari sp;
    
    public SanapariTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sp = new Sanapari();
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
    public void setteriJaGetteri() {
        String kysymys = "onko testit kivoja?";
        sp.setKysymys(kysymys);
        assertEquals(sp.getKysymys(),kysymys);
    }
}
