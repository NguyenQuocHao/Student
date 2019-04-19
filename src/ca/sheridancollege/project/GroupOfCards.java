/**
 * SYST 17796 Project Winter 2019 Base code. Students can modify and extend to
 * implement their game. Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int size;//the size of the grouping

    public GroupOfCards(int givenSize) {
        size = givenSize;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> showCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }

    public void readyAllCards() {
        System.out.println(cards.size());
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
//             CardBlackJack c = new CardBlackJack(CardBlackJack.SUIT[j],CardBlackJack.VALUE[i]);
//             cards.add(c);
             
             CardBlackJack c = new CardBlackJack(CardBlackJack.SUIT.values()[j],CardBlackJack.VALUE.values()[i]);
             cards.add(c);
            }
        }
        System.out.println(cards.size());
    }

    public String toString() {
        String all="";
        for (int i = 0; i < cards.size(); i++) {
            all=all+cards.get(i).toString() + "\n";
        }
        return all;
    }
}//end class
