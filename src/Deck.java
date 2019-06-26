import java.util.ArrayList;
import java.util.Collections;
public class Deck {
	private String[] suits = new String[] {"Hearts", "Clubs", "Spades", "Diamonds"};
	private int[] values = new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14};

	private ArrayList<Card> deckOfCards = new ArrayList<Card>();

	public Deck() {
		for (String suit : suits) {
			for (int value : values) {
				Card card = new Card(suit, value);
				deckOfCards.add(card);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.deckOfCards);
	}
	
	public ArrayList<Card> getDeckOfCards(){
		return this.deckOfCards;
	}
	
	public Boolean isEmpty() {
		return this.deckOfCards.isEmpty();
	}
	
	public Card removeCard() {
		Card card;
		card = this.deckOfCards.get(0);
		this.deckOfCards.remove(0);
		return card;
	}
	
}
