package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.AiPlayer.Strategy;

public class Game {
    
    public enum GameDirection {
        CLOCKWISE(true), COUNTER_CLOCKWISE(false);
        
        private boolean gameDirection;
        
        GameDirection(boolean gameDirection) {
            this.gameDirection = gameDirection;
        }

        public boolean getGameDirection() {
            return gameDirection;
        }
        
        public static GameDirection forValue(boolean gameDirection) {
            for (GameDirection g: values()) {
                if (g.getGameDirection() == gameDirection) return g;
            }
            return CLOCKWISE;
        }
    }
    
    private int currentPlayerId;
    private final int lastPlayerId;
    private Deck deck;
    private Discard discard;
    private List<Player> playersList;
    private List<Player> sortedPlayerList;
    private Card.Color validColor;
    private Card.Value validValue;
    private GameDirection gameDirection;
    
    private Player topPlayer;
    private Player rightPlayer;
    private Player leftPlayer;
    private Player bottomPlayer;
    
    public Game(Account player) {
        topPlayer = new AiPlayer(new Account("Top Player"), Strategy.KEEP_COLOR);
        rightPlayer = new AiPlayer(new Account("Right Player"), Strategy.CHANGE_COLOR);
        leftPlayer = new AiPlayer(new Account("Left Player"), Strategy.USE_SPECIAL);
        bottomPlayer = new Player(player);
        
        deck = new Deck();
        System.out.println(deck.toString());
        discard = new Discard();
        
        playersList = new ArrayList<>(Arrays.asList(topPlayer, rightPlayer, leftPlayer, bottomPlayer));
        sortedPlayerList = playersList.stream()
                                      .sorted(Comparator.comparingInt(Player::getPlayerId))
                                          .collect(Collectors.toList());
        dealCards(sortedPlayerList);
        currentPlayerId = 0;
        lastPlayerId = playersList.size();
        startGame(this);
        System.out.println(deck.toString());
        System.out.println(discard.toString());
        
        System.out.println(validColor+" "+validValue);
        for (Player p : playersList) {
            System.out.println("VALID MOVES: "+p.getValidMoves(validValue, validColor));
        }
        
        System.out.println(this.getGameDirection());
        reverseTurn();
        System.out.println(this.getGameDirection());
        
        System.out.println(getCurrentPlayer().getPlayerId());
        nextTurn();
        System.out.println(getCurrentPlayer().getPlayerId());
        nextTurn();
        System.out.println(getCurrentPlayer().getPlayerId());
        nextTurn();
        System.out.println(getCurrentPlayer().getPlayerId());
        nextTurn();
        System.out.println(getCurrentPlayer().getPlayerId());
        nextTurn();
        System.out.println(getCurrentPlayer().getPlayerId());
    }
    
    private void dealCards(List<Player> playersList) {
        for (Player player : playersList) {
            player.setHandCards(new ArrayList<>(deck.getCards(7)));
            System.out.println(player.getAccountInfo().toString());
            System.out.println(player.getHandCards().toString());
        }
    }
    
    private void startGame(Game game) {
        Card card = deck.getCard();
        validColor = card.getColor();
        validValue = card.getValue();
        
        if (card.isWild() || card.isSpecial()) {
            startGame(game);
            System.out.println("DISCARD NOT LEGIT");
        } else {
            discard.setDiscard(card);
        }
        
        gameDirection = Game.GameDirection.CLOCKWISE;
    }
    
    public void refillDeck() {
        if (deck.isEmpty()) {
            deck.replaceDeck(discard);
        }
    }
    
    public boolean validCardPlay(Card card) {
        if (card.getColor().equals(validColor) ||
             card.getValue().equals(validValue) ||
              card.isWild()) {
            discard.setDiscard(card);
            return true;
        }
        return false;
    }
    
    public boolean winGame() {
        for (Player p : playersList) {
            return p.getHandCards().equals(null);
        }
        return false;
    }
    
    public void nextTurn() {
        int next = currentPlayerId + 1;
        currentPlayerId = (next == playersList.size()) ? 0 : next;
    }
    
    public void reverseTurn() {
        gameDirection = GameDirection.forValue(!gameDirection.getGameDirection());
    }
    
    public int previousId() {
        int previous = currentPlayerId - 1;
        return (previous == -1) ? lastPlayerId : previous;
    }
    
    public Player getCurrentPlayer() {
        return sortedPlayerList.get(currentPlayerId);
    }
    
    public Player getPreviousPlayer() {
        return sortedPlayerList.get(previousId());
    }
    
    public List<Player> getPlayers() {
        return sortedPlayerList;
    }

    public void setAI(List<Account> players) {
    }
    
    public void setValidColor(Card.Color validColor) {
        this.validColor = validColor;
    }

    public Card.Color getValidColor() {
        return validColor;
    }

    public Card.Value getValidValue() {
        return validValue;
    }

    public GameDirection getGameDirection() {
        return gameDirection;
    }
    
    public Deck getDeck() {
        return deck;
    }
    
    public Discard getDiscard() {
        return discard;
    }
    
    //////////////////////////////////////
    
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
