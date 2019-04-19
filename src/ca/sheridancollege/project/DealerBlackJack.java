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
public class DealerBlackJack extends Player {

    private HandOfCards cards;

    public DealerBlackJack() {
        super("Dealer");
        cards = new HandOfCards(2);
    }

    public int calculateHand() {
        int total = 0;
        for (Card card : cards.showCards()) {
            total += card.getNumericValue();
        }
        return total;
    }

    public void dealCard(Card[] cardsArr) {
        for (Card card : cardsArr) {
            cards.addCard(card);
        }
    }
    
    public void clearHand() {
        cards.clearHand();
    }

    @Override
    public void play() {
        boolean playing = true;
        while (playing) {
            if (calculateHand() < 17) {
                System.out.println("Dealer hits on " + calculateHand());
                GameBlackJack.hitDealer(this, 1);
                System.out.println("Dealer has: " + calculateHand());
            } else if(calculateHand() >= 17) {
                System.out.println("Dealer stands on: " + calculateHand());
                return;
            }
        }
    }

}
