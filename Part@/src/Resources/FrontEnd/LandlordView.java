package Resources.FrontEnd;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Resources.Entities.Landlord;
import Resources.Entities.Property;

public class LandlordView extends JFrame{
    private String email;
    private JLabel loggedInAs;
    private JButton addPropertyButton = new JButton("Add Property");
    private JButton viewPropertyButton = new JButton("View Properties");
    private JButton payFees = new JButton("Pay Fees");
    private JButton changePropertyStatusButton = new JButton("change status Listing");
    private JButton logoutButton = new JButton("Logout");
    private JPanel lanPanel;
    private JTextField payFeeField = new JTextField(20);
    private JButton submitFundsButton = new JButton("submit funds");
    private JButton backButton = new JButton("Back");
    private JButton addHouseButton = new JButton("Add Property and Pay fee");
    private JTextField address = new JTextField(40);
    private JTextField numBathrooms = new JTextField(5);
    private JTextField numBedrooms = new JTextField(5);
    private JComboBox propertyType;
    private JComboBox furnished;
    private JComboBox quadrant;
    private JComboBox statusSetter;
    private JTextField statusSetID = new JTextField(20);
    private JButton setStatusButton = new JButton("set Status");
    JPanel viewPropertiesPanel;
    public LandlordView(String email) {
    	this.email = email;
    	this.loggedInAs = new JLabel("Logged In as: "+ email);
    	lanPanel = new JPanel();
    	this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        lanPanel.add(loggedInAs);
        lanPanel.add(addPropertyButton);
        lanPanel.add(viewPropertyButton);
        lanPanel.add(payFees);
        lanPanel.add(changePropertyStatusButton);
        lanPanel.add(logoutButton);
        
        this.add(lanPanel);
        this.setVisible(true);
    }public void setViewProperties(Landlord landlord){
    	viewPropertiesPanel = new JPanel();
    	Vector<Property> properties = landlord.getOwnedProperties();
    	for(Property p : properties) {
    		viewPropertiesPanel.add(new JLabel("Address: "+p.getAddress()+" type: "+p.getPropertyType()+" Status: "+p.getPropertyStatus()));
    	}
    	this.add(viewPropertiesPanel);
    	this.setVisible(true);
    	
    	
    }
    public void setChangeStatusView() {
    	if(viewPropertiesPanel != null) {
    		viewPropertiesPanel.removeAll();
    		
    	}
  	  this.remove(lanPanel);
  	  lanPanel.removeAll();
  	  lanPanel = new JPanel();
  	  lanPanel.add(new JLabel("Select Property ID to change: "));
  	  lanPanel.add(statusSetID);
  	  lanPanel.add(new JLabel("change Status: "));
  	  String[] s1 = {"Rented", "Active","Cancelled"};
  	  statusSetter = new JComboBox(s1);
  	  lanPanel.add(statusSetter);
  	  lanPanel.add(setStatusButton);
  	  lanPanel.add(backButton);
  	  
  	  this.add(lanPanel);
  	  
  	  this.setVisible(true);
    }
    public void addChangePropertyListener(ActionListener UpdateStatusListener) {
  	  setStatusButton.addActionListener(UpdateStatusListener);
  	  backButton.addActionListener(UpdateStatusListener);
    }
    public void setAddPropertyView() {
    	if(viewPropertiesPanel != null) {
    		viewPropertiesPanel.removeAll();
    		
    	}
    	this.remove(lanPanel);
    	lanPanel.removeAll();
    	lanPanel = new JPanel();
    	lanPanel.add(new JLabel("Address: "));
    	lanPanel.add(address);
    	String[] s = {"Town House","Detached House", "Apartment","Condominium","Corporate","Other"};
    	propertyType = new JComboBox(s);
    	lanPanel.add(propertyType);
    	lanPanel.add(new JLabel("Number of Bedrooms: "));
    	lanPanel.add(numBedrooms);
    	lanPanel.add(new JLabel("Number of Bedrooms: "));
    	lanPanel.add(numBathrooms);
    	String[] f = {"Furnished","Unfirnished"};
    	furnished = new JComboBox(f);
    	lanPanel.add(furnished);
    	String[] l = {"SW","NW","NE","SE"};
    	
    	quadrant = new JComboBox(l);
    	lanPanel.add(quadrant);
    	lanPanel.add(addHouseButton);
    	lanPanel.add(backButton);
    	this.add(lanPanel);
		this.setVisible(true);
    }
    public void setFeeView(Landlord landlord) {
    	if(viewPropertiesPanel != null) {
    		viewPropertiesPanel.removeAll();
    		
    	}
    	this.remove(lanPanel);
    	lanPanel.removeAll();
    	lanPanel = new JPanel();
    	lanPanel.add(new JLabel("you owe "+landlord.getAmountOwed()));
    	lanPanel.add(new JLabel("click to pay fee"));
    	lanPanel.add(submitFundsButton);
    	lanPanel.add(backButton);
		this.add(lanPanel);
		this.setVisible(true);
    }
    public void addAddPropertyListener(ActionListener AddPropertyListener) {
    	addHouseButton.addActionListener(AddPropertyListener);
    	backButton.addActionListener(AddPropertyListener);
    }
    public void addLandlordFeeListener(ActionListener LandlordFeeListener) {
    	backButton.addActionListener(LandlordFeeListener);
    	submitFundsButton.addActionListener(LandlordFeeListener);
    }
    public void addLandlordMenuListener(ActionListener landLordMenuListener) {
    	addPropertyButton.addActionListener(landLordMenuListener);
    	viewPropertyButton.addActionListener(landLordMenuListener);   
    	payFees.addActionListener(landLordMenuListener);
    	changePropertyStatusButton.addActionListener(landLordMenuListener);
    	logoutButton.addActionListener(landLordMenuListener);   	
    }
    public JButton getChangeStatusButton() {
    	return changePropertyStatusButton;
    }
    public String getAddress() {
    	return address.getText();
    	
    }
    public String getNumBathrooms() {
    	return numBathrooms.getText();
    	
    }
    public String getNumBedrooms() {
    	return numBedrooms.getText();
    	
    }
    public String getStatusSetId() {
  	  return statusSetID.getText();
    }
    public String getStatusSet() {
  	  return statusSetter.getSelectedItem().toString();
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
    public void addLandlordAddHouseListener(ActionListener LandlordAddHouseListener) {
    	backButton.addActionListener(LandlordAddHouseListener);
    	
    }
    public String getEmail() {
    	return email;
    }
    public JButton getAddPropertyButton() {
        return addPropertyButton;
    }
    public JButton getViewPropertyButton() {
        return viewPropertyButton;
    }
    public JButton getPayFeesButton() {
    	return payFees;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
    public JButton getBackButton() {
    	return backButton;
    }
    public void displayErrorMessage(String errorMessage) {
    	JOptionPane.showMessageDialog(this, errorMessage);
    }
    
}