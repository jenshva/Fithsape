package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jens van der Sman
 */
public class MenuLeft extends JPanel{

	public MenuLeft(){
		super();
		setLayout(new GridLayout(3,1, 20,20));
        initComponents();	
	}
	
	private void initComponents() {
        this.setBackground(Color.white);
		addLogo();
		addButtons();	
	}
	
	private void addLogo(){
		JLabel logo = new JLabel();
		logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fitshape.png")));
		logo.setBounds(0,0,269,191);
		add(logo);
	}
	
	private void addButtons(){
		JButton btnBarApp = new JButton();
		btnBarApp.setText("Bar Applicatie");
		add(btnBarApp);
		
		JButton btnAdministartieveApp = new JButton();
		btnAdministartieveApp.setText("Adiministratieve Applicatie");
		add(btnAdministartieveApp);
	}
	
		
}
