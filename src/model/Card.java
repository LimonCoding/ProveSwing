package model;

public class Card {
	
	public enum Color {
		BLUE(0), GREEN(1), RED(2), YELLOW(3), WILD(4);
		
		private final int color;
		
		Color(int color) {
			this.color = color;
		}

		public int getColor() {
			return color;
		}
		
		public static Color forValue(int color) {
            for (Color c: values()) {
                if (c.getColor() == color) return c;
            }
            return null;
        }
	}
	
	public enum Value {
		
		ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
		SIX(6), SEVEN(7), EIGHT(8), NINE(9), 
		REVERSE(10), DRAW_TWO(11), SKIP(12),
		WILD(13), WILD_FOUR(14); 
		
		private final int value;
		
		Value (int value) {
            this.value = value;
        }
		
		public int getValue() {
			return value;
		}
		
		public static Value forValue(int value) {
            for (Value v: values()) {
                if (v.getValue() == value) return v;
            }
            return null;
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

    public boolean isWild() {
        return this.getColor().equals(Color.WILD);
    }
    
    public boolean isSpecial() {
        return this.getValue().equals(Value.DRAW_TWO) ||
                this.getValue().equals(Value.REVERSE) ||
                 this.getValue().equals(Value.SKIP); 
    }

}
