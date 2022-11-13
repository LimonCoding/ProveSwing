package model;

public class Card implements Comparable<Card>{
	
	public enum Color {
		BLUE(0), GREEN(1), RED(2), YELLOW(3), WILD(4);
		
		private final int color;
		
		Color(int color) {
			this.color = color;
		}

		public int getColor() {
			return color;
		}
	}
	
	public enum Value {
		
		ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
		SIX(6), SEVEN(7), EIGHT(8), NINE(9), 
		REVERSE(10), DRAW_TWO(11), SKIP(12),
		WILD(13), WILD_FOUR(14); 
		
		private final int value;
		
		public int getValue() {
			return value;
		}
		
		Value (int value) {
	        this.value = value;
	    }
	}
	
	private final Color color;
	private final Value value;
	
	public Card(final Color color, final Value value) {
		this.color = color;
		this.value = value;
	}
	
	public static Card getCard(final Color color, final Value value) {
		return new Card(color, value);
	}
	
	public Color getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}
	
	public String toString() {
		return color + "_" + value + ".png";
	}

    @Override
    public int compareTo(Card card) {
        if (card.getColor().equals(Color.WILD)) {
            return 1;
        }
        return 0;
    }
    
    public boolean isWild(Card card) {
        return card.getColor().equals(Color.WILD);
    }

}
