package Resources.FrontEnd;

import javax.swing.*;

import java.awt.event.ActionListener;

public class RenterView extends JFrame{

    private String email;
    private JLabel loggedInAs;
    private JButton updatePreferencesButton = new JButton("Update Prefered Filters");
    private JButton logoutButton = new JButton("Logout");
    private JPanel rentPanel;

    public RenterView(String email) {
        this.email = email;
        this.loggedInAs = new JLabel("Logged In as: "+ email);
        rentPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        rentPanel.add(loggedInAs);
        rentPanel.add(updatePreferencesButton);
        this.add(rentPanel);
        this.setVisible(true);
    }

    public void addRenterMenuListener(ActionListener RenterMenuListener){
		updatePreferencesButton.addActionListener(RenterMenuListener);
        logoutButton.addActionListener(RenterMenuListener);
	}
    public void generateUpdatePreferencesView(){
        rentPanel.removeAll();
    }    
}