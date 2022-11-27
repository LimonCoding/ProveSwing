package model;

import java.util.List;
import java.util.Optional;
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
    public void chooseCard(List<Card> validCards, Card rejected) {
        if(aiStrategy.equals(Strategy.SAME_COLOR)) {
            //ORDERING BASED ON SAME COLOR CARD OF LAST DISCARD
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .findAny();
            
            System.out.println(validCardByColor);
            System.out.println("- validByColor -");
            validByColor.forEach(System.out::println);
            
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .findAny();
            System.out.println(validCardByValue);
            System.out.println("- validByValue -");
            validByValue.forEach(System.out::println);
            
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            System.out.println("- validWild -");
            validWild.forEach(System.out::println);
            
//            return validCards.get((int)(Math.random()*validCards.size()));
        }
        if(aiStrategy.equals(Strategy.SAME_VALUE)) {
            //ORDERING BASED ON SAME VALUE CARD OF LAST DISCARD
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            System.out.println("- validByValue -");
            validByValue.forEach(System.out::println);
            
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            System.out.println("- validByColor -");
            validByColor.forEach(System.out::println);
            
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            System.out.println("- validWild -");
            validWild.forEach(System.out::println);
            
//            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_SPECIAL)) {
            //ORDERING BASED ON SAME COLOR OF LAST DISCARD BUT WITH SPECIAL CARDS VALUE FIRST
            List<Card> validSpecial = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()) && rejected.isSpecial())
                    .collect(Collectors.toList());
            System.out.println("- validSpecial -");
            validSpecial.forEach(System.out::println);
            
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
            
//            return validCards.get(validCards.size()-1);
        }
        if(aiStrategy.equals(Strategy.USE_WILD)) {
            //ORDERING BASED ON WILD COLOR CARDS
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            System.out.println("validWild");
            validWild.forEach(System.out::println);
            
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            System.out.println("validByColor");
            validByColor.forEach(System.out::println);
            
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            System.out.println("validByValue");
            validByValue.forEach(System.out::println);
            
            List<Card> validSpecial = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()) && rejected.isSpecial())
                    .collect(Collectors.toList());
            System.out.println("validSpecial");
            validSpecial.forEach(System.out::println);
//            return validCards.get(validCards.size()-1);
        }
//        return null;
    }
    
    public void drawCard() {
    }

}
