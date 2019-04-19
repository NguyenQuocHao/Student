/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.sheridancollege.project;

/**
 *
 * @author Brandon
 */
public class HandOfCards extends GroupOfCards {

    public HandOfCards(int givenSize) {
        super(givenSize);
    }
    
    public void addCard(Card card) {
        showCards().add(card);
    }
    
    public void clearHand() {
        showCards().clear();
    }
    
}
