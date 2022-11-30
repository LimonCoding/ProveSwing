package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.Controller;
import model.Card;
import model.Player;

public class PlayerPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitledBorder innerBorder;
	private Border outerBorder;
	private PlayFrame frame;
	private Controller controller;
	private FlowLayout myCardLayout;
    private Player player;
	
	public PlayerPanel(Controller controller, PlayFrame frame, Player player, int space, int nCards) {
		this.frame = frame;
		this.controller = controller;
	    this.player = player;
	    setInnerBorder(player.getAccountInfo().getAlias());
		setOuterBorder();
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setCardLayoutSpec(space, nCards);
		setLayout(myCardLayout);
		setOpaque(false);
		
	}
	
	public PlayerPanel(Controller controller, PlayFrame frame, String alias, int space, int nCards) {
        this.frame = frame;
        this.controller = controller;
        setInnerBorder(alias);
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
	
	public Player getPlayer() {
        return player;
    }

    public void setPlayerTurn() {
	    innerBorder.setTitleColor(Color.RED);
    }
	
	public void clearTurn() {
	    innerBorder.setTitleColor(Color.BLACK);
    }
	
	public void setOuterBorder() {
		outerBorder = BorderFactory.createEmptyBorder(8, 8, 8, 8);
	}
	
	public void setCardLayoutSpec(int space, int nCards) {
		myCardLayout = new FlowLayout(FlowLayout.CENTER,space,nCards);
	}
	
	public void setCard(List<Card> cards) {
	    controller.getGame().getBottomPlayer().setHandCards(cards);
        cards.stream().forEach((card) -> {
	        JButton carta = new JButton();
            carta.setIcon(card.getFaceCard());
            carta.setBorder(BorderFactory.createEmptyBorder());
            carta.setContentAreaFilled(false);
            carta.setPreferredSize(new Dimension(100, 150));
            add(carta);
            carta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.getGame().getCurrentPlayer().equals(player)) {
                        if (controller.legitDiscard(card)) {
                            controller.getGame().getBottomPlayer().discard(card);
                            controller.getGame().nextTurn();
                            frame.updateCurrentPlayer(controller);
                            frame.setVisible(true);
                            controller.getDiscard().setDiscard(card);
                            
                            System.out.println("Discarded from player panel: "+controller.getDiscard().getLastDiscard());
                            System.out.println("Last rejected: "+controller.getDiscard().getLastDiscard());
                            controller.getGame().getRightPlayer().play(controller.getGame().getDiscard().getLastDiscard());
                            frame.getDeckPanel().getDiscardButton().setVisible(true);
                            frame.getDeckPanel().getDiscardButton().setIcon(carta.getIcon());
                            JButton buttonThatWasClicked = (JButton)e.getSource();
                            Container parent = buttonThatWasClicked.getParent();
                            parent.remove(buttonThatWasClicked);
                            parent.revalidate();
                            parent.repaint();
                            } else {
                                System.out.println(player);
                                System.out.println(controller.getGame().getCurrentPlayer());
                                JOptionPane.showMessageDialog(frame, 
                                    "This card is not legit to throw.", 
                                    "Unlegit discard!", JOptionPane.ERROR_MESSAGE);
                       }
                    } else {
                        System.out.println(controller.getGame().getCurrentPlayer());
                        JOptionPane.showMessageDialog(frame, 
                            "Wait your turn!", 
                            "Not your turn!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
	    });
	}	
	public void drawCard(Card card) {
		JButton carta = new JButton();
		carta.setIcon(card.getFaceCard());
		carta.setBorder(BorderFactory.createEmptyBorder());
		carta.setContentAreaFilled(false);
		carta.setPreferredSize(new Dimension(100, 150));
		add(carta);
		controller.getGame().getBottomPlayer().addHandCard(card);
		System.out.println(controller.getGame().getBottomPlayer().getHandCards().toString());
		carta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.legitDiscard(card)) {
                    controller.getGame().getBottomPlayer().discard(card);
                    controller.getGame().nextTurn();
                    System.out.println(controller.getGame().getCurrentPlayer().getAccountInfo().getAlias());
                    frame.updateCurrentPlayer(controller);
                    System.out.println(controller.getGame().getBottomPlayer().getHandCards().toString());
                    controller.getDiscard().setDiscard(card);
                    System.out.println("\nDiscarded from player panel: "+controller.getDiscard().toString());
                    frame.getDeckPanel().getDiscardButton().setVisible(true);
                    frame.getDeckPanel().getDiscardButton().setIcon(carta.getIcon());
                    JButton buttonThatWasClicked = (JButton)e.getSource();
                    Container parent = buttonThatWasClicked.getParent();
                    parent.remove(buttonThatWasClicked);
                    parent.revalidate();
                    parent.repaint();
                } else {
                    JOptionPane.showMessageDialog(frame, 
                            "This card is not legit to throw.", 
                            "Unlegit discard!", JOptionPane.ERROR_MESSAGE);
                }
    		}
        });
	}
	
	public void setEnemyCard(List<Card> cards) {
	    cards.stream().forEach((card) -> {
	        JButton carta = new JButton();
            carta.setIcon(card.getFaceCard());
            carta.setBorder(BorderFactory.createEmptyBorder());
            carta.setContentAreaFilled(false);
            carta.setPreferredSize(new Dimension(100, 150));
            add(carta);
	    });
    }
	
	public void drawEnemyCard(Card card) {
        JButton carta = new JButton();
        carta.setIcon(card.getFaceCard());
        carta.setBorder(BorderFactory.createEmptyBorder());
        carta.setContentAreaFilled(false);
        carta.setPreferredSize(new Dimension(100, 150));
        add(carta);
    }
    
}
