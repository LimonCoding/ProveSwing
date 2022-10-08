import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class PlayFrame extends JFrame {
	
	private static final ImageIcon deckCard = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PlayerPanel topPlayerAI;
	private PlayerPanel rightPlayerAI;
	private PlayerPanel leftPlayerAI;
	private PlayerPanel myPlayer;
	private DeckPanel deckPanel;
	
	
	public PlayFrame() {
		
		super("Play Frame");
		
		JPanel myPanel = new PanelGradient();
		myPanel.setLayout(new BorderLayout(8,6));
		myPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		/**
		 * Creazione e posizionamento dei pannelli per giocatore
		 */
		topPlayerAI = new PlayerPanel("Top Player", -30, 20);
		rightPlayerAI = new PlayerPanel("Right Player", -50, 20);
		leftPlayerAI = new PlayerPanel("Left Player", -50, 20);
		myPlayer = new PlayerPanel("Me", -30, 20);
		
		deckPanel = new DeckPanel("Deck", 50,2);
		
		Dimension dim = getPreferredSize();
		dim.width = 450;
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
		topPlayerAI.drawCard(deckCard);		
		topPlayerAI.drawCard(deckCard);		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 2
		 */
		rightPlayerAI.drawCard(deckCard);
		rightPlayerAI.drawCard(deckCard);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 3
		 */
		leftPlayerAI.drawCard(deckCard);
		leftPlayerAI.drawCard(deckCard);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 4 (io)
		 */
		myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/YELLOW_NINE.png"));
		myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/WILD.png"));
		
		deckPanel.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				topPlayerAI.drawCard(deckCard);	
				rightPlayerAI.drawCard(deckCard);	
				leftPlayerAI.drawCard(deckCard);
				//UnoCard cardDrawed = new UnoCard(Color.getColor(2),Value.getValue(2));
				//String cardString = cardDrawed.toString();
				//myPlayer.drawCard(new ImageIcon(cardString));	
				myPlayer.drawCard(new ImageIcon("ImageLibrary/CARTE-UNO/small/RED_SIX.png"));	
				setVisible(true);
				
			}
		});

		
		add(myPanel);
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
