package toistoharjoittelua;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import toistoharjoittelua.Sanapari;
import toistoharjoittelua.Sanaparilista;

/**
 *
 * @author hztuomis
 */
public class SanapariTest {
    
    Sanaparilista s;
    
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
    public void sanapariOnAlussaTyhja(){
        Sanapari s = new Sanapari("","");
        Assert.assertEquals("",s.getKysymys());
        Assert.assertEquals("",s.getVastaus());
    }
    
    @Test
    public void sanapariOnAlussaTyhjaBoolean(){
        Sanapari s = new Sanapari("","");
        Assert.assertEquals(true,s.kysymysTyhja());
        Assert.assertEquals(true,s.vastausTyhja());
    }
    
    @Test
    public void sanaParinAsetusKonstruktorillaOnnistuu(){
        Sanapari s = new Sanapari("hei","heihei");
        Assert.assertEquals("hei", s.getKysymys());
        Assert.assertEquals("heihei", s.getVastaus());        
    }
    
    @Test
    public void kysymysSananAsetusMetodillaOnnistuu(){
        Sanapari s = new Sanapari("","");
        s.setKysymys("hei");
        Assert.assertEquals("hei", s.getKysymys());
    }
    
    @Test
    public void vastausSananAsetusMetodillaOnnistuu(){
        Sanapari s = new Sanapari("","");
        s.setVastaus("heihei");        
        Assert.assertEquals("heihei", s.getVastaus());
    }
        
        
}
