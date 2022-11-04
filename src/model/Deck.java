package model;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Deck {

	private Stack<Card> deck;
	
	private Deck(Stack<Card> deck) {
		this.deck = initDeck();
	}
	
	private Stack<Card> initDeck() {
		Stack<Card> deckCards = new Stack<>();
		for (final Card.Color color : Card.Color.values()) {
			for (final Card.Value value : Card.Value.values()) {
				deck.push(Card.getCard(color, value));
			}
		}
		Collections.shuffle(deckCards);
		return deckCards;
	}
}
