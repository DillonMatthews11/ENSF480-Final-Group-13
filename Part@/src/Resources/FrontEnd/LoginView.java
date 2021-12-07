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
    private JButton newUserButton = new JButton("Create New Account");
    private JPasswordField passField = new JPasswordField(30);
    private JButton submit = new JButton("submit");
    private JButton create = new JButton("Create");
    private JComboBox newUserType;
    private JTextField firstName = new JTextField(25);
    private JTextField lastName = new JTextField(25);
    private JPanel logPanel;
    private JButton backButton = new JButton("Back");
    private JComboBox accountType;

    public LoginView(){
        logPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        logPanel.add(loginMenu);
        logPanel.add(renterButton);
        logPanel.add(landlordButton);
        logPanel.add(managerButton);
        logPanel.add(defaultButton);
        logPanel.add(newUserButton);
    
        this.add(logPanel);
    }
    public void addModeListener(ActionListener listenForMode) {
    	landlordButton.addActionListener(listenForMode);
    	renterButton.addActionListener(listenForMode);
    	managerButton.addActionListener(listenForMode);
    	defaultButton.addActionListener(listenForMode);
    	newUserButton.addActionListener(listenForMode);
    }
    public void addEntryListener(ActionListener listenForEntry) {
    	submit.addActionListener(listenForEntry);
    	backButton.addActionListener(listenForEntry);
    }
    public void addCreateListener(ActionListener listenForCreate){
        create.addActionListener(listenForCreate);
        backButton.addActionListener(listenForCreate);
    }
    public void setNewUserView(){
        logPanel.removeAll();
        logPanel = new JPanel();
        logPanel.add(new JLabel("Select Account Type: "));
        String[] s = {"Renter","Landlord"};
        accountType = new JComboBox(s);
        logPanel.add(accountType);
        logPanel.add(new JLabel("Email: "));
        logPanel.add(userField);
        logPanel.add(new JLabel("Password"));
        logPanel.add(passField);
        logPanel.add(new JLabel("First Name: "));
        logPanel.add(firstName);
        logPanel.add(new JLabel("Last Name: "));
        logPanel.add(lastName);
        logPanel.add(create);
        logPanel.add(backButton);
        this.add(logPanel);
        this.setVisible(true);
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
        logPanel.add(backButton);
        this.add(logPanel);
        this.setVisible(true);
    }
    public String getFirst(){
        return firstName.getText();
    }
    public String getLast(){
        return lastName.getText();
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
    public JButton getBackButton(){
        return backButton;
      }
    public String getAccountType() {
    	return accountType.getSelectedItem().toString();
    }
    
}