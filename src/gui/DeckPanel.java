package gui;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Card;

public class DeckPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final ImageIcon deckCard = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	
	private Border innerBorder;
	private Border outerBorder;
	
	private JButton deck;
	private JButton discard;
	private FlowLayout myCardLayout;
	
	/* TO DO: SET AN IMAGE ICON TO SEE GAME DIRECTION IN GAME */
	private ImageIcon gameDirection;
	
	public DeckPanel(Card discard, String borderTitle, int space, int nCards) {
		setNameBorder(borderTitle);
		outerBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setCardLayoutSpec(space, nCards);
		setLayout(myCardLayout);
		setOpaque(false);
		
		/**
		 * Creazione e posizionamento dei bottoni Mazzo e Scartate
		 */
		deck = new JButton();
		setDeck();
		add(deck);

		this.discard = new JButton();
		setDiscardButton(discard.toString());
		add(this.discard);
	}
	
	public void setNameBorder(String title) {
		innerBorder = BorderFactory.createTitledBorder(title);
	}
	
	public void setCardLayoutSpec(int space, int nCards) {
		myCardLayout = new FlowLayout(FlowLayout.CENTER,space,nCards);
	}
	
	public JButton getDeckButton() {
		return deck;
	}
	
	public JButton getDiscardButton() {
        return discard;
    }
	
	public void setDeck() {
	    deck.setIcon(deckCard);
	    deck.setBorder(BorderFactory.createEmptyBorder());
        deck.setContentAreaFilled(false);
        deck.setPreferredSize(new Dimension(100, 150));
    }
	
	public void setDiscardButton(String discard) {
	    this.discard.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+discard));
	    this.discard.setBorder(BorderFactory.createEmptyBorder());
        this.discard.setContentAreaFilled(false);
        this.discard.setPreferredSize(new Dimension(100, 150));
    }

    public ImageIcon getGameDirection() {
        return gameDirection;
    }

    public void setGameDirection(ImageIcon gameDirection) {
        this.gameDirection = gameDirection;
    }
}
