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
public class GameBlackJackTest {
    GameBlackJack instance = new GameBlackJack("TEST");
    PlayerBlackJack player = PlayerBlackJackTest.player;
    public GameBlackJackTest() {
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


    
    //tes hitPlayerGood()
     @Test
    public void tesHitPlayerGood() {
        GameBlackJack.hitPlayer(player, 1);
       
    }
    @Test
    public void tesHitPlayerBad() {
        GameBlackJack.hitPlayer(player, 100);
       
    }
    @Test
    public void tesHitPlayerBoundary() {
        GameBlackJack.hitPlayer(player, 52);
       
    }
    
}
