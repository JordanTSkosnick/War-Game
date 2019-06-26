
public class Player {
	private String name;
	private Hand hand;
	
	public Player (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	private void giveHand(Hand hand) {
		this.hand = hand;
	}
	
	public void deal (Deck deck, Player player1, Player player2) {
		Hand player1Hand = new Hand();
		Hand player2Hand = new Hand();
		
		while (!deck.isEmpty()) {
			player1Hand.addCard(deck.removeCard());
			player2Hand.addCard(deck.removeCard());
		}
		
		player1.giveHand(player1Hand);
		player2.giveHand(player2Hand);
	}
	
	public Card playCard() {
		Card playedCard = this.hand.getDeckOfCards().get(0);
		this.hand.getDeckOfCards().remove(0);
		return playedCard;
	}
}
