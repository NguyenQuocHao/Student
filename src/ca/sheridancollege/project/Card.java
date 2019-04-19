/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code
 * should remember to add themselves as a modifier.
 * @author dancye 2018, Brandon 2019
 */
public abstract class Card {
    
    private final Suit suit;
    private final Value value;
    
    public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS};
    public enum Value {ACE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Value getValue() {
        return value;
    }
    
    public int getNumericValue() {
        switch(getValue().toString()) {
            case "ACE":
                return 1;
            case "TWO":
                return 2;
            case "THREE":
                return 3;
            case "FOUR":
                return 4;
            case "FIVE":
                return 5;
            case "SIX":
                return 6;
            case "SEVEN":
                return 7;
            case "EIGHT":
                return 8;
            case "NINE":
                return 9;
            case "TEN":
                return 10;
            case "JACK":
                return 10;
            case "QUEEN":
                return 10;
            case "KING":
                return 10;
            default:
                return 0;
        }
    }
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    @Override
    public abstract String toString();
    
}