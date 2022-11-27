package model;

import javax.swing.ImageIcon;

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
	private static final String subPath = "ImageLibrary/CARTE-UNO/small/";
	private boolean covered;
    private final ImageIcon backFace = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private ImageIcon faceCard;
	
	public Card(final Color color, final Value value) {
		this.color = color;
		this.value = value;
		this.covered = false;
		if (covered) {
		    this.faceCard = backFace;
        } else 
            this.faceCard = new ImageIcon(subPath+this.toString());
	}
	
	public Card(final Color color, final Value value, boolean covered) {
        this.color = color;
        this.value = value;
        this.covered = covered;
        if (covered) {
            this.faceCard = backFace;
        } else 
            this.faceCard = new ImageIcon(subPath+this.toString());
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
    
    public boolean isSameValue(Value validValue) {
        return this.getValue().equals(validValue); 
    }

    public ImageIcon getFaceCard() {
        return faceCard;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
        if (covered) {
            this.faceCard = backFace;
        } else 
            this.faceCard = new ImageIcon(subPath+this.toString());
    }

}
