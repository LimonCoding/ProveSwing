import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	AccountFrame() {
		
		super("Account Frame");
		FlatDarkLaf.setup();
		
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BorderLayout());
		
		JPanel accountPanel1 = new JPanel();
		accountPanel1.setOpaque(false);
		myPanel.add(accountPanel1, BorderLayout.CENTER);
		
		JPanel accountPanel2 = new JPanel();
		accountPanel2.setPreferredSize(new Dimension(100,100));
		accountPanel2.setOpaque(false);
		myPanel.add(accountPanel2, BorderLayout.PAGE_START);
		
		myPanel.setBackground(new Color(255,130,0));
		
		JLabel inserisci = new JLabel("Inserisci il nome utente: ");
		accountPanel1.add(inserisci, BorderLayout.CENTER);
		
		JTextField insertName = new JTextField();
		accountPanel1.add(insertName, BorderLayout.CENTER);
		
		JButton submit = new JButton("Avanti");
		accountPanel1.add(submit, BorderLayout.PAGE_END);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!insertName.getText().equals("")){
	        		
						
//					JLabel stampaNome = new JLabel("Benvenuto "+insertName.getText()+"!");
//					stampaNome.setForeground(Color.BLACK);
//					stampaNome.setFont(new Font("Cabin", 30, 30));
//					myPanel.add(stampaNome);
//					insertName.setVisible(false);
//					setVisible(true);
					
	        }
				new PlayFrame();
				dispose();
				
			}
		});

		this.add(myPanel);
		this.setIconImage(new ImageIcon("Uno_logo_PNG2.png").getImage());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
