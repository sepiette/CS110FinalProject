//Sara Piette
//CS 110: Horton
//Assignment 5: Card Class

/**Class that creates card objects of a 52 playing card deck
   **methods return card suit and/or rank and allow for card object comparison   
*/

public class Card
{
   //Declare Constants
     public final static int CLUBS = 0;
     public final static int DIAMONDS = 1;
     public final static int HEARTS = 2;
     public final static int SPADES = 3;
     public final static int JOKER = 4;
      
     public final static int ACE = 1;
     public final static int KING = 13;
     public final static int QUEEN = 12;
     public final static int JACK = 11;

   //Declare Variables
   private final int suit;    //holds value of suit and does not change
   private final int rank;    //holds numerical value of card and does not change
   
   
   /**
      Constructor 
      default to joker if no parameters set
   */
   public Card()
   {
      suit = JOKER;
      rank = 0;
   }
   
   /**
      Constructor 
      @param int value of suit
      @param int value of rank
   */
   
   public Card (int theSuit, int theRank)
   {
      suit = theSuit;
      rank = theRank;
      
   }
   
   /**
      getSuit method
      @returns int value of suit
      
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
      getRank method
      @returns int value of rank
      
   */
   public int getRank()
   {
      return rank;
   }
   
   /**
      suitToString method
      @return string value of suit selected 
   */
   public String suitToString()
   {
      switch(suit)
      {
         case CLUBS:
         {
            return "Clubs";
            
         }
         case DIAMONDS:
         {
            return "Diamonds";
            
         }
         case HEARTS:
         {
            return "Hearts";
            
         }
         case SPADES:
         {
            return "Spades";
            
         }
         default:
         { 
            return "Joker";
            
         }
      }
   }
   
   /**
      rankToString method
      @return string of rank numerical value
   */
   public String rankToString()
   {
      if (suit == JOKER)
      {
         return "0";
      }
      else
      {
         switch(rank)
         {
            case 1: 
            {
               return "Ace"; 
            }
             case 2: 
            {
               return "2";
            }
             case 3: 
            {
               return "3";
            }
             case 4: 
            {
               return "4"; 
            }
             case 5: 
            {
               return "5"; 
            }
             case 6: 
            {
               return "6";  
            }
             case 7: 
            {
               return "7";
            }
             case 8: 
            {
               return "8";
            }
             case 9: 
            {
               return "9"; 
            }
             case 10: 
            {
               return "10";  
            }
             case 11: 
            {
               return "Jack";
            }
             case 12: 
            {
               return "Queen"; 
            }
             case 13: 
            {
               return "King"; 
            }
            default:
            {
               return "King";
            } 
         }
      }
   }
   
   /**
      toString method
      @return string of suit and rank
   */
   
   public String toString()
   {
      return rankToString()+ " of " +suitToString();
   }
  
   /**
      equalsRank method
      @return boolean of whether or not cards' ranks are equal
   */
   public boolean equalsRank(Card otherCard)
   {
      //Declare variables
      boolean status;
      
      if (rank == otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
      
      return status; 

   }
   
   /**
      greaterThan method
      @return boolean of whether or not card rank is greater than otherCard
   */
   public boolean greaterThan(Card otherCard)
   {
      //Declare variables
      boolean status;
      
      if (rank > otherCard.rank)
      {
         status = true;
      }
      else
      {
         status = false;
      }
      
      return status; 

   }

}