package model;

import java.util.List;

public class Player {

    private List<Card> handCards;
    private Account accountInfo;
    
    private static int count = 1;
    private int playerId;
    
    public Player(Account accountInfo, List<Card> handCards) {
        this.accountInfo = accountInfo;
        this.handCards = handCards;
        
        this.playerId = count;
        count++;
    }
    
    public Player(List<Card> handCards) {
        this.handCards = handCards;
        
        this.playerId = count;
        count++;
    }
    
    public Player(Account accountInfo) {
        this.accountInfo = accountInfo;
        
        this.playerId = count;
        count++;
    }
    
    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }
    
    public void addHandCard(Card handCards) {
        this.handCards.add(handCards);
    }
    
    public void discard(Card card) {
        handCards.remove(card);
    }

    public Account getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Account accountInfo) {
        this.accountInfo = accountInfo;
    }
    
    public int getPlayerId() {
        return playerId;
    }
    
    @Override
    public String toString() {
        return accountInfo.toString()+" [handCards=" + handCards + "]";
    }
}
