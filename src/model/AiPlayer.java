package model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.Timer;

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
    
    public void play(Card rejected) {
        System.out.println(this.getHandCards());
        Timer play = new Timer(5000, (ae)->{
            Card selected = chooseCard(getHandCards(), rejected);
            if (!(selected == null)) {
                System.out.println(selected);
                this.getHandCards().removeIf(c -> c.equals(selected));
                System.out.println(this.getHandCards());
            } else {
                System.out.println("Have to draw a card");
            }
        });
        play.setRepeats(false);
        play.start();
    }
    
    public Strategy getAiStrategy() {
        return aiStrategy;
    }
    
    public void setAiStrategy(Strategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }
    
    //Based on getValidMoves method, 
    //AI player can choose on cards ordered by strategy specifications
    public Card chooseCard(List<Card> validCards, Card rejected) {
        if(aiStrategy.equals(Strategy.SAME_COLOR)) {
            //ORDERING BASED ON SAME COLOR CARD OF LAST DISCARD
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByColor = validByColor.stream()
                    .findAny();
//            System.out.println(validCardByColor);
//            System.out.println("- validByColor -");
//            validByColor.forEach(System.out::println);
            
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByValue = validByValue.stream()
                    .findAny();
//            System.out.println(validCardByValue);
//            System.out.println("- validByValue -");
//            validByValue.forEach(System.out::println);
            
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            Optional<Card> validCardByWild = validWild.stream()
                    .findAny();
//            System.out.println("- validWild -");
//            validWild.forEach(System.out::println);
            
            if (!validCardByColor.isEmpty()) {
                return validCardByColor.get();
            } else if (!validCardByValue.isEmpty()) {
                return validCardByValue.get();
            } else if (!validCardByWild.isEmpty())
                return validCardByWild.get();
            
        }
        if(aiStrategy.equals(Strategy.SAME_VALUE)) {
            //ORDERING BASED ON SAME VALUE CARD OF LAST DISCARD
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByValue = validByValue.stream()
                    .findAny();
//            System.out.println("- validByValue -");
//            validByValue.forEach(System.out::println);
            
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByColor = validByColor.stream()
                    .findAny();
//            System.out.println("- validByColor -");
//            validByColor.forEach(System.out::println);
            
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            Optional<Card> validCardByWild = validWild.stream()
                    .findAny();
//            System.out.println("- validWild -");
//            validWild.forEach(System.out::println);
            
            if (!validCardByValue.isEmpty()) {
                return validCardByValue.get();
            } else if (!validCardByColor.isEmpty()) {
                return validCardByColor.get();
            } else if (!validCardByWild.isEmpty()) {
                return validCardByWild.get();
            }
            
        }
        if(aiStrategy.equals(Strategy.USE_SPECIAL)) {
            //ORDERING BASED ON SAME COLOR OF LAST DISCARD BUT WITH SPECIAL CARDS VALUE FIRST
            List<Card> validSpecial = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()) && rejected.isSpecial())
                    .collect(Collectors.toList());
            Optional<Card> validCardBySpecial = validSpecial.stream()
                    .findAny();
//            System.out.println("- validSpecial -");
//            validSpecial.forEach(System.out::println);
            
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByColor = validByColor.stream()
                    .findAny();
//            System.out.println("- validByColor -");
//            validByColor.forEach(System.out::println);
            
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByValue = validByValue.stream()
                    .findAny();
//            System.out.println("- validByValue -");
//            validByValue.forEach(System.out::println);
            
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            Optional<Card> validCardByWild = validWild.stream()
                    .findAny();
//            System.out.println("- validWild -");
//            validWild.forEach(System.out::println);
            
            if (!validCardBySpecial.isEmpty()) {
                return validCardBySpecial.get();
            } else if (!validCardByColor.isEmpty()) {
                return validCardByColor.get();
            } else if (!validCardByValue.isEmpty()) {
                return validCardByValue.get();
            } else if (!validCardByWild.isEmpty()) {
                return validCardByWild.get();
            }
            
        }
        if(aiStrategy.equals(Strategy.USE_WILD)) {
            //ORDERING BASED ON WILD COLOR CARDS
            List<Card> validWild = validCards.stream()
                    .filter(card -> card.isWild())
                    .collect(Collectors.toList());
            Optional<Card> validCardByWild = validWild.stream()
                    .findAny();
//            System.out.println("validWild");
//            validWild.forEach(System.out::println);
            
            List<Card> validByColor = validCards.stream()
                    .filter(card -> card.getColor().equals(rejected.getColor()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByColor = validByColor.stream()
                    .findAny();
//            System.out.println("validByColor");
//            validByColor.forEach(System.out::println);
            
            List<Card> validByValue = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()))
                    .collect(Collectors.toList());
            Optional<Card> validCardByValue = validByValue.stream()
                    .findAny();
//            System.out.println("validByValue");
//            validByValue.forEach(System.out::println);
            
            List<Card> validSpecial = validCards.stream()
                    .filter(card -> card.getValue().equals(rejected.getValue()) && rejected.isSpecial())
                    .collect(Collectors.toList());
            Optional<Card> validCardBySpecial = validSpecial.stream()
                    .findAny();
//            System.out.println("validSpecial");
//            validSpecial.forEach(System.out::println);
            
            if (!validCardByWild.isEmpty()) {
                return validCardByWild.get();
            } else if (!validCardByColor.isEmpty()) {
                return validCardByColor.get();
            } else if (!validCardByValue.isEmpty()) {
                return validCardByValue.get();
            } else if (!validCardBySpecial.isEmpty()) {
                return validCardBySpecial.get();
            } 
            
        }
        return null;
    }
    
    public void drawCard() {
    }

}
