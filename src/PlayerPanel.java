import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayerPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Border innerBorder;
	Border outerBorder;
	
	FlowLayout myCardLayout;
	
	public PlayerPanel(String borderTitle, int space, int nCards) {
		setNameBorder(borderTitle);
		outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setCardLayoutSpec(space, nCards);
		setLayout(myCardLayout);
		setOpaque(false);
		
	}
	
	public void setNameBorder(String title) {
		innerBorder = BorderFactory.createTitledBorder(title);
	}
	
	public void setCardLayoutSpec(int space, int nCards) {
		myCardLayout = new FlowLayout(FlowLayout.CENTER,space,nCards);
	}
	
	public void drawCard(ImageIcon image) {
		JButton carta = new JButton();
		carta.setIcon(image);
		carta.setBorder(BorderFactory.createEmptyBorder());
		carta.setContentAreaFilled(false);
		carta.setPreferredSize(new Dimension(100, 150));
		add(carta);
	}
}
