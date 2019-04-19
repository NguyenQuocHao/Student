/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author nguyen
 */
public class CardBlackJack extends Card {

    public static enum SUIT {HEARTS, CLUBS, SPADES, DIAMONDS};
    public static enum VALUE {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
    private SUIT suit;
    private VALUE value;

    public CardBlackJack(SUIT s, VALUE gVal) {
        suit = s;
        value = gVal;
    }
//    protected String v;
//    protected String s;
//
//    protected static final String[] SUIT = {"HEARTS", "CLUBS", "SPADES", "DIAMONDS"};
//    protected static final String[] VALUE = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
//
//    public CardBlackJack(String suit, String value) {
//        s = suit;
//        v = value;
//    }
    public VALUE getValue() {
        return this.value;
    }

    public SUIT getSuit() {
        return this.suit;
    }
//    public String getValue() {
//        return v;
//    }
//    public String getSuit() {
//        return s;
//    }

    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
