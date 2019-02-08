/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;
import java.util.Scanner;
import java.awt.BorderLayout;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author 
 */
public class CardTrick {
    
    public static void main(String[] args)
    {   Scanner inp= new Scanner(System.in);
        Card[] magicHand = new Card[7];
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            
            c.setValue((int)(Math.random()*13+1));      //Creat random valiue
            c.setSuit(Card.SUITS[(int)(Math.random()*4)]);      //Creat random suit
            
            magicHand[i]=c;
        }
        
        
        System.out.println("Please pick a card");   //Prompt user
        System.out.println("Enter value from 1-13: ");
        int uValue=inp.nextInt();
        System.out.println("Enter suit, Hearts, Diamonds, Spades or Clubs: ");
        String uSuit=inp.next();

        
        Card userCard = new Card(); //Creat user Card
        userCard.setValue(uValue);
        userCard.setSuit(uSuit);
        
        
        for (int i=0; i<magicHand.length;i++){      //Search through magicHand array
            if (userCard.getValue()==magicHand[i].getValue() && userCard.getSuit().equals(magicHand[i].getSuit())){
                System.out.println("Your card matches with "+magicHand[i]);
                break;
            }
            else{
                System.out.println("Your card doesn't match with "+magicHand[i]);
            }
        }
        
    }

    
    
}