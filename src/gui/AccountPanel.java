package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.InsetsUIResource;

import controller.Controller;

public class AccountPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel inserisci;
	private JTextField insertName;
	private JButton insertButton;
	private String accountName = "";
	private AccountListener accountListener;
	private JButton submit;
	
	public AccountPanel() {
		
		inserisci = new JLabel("Crea un Account: ");
		insertName = new JTextField();
		insertButton = new JButton("Inserisci");
		
		inserisci.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertName.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(0,250)));
		add(inserisci);
		add(Box.createRigidArea(new Dimension(0,30)));
		add(insertName);
		
		fontSettings();
		
		AbstractAction action = new AbstractAction()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if (checkBtn()) {
		    		accountName = insertName.getText();
		    		
		    		AccountEvent ev = new AccountEvent(this, accountName, 0);
		    		
		    		if (accountListener != null) {
						accountListener.accountEventOccurred(ev);
					}
		    		
		    		insertName.setText(null);
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

		add(Box.createRigidArea(new Dimension(0,10)));
		add(insertButton);
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
		
		inserisci.setForeground(Color.BLACK);
		inserisci.setFont(new Font("Cabin Bold", 30, 50));
    }
	
    public void setAccountListener(AccountListener accountListener) {
    	this.accountListener = accountListener;
    }
    
    public void updateAccountGuiList(Controller controller) {

		String alias = controller.getAccounts().get(0).getAlias();
		int level = controller.getAccounts().get(0).getLevel();
		
		JLabel stampaNome = new JLabel("Benvenuto "+alias+"!");
		JLabel stampaLivello = new JLabel("Livello: "+level);
		stampaNome.setForeground(Color.BLACK);
		stampaNome.setFont(new Font("Cabin", 30, 30));
		stampaNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		stampaLivello.setForeground(Color.BLACK);
		stampaLivello.setFont(new Font("Cabin", 30, 30));
		stampaLivello.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(stampaNome);
		add(stampaLivello);
		
		submit = new JButton("GIOCA");
		submit.setToolTipText("Clicca per giocare!");
		submit.setMargin(new InsetsUIResource(10, 20, 10, 20));
		submit.setFont(new Font("Cabin Bold", 30, 30));
		add(Box.createRigidArea(new Dimension(0,10)));
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(submit);
			
		submit.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
					new PlayFrame(alias);
			}				
		});
    }
}
