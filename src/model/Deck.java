package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import model.Card.Color;
import model.Card.Value;

public class Deck extends Stack<Card> {

	private Stack<Card> deck;
	private static int numCards = 0;
	int cards = 0;
	
	private static final int numColors = Color.values().length-1;
	
    public Deck() {
		this.deck = initDeck();
	}
	
	private Stack<Card> initDeck() {
		Stack<Card> deckCards = new Stack<>();
		
		for (int color = 0; color < numColors; color++) {
            
            deckCards.push(new Card(Color.forValue(color), Value.forValue(0)));
            
            for (int oneToNine = 1; oneToNine <= 9; oneToNine++) {
                deckCards.push(new Card(Color.forValue(color), Value.forValue(oneToNine)));
                deckCards.push(new Card(Color.forValue(color), Value.forValue(oneToNine)));
            }
            
            for (int special = 10; special <= 12; special++) {
                deckCards.push(new Card(Color.forValue(color), Value.forValue(special)));
                deckCards.push(new Card(Color.forValue(color), Value.forValue(special)));
            }
        }
        
        for (int wildColor = 13; wildColor <= 14; wildColor++) {
            for (int wildValue = 0; wildValue < 4; wildValue++) {
                deckCards.push(new Card(Color.WILD, Value.forValue(wildColor)));
            }
        }
        Collections.shuffle(deckCards);
		return deckCards;
	}
	
	public void suffle() {
	    Collections.shuffle(deck);
	}
	
	public void replaceDeck(Stack<Card> deck) {
	    Collections.shuffle(deck);
	    this.deck = deck;
	}
	
	public Card getCard() {
	    return deck.pop();
	}
	
	public ArrayList<Card> getCards(int nCards) {
	    ArrayList<Card> cardsDrawed = new ArrayList<>(nCards);
        for (int i = 0; i < nCards; i++) {
            cardsDrawed.add(deck.pop());
        }
        return cardsDrawed;
    }
	
	@Override
    public String toString() {
	    String deckString = "";
	    numCards = 0;
	    for (Card card : deck) {
	        deckString += ++numCards + " " + card.toString() + "\n";
	    }
        return "Deck: \n" + deckString + "";
    }
	
}
