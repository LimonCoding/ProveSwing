package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.Card;

public class PlayerPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Border innerBorder;
	private Border outerBorder;
	private PlayFrame frame;
	
	FlowLayout myCardLayout;
	
	public PlayerPanel(PlayFrame frame, String borderTitle, int space, int nCards) {
		this.frame = frame;
	    
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
		carta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getDeckPanel().getDiscard().setVisible(true);
                frame.getDeckPanel().getDiscard().setIcon(image);
                System.out.println(image);
            }
        });
	}
	
	public void drawEnemyCards(List<Card> cards) {
	    for (Card card : cards) {
	        JButton carta = new JButton();
	        carta.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+card.toString()));
	        carta.setBorder(BorderFactory.createEmptyBorder());
	        carta.setContentAreaFilled(false);
	        carta.setPreferredSize(new Dimension(100, 150));
	        add(carta);
        }
    }
	
	public void drawEnemyCard(Card card) {
        JButton carta = new JButton();
        carta.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+card.toString()));
        carta.setBorder(BorderFactory.createEmptyBorder());
        carta.setContentAreaFilled(false);
        carta.setPreferredSize(new Dimension(100, 150));
        add(carta);
    }
	
	public void drawEnemyCard(ImageIcon image, ImageIcon value) {
        JButton carta = new JButton();
        carta.setIcon(image);
        carta.setBorder(BorderFactory.createEmptyBorder());
        carta.setContentAreaFilled(false);
        carta.setPreferredSize(new Dimension(100, 150));
        add(carta);
        carta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getDeckPanel().getDiscard().setVisible(true);
                frame.getDeckPanel().getDiscard().setIcon(value);
                System.out.println(value);
            }
        });
    }
}
