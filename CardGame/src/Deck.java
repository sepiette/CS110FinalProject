
import java.util.Random;

public class Deck
{
	//Declare class fields
	private Card [] deck;
	private int usedCards;
	
	/**
	 * Default Constructor
	 */
	public Deck()
	{
		this(false);
	}
	/**
	 * determines whether a set of 52 or 54 cards depending on Jokers or not
	 * @param includeJokers
	 */
	public Deck(boolean includeJokers)
	{
		//Declare variables
		int cardCount = 0;	//keeps track of cards in stack
		
		if(includeJokers)
		{
			deck = new Card[54];
		}
		else
		{
			deck = new Card[52];
		}
		//loop through and add cards to list
		for (int suit = 0; suit <= 3; suit++)
		{
			for(int rank = 0; rank <= 13; rank++)
			{
				deck[cardCount] = new Card(suit, rank);
				cardCount++;
			}
		}
		//add the two jokers to the end of the deck
		if (includeJokers)
		{
			deck[52] = new Card(1,Card.JOKER);
			deck[53] = new Card(2,Card.JOKER);
		}
		usedCards = 0;
		
		shuffle();
	}
	
	/**
	 * cardsLeft method returns how many unused cards are left
	 * @return Int value of unused cards left
	 */
	public int cardsLeft()
	{
		return deck.length - usedCards;
	}
	
	/**
	 * dealCard method gives a card object
	 * @return Card 
	 */
	public Card dealCard()
	{
		if (usedCards == deck.length)
		{
			throw new ListIndexOutOfBoundsException("there are no cards left.");
		}
		else
		{
			usedCards++;
			return deck[usedCards-1];
		}
	}
	/**
	 * Shuffle randomizes cards in deck
	 * serially assigns each card in deck to temp card object
	 * takes randNum index position and replaces card at specified serial index i
	 * card object temp re-assigns former object at i to randNum position
	 */
	public void shuffle()
	{
		//Declare variables
		Random gen = new Random();
		int cardShuffle, randNum;
		
		//determine how many cards in deck to shuffle
		if (deck.length == 54)
		{
			cardShuffle = 54;
		}
		else
		{
			cardShuffle = 52;
		}
		
		//loop shuffles cards in deck
		for (int i = 0; i <= deck.length-1;i++)
		{
			randNum = gen.nextInt(cardShuffle);
			Card temp = deck[i];
			deck[i] = deck[randNum];
			deck[randNum] = temp;	
		}
		
		usedCards = 0;
	}
	/**
	 * hasJokers returns whether deck has Joker cards
	 * @return true if deck has Jokers
	 */
	public boolean hasJokers()
	{
		if (deck.length == 54)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}