package model;

import java.util.Stack;

public class Discard {

    private final Stack<Card> discard;
    private static int numCards = 0;
    int cards = 0;
    
    public Discard() {
        this.discard = initDiscard();
    }
    
    private Stack<Card> initDiscard() {
        return new Stack<>();
    }
    
    public void setDiscard(Card discard) {
        this.discard.push(discard);
    }
    
    public Card getLastDiscard() {
        int index = discard.size()-1;
        return discard.get(index);
    }
    
    @Override
    public String toString() {
        String discardString = "";
        for (Card card : discard) {
            discardString += (numCards++) + " " + card.toString() + "\n";
        }
        return "DISCARD: \n" + discardString + "";
    }
}
