package model;

import java.util.ArrayList;
import java.util.List;

import model.Card.Color;
import model.Card.Value;

public class Player {

    private List<Card> handCards;
    private Account accountInfo;
    
    private static int count = 0;
    private int gameId;
    
    public Player(Account accountInfo, List<Card> handCards) {
        this.accountInfo = accountInfo;
        this.handCards = handCards;
        
        this.gameId = count;
        count++;
    }
    
    public Player(List<Card> handCards) {
        this.handCards = handCards;
        
        this.gameId = count;
        count++;
    }
    
    public Player(Account accountInfo) {
        this.accountInfo = accountInfo;
        
        this.gameId = count;
        count++;
    }
    
    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }
    
    public void addHandCard(Card handCard) {
        this.handCards.add(handCard);
    }
    
    //It can be sorted by color, value, if it's a wild card or a special one
    public List<Card> getValidMoves(Value validValue, Color validColor) {
        List<Card> validCards = new ArrayList<>();
        for(Card card : this.getHandCards()) {
            if(card.getValue().equals(validValue) || card.getColor().equals(validColor)
                                               || card.getColor().equals(Color.WILD)) {
                validCards.add(card);
            }
        }
        return validCards;
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
    
    public int getGameId() {
        return gameId;
    }
    
    @Override
    public String toString() {
        return "GameID: "+this.getGameId()+" "+accountInfo.toString()+" [handCards=" + handCards + "]";
    }

}
