import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	public String accountName = "";
	
	private PanelGradient myPanel;
	private JPanel accountPanel1;
	
	public AccountFrame() {
		
		super("Account Frame");
		FlatDarkLaf.setup();
		
		myPanel = new PanelGradient();
		
		accountPanel1 = new JPanel();
		accountPanel1.setOpaque(false);
		BoxLayout layout = new BoxLayout(accountPanel1, BoxLayout.PAGE_AXIS);
		accountPanel1.setLayout(layout);
		
		JLabel inserisci = new JLabel("Inserisci il nome utente: ");
		JTextField insertName = new JTextField();
		JButton insertButton = new JButton("Inserisci");
		JButton submit = new JButton("Avanti");
		
		inserisci.setForeground(Color.BLACK);
		inserisci.setFont(new Font("Cabin Bold", 30, 50));
		
		inserisci.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertName.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		accountPanel1.add(Box.createRigidArea(new Dimension(0,250)));
		accountPanel1.add(inserisci);
		accountPanel1.add(Box.createRigidArea(new Dimension(0,30)));
		accountPanel1.add(insertName);
		
		myPanel.add(accountPanel1);
		
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!insertName.getText().isEmpty()){
	        		
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
		});

		accountPanel1.add(Box.createRigidArea(new Dimension(0,10)));
		accountPanel1.add(insertButton);
		add(myPanel);
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public String getAccountName() {
		return accountName;
	}
}
