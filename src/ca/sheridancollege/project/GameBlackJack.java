/*
 * Group member: Hao, Bradon, Priya
 This class moderator: Hao
 */
package ca.sheridancollege.project;

import java.util.Scanner;
//import java.util.Random;

/**
 *
 * @author nguyen
 */
public class GameBlackJack extends Game {

    Scanner inp = new Scanner(System.in);
    String type;

    /**
     *
     * @param givenName
     */
    public GameBlackJack(String givenName) {
        super(givenName);
    }

    @Override
    public void declareWinner() {
        System.out.println("Winner");

    }

    @Override
    public void play() {
        System.out.println("Please enter dealer's name: ");
        type = inp.nextLine();
        DealerBlackJack dealer = new DealerBlackJack(type);
        getPlayers().add(dealer);

        for (int i = 1; i < 4; i++) {
            System.out.println("Please enter player" + i + "'s name: ");
            type = inp.nextLine();
            getPlayers().add(new PlayerBlackJack(type));
        }

        String cont = "y";
        while (cont.equals("y")) {
            System.out.println("Please enter the bet: ");
            double bet = inp.nextDouble();
            dealer.play();
            for (int i = 1; i < 4; i++) {
                getPlayers().get(i).play();
            }
            declareWinner();
            System.out.println("Do you want to replay? Type 'y' to run, type anthing else to quit.");
            inp.nextLine();
            cont = inp.nextLine();
  
        }
    }
}
