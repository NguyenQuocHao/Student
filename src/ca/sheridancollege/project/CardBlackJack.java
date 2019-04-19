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
public class CardBlackJack extends Card {

    public CardBlackJack(Suit suit, Value value) {
        super(suit, value);
    }

    /**
     * Get the value of a card
     * @return the string value of a card
     */
    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
    
    
}
