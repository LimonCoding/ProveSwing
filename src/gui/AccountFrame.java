package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.plaf.InsetsUIResource;

import com.formdev.flatlaf.FlatDarkLaf;

import controller.Controller;

public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	
	private PanelGradient myPanel;
	private AccountPanel accountPanel;
	private Controller controller;
	private TablePanel tablePanel;
	private JFrame frame;
	
	public AccountFrame() {
		super("Account Frame");
		frame = this;
		FlatDarkLaf.setup();
		
		myPanel = new PanelGradient();
		accountPanel = new AccountPanel();
		tablePanel = new TablePanel();
		controller = new Controller();
		controller.createAccountList();
		tablePanel.setData(controller.getAccounts());
		tablePanel.setOpaque(false);
		
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
		
		JButton submit = new JButton();
        submit.setToolTipText("Clicca per giocare!");
        submit.setIcon(new ImageIcon("ImageLibrary/startButton.png"));
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setContentAreaFilled(false);
        submit.setPreferredSize(new Dimension(100, 50));
        submit.setMargin(new InsetsUIResource(10, 20, 10, 20));
        submit.setFont(new Font("Cabin Bold", 30, 30));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (!controller.getAccounts().isEmpty()) {
                        JTable table = tablePanel.getTable();
                        if (table.getSelectedRow() != -1) {
                            Integer id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
                            dispose();
                            new PlayFrame(controller, id);
                        } else {
                            JOptionPane.showMessageDialog(frame, 
                                    "SELECT AN ACCOUNT TO PLAY!", 
                                    "SELECT ACCOUNT", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, 
                                "INSERT AN ACCOUNT FIRST!", 
                                "INSERT ACCOUNT", JOptionPane.WARNING_MESSAGE);
                    }
            }               
        });
        
        Dimension dim = getPreferredSize();
        dim.width = 1200;
        dim.height = 800;
        tablePanel.setPreferredSize(dim);
		
		myPanel.add(accountPanel, BorderLayout.PAGE_START);
		myPanel.add(Box.createRigidArea(new Dimension(400,50)),BorderLayout.EAST);
		myPanel.add(Box.createRigidArea(new Dimension(400,50)),BorderLayout.WEST);
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
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent we) {
                int result = JOptionPane.showConfirmDialog(frame,
                    "Do you want to Exit ?", "Exit Confirmation : ",
                    JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              }
            });
		pack();
		setMinimumSize(new Dimension(1500, 700));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
    }
}
