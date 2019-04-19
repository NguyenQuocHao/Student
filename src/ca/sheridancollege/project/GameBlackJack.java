package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Brandon
 */
public class GameBlackJack extends Game {

    private static final DeckOfCards deck = new DeckOfCards();
    private final DealerBlackJack dealer = new DealerBlackJack();
    private boolean started = false;
    private PlayerBlackJack player;
    private Player lastWinner = null;

    /**
     * Black Jack Constructor
     *
     * @param name the name of the game
     */
    public GameBlackJack(String name) {
        super(name);
    }

    /**
     * Deal to a black jack player
     *
     * @param player a instance of a player
     * @param amount the amount of cards to deal
     */
    public static void hitPlayer(PlayerBlackJack player, int amount) {
        player.dealCard(deck.dealCard(amount));
    }

    /**
     * Deal to the dealer
     *
     * @param player a instance of a dealer
     * @param amount the amount of cards to deal
     */
    public static void hitDealer(DealerBlackJack player, int amount) {
        player.dealCard(deck.dealCard(amount));
    }
  

    /**
     * Plays the game through a loop
     */
    @Override
    public void play() {
        if (started != true) {
            System.out.println("Welcome to " + getGameName());
            System.out.println("What is your name?");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            player = new PlayerBlackJack(name);
            deck.generateDeck();
            started = true;
        }
        while (started == true) {
            player.dealCard(deck.dealCard(2));
            player.play();
            dealer.dealCard(deck.dealCard(2));
            dealer.play();
            declareWinner();
            payOut();
            started = nextRound();
        }
    }

      /**
     * Ask if there should be a next round
     *
     * @return the users response to the next round as true or false
     */
    public boolean nextRound() {
        Scanner in = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Would you like to play again?");
        System.out.println("[1] Yes");
        System.out.println("Enter any other value to quit!");
        dealer.clearHand();
        player.clearHand();
        String input = in.next();
        return input.equals("1");
    }
    
    /**
     * Pays out the players bets
     */
    public void payOut() {
        if (player.getBet() > 0) {
            if (lastWinner.equals(player)) {
                System.out.println("Your wallet: " + (player.getBet() * 2));
                player.setWalletBalance(player.getBet() * 2);
            } else {
                System.out.println("You lost the bet!");
            }
        } else {
            System.out.println("You didn't place a bet that time!");
        }
    }

    /**
     * Declares the winner of Black Jack
     */
    @Override
    public void declareWinner() {
        // find out who won
        if (player.calculateHand() > 21) {
            System.out.println("You exceeded 21!");
            System.out.println("You lost!");
            lastWinner = dealer;
        } else if (player.calculateHand() == dealer.calculateHand()) {
            System.out.println("It was a draw!");
            System.out.println("Nobody wins.");
            lastWinner = null;
        } else if (dealer.calculateHand() <= 21 && dealer.calculateHand() > player.calculateHand()) {
            System.out.println("The dealer had " + dealer.calculateHand());
            System.out.println("You had " + player.calculateHand());
            System.out.println("You lost!");
            lastWinner = dealer;
        } else {
            System.out.println("The dealer had " + dealer.calculateHand());          
            System.out.println("You had " + player.calculateHand());
            System.out.println("You won!");
            lastWinner = player;
        }
    }

}
