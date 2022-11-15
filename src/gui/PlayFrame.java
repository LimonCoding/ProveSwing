package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Controller;

@SuppressWarnings("serial")
public class PlayFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PlayerPanel topPlayerAI;
	private PlayerPanel rightPlayerAI;
	private PlayerPanel leftPlayerAI;
	private PlayerPanel myPlayer;
	private DeckPanel deckPanel;
	
	public PlayFrame(Controller controller, int id) {
		
		super("Play Frame");
		controller.createGame(controller.getAccount(id));
		
		JPanel myPanel = new PanelGradient();
		myPanel.setLayout(new BorderLayout(8,6));
		myPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		/**
		 * Creazione e posizionamento dei pannelli per giocatore
		 */
		topPlayerAI = new PlayerPanel(controller, this, "Top Player", -30, 15);
		rightPlayerAI = new PlayerPanel(controller, this, "Right Player", -50, 15);
		leftPlayerAI = new PlayerPanel(controller, this, "Left Player", -50, 15);
		myPlayer = new PlayerPanel(controller, this, controller.getAccount(id).getAlias(), -30, 15);
		deckPanel = new DeckPanel(controller.getDiscard().getLastDiscard(), "Deck", 50, 2);
		
		Dimension dim = getPreferredSize();
		dim.width = 625;
		dim.height = 700;
		rightPlayerAI.setPreferredSize(dim);
		leftPlayerAI.setPreferredSize(dim);
		
		myPanel.add(topPlayerAI, BorderLayout.PAGE_START);
		myPanel.add(rightPlayerAI, BorderLayout.EAST);
		myPanel.add(leftPlayerAI, BorderLayout.WEST);
		myPanel.add(myPlayer, BorderLayout.PAGE_END);
		myPanel.add(deckPanel, BorderLayout.CENTER);
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 1
		 */
		topPlayerAI.setEnemyCard(controller.getGame().getTopPlayer().getHandCards());
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 2
		 */
		rightPlayerAI.setEnemyCard(controller.getGame().getRightPlayer().getHandCards());
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 3
		 */
		leftPlayerAI.setEnemyCard(controller.getGame().getLeftPlayer().getHandCards());
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 4 (io)
		 */
	    myPlayer.setCard(controller.getGame().getBottomPlayer().getHandCards());
		
		deckPanel.getDeck().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println(controller.getDeck().toString());
				myPlayer.drawCard(controller.getDeck().getCard());	
				setVisible(true);
			}
		});

		
		add(myPanel);
		
		setFrameSettings();
	}
	
	public DeckPanel getDeckPanel() {
	    return deckPanel;
	}
	
	private void setFrameSettings() {
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1700, 850));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
