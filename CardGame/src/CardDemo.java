//Sara Piette
//CS 110: Horton
//Assignment 5: Card Class Demo
//Similar to War: creates card deck and randomly picks a card for user and computer
//whoever has higher card wins (**Aces count as ones**)


import java.util.Random;
import java.util.Scanner;

public class CardDemo
{
   public static void main(String [] args)
   {
      //declare variables
      Random randGenerator = new Random();   //generates random numbers
      Scanner input = new Scanner(System.in);   //reads for userChoice
      int compInt, userInt;      //holds random number that picks random card from the
      String userChoice;         //determines whether game continues
      Card userCard, compCard;   //holds object instance from deck to compare
      boolean userWins;          //determines whether user wins
      int cardCount = 0;         //keeps count of number of cards in deck so far
      
      //Array of card objects in a deck
      
      Card [] deck = new Card [52];
      
      //Create card deck
      for (int suit=0; suit<= 3; suit++)
      {
         for (int rank = 1; rank <= 13; rank++)
         {
            deck[cardCount] = new Card(suit, rank);
            cardCount++;
         }
      }
      
      //Ask user to pick a card
      System.out.print("Pick a card? (y/n): ");
      userChoice = input.nextLine();
      
      //validate input
      while (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n"))
      {
         System.out.print("Invalid.Pick a card? (y/n): ");
         userChoice = input.nextLine();
      }
      
      //Play Game
      while (userChoice.equalsIgnoreCase("y"))
      {
         //have cards randomly selected for user and computer
         compInt = randGenerator.nextInt(deck.length);
         userInt = randGenerator.nextInt(deck.length);
         
         //assign card instances to computer and user
         compCard = deck[compInt];
         userCard = deck[userInt];
         
         //determine whether the user's card is greater than the opponent's
         /*
            ***ACES COUNT AS ONES***
         */
         userWins = userCard.greaterThan(compCard);
         
         //Check to see if user or computer wins
         if (userWins == true)
         {
            System.out.println("You had a "+userCard);
            System.out.println("The computer had a "+compCard);
            System.out.println("YOU WIN!");
         }
         else if(userCard.equalsRank(compCard))
         {
            System.out.println("You had a "+userCard);
            System.out.println("The computer had a "+compCard);
            System.out.println("Tie.");
         }
         else if (userWins == false)
         {
            System.out.println("You had a "+userCard);
            System.out.println("The computer had a "+compCard);
            System.out.println("You Lose.");
         }
         
         
         System.out.print("\nPick another card? (y/n): ");
         userChoice = input.nextLine();
         //validate input
         while (!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n"))
         {
            System.out.print("Invalid.Pick a card? (y/n): ");
            userChoice = input.nextLine();
         }


      }
      
      //End game
      System.out.println("Goodbye!");
           
   }

}