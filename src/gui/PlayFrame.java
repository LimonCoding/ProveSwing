package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import controller.Controller;
import model.Game;
import model.Game.Flipped;

@SuppressWarnings("serial")
public class PlayFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PlayerPanel topPlayerAI;
	private PlayerPanel rightPlayerAI;
	private PlayerPanel leftPlayerAI;
	private PlayerPanel myPlayer;
	private DeckPanel deckPanel;
	private JFrame frame;
	private Controller controller;
	
	private Timer aiPlayerGuiUpdate = new Timer(Game.getSecAiPlay(), (ae)->{
        topPlayerAI.updateEnemyCard(controller.getGame().getTopPlayer().getHandCards());
        rightPlayerAI.updateEnemyCard(controller.getGame().getRightPlayer().getHandCards());
        leftPlayerAI.updateEnemyCard(controller.getGame().getLeftPlayer().getHandCards());
        deckPanel.getDiscardButton().setIcon(controller.getDiscard().getLastDiscard().getFaceCard());
        SwingUtilities.updateComponentTreeUI(frame);
        updateCurrentPlayer(controller);
    });
	
	public PlayFrame(Controller c, int id) {
		
		super("Play Frame");
		frame = this;
		this.controller = c; 
		controller.createGame(controller.getAccount(id));
		
		JPanel myPanel = new PanelGradient();
		myPanel.setLayout(new BorderLayout(8,6));
		myPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		/**
		 * Creazione e posizionamento dei pannelli per giocatore
		 */
		topPlayerAI = new PlayerPanel(controller, this, controller.getGame().getTopPlayer(), -30, 15);
		rightPlayerAI = new PlayerPanel(controller, this, controller.getGame().getRightPlayer(), -50, 15);
		leftPlayerAI = new PlayerPanel(controller, this, controller.getGame().getLeftPlayer(), -50, 15);
		myPlayer = new PlayerPanel(controller, this, controller.getGame().getBottomPlayer(), -30, 15);
		deckPanel = new DeckPanel(controller, controller.getDiscard().getLastDiscard(), "Deck", 50, 2);
        
		Dimension dim = getPreferredSize();
		dim.width = 550;
		dim.height = 700;
		rightPlayerAI.setPreferredSize(dim);
		leftPlayerAI.setPreferredSize(dim);
		
		updateCurrentPlayer(controller);
		
		deckPanel.getDeckButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    if (controller.getGame().getCurrentPlayer().equals(myPlayer.getPlayer())) {
//			        System.out.println(controller.getDeck().toString());
	                myPlayer.drawCard(controller.getDeck().getCard(Flipped.FLIPPED));
	                controller.getGame().nextTurn();
	                updateCurrentPlayer(controller);
	                setVisible(true);
                } else {
                    System.out.println("Current player from playframe: "+controller.getGame().getCurrentPlayer());
                    JOptionPane.showMessageDialog(frame, 
                        "Wait your turn!", 
                        "Not your turn!", JOptionPane.ERROR_MESSAGE);
                }
			    
			}
		});
		
		myPanel.add(topPlayerAI, BorderLayout.PAGE_START);
        myPanel.add(rightPlayerAI, BorderLayout.EAST);
        myPanel.add(leftPlayerAI, BorderLayout.WEST);
        myPanel.add(myPlayer, BorderLayout.PAGE_END);
        myPanel.add(deckPanel, BorderLayout.CENTER);
		add(myPanel);
		setFrameSettings();
	}
	
    public void updateCurrentPlayer(Controller controller) {
//	    System.out.println("Gui Game ID: "+controller.getGame().getCurrentPlayer().getGameId());
//	    System.out.println(controller.getGame().getCurrentPlayer());
        aiPlayerGuiUpdate.setRepeats(false);
	    switch (controller.getGame().getCurrentPlayer().getGameId()) {
            case 0 -> {
                myPlayer.setPlayerTurn();
                rightPlayerAI.clearTurn();
                topPlayerAI.clearTurn();
                leftPlayerAI.clearTurn();
                }
            case 1 -> {
                rightPlayerAI.setPlayerTurn();
                myPlayer.clearTurn();
                topPlayerAI.clearTurn();
                leftPlayerAI.clearTurn();
                System.out.println("Last rejected: "+controller.getGame().getDiscard().getLastDiscard());
                controller.getGame().AiPlay(controller.getGame().getDiscard().getLastDiscard());
                
                aiPlayerGuiUpdate.start();
            }
            case 2 -> {
                topPlayerAI.setPlayerTurn();
                myPlayer.clearTurn();
                rightPlayerAI.clearTurn();
                leftPlayerAI.clearTurn();
                System.out.println("Last rejected: "+controller.getGame().getDiscard().getLastDiscard());
                controller.getGame().AiPlay(controller.getGame().getDiscard().getLastDiscard());
                
                aiPlayerGuiUpdate.start();
            }
            case 3 -> {
                leftPlayerAI.setPlayerTurn();
                myPlayer.clearTurn();
                rightPlayerAI.clearTurn();
                topPlayerAI.clearTurn();
                System.out.println("Last rejected: "+controller.getGame().getDiscard().getLastDiscard());
                controller.getGame().AiPlay(controller.getGame().getDiscard().getLastDiscard());

                aiPlayerGuiUpdate.start();
            }
        }
	    topPlayerAI.updateEnemyCard(controller.getGame().getTopPlayer().getHandCards());
        rightPlayerAI.updateEnemyCard(controller.getGame().getRightPlayer().getHandCards());
        leftPlayerAI.updateEnemyCard(controller.getGame().getLeftPlayer().getHandCards());
        myPlayer.setCards(controller.getGame().getBottomPlayer().getHandCards());
        deckPanel.updateLabelTurn();
        deckPanel.updateLabelDiscard();
	    SwingUtilities.updateComponentTreeUI(frame);
    }

    public DeckPanel getDeckPanel() {
	    return deckPanel;
	}
	
	private void setFrameSettings() {
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent we) {
		        int result = JOptionPane.showConfirmDialog(frame,
		            "Do you want to Exit ?", "Exit Confirmation : ",
		            JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION)
		          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      }
		    });
		setMinimumSize(new Dimension(1700, 850));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
