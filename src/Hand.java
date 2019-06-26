import java.util.ArrayList;

public class Hand {
	
	private ArrayList<Card> deckOfCards = new ArrayList<Card>();
	
	public void addCard(Card card) {
		deckOfCards.add(card);
	}
	
	public ArrayList<Card> getDeckOfCards(){
		return this.deckOfCards;
	}
	
	public Boolean isEmpty() {
		return this.deckOfCards.isEmpty();
	}
	
	public int count() {
		return this.deckOfCards.size();
	}
	
	public void showHand() {
		for (Card c : deckOfCards) {
			System.out.println(c.flip());
		}
	}
}
