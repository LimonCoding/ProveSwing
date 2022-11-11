package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.plaf.InsetsUIResource;

import com.formdev.flatlaf.FlatDarkLaf;

import controller.Controller;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PanelGradient myPanel;
	private AccountPanel accountPanel;
//	private JButton submit;
	private Controller controller;
	private TablePanel tablePanel;
	
	
	public AccountFrame() {
		super("Account Frame");
		FlatDarkLaf.setup();
		
		myPanel = new PanelGradient();
		accountPanel = new AccountPanel(this);
		tablePanel = new TablePanel();
		controller = new Controller();
		controller.createAccountList();
		tablePanel.setData(controller.getAccounts());
		
		BorderLayout mainLayout = new BorderLayout();
		myPanel.setLayout(mainLayout);
		
		accountPanel.setOpaque(false);
		BoxLayout layout = new BoxLayout(accountPanel, BoxLayout.PAGE_AXIS);
		accountPanel.setLayout(layout);
		
		accountPanel.setAccountListener(new AccountListener() {
			@Override
			public void accountEventOccurred(AccountEvent e) {
				controller.addAccount(e);
				accountPanel.updateAccountGuiList(controller, tablePanel);
			}
		});
		
		JButton submit = new JButton("GIOCA");
        submit.setToolTipText("Clicca per giocare!");
        submit.setMargin(new InsetsUIResource(10, 20, 10, 20));
        submit.setFont(new Font("Cabin Bold", 30, 30));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String alias = controller.getAccounts().get(0).getAlias();
                    dispose();
                    new PlayFrame(alias);
            }               
        });
		
		myPanel.add(accountPanel, BorderLayout.PAGE_START);
		myPanel.add(Box.createRigidArea(new Dimension(0,10)),BorderLayout.CENTER);
		myPanel.add(submit, BorderLayout.PAGE_END);
		myPanel.add(tablePanel, BorderLayout.CENTER);
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
