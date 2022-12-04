package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.Controller;
import model.Card;

public class DeckPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Border innerBorder;
	private Border outerBorder;
	
	private JButton deck;
	private JButton discard;
	private FlowLayout myCardLayout;
	
	/* TO DO: SET AN IMAGE ICON TO SEE GAME DIRECTION IN GAME */
	private ImageIcon gameDirection;
	private Controller controller;
	
	private JLabel turnLabel;
	private JLabel lastDiscardLabel;
	
	public DeckPanel(Controller controller, Card discard, String borderTitle, int space, int nCards) {
		this.controller = controller;
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
		
		turnLabel = new JLabel();
		turnLabel.setFont(new Font("Cabin Bold", 30, 30));
		turnLabel.setForeground(Color.BLACK);
		add(turnLabel);
		
		lastDiscardLabel = new JLabel();
		lastDiscardLabel.setFont(new Font("Cabin Bold", 30, 30));
		lastDiscardLabel.setForeground(Color.BLACK);
        add(lastDiscardLabel);
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
	    deck.setIcon(controller.getDeck().getDeckFace());
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
    
    public void updateLabelTurn() {
        this.turnLabel.setText("It's "+controller.getCurrentPlayerAlias()+" turn.");
    }
    
    public void updateLabelDiscard() {
        this.lastDiscardLabel.setText(controller.getLastDiscard()+" it's last discard");
    }
}
