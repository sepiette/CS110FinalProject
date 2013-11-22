
public class WarGame {

	//Declare variables
	private StackInterface userCards;
	private StackInterface compCards;
	private Deck cardDeck;
	private Object userCard, compCard;
	
	public WarGame()
	{
		userCards = new StackList();
		compCards = new StackList();
		cardDeck = new Deck();

	}
	
	
	//Divide deck between user and computer
	public void splitDeck()
	{
		
		while(cardDeck.cardsLeft() != 0)
		{
			userCards.push(cardDeck.dealCard());
			compCards.push(cardDeck.dealCard());
		}
	}
	
	//pop first card in each stack as flip of card
	public void flipCard()
	{
		if (!userCards.isEmpty() && !compCards.isEmpty())
		{
			userCard = userCards.pop();
			compCard = compCards.pop();
		}
		else if (userCards.isEmpty() && !compCards.isEmpty())
		{
			//put in winner method saying computer wins
		}
		else if(!userCards.isEmpty() && compCards.isEmpty())
		{
			//put in winner method saying user wins
		}
		else if(userCards.isEmpty() && compCards.isEmpty())
		{
			throw new StackException("the stack is empty");
		}
		
	}
	//
	public Object getUserCard()
	{
		return userCard;
	}
	public Object getcompCard()
	{
		return compCard;
	}
	
	public static void main(String [] args)
	{
		WarGame war = new WarGame();
		
		war.splitDeck();
		
		for (int i = 0; i< 26; i++)
		{
			war.flipCard();
			System.out.println(war.getUserCard().toString());
			//System.out.println(war.getcompCard().toString());
		}
	}
}