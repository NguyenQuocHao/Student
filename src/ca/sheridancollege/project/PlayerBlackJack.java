/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class PlayerBlackJack extends Player {

    private int wallet;
    private HandOfCards cards;
    private int bet = 0;

    public PlayerBlackJack(String name) {
        super(name);
        setPlayerID(name + Math.random());
        wallet = 100;
        cards = new HandOfCards(2);
    }

    public void dealCard(Card[] cardsArr) {
        for (Card card : cardsArr) {
            cards.addCard(card);
        }
    }

    public int getWalletBalance() {
        return wallet;
    }

    public void setWalletBalance(int newBalance) {
        wallet = newBalance;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int amount) {
        if (wallet >= amount) {
            System.out.println("Bet placed at: " + amount);
            wallet -= amount;
            bet = amount;
        } else {
            System.out.println("You do not have a high enough balance!");
        }
    }

    public int calculateHand() {
        int total = 0;
        for (Card card : cards.showCards()) {
            total += card.getNumericValue();
        }
        return total;
    }

    public void clearHand() {
        cards.clearHand();
    }

    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        boolean playing = true;
        int status = 0;
        while (playing != false) {
            switch (status) {
                case 0:
                    System.out.println("--------------------");
                    System.out.println("It's your turn!");
                    System.out.println("Your cards equal: " + calculateHand());
                    System.out.println("Your wallet balance is: " + wallet);
                    System.out.println("[1] Hit");
                    System.out.println("[2] Stand");
                    System.out.println("[3] Place Bet");
                    System.out.println("--------------------");
                    try {
                        status = in.nextInt();
                    } catch (Exception e) {
                        status = 0;
                    }
                    while (!(status > 0) && !(status <= 3)) {
                        System.out.println("Please enter a valid number!");
                        status = in.nextInt();
                    }
                    break;
                case 1:
                    System.out.println("You hit!");
                    GameBlackJack.hitPlayer(this, 1);
                    System.out.println("Your cards equal: " + calculateHand());
                    if (calculateHand() > 21) {
                        status = 2;
                    } else {
                        status = 0;
                    }
                    break;
                case 2:
                    System.out.println("You stand at " + calculateHand() + "!");
                    return;
                case 3:
                    System.out.println("How much would you like to bet?");
                    try {
                        int betAmount = in.nextInt();
                        setBet(betAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid bet amount!");
                    }
                    status = 0;
                    break;
                default:
                    System.out.println("An error occured!");
                    status = 0;
                    break;
            }
        }
    }

}
