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
	
	private static final ImageIcon deckCard = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PlayerPanel topPlayerAI;
	private PlayerPanel rightPlayerAI;
	private PlayerPanel leftPlayerAI;
	private PlayerPanel myPlayer;
	private DeckPanel deckPanel;
	
	private Controller controller = new Controller();
	
	public PlayFrame(String alias) {
		
		super("Play Frame");
		controller.createDeck();
		
		JPanel myPanel = new PanelGradient();
		myPanel.setLayout(new BorderLayout(8,6));
		myPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		/**
		 * Creazione e posizionamento dei pannelli per giocatore
		 */
		topPlayerAI = new PlayerPanel(this, "Top Player", -30, 15);
		rightPlayerAI = new PlayerPanel(this, "Right Player", -50, 15);
		leftPlayerAI = new PlayerPanel(this, "Left Player", -50, 15);
		myPlayer = new PlayerPanel(this, alias, -30, 15);
		
		deckPanel = new DeckPanel("Deck", 50,2);
		
		Dimension dim = getPreferredSize();
		dim.width = 700;
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
		topPlayerAI.drawEnemyCard(deckCard, new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));		
		topPlayerAI.drawEnemyCard(deckCard, new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 2
		 */
		rightPlayerAI.drawEnemyCard(deckCard,new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		rightPlayerAI.drawEnemyCard(deckCard,new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 3
		 */
		leftPlayerAI.drawEnemyCard(deckCard,new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		leftPlayerAI.drawEnemyCard(deckCard,new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 4 (io)
		 */
		myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+controller.getDeck().getCard().toString()));
		
		deckPanel.getDeck().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.out.println(controller.getDeck().toString());
			    String cartaPescata = controller.getDeck().getCard().toString();
			    System.out.println(cartaPescata);
				myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/"+cartaPescata));	
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
		pack();
		setMinimumSize(new Dimension(1200, 1000));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
