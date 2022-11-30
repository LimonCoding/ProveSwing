package model;

import java.util.Stack;

public class Discarded extends Stack<Card> {

    private Stack<Card> discarded;
    
    public Discarded() {
        this.discarded = initDiscard();
    }
    
    private Stack<Card> initDiscard() {
        return new Stack<>();
    }
    
    public void setDiscard(Card discard) {
        discarded.push(discard);
        System.out.println("Discarded from model discard: "+discarded);
    }
    
    public Card getLastDiscard() {
        int index = (discarded.size()-1);
        return discarded.get(index);
    }
    
}
