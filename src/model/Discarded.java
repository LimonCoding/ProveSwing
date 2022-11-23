package model;

import java.util.Stack;

public class Discarded extends Stack<Card> {

    private final Stack<Card> discarded;
    private static int numCards = 0;
    int cards = 0;
    
    public Discarded() {
        this.discarded = initDiscard();
    }
    
    private Stack<Card> initDiscard() {
        return new Stack<>();
    }
    
    public void setDiscard(Card discard) {
        this.discarded.push(discard);
    }
    
    public Card getLastDiscard() {
        int index = discarded.size()-1;
        return discarded.get(index);
    }
    
    @Override
    public String toString() {
        String discardString = "";
        numCards = 0;
        for (Card card : discarded) {
            discardString += (numCards++) + " " + card.toString() + "\n";
        }
        return "DISCARD: \n" + discardString + "";
    }
}
