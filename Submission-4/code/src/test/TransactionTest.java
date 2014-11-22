package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import nirmaan.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sreejith
 */
public class TransactionTest {
    private static Transaction instance;
    public TransactionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	Transaction fund = new Transaction("treasurer", "Jus like that", -3000);
    	fund.modifyFunds();
    	instance = new Transaction("t1guy1", "Random things", 300);
    	instance.modifyFunds();
        
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of getuser method, of class Transaction.
     */
    @Test
    public void testGetuser() {
        System.out.println("getuser");
        
        String expResult = "t1guy1";
        String result = instance.getuser();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getreason method, of class Transaction.
     */
    @Test
    public void testGetreason() {
        System.out.println("getreason");
        
        String expResult = "Random things";
        String result = instance.getreason();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registertransaction method, of class Transaction.
     */
    @Test
    public void testRegistertransaction() {
        System.out.println("registertransaction");
       
         
         boolean expResult = true;
         boolean result = instance.registertransaction();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPending method, of class Transaction.
     */
    @Test
        public void testGetPending() {
        System.out.println("getPending");
        Transaction instance2 = new Transaction("t5guy5", "specific things", 300);
        Transaction instance3 = new Transaction("t6guy6", "rand things", 300);
        boolean result2=instance2.registertransaction();
        assertTrue(result2);
        result2=instance3.registertransaction();
        assertTrue(result2);
        
        
        ArrayList<Transaction> result = Transaction.getPending();
        boolean found1=false;
        boolean found2=false;
        for(Transaction tar : result)
        {   
            if(tar.getuser().equals(instance3.getuser()))
                found1=true;
            if(tar.getuser().equals(instance2.getuser()))
                found2=true;
        }
        assertEquals(found1&&found2,true); //If an error occurs here, change the path of .ser file in 
        								   //Transaction.java
        
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
