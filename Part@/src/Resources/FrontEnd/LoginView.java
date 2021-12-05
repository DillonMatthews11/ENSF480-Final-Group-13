package Resources.FrontEnd;
import java.awt.event.ActionListener;

import javax.swing.*;
public class LoginView extends JFrame{
    private JLabel loginMenu = new JLabel("Choose what mode:");
    private JButton renterButton = new JButton("Renter");
    private JButton landlordButton = new JButton("LandLord");
    private JButton defaultButton = new JButton("Default User");
    private JButton managerButton = new JButton("Manager");
    private JLabel userName = new JLabel("Email: ");
    private JTextField userField = new JTextField(30);
    private JLabel password= new JLabel("PassWord: ");
    private JPasswordField passField = new JPasswordField(30);
    private JButton submit = new JButton("submit");
    JPanel logPanel;

    public LoginView(){
        logPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        logPanel.add(loginMenu);
        logPanel.add(renterButton);
        logPanel.add(landlordButton);
        logPanel.add(managerButton);
        logPanel.add(defaultButton);
        this.add(logPanel);
    }
    public void addModeListener(ActionListener listenForMode) {
    	landlordButton.addActionListener(listenForMode);
    	renterButton.addActionListener(listenForMode);
    	managerButton.addActionListener(listenForMode);
    	defaultButton.addActionListener(listenForMode);
    	
    }
    public void addEntryListener(ActionListener listenForEntry) {
    	submit.addActionListener(listenForEntry);
    }
    public void setEntryView() {
    	logPanel.removeAll();
    	logPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        logPanel.add(userName);
        logPanel.add(userField);
        logPanel.add(password);
        logPanel.add(passField);
        logPanel.add(submit);
        this.add(logPanel);
        this.setVisible(true);
    }
    
    public String getUserName() {
    	return userField.getText();
    }
    public String getPassword() {
    	return passField.getText();
    }
    public void displayErrorMessage(String errorMessage) {
    	JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    
}