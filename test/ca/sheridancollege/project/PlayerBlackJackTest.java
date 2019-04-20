/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nguyen
 */
public class PlayerBlackJackTest {
    static PlayerBlackJack player = new PlayerBlackJack("abc");

    
    public PlayerBlackJackTest() {
        
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

    /**
     * Test of dealCard method, of class PlayerBlackJack.
     */
    
    //Test setBest
    @Test
    public void testSetBetGood() {
        player.setBet(10);
    }
    @Test
    public void testSetBetBad() {
        player.setBet(-10);
    }
    @Test
    public void testSetBetBoundary() {
        player.setBet(10000);
    }

    
    //Test SetWallet
    @Test
    public void testSetWalletBalanceGood() {
        player.setWalletBalance(100);
    }
    @Test
    public void testSetWalletBalanceBad() {
        player.setWalletBalance(-100);
    }
    @Test
    public void testSetWalletBalanceBoundary() {
        player.setWalletBalance(1000);
    }
    
}
