package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PlayerPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Border innerBorder;
	Border outerBorder;
	
	FlowLayout myCardLayout;
	
	public PlayerPanel(String borderTitle, int space, int nCards) {
		setInnerBorder(borderTitle);
		setOuterBorder();
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setCardLayoutSpec(space, nCards);
		setLayout(myCardLayout);
		setOpaque(false);
		
	}
	
	public void setInnerBorder(String title) {
		innerBorder = BorderFactory.createTitledBorder(null, title, 
				TitledBorder.CENTER, TitledBorder.TOP, 
				new Font("Cabin Bold", 30, 30), Color.BLACK);
	}
	
	public void setOuterBorder() {
		outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
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
