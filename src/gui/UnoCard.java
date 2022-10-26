package gui;
public class UnoCard {
	
	enum Color {
		
		RED, BLUE, GREEN, YELLOW, WILD;
		
		private static final Color[] colors = Color.values();
		
		public static Color getColor(int i) {
			return Color.colors[i];
		}
	}
	
	enum Value {
		
		ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
		DRAW_TWO(10), SKIP(11), REVERSE(12), WILD(13), WILD_FOUR(14);
		
		private static final Value[] values = Value.values();
		int value;
		
		private Value(int value) {
			this.value = value;
		}

		public static Value getValue(int value) {
			return Value.values[value];
		}
	}

	private final Color color;
	private final Value value;
	
	public UnoCard(final Color color, final Value value) {
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return this.color;
	}

	public Value getValue() {
		return this.value;
	}
	
	public String toString() {
		return "ImageLibrary/CARTE-UNO/small/" + color + "_" + value + ".png";
	}

}
