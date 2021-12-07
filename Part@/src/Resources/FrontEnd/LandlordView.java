package Resources.FrontEnd;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandlordView extends JFrame{
    private String email;
    private JLabel loggedInAs;
    private JButton addPropertyButton = new JButton("Add Property");
    private JButton viewPropertyButton = new JButton("View Properties");
    private JButton payFees = new JButton("Pay Fees");
    private JButton logoutButton = new JButton("Logout");
    private JPanel lanPanel;
    public LandlordView(String email) {
    	this.email = email;
    	this.loggedInAs = new JLabel("Logged In as: "+ email);
    	lanPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        lanPanel.add(loggedInAs);
        lanPanel.add(addPropertyButton);
        lanPanel.add(viewPropertyButton);
        lanPanel.add(payFees);
        lanPanel.add(logoutButton);
        this.add(lanPanel);
        this.setVisible(true);
    }
    public void addLandlordMenuListener(ActionListener landLordMenuListener) {
    	addPropertyButton.addActionListener(landLordMenuListener);
    	viewPropertyButton.addActionListener(landLordMenuListener);      
    	logoutButton.addActionListener(landLordMenuListener);   	
    }
    public JButton getAddPropertyButton() {
        return addPropertyButton;
    }
    public JButton getViewPropertyButton() {
        return viewPropertyButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
}