package gui;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;

public class ExitPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton exitButton;
	
	private Border outerBorder;
	
	public ExitPanel() {
		outerBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		setBorder(outerBorder);
		
		setOpaque(false);
		
		exitButton = new JButton("ESCI");
		exitButton.setFont(new Font("Cabin Bold", 30, 30));
		exitButton.setToolTipText("Clicca per uscire!");
		exitButton.setMargin(new InsetsUIResource(10, 20, 10, 20));
		add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
	}	
}
