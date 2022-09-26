import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.*;


@SuppressWarnings("serial")
public class PlayFrame extends JFrame {
	
	private static final ImageIcon deckCard = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private static final ImageIcon deckCardDx = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private static final ImageIcon deckCardSx = new ImageIcon("ImageLibrary/CARTE-UNO/small/RETRO.png");
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	public PlayFrame() {
		
		super("Play Frame");
		
		JPanel myPanel = new PanelGradient();
		myPanel.setLayout(new BorderLayout(8,6));
		myPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		
		/**
		 * Creazione e posizionamento dei pannelli per giocatore
		 */
		JPanel player1 = new JPanel();
		JPanel player2 = new JPanel();
		JPanel player3 = new JPanel();
		JPanel player4 = new JPanel();
		JPanel deckPanel = new JPanel();
		
		/**
		 * Settaggio del FlowLayout per tutti i pannelli giocatore
		 */
		player1.setLayout(new FlowLayout(FlowLayout.CENTER,-30,20));
		player2.setLayout(new GridLayout(15, 1, 10, -20));
		player3.setLayout(new FlowLayout(FlowLayout.LEFT,-20, 10));
		player3.setBorder(BorderFactory.createTitledBorder("AI 2"));
		player4.setLayout(new FlowLayout(FlowLayout.CENTER,-30,20));
		player4.setBorder(BorderFactory.createTitledBorder("Simone"));
		deckPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		
		myPanel.add(player1, BorderLayout.PAGE_START);
		myPanel.add(player2, BorderLayout.EAST);
		myPanel.add(player3, BorderLayout.WEST);
		myPanel.add(player4, BorderLayout.PAGE_END);
		myPanel.add(deckPanel, BorderLayout.CENTER);
		
		/**
		 * Settaggio del colore per ogni pannello giocatore
		 */
		player1.setOpaque(false);
		player2.setOpaque(false);
		player3.setOpaque(false);
		player4.setOpaque(false);
		deckPanel.setOpaque(false);
		
		/**
		 * Creazione e posizionamento dei bottoni Mazzo e Scartate
		 */
		JButton deck = new JButton();
		
		deck.setIcon(deckCard);
		deck.setBorder(BorderFactory.createEmptyBorder());
		deck.setContentAreaFilled(false);
		deck.setPreferredSize(new Dimension(100, 150));
		deckPanel.add(deck);

		
		JButton discard = new JButton("Scartate");
		discard.setPreferredSize(new Dimension(100, 150));
		discard.setEnabled(false);
		deckPanel.add(discard);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 1
		 */
		JButton carta1 = new JButton();
		carta1.setIcon(deckCard);
		carta1.setBorder(BorderFactory.createEmptyBorder());
		carta1.setContentAreaFilled(false);
		carta1.setPreferredSize(new Dimension(100, 150));
		player1.add(carta1);
		
		JButton carta2 = new JButton();
		carta2.setIcon(deckCard);
		carta2.setBorder(BorderFactory.createEmptyBorder());
		carta2.setContentAreaFilled(false);
		carta2.setPreferredSize(new Dimension(100, 150));
		player1.add(carta2);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 2
		 */
		JButton carta3 = new JButton();
		carta3.setIcon(deckCardSx);
		carta3.setBorder(BorderFactory.createEmptyBorder());
		carta3.setContentAreaFilled(false);
		carta3.setPreferredSize(new Dimension(150, 100));
		player2.add(carta3);
		
		JButton carta4 = new JButton();
		carta4.setIcon(deckCardSx);
		carta4.setBorder(BorderFactory.createEmptyBorder());
		carta4.setContentAreaFilled(false);
		carta4.setPreferredSize(new Dimension(150, 100));
		player2.add(carta4);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 3
		 */
		JButton carta5 = new JButton();
		carta5.setPreferredSize(new Dimension(150, 100));
		carta5.setIcon(deckCardDx);
		carta5.setBorder(BorderFactory.createEmptyBorder());
		carta5.setContentAreaFilled(false);
		player3.add(carta5);
		
		JButton carta6 = new JButton();
		carta6.setPreferredSize(new Dimension(150, 100));
		carta6.setIcon(deckCardDx);
		carta6.setBorder(BorderFactory.createEmptyBorder());
		carta6.setContentAreaFilled(false);
		player3.add(carta6);
		
		/**
		 * Creazione e posizionamento delle carte (bottoni) per il giocatore 4 (io)
		 */
		JButton carta7 = new JButton("Carta 1");
		carta7.setPreferredSize(new Dimension(100, 150));
		carta7.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/YELLOW_NINE.png"));
		carta7.setContentAreaFilled(false);
		player4.add(carta7);
		
		JButton carta8 = new JButton("Carta 2");
		carta8.setPreferredSize(new Dimension(100, 150));		
		carta8.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/WILD.png"));
		carta8.setContentAreaFilled(false);
		player4.add(carta8);
		
		deck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JButton cartaP1 = new JButton();
				cartaP1.setPreferredSize(new Dimension(100, 150));
				cartaP1.setIcon(deckCard);
				cartaP1.setBorder(BorderFactory.createEmptyBorder());
				cartaP1.setContentAreaFilled(false);
				player1.add(cartaP1);
				
				JButton cartaP2 = new JButton();
				cartaP2.setPreferredSize(new Dimension(150, 100));
				cartaP2.setIcon(deckCardSx);
				cartaP2.setBorder(BorderFactory.createEmptyBorder());
				cartaP2.setContentAreaFilled(false);
				player2.add(cartaP2);
				
				JButton cartaP3 = new JButton();
				cartaP3.setPreferredSize(new Dimension(150, 100));
				cartaP3.setIcon(deckCardDx);
				cartaP3.setBorder(BorderFactory.createEmptyBorder());
				cartaP3.setContentAreaFilled(false);
				player3.add(cartaP3);
				
				JButton cartaP4 = new JButton("Carta");
				cartaP4.setPreferredSize(new Dimension(100, 150));
				cartaP4.setBorder(BorderFactory.createEmptyBorder());
				cartaP4.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/BLUE_ZERO.png"));
				cartaP4.setIcon(new ImageIcon("ImageLibrary/CARTE-UNO/small/BLUE_ZERO.png"));
				player4.add(cartaP4);
				cartaP4.setContentAreaFilled(false);
				setVisible(true);
				
			}
		});

		
		add(myPanel);
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
