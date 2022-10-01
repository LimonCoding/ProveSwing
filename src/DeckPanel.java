import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DeckPanel extends JPanel {
	
	private static final ImageIcon deckCard = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	
	Border aiInnerBorder;
	Border outerBorder;
	
	private JButton deck;
	
	FlowLayout myCardLayout;
	
	public DeckPanel(String borderTitle, int space, int nCards) {
		setNameBorder(borderTitle);
		outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, aiInnerBorder));
		
		setCardLayoutSpec(space, nCards);
		setLayout(myCardLayout);
		setOpaque(false);
		

		/**
		 * Creazione e posizionamento dei bottoni Mazzo e Scartate
		 */
		deck = new JButton();
		
		deck.setIcon(deckCard);
		deck.setBorder(BorderFactory.createEmptyBorder());
		deck.setContentAreaFilled(false);
		deck.setPreferredSize(new Dimension(100, 150));
		add(deck);

		
		JButton discard = new JButton("Scartate");
		discard.setPreferredSize(new Dimension(100, 150));
		discard.setEnabled(false);
		add(discard);
	}
	
	public void setNameBorder(String title) {
		aiInnerBorder = BorderFactory.createTitledBorder(title);
	}
	
	public void setCardLayoutSpec(int space, int nCards) {
		myCardLayout = new FlowLayout(FlowLayout.CENTER,space,nCards);
	}
	
	public JButton getButton() {
		return deck;
	}
}
