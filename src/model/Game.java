package model;

public class Game {
    
    private Player topPlayer;
    private Player rightPlayer;
    private Player leftPlayer;
    private Player bottomPlayer;
    
    public Game(Account player) {
        topPlayer = new Player(new Account("Top Player", 0));
        rightPlayer = new Player(new Account("Right Player", 0));
        leftPlayer = new Player(new Account("Left Player", 0));
        bottomPlayer = new Player(player);
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
