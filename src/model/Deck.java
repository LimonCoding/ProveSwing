package model;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private Stack<Card> deck;
	private static int numCards = 0;
	
    private Deck() {
		this.deck = initDeck();
	}
	
	private Stack<Card> initDeck() {
		Stack<Card> deckCards = new Stack<>();
		for (final Card.Color color : Card.Color.values()) {
			for (final Card.Value value : Card.Value.values()) {
			    deckCards.push(Card.getCard(color, value));
			}
		}
//		Collections.shuffle(deckCards);
		return deckCards;
	}
	
	@Override
    public String toString() {
	    String deckString = "";
	    for (Card card : deck) {
	        deckString += ++numCards + " " + card.toString() + "\n";
	    }
        return "Deck: \n" + deckString + "";
    }
	
	public static void main(String[] args) {
	    final Deck deck = new Deck();
	    System.out.println(deck.toString());
    }
}
