import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.formdev.flatlaf.*;

public class JUno {
	
	public static void main(String[] args) {
		
		FlatDarkLaf.setup();
		
		JFrame myFrame = new JFrame("J UNO");
		
		myFrame.setIconImage(new ImageIcon("Uno_logo_PNG2.png").getImage());

	
		JPanel myPanel = new JPanel();
		BoxLayout layout = new BoxLayout(myPanel, BoxLayout.Y_AXIS);
		myPanel.setLayout(layout);
		myPanel.setBackground(new Color(255,130,0));
		
		JButton playButton = new JButton("GIOCA");
		ImageIcon playIcon = new ImageIcon("play.png");
		playButton.setIcon(playIcon);
		playButton.setBorder(BorderFactory.createEmptyBorder());
		playButton.setContentAreaFilled(false);
		playButton.setHorizontalTextPosition(JButton.CENTER);
		playButton.setVerticalTextPosition(JButton.BOTTOM);
		playButton.setForeground(Color.WHITE);
		playButton.setFont(new Font("Cabin Bold", 30, 30));

		
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AccountFrame();
				myFrame.dispose();
				
			}
		});

		JLabel labely = new JLabel("Benvenuto al gioco");
		labely.setForeground(Color.BLACK);
		labely.setFont(new Font("Cabin Medium", 30, 30));
		

		JLabel unoText = new JLabel("UNO!");
		unoText.setForeground(Color.BLACK);
		unoText.setFont(new Font("Cabin Bold", 60, 100));
		
		JLabel pic = new JLabel(new ImageIcon("Uno_Logo_PNG1-3.png"));

		pic.setAlignmentX(myPanel.CENTER_ALIGNMENT);
		labely.setAlignmentX(myPanel.CENTER_ALIGNMENT);
		unoText.setAlignmentX(myPanel.CENTER_ALIGNMENT);
		playButton.setAlignmentX(myPanel.CENTER_ALIGNMENT);
		
		myPanel.add(pic);
		myPanel.add(labely);
		myPanel.add(unoText);
		myPanel.add(playButton);
		myFrame.add(myPanel);
		
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setBounds(100, 100, 1280, 720);
		myFrame.pack();
		myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		myFrame.setResizable(true);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

}