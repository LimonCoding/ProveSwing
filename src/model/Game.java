package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    
    public enum GameDirection {
        CLOCKWISE(true), COUNTERCLOCKWISE(false);
        
        private boolean gameDirection;
        
        GameDirection(boolean gameDirection) {
            this.gameDirection = gameDirection;
        }

        public boolean getGameDirection() {
            return gameDirection;
        }
    }
    
    private int currentPlayer;
    private Deck deck;
    private Discard discard;
    private List<Player> playersList;
    private Card.Color validColor;
    private Card.Value validValue;
    private GameDirection gameDirection;
    
    private Player topPlayer;
    private Player rightPlayer;
    private Player leftPlayer;
    private Player bottomPlayer;
    
    public Game(Account player) {
        topPlayer = new Player(new Account("Top Player", 0));
        rightPlayer = new Player(new Account("Right Player", 0));
        leftPlayer = new Player(new Account("Left Player", 0));
        bottomPlayer = new Player(player);
        System.out.println(topPlayer.getAccountInfo().toString());
        System.out.println(rightPlayer.getAccountInfo().toString());
        System.out.println(leftPlayer.getAccountInfo().toString());
        System.out.println(bottomPlayer.getAccountInfo().toString());
    }
    
    //NOT USED YET
    public Game(AccountListDatabase players, Account player) {
        topPlayer = new Player(new Account("Top Player", 0));
        rightPlayer = new Player(new Account("Right Player", 0));
        leftPlayer = new Player(new Account("Left Player", 0));
        bottomPlayer = new Player(player);
        
        deck = new Deck();
        discard = new Discard();
        discard.setDiscard(deck.getCard());
        
        playersList = new ArrayList<>(Arrays.asList(
                topPlayer, rightPlayer, leftPlayer, bottomPlayer));
        dealCards(playersList);
    }
    
    private void dealCards(List<Player> playersList) {
        for (Player player : playersList) {
            player.setHandCards(new ArrayList<>(deck.getCards(7)));
        }
    }

    public void setAI(List<Account> players) {
    }
    
    public Player getTopPlayer() {
        return topPlayer;
    }

    public Player getRightPlayer() {
        return rightPlayer;
    }

    public Player getLeftPlayer() {
        return leftPlayer;
    }

    public Player getBottomPlayer() {
        return bottomPlayer;
    }

}
