import java.util.ArrayList;

public class WarGame {
   //declare static constants
   private static final int COMP_WIN = 0;
   private static final int USER_WIN = 1;
   private static final int WAR = -1;
	//Declare variables
	private ArrayList<Card> userCards;
	private ArrayList<Card> compCards;
	private ArrayList<Card> warCards;
	private Deck cardDeck;
	private Card userCard, compCard;
   private int winNum;
   private boolean gameOver;
	
   /**
	 * Default Constructor
	 */
	public WarGame()
	{
		userCards = new ArrayList<Card>();
		compCards = new ArrayList<Card>();
		warCards = new ArrayList<Card>();
		cardDeck = new Deck();
      gameOver = false;
		
		splitDeck();
	}
	
	/**
	 * SplitDeck method splits the card deck in half between two players
	 */
	public void splitDeck()
	{
		
		while(cardDeck.cardsLeft() != 0)
		{
			userCards.add(cardDeck.dealCard());
			compCards.add(cardDeck.dealCard());
		}
	}
	
	/**
	 * flipCard method removes a card from each player's list and assigns to card object
	 */
	public void flipCard()
	{
		if (!userCards.isEmpty() && !compCards.isEmpty())
		{
			userCard = userCards.remove((userCards.size())-1);
			compCard = compCards.remove((compCards.size())-1);
		}
		else if (userCards.isEmpty() && !compCards.isEmpty())
		{
			//Computer Wins
			winNum = COMP_WIN;
         gameOver = true;
		}
		else if(!userCards.isEmpty() && compCards.isEmpty())
		{
			//User Wins
			winNum = USER_WIN;
         gameOver = true;
		}
		else if(userCards.isEmpty() && compCards.isEmpty())
		{
			throw new ListIndexOutOfBoundsException ("the arraylist is empty");
		}
		
	}
	/**
	 * CompareCards method sees whether user or computer's deck has higher cards
	 * if user or computer runs out of cards, opposite automatically wins
	 * if users have equal cards, goes to a war
	 */
	public void compareCards()
	{
		//add cards to temporary array that will give all cards to winner
		warCards.add(userCard);
		warCards.add(compCard);
		
		//if cards are equal, a war ensues
		if (userCard.equals(compCard))
		{
         winNum = WAR;
			war();
		}
		//else if the user's card is greater than the computers
		//add all cards to user's card pile
		else if (userCard.greaterThan(compCard)==true)
		{
			winNum = USER_WIN;
			
			for(Card c: warCards)
			{
				userCards.add(0,c);
			}
			warCards.clear();
		}
		//else if the computer's card is greater than the user
		//add all cards to computer's card pile
		else 
		{
			winNum = COMP_WIN;
			
			for(Card c: warCards)
			{
				compCards.add(0,c);
			}
			warCards.clear();
		}
	}
	//War method
	public void war()
	{		
		warCards.add(userCards.remove((userCards.size())-1));
		warCards.add(compCards.remove((compCards.size())-1));	
	}

	
	
	/**
	 * getUserCard method returns card object from user's pile
	 * @return userCard object
	 */
	public Card getUserCard()
	{
		return userCard;
	}
	/**
	 * getCompCard method returns card object from computer's pile
	 * @return compCard object
	 */
	public Card getCompCard()
	{
		return compCard;
	}
	
	
	/**
	 * getUserNumCards method returns number of cards in user's pile
	 * @return Int number of cards left in user's deck
	 */
	public int getUserNumCards()
	{
		return userCards.size();
	}
	/**
	 * getCompNumCards method returns number of cards in computer's pile
	 * @return Int number of cards left in computer's deck
	 */
	public int getCompNumCards()
	{
		return compCards.size();
	}
	/**
	 * 
	 * @return Int size of warCards array for how many cards are wagered
	 */
	public int getWagerSize()
	{
		return warCards.size();
	}
	
   /**
    *getWinner() determines who won each round
    *@return boolean of who won round
   */  
	public int getRoundWinner()
   {
      return winNum;
   }
	
   /**
   *determines whether or not game over.
   */
	public boolean gameOver()
   {
      return gameOver;
   }   
	

}
