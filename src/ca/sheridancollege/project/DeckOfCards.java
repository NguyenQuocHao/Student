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
public class DeckOfCards extends GroupOfCards {
    
    public DeckOfCards() {
        super(52);
    }
    
    /**
     * Generates a new card deck
     */
    public void generateDeck() {
        System.out.println("Generating a new deck!");
        for(CardBlackJack.Suit suit: CardBlackJack.Suit.values()) {
            for(CardBlackJack.Value value: CardBlackJack.Value.values()) {
                showCards().add(new CardBlackJack(suit, value));
            }
        }
        shuffle();
    }
    
    /**
     * Deals a card
     * @param amount the number of cards to deal 
     * @return the amount of cards requested from the deck
     */
    public Card[] dealCard(int amount) {
        Card[] deal = new Card[amount];
        // if the deck is empty or doesn't have enough showCards() to deal
        if(showCards().isEmpty() || !(showCards().size() - amount >= 0)) {
            generateDeck();
        } else {
            for(int i = 0; i < amount; i++) {
                deal[i] = showCards().get(0);
                showCards().remove(showCards().get(0));
            }
        }
        return deal;
    }
    
}
