package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Card.Color;
import model.Card.Value;

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
    
    public int getPlayerId() {
        return playerId;
    }
    
    @Override
    public String toString() {
        return accountInfo.toString()+" [handCards=" + handCards + "]";
    }

    public void chooseCard(List<Card> validCards, Card rejected) {
        List<Card> validByColor = validCards.stream()
                .filter(card -> card.getColor().equals(rejected.getColor()))
                .collect(Collectors.toList());
        System.out.println("- validByColor -");
        validByColor.forEach(System.out::println);
        
        List<Card> validByValue = validCards.stream()
                .filter(card -> card.getValue().equals(rejected.getValue()))
                .collect(Collectors.toList());
        System.out.println("- validByValue -");
        validByValue.forEach(System.out::println);
        
        List<Card> validWild = validCards.stream()
                .filter(card -> card.isWild())
                .collect(Collectors.toList());
        System.out.println("- validWild -");
        validWild.forEach(System.out::println);
    }
}
