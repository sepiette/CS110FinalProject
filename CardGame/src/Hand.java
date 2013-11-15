import java.util.ArrayList;

public class Hand {
	
	//Declare fields
	private int cardCount;
	private ArrayList<Card> hand;
	
	/**
	 * Constructor
	 */
	public Hand()
	{
		hand = new ArrayList<Card>();
		cardCount = 0;
	}
	
	/**
	 * Clear method discards all cards from hand
	 */
	public void clear()
	{
		hand.clear();
	}
	
	/**
	 * Add the card to the hand
	 * @throws exception if hand is full;
	 * @param Card to be added to hand
	 */
	public void addCard(Card c)
	{
		if (hand.size() >= 5)
		{
			throw new ListIndexOutOfBoundsException("Your hand is full.");
		}
		else
		{
			hand.add(c);
			cardCount++;
		}
	}
	/**
	 * Removes specific card c from hand if in hand.
	 * @param c
	 */
	public void removeCard(Card c)
	{
		if (hand.contains(c))
		{
			hand.remove(c);
		}
		else 
		{
			throw new IllegalArgumentException("The card is not in the hand.");
		}
	}
	
	/**
	 * removes card at specified index position in hand
	 * @param pos
	 */
	public void removeCard(int pos)
	{
		if (pos < 0 || pos >= hand.size())
		{
			throw new IllegalArgumentException("The position "+pos+" is out of bounds.");
		}
		else
		{
			hand.remove(pos);
		}
	}
	
	/**
	 * 
	 * @return integer value of cards in hand
	 */
	public int getCardCount()
	{
		return cardCount;
	}
	/**
	 * gets a card from the hand at specified index position 
	 * and returns card object
	 * @param pos
	 * @return Card at specified index position
	 */
	public Card getCard(int pos)
	{
		return hand.get(pos);
	}
	
	/**
	 * Sorts card in a hand of the same suit.
	 * Within a suit, cards sorted by rank
	 */
	public void sortBySuit()
	{
		//Declare Variables
		ArrayList<Card> sortedHand = new ArrayList<Card>();
		
		while(hand.size() >0)
		{
			int index = 0;
			Card start = hand.get(0);
			for (int i = 1; i < hand.size(); i++)
			{
				Card next = hand.get(i);
				if (next.getSuit() < start.getSuit() || 
						(next.getSuit() == start.getSuit() &&
						next.getRank() < start.getRank()))
				{
					index = i;
					start = next;
				}
			}
			hand.remove(index);
			sortedHand.add(start);
		}
		hand = sortedHand;
		
	}
	
	/**
	 * cards in hand sorted into order of increasing rank
	 * Ace is considered the lowest rank card
	 */
	public void sortByRank()
	{
		//Declare Variables
				ArrayList<Card> sortedHand = new ArrayList<Card>();
				
				while(hand.size() >0)
				{
					int index = 0;
					Card start = hand.get(0);
					for (int i = 1; i < hand.size(); i++)
					{
						Card next = hand.get(i);
						if (next.getRank() < start.getRank() || 
								(next.getRank() == start.getRank() &&
								next.getSuit() < start.getSuit()))
						{
							index = i;
							start = next;
						}
					}
					hand.remove(index);
					sortedHand.add(start);
				}
				hand = sortedHand;
				
	}
}