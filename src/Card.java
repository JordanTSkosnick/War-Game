//create a class for the cards in a deck
public class Card {
	private String suit;
	private int value;
	
	// create constructor for the card
	public Card (String suit, int value) {
		this.suit = suit;
		this.value = value;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	//flip the card over, revealing the card's attributes
	public String flip() {
		String result = "blank card";
		if (this.value == 11) {
			result = "JOKER of " + this.suit;
		}
		else if (this.value == 12) {
			result = "QUEEN of " + this.suit;
		}
		else if (this.value == 13) {
			result = "KING of " + this.suit;
		}
		else if (this.value == 14) {
			result = "ACE of " + this.suit;
		}
		else {
			result = this.value + " " + this.suit;
		}
		
		return result;
	}
}
