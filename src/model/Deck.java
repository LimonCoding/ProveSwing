package model;

import java.util.Collections;
import java.util.Stack;

public class Deck {

	private final Stack<Card> deck;
	private static int numCards = 0;
	int cards = 0;
	
    private Deck() {
		this.deck = initDeck();
	}
	
	private Stack<Card> initDeck() {
		Stack<Card> deckCards = new Stack<>();
//		for (final Card.Color color : Card.Color.values()) {
//			for (final Card.Value value : Card.Value.values()) {
//			    deckCards.push(Card.getCard(color, value));
//			}
//		}
		
		Card.Color[] colors = Card.Color.values();
		Card.Value[] values = Card.Value.values();
		for (int i = 0; i < colors.length-1; i++) {
            
            Card.Color color = colors[i];
            Card.Value value = values[0];
            
            deckCards.push(new Card(color, value));
            
            for (int j = 1; j < 10; j++) {
                Card.Value oneToNine = values[j];
                deckCards.push(new Card(color, oneToNine));
                deckCards.push(new Card(color, oneToNine));
            }
            
            Card.Value[] special = new Card.Value[] { 
                    Card.Value.REVERSE, Card.Value.DRAW_TWO, Card.Value.SKIP 
            };
            for (Card.Value v : special) {
                deckCards.push(new Card(color, v));
                deckCards.push(new Card(color, v));
            }
        }
        
        values = new Card.Value[] { 
                Card.Value.WILD, Card.Value.WILD_FOUR
        };
        for (Card.Value v : values) {
            for (int i = 0; i < 4; i++) {
                deckCards.push(new Card(Card.Color.WILD, v));
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
