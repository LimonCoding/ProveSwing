package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AiPlayer extends Player {
    
    public enum Strategy {
        SAME_COLOR(0), SAME_VALUE(1), USE_SPECIAL(2), USE_WILD(3);
        
        private int strategy;
        
        Strategy(int strategy) {
            this.strategy = strategy;
        }

        public int getStrategy() {
            return strategy;
        }
        
        public void setStrategy(int strategy) {
            this.strategy = strategy;
        }
        
        public static Strategy forValue(int strategy) {
            for (Strategy s: values()) {
                if (s.getStrategy() == strategy) return s;
            }
            return null;
        }
    }
    
    private Strategy aiStrategy;
    
    public AiPlayer(Account accountInfo, Strategy aiStrategy) {
        super(accountInfo);
        this.aiStrategy = aiStrategy;
    }
    
    public void play() {
        
    }
    
    public Strategy getAiStrategy() {
        return aiStrategy;
    }
    
    public void setAiStrategy(Strategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }
    
    //Based on getValidMoves method, 
    //AI player can choose on cards ordered by strategy specifications
    public void chooseCard(List<Card> validCards, Card discarded) {
        if(aiStrategy.equals(Strategy.SAME_COLOR)) {
            //ORDERING BASED ON SAME COLOR CARD OF LAST DISCARD
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            List<Card> sortedByColor = validCards.stream()
                    .sorted(new Comparator<Card>() {
                        @Override
                        public int compare(Card c, Card discarded) {
                            if (c.getValue().equals(discarded.getValue())) {
                                return 1;
                            }
                            return c.getColor().compareTo(discarded.getColor());
                        }
                    })
                    .collect(Collectors.toList());
            sortedByColor.forEach(System.out::println);
//            return validCards.get((int)(Math.random()*validCards.size()));
        }
        if(aiStrategy.equals(Strategy.SAME_VALUE)) {
            //ORDERING BASED ON SAME VALUE CARD OF LAST DISCARD
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            List<Card> sortedByValue = validCards.stream()
                    .sorted(new Comparator<Card>() {
                        @Override
                        public int compare(Card c, Card discarded) {
                            return c.getValue().compareTo(discarded.getValue());
                        }
                    })
                    .collect(Collectors.toList());
            sortedByValue.forEach(System.out::println);
//            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_SPECIAL)) {
            //ORDERING BASED ON SAME COLOR OF LAST DISCARD BUT WITH SPECIAL CARDS VALUE FIRST
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            List<Card> sortedBySpecial = validCards.stream()
                    .sorted(Comparator.comparing(Card::getColor).
                            thenComparing(Card::getValue).reversed())
                    .collect(Collectors.toList());
            sortedBySpecial.forEach(System.out::println);
//            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_WILD)) {
            //ORDERING BASED ON WILD COLOR CARDS
            // | TO DO | | TO DO | | TO DO | | TO DO | | TO DO |
            List<Card> sorterByWild = validCards.stream()
                    .sorted(Comparator.comparing(Card::isWild)
                    .thenComparing(Card::getColor)
                    .thenComparing(Card::getValue))
                    .collect(Collectors.toList());
            sorterByWild.forEach(System.out::println);
//            return validCards.get(validCards.size()-1);
        }
//        return null;
    }

}
