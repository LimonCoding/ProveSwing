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
    private Discarded discarded;
    private List<Player> playersList;
    private List<Player> sortedPlayerList;
    private List<AiPlayer> aiPlayersList;
    private Card.Color validColor;
    private Card.Value validValue;
    private GameDirection gameDirection;
    
    private AiPlayer topPlayer;
    private AiPlayer rightPlayer;
    private AiPlayer leftPlayer;
    private Player bottomPlayer;
    
    public Game(Account player) {
        bottomPlayer = new Player(player);
        rightPlayer = new AiPlayer(new Account("Right Player"), Strategy.SAME_VALUE);
        topPlayer = new AiPlayer(new Account("Top Player"), Strategy.SAME_COLOR);
        leftPlayer = new AiPlayer(new Account("Left Player"), Strategy.USE_SPECIAL);
        
        deck = new Deck();
//        System.out.println(deck.toString());
        discarded = new Discarded();
        
        playersList = new ArrayList<>(Arrays.asList(bottomPlayer, topPlayer, rightPlayer, leftPlayer));
        aiPlayersList = new ArrayList<>(Arrays.asList(topPlayer, rightPlayer, leftPlayer));
        sortedPlayerList = playersList.stream()
                                      .sorted(Comparator.comparing(Player::getGameId))
                                          .collect(Collectors.toList());
        currentPlayerId = 0;
        dealCards(sortedPlayerList);
        lastPlayerId = playersList.size()-1;
        startGame(this);
//        System.out.println(deck.toString());
//        System.out.println(discarded);
        
        
        System.out.println("Valid color + valid value: "+validColor+" "+validValue);
        System.out.println();
//        for (Player p : playersList) {
//            System.out.println("VALID MOVES OF "+p.getAccountInfo().getAlias()+": "+p.getValidMoves(validValue, validColor));
//        }
        for (AiPlayer a : aiPlayersList) {
//            System.out.println(a.getAccountInfo().getAlias()+" - Strategy: "+a.getAiStrategy());
            a.chooseCard(a.getValidMoves(validValue, validColor), discarded.getLastDiscard());
        }
//        System.out.println(this.getGameDirection());
//        reverseTurn();
//        System.out.println(this.getGameDirection());
//        
//        System.out.println(getCurrentPlayer().getGameId());
//        nextTurn();
//        System.out.println(getCurrentPlayer().getGameId());
//        nextTurn();
//        System.out.println(getCurrentPlayer().getGameId());
//        nextTurn();
//        System.out.println(getCurrentPlayer().getGameId());
//        nextTurn();
//        System.out.println(getCurrentPlayer().getGameId());
//        nextTurn();
//        System.out.println(getCurrentPlayer().getGameId());
    }
    
    private void dealCards(List<Player> playersList) {
        for (AiPlayer p : aiPlayersList) {
            p.setHandCards(new ArrayList<>(deck.getCards(7, false)));
        }
        bottomPlayer.setHandCards(new ArrayList<>(deck.getCards(7, false)));
    }
    
    private void startGame(Game game) {
        Card card = deck.getCard(true);
        System.out.println(card);
        validColor = card.getColor();
        validValue = card.getValue();
        
        if (card.isWild() || card.isSpecial()) {
            System.out.println("DISCARD NOT LEGIT");
            startGame(game);
        } else {
            System.out.println("Discard Setted: "+card);
            discarded.setDiscard(card);
        }
        System.out.println("Discarder from model game: "+discarded);
        gameDirection = Game.GameDirection.CLOCKWISE;
    }
    
    public void refillDeck() {
        if (deck.isEmpty()) {
            deck.replaceDeck(discarded);
        }
    }
    
    public boolean validCardPlay(Card card) {
        if (card.getColor().equals(validColor) ||
             card.getValue().equals(validValue) ||
              card.isWild()) {
            discarded.setDiscard(card);
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
        if (gameDirection.getGameDirection()) {
            int next = currentPlayerId + 1;
            currentPlayerId = (next == playersList.size()) ? 0 : next;
        } else {
            int next = currentPlayerId - 1;
            currentPlayerId = (next == -1) ? lastPlayerId : next;
        }
        
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
    
    public Discarded getDiscard() {
        return discarded;
    }
    
    //////////////////////////////////////
    
    public AiPlayer getTopPlayer() {
        return topPlayer;
    }

    public AiPlayer getRightPlayer() {
        return rightPlayer;
    }

    public AiPlayer getLeftPlayer() {
        return leftPlayer;
    }

    public Player getBottomPlayer() {
        return bottomPlayer;
    }
}
