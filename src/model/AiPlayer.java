package model;

import java.util.List;

public class AiPlayer extends Player {
    
    public enum Strategy {
        KEEP_COLOR(0), CHANGE_COLOR(1), USE_SPECIAL(2), USE_WILD(3);
        
        private final int strategy;
        
        Strategy(int strategy) {
            this.strategy = strategy;
        }

        public int getStrategy() {
            return strategy;
        }
    }
    
    private final Strategy aiStrategy;
    
    public AiPlayer(Account accountInfo, Strategy aiStrategy) {
        super(accountInfo);
        this.aiStrategy = aiStrategy;
    }
    
    //Based on getValidMoves method, 
    //AI player can choose on cards ordered by strategy specifications
    @SuppressWarnings("unused")
    private Card chooseCard(List<Card> validCards) {
        if(aiStrategy.equals(Strategy.KEEP_COLOR)) {
            //ORDERING BASED ON SAME COLOR CARD OF LAST DISCARD
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            return validCards.get((int)(Math.random()*validCards.size()));
        }
        if(aiStrategy.equals(Strategy.CHANGE_COLOR)) {
            //ORDERING BASED ON SAME VALUE CARD OF LAST DISCARD
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_SPECIAL)) {
            //ORDERING BASED ON SAME COLOR OF LAST DISCARD BUT WITH SPECIAL CARDS VALUE FIRST
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_WILD)) {
            //ORDERING BASED ON WILD COLOR CARDS
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            return validCards.get(validCards.size()-1);
        }
        return null;
    }
    
    public void play() {
        
    }
    
    public Strategy getAiStrategy() {
        return aiStrategy;
    }

}
