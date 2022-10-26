package gui;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

public class JUno {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FlatDarkLaf.setup();
				UIManager.put( "Button.arc", 40 );
				UIManager.put( "TextComponent.arc", 30 );
				UIManager.put( "Component.focusWidth", 2 );
				UIManager.put( "Component.innerFocusWidth", 1 );
				UIManager.put( "Button.innerFocusWidth", 1 );

				new FrameJUno();
			}
		});
	}
}
