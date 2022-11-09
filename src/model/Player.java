package model;

import java.util.List;

public class Player {

    private List<Card> handCards;
    private Account accountInfo;
    
    public Player(Account accountInfo, List<Card> handCards) {
        this.accountInfo = accountInfo;
        this.handCards = handCards;
    }
    
    public Player(List<Card> handCards) {
        this.handCards = handCards;
    }
    
    public Player(Account accountInfo) {
        this.accountInfo = accountInfo;
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

    public Account getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Account accountInfo) {
        this.accountInfo = accountInfo;
    }
    
}
