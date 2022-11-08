package gui;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.formdev.flatlaf.FlatDarkLaf;

import controller.Controller;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PanelGradient myPanel;
	private AccountPanel accountPanel;
//	private JButton submit;
	private Controller controller;
	
	public AccountFrame() {
		
		super("Account Frame");
		FlatDarkLaf.setup();
		
		myPanel = new PanelGradient();
		accountPanel = new AccountPanel();
		
		
		controller = new Controller();
		
		accountPanel.setOpaque(false);
		BoxLayout layout = new BoxLayout(accountPanel, BoxLayout.PAGE_AXIS);
		accountPanel.setLayout(layout);
		
		accountPanel.setAccountListener(new AccountListener() {
			@Override
			public void accountEventOccurred(AccountEvent e) {
				controller.addAccount(e);
				accountPanel.updateAccountGuiList(controller);
			}
		});
		
		myPanel.add(accountPanel);
		add(myPanel);
		
		setFrameSettings();
	}
	
	public String getAccountName() {
		return getAccountName();
	}
	
    private void setFrameSettings() {
    	setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(500, 900));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
    }
}
