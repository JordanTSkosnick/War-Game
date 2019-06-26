/**
 * Card game 'War' program
 * Created by: Jordan Skosnick
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static void main(String args[]) {
		
		String name1;
		String name2;
		Player player1;
		Player player2;
		Deck deck = new Deck();
		Card player1Card;
		Card player2Card;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What is Player 1's name?");
		name1 = scanner.nextLine();
		System.out.println("What is Player 2's name?");
		name2 = scanner.nextLine();
		
		player1 = new Player(name1);
		player2 = new Player(name2);
		
		//Shuffle the deal the deck to the players. Assumes Player2 = dealer
		deck.shuffle();
		player2.deal(deck, player1, player2);
		
		System.out.println("Press any button to play a round. Press 'q' to quit.");
		
		//while both players have at least 1 card left in their hand.
		while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
			if (scanner.nextLine().equals("q")) {
				System.out.println("Bye! Thanks for playing!");
				scanner.close();
				System.exit(0);
			}
			
			//Place a card on the table for battle.
			player1Card = player1.playCard();
			player2Card = player2.playCard();
			System.out.println(player1.getName() + "'s card: " + player1Card.flip());
			System.out.println(player2.getName() + "'s card: " + player2Card.flip());
						
			//compare the two cards against each other
			if(player1Card.getValue() > player2Card.getValue()) {
				player1.getHand().addCard(player1Card);
				player1.getHand().addCard(player2Card);
			}
			else if (player2Card.getValue() > player1Card.getValue()) {
				player2.getHand().addCard(player1Card);
				player2.getHand().addCard(player2Card);
			}
			else {
				war(scanner, player1, player2, player1Card, player2Card);
			}
			
			System.out.println("\n" + player1.getName() + "'s number of cards: " + player1.getHand().count());
			System.out.println(player2.getName() + "'s number of cards: " + player2.getHand().count());
			System.out.println("____________________________");
		}
		scanner.close();
		gameOver(player1, player2);
		
	}
	
	/**
	 * war - simulates the 'WAR' scenario in which identical cards were played. Each player places two cards down.
	 * The last card is the one that will be compared. Winner takes all.
	 * @param scanner - Scanner : retrieves input
	 * @param player1 - Player : Player 1
	 * @param player2 - Player : Player 2
	 * @param player1Card - Card : Player 1's 'battle' card
	 * @param player2Card - Card : Player 2's 'battle' card
	 */
	public static void war(Scanner scanner, Player player1, Player player2, Card player1Card, Card player2Card) {
		ArrayList<Card> player1PlayedCards = new ArrayList<Card>();
		ArrayList<Card> player2PlayedCards = new ArrayList<Card>();
		Boolean warOver = false; //checks if the war was won yet.
		
		System.out.println("\n~~~~~You have entered WAR!~~~~~\n");

		while (!warOver) {
			if (scanner.nextLine().equals("q")) {
				System.out.println("Bye! Thanks for playing!");
				System.exit(0);
			}
			
			//place Player 1's war cards down
			player1PlayedCards.add(0,player1Card);
			for (int p1 = 1; p1 < 3; p1++) {
				if(player1.getHand().isEmpty()) { //check if player has enough cards to continue WAR
					System.out.println(player1.getName() + " ran out of cards during war! Forfeit due to lack of resources!");
					gameOver(player1, player2);
				}
				else {
					System.out.println(player1.getName() + " placed a card facedown.");
					player1PlayedCards.add(0, player1.playCard());				}
			}
			
			//place Player 2's war cards down
			player2PlayedCards.add(0,player2Card);
			for (int p2 = 1; p2 < 3; p2++) {
				if(player2.getHand().isEmpty()) { //check if player has enough cards to continue WAR
					System.out.println(player2.getName() + " ran out of cards during war! Forfeit due to lack of resources!");
					gameOver(player1, player2);
				}
				else {
					System.out.println(player2.getName() + " placed a card facedown.");
					player2PlayedCards.add(0, player2.playCard());
				}
			}
			
			//This is added so there isn't just a big block of text when war is played.
			if (scanner.nextLine().equals("q")) {
				System.out.println("Bye! Thanks for playing!");
				System.exit(0);
			}
			
			System.out.println("The war cards are flipped...\n");
			System.out.println(player1.getName() + "'s WAR card: " + player1PlayedCards.get(0).flip());
			System.out.println(player2.getName() + "'s WAR card: " + player2PlayedCards.get(0).flip());
			
			//compare the cards to determine who gets them all
			if(player1PlayedCards.get(0).getValue() > player2PlayedCards.get(0).getValue()) {
				for(Card c : player1PlayedCards) {
					player1.getHand().addCard(c);
				}
				for(Card c : player2PlayedCards) {
					player1.getHand().addCard(c);
				}
				System.out.println("\n" + player1.getName() + " won this round of war!");
				warOver = true;
			}
			else if(player2PlayedCards.get(0).getValue() > player1PlayedCards.get(0).getValue()) {
				for(Card c : player1PlayedCards) {
					player2.getHand().addCard(c);
				}
				for(Card c : player2PlayedCards) {
					player2.getHand().addCard(c);
				}
				System.out.println("\n" + player2.getName() + " won this round of war!");
				warOver = true;
			}
		}
		
	}
	/**
	 * gameOver - determines which player has an empty hand then crowns the other as victorious
	 * @param player1 - Player : Player 1
	 * @param player2 - Player : Player 2
	 */
	public static void gameOver(Player player1, Player player2) {
		
		if(player1.getHand().isEmpty()) {
			System.out.println("Congrats " + player2.getName() + "! You win!");
		}
		else if(player2.getHand().isEmpty()) {
			System.out.println("Congrats " + player1.getName() + "! You win!");
		}
		else {
			System.out.println("No one won...");
		}
		System.exit(0);
	}
	
}
