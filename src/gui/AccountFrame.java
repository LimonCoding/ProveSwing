package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.InsetsUIResource;

import com.formdev.flatlaf.FlatDarkLaf;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	public String accountName = "";
	
	private PanelGradient myPanel;
	private JPanel accountPanel1;
	private JLabel inserisci;
	private JTextField insertName;
	private JButton insertButton;
	private JButton submit;
	
	public AccountFrame() {
		
		super("Account Frame");
		FlatDarkLaf.setup();
		
		myPanel = new PanelGradient();
		accountPanel1 = new JPanel();
		inserisci = new JLabel("Crea un Account: ");
		insertName = new JTextField();
		insertButton = new JButton("Inserisci");
		submit = new JButton("GIOCA");
		
		accountPanel1.setOpaque(false);
		BoxLayout layout = new BoxLayout(accountPanel1, BoxLayout.PAGE_AXIS);
		accountPanel1.setLayout(layout);
		
		fontSettings();
		
		inserisci.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertName.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		accountPanel1.add(Box.createRigidArea(new Dimension(0,250)));
		accountPanel1.add(inserisci);
		accountPanel1.add(Box.createRigidArea(new Dimension(0,30)));
		accountPanel1.add(insertName);
		
		myPanel.add(accountPanel1);
		
		AbstractAction action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if (checkBtn()) {
		    		accountName = insertName.getText();	
					JLabel stampaNome = new JLabel("Benvenuto "+accountName+"!");
					stampaNome.setForeground(Color.BLACK);
					stampaNome.setFont(new Font("Cabin", 30, 30));
					stampaNome.setAlignmentX(Component.CENTER_ALIGNMENT);
					accountPanel1.add(Box.createRigidArea(new Dimension(0,20)));
					accountPanel1.add(stampaNome);
						
					accountPanel1.add(Box.createRigidArea(new Dimension(0,10)));
					submit.setAlignmentX(Component.CENTER_ALIGNMENT);
					accountPanel1.add(submit);
						
					insertName.setText(null);
						
					submit.addActionListener(new ActionListener() {
							
						@Override
						public void actionPerformed(ActionEvent e) {
								new PlayFrame();
								dispose();
						}				
					});
					
				setVisible(true);
			    }
			}
		};
		
		insertButton.setEnabled(false);
		insertName.addActionListener(action);
		
		insertName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkBtn();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkBtn();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkBtn();
            }
        });
		
		insertButton.addActionListener(action);

		accountPanel1.add(Box.createRigidArea(new Dimension(0,10)));
		accountPanel1.add(insertButton);
		add(myPanel);
		
		setFrameSettings();
	}
	
	public String getAccountName() {
		return accountName;
	}
	
    private boolean checkBtn() {
        boolean value = !insertName.getText().trim().isEmpty();
        insertButton.setEnabled(value);
        return value;
    }
    
    private void fontSettings() {
    	inserisci.setFont(new Font("Cabin Bold", 30, 30));
		
		insertName.setMargin(new InsetsUIResource(10, 20, 10, 20));
		
		insertButton.setToolTipText("Clicca per giocare!");
		insertButton.setMargin(new InsetsUIResource(10, 20, 10, 20));
		insertButton.setFont(new Font("Cabin Bold", 30, 30));
		
		submit.setToolTipText("Clicca per giocare!");
		submit.setMargin(new InsetsUIResource(10, 20, 10, 20));
		submit.setFont(new Font("Cabin Bold", 30, 30));
		
		inserisci.setForeground(Color.BLACK);
		inserisci.setFont(new Font("Cabin Bold", 30, 50));
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
