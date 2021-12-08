package Resources.FrontEnd;

import javax.swing.*;

import Resources.Entities.Property;

import java.awt.event.ActionListener;
import java.util.Vector;

public class RenterView extends JFrame{

    private String email;
    private JLabel loggedInAs;
    private JButton updatePreferencesButton = new JButton("Update Prefered Filters");
    private JButton logoutButton = new JButton("Logout");
    private JButton searchButton = new JButton("search");
    private JButton notificationButton = new JButton("Notifications");
    private JPanel rentPanel;
    private JTextField address = new JTextField(40);
    private JTextField numBathrooms = new JTextField(5);
    private JTextField numBedrooms = new JTextField(5);
    private JComboBox propertyType;
    private JComboBox furnished;
    private JComboBox quadrant;
    private JButton updatePreferences = new JButton("Update Preferences");
    Vector<JButton> contactButtons;
    private JButton backButton = new JButton("back");
    private JButton sendMessage = new JButton("send message");
    private JTextArea messageArea = new JTextArea(20,40);
    
    

    public RenterView(String email) {
        this.email = email;
        this.loggedInAs = new JLabel("Logged In as: "+ email);
        rentPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        rentPanel.add(loggedInAs);
        rentPanel.add(updatePreferencesButton);
        rentPanel.add(searchButton);
        rentPanel.add(notificationButton);
        rentPanel.add(logoutButton);
        this.add(rentPanel);
        this.setVisible(true);
    }
    public void setMessageView() {
    	this.remove(rentPanel);
    	rentPanel.removeAll();
    	rentPanel = new JPanel();
    	rentPanel.add(new JLabel("Type message to send to landlord"));
    	rentPanel.add(messageArea);
    	rentPanel.add(sendMessage);
    	rentPanel.add(backButton);
    	this.add(rentPanel);
    	this.setVisible(true);
    	
    }
    public void addMessageListener(ActionListener ml) {
    	sendMessage.addActionListener(ml);
    }
    public void setSearchView(Vector<Property> properties) {
    	contactButtons = new Vector<JButton>();
    	this.remove(rentPanel);
    	rentPanel.removeAll();
    	rentPanel = new JPanel();
    	rentPanel.add(backButton);
    	for(Property p : properties) {
    		rentPanel.add(new JLabel(p.getAll()));
    		JButton button = new JButton("contact landlord");
    		rentPanel.add(button);
    		contactButtons.add(button);
    		
    	}
    	this.add(rentPanel);
    	this.setVisible(true);
    }
    public void addSearchListener(ActionListener sl) {
    	backButton.addActionListener(sl);
    	for(JButton b : contactButtons) {
    		b.addActionListener(sl);
    	}
    }
    public void setPreferencesView() {
    	this.remove(rentPanel);
    	rentPanel.removeAll();
    	rentPanel = new JPanel();
    	
    	String[] s = {"Town House","Detached House", "Apartment","Condominium","Corporate","Other"};
    	propertyType = new JComboBox(s);
    	rentPanel.add(propertyType);
    	rentPanel.add(new JLabel("Number of Bedrooms: "));
    	rentPanel.add(numBedrooms);
    	rentPanel.add(new JLabel("Number of Bedrooms: "));
    	rentPanel.add(numBathrooms);
    	String[] f = {"Furnished","Unfirnished"};
    	furnished = new JComboBox(f);
    	rentPanel.add(furnished);
    	String[] l = {"SW","NW","NE","SE"};
    	
    	quadrant = new JComboBox(l);
    	rentPanel.add(quadrant);
    	rentPanel.add(updatePreferences);
    	this.add(rentPanel);
		this.setVisible(true);
    }
    
    public void addUpdatePreferencesListener(ActionListener upl) {
    	updatePreferences.addActionListener(upl);
    }
    public void addRenterMenuListener(ActionListener RenterMenuListener){
		updatePreferencesButton.addActionListener(RenterMenuListener);
		searchButton.addActionListener(RenterMenuListener);
		notificationButton.addActionListener(RenterMenuListener);
        logoutButton.addActionListener(RenterMenuListener);
	}
    public void generateUpdatePreferencesView(){
        rentPanel.removeAll();
    }
    public JButton getSearchButton() {
    	return searchButton;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
    public JButton getNotificationButton() {
        return notificationButton;
    }
    public JButton getUpdatePreferencesButton() {
        return updatePreferencesButton;
    }
    public String getNumBathrooms() {
    	return numBathrooms.getText();
    	
    }
    public String getNumBedrooms() {
    	return numBedrooms.getText();
    
    }
    public String getPropertyType() {
    	return propertyType.getSelectedItem().toString();
    	
    }
    public String getFurnished() {
    	return furnished.getSelectedItem().toString();
    	
    }
    public String getQuadrant() {
    	return quadrant.getSelectedItem().toString();
    	
    }
    public void displayErrorMessage(String errorMessage) {
    	JOptionPane.showMessageDialog(this, errorMessage);
    }
    public String getEmail() {
    	return email;
    }
    public JButton getBackButton() {
    	return backButton;
    }
    public Vector<JButton> getContactButtons(){
    	return contactButtons;
    }
    public String getMessage(){
    	return messageArea.getText();
    }
}