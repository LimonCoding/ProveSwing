package model;

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

    public Strategy getAiStrategy() {
        return aiStrategy;
    }

}
