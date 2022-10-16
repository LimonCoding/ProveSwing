import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameJUno extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4653355276161482242L;
	private static final ImageIcon logo = new ImageIcon("ImageLibrary/Uno_Logo_PNG1-3.png");
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private JPanel myPanel;
	
	private JButton playButton;
	private JLabel labely;
	private JLabel unoText;
	private ExitPanel exitButton;
	
	public FrameJUno() {
		
		super("J Uno");
		
		setIconImage(iconApp.getImage());

	
		myPanel = new PanelGradient();
		BoxLayout layout = new BoxLayout(myPanel, BoxLayout.PAGE_AXIS);
		myPanel.setLayout(layout);
		
		playButton = new JButton("Clicca sul logo per giocare");
		playButton.setIcon(logo);
		playButton.setBorder(BorderFactory.createEmptyBorder());
		playButton.setContentAreaFilled(false);
		playButton.setHorizontalTextPosition(JButton.CENTER);
		playButton.setVerticalTextPosition(JButton.BOTTOM);
		playButton.setForeground(Color.WHITE);
		playButton.setFont(new Font("Cabin Bold", 30, 30));
		playButton.setToolTipText("Clicca per giocare!");
		playButton.setMnemonic(KeyEvent.VK_ENTER);
		
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AccountFrame();
				dispose();
				
			}
		});

		labely = new JLabel("Benvenuto al gioco");
		labely.setForeground(Color.WHITE);
		labely.setFont(new Font("Cabin Medium", 30, 45));
		

		unoText = new JLabel("UNO!");
		unoText.setForeground(Color.BLACK);
		unoText.setFont(new Font("Cabin Bold", 60, 150));

		exitButton = new ExitPanel();

		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		labely.setAlignmentX(Component.CENTER_ALIGNMENT);
		unoText.setAlignmentX(Component.CENTER_ALIGNMENT);
		exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		myPanel.add(Box.createRigidArea(new Dimension(0,80)));
		myPanel.add(labely);
		myPanel.add(unoText);
		myPanel.add(Box.createRigidArea(new Dimension(0,30)));
		myPanel.add(playButton);
		myPanel.add(exitButton);
		add(myPanel);
		
		setFrameSettings();
	}

	private void setFrameSettings() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}