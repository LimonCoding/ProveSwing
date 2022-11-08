package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private AccountFrame frame;
	
	public AccountPanel(AccountFrame frame) {
		this.frame = frame;
		
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
//		int level = controller.getAccounts().get(0).getLevel();
		
		ButtonGroup players = new ButtonGroup();
		
		controller.getAccounts().stream().forEach(
				(accListTemp) -> {
					JRadioButton list = new JRadioButton(accListTemp.getAlias() + " - Level: " + accListTemp.getLevel());
					list.setFont(new Font("Cabin", 30, 30));
					list.setAlignmentX(Component.CENTER_ALIGNMENT);
					list.setForeground(Color.BLACK);
					list.setSelected(true);
					players.add(list);
					add(list);
				}
		);
		
		submit = new JButton("GIOCA");
		submit.setToolTipText("Clicca per giocare!");
		submit.setMargin(new InsetsUIResource(10, 20, 10, 20));
		submit.setFont(new Font("Cabin Bold", 30, 30));
		add(Box.createRigidArea(new Dimension(0,10)));
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		if (controller.getAccounts() != null) {
			add(submit);
		}
			
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			        frame.dispose();
					new PlayFrame(alias);
			}				
		});
		this.revalidate();
    }
}
