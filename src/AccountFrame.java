import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;

@SuppressWarnings("serial")
public class AccountFrame extends JFrame {
	
	private static final ImageIcon iconApp = new ImageIcon("ImageLibrary/Uno_logo_PNG2.png");
	public String accountName = "";
	
	public AccountFrame() {
		
		super("Account Frame");
		FlatDarkLaf.setup();
		
		JPanel myPanel = new PanelGradient();
		
		JPanel accountPanel1 = new JPanel();
		accountPanel1.setOpaque(false);
		BoxLayout layout = new BoxLayout(accountPanel1, BoxLayout.PAGE_AXIS);
		accountPanel1.setLayout(layout);
		
		JLabel inserisci = new JLabel("Inserisci il nome utente: ");
		JTextField insertName = new JTextField();
		JButton submit = new JButton("Avanti");
		
		inserisci.setForeground(Color.BLACK);
		inserisci.setFont(new Font("Cabin Bold", 30, 50));
		
		inserisci.setAlignmentX(Component.CENTER_ALIGNMENT);
		insertName.setAlignmentX(Component.CENTER_ALIGNMENT);
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		accountPanel1.add(Box.createRigidArea(new Dimension(0,250)));
		accountPanel1.add(inserisci);
		accountPanel1.add(Box.createRigidArea(new Dimension(0,30)));
		accountPanel1.add(insertName);
		accountPanel1.add(Box.createRigidArea(new Dimension(0,180)));
		accountPanel1.add(submit);
		myPanel.add(accountPanel1);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (!insertName.getText().isEmpty()){
	        		
					accountName = insertName.getText();	
//					JLabel stampaNome = new JLabel("Benvenuto "+insertName.getText()+"!");
//					stampaNome.setForeground(Color.BLACK);
//					stampaNome.setFont(new Font("Cabin", 30, 30));
//					myPanel.add(stampaNome);
//					insertName.setVisible(false);
//					setVisible(true);
					new PlayFrame();
					dispose();
					
				}				
			}
		});

		add(myPanel);
		setIconImage(iconApp.getImage());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
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
