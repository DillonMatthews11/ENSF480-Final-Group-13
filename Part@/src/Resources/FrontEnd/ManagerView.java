package Resources.FrontEnd;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import Resources.Entities.*;
import java.util.*;
public class ManagerView extends JFrame{
	
	private String email;
    private JLabel loggedInAs;
    private JButton generateReportButton = new JButton("Generate Report");
    private JButton updateStatusButton = new JButton("Update Property Status");
    private JButton updateFeesButton = new JButton("Update Fees");
    private JButton searchDatabaseButton = new JButton("Search Database");
    private JButton logoutButton = new JButton("Logout");
    private JPanel manPanel;
    private JPanel report;
    private JLabel selectReportPeriodLabel = new JLabel("Please type the report period in days:");
    private JButton createReportButton = new JButton("Generate Report");
    private JTextField selectReportPeriodField = new JTextField(10);
    private JButton backButton = new JButton("Back");
    private JComboBox statusSetter;
    private JTextField statusSetID = new JTextField(20);
    private JButton setStatusButton = new JButton("set Status");
    private JTextField updateFeeCost = new JTextField(20);
    private JTextField updateFeePeriod = new JTextField(20);
    private JButton setFeeButton = new JButton("Update Fees");
    
    public ManagerView(String email){
		this.email = email;
    	this.loggedInAs = new JLabel("Logged In as: "+ email);
    	manPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        manPanel.add(loggedInAs);
        manPanel.add(generateReportButton);
        manPanel.add(updateStatusButton);
        manPanel.add(updateFeesButton);
        manPanel.add(searchDatabaseButton);
        manPanel.add(logoutButton);
        this.setLayout(new GridLayout(3,1));
        this.add(manPanel);
        this.setVisible(true);
	}
    
	public void addManagerMenuListener(ActionListener ManagerMenuListener){
		generateReportButton.addActionListener(ManagerMenuListener);
		updateStatusButton.addActionListener(ManagerMenuListener);
		updateFeesButton.addActionListener(ManagerMenuListener);
		searchDatabaseButton.addActionListener(ManagerMenuListener);
		logoutButton.addActionListener(ManagerMenuListener);
	}
  public void addManagerReportListener(ActionListener ManagerReportListener){
    createReportButton.addActionListener(ManagerReportListener);
    backButton.addActionListener(ManagerReportListener);

  }
  public void addUpdateFeeListener(ActionListener UpdateFeeListener) {
	  setFeeButton.addActionListener(UpdateFeeListener);
	    backButton.addActionListener(UpdateFeeListener);
  }
  public void addUpdateStatusListener(ActionListener UpdateStatusListener) {
	  setStatusButton.addActionListener(UpdateStatusListener);
	  backButton.addActionListener(UpdateStatusListener);
  }
  public void generateReportView(){
    this.remove(manPanel);
	 manPanel.removeAll();
    manPanel = new JPanel();
    manPanel.add(selectReportPeriodLabel);
    manPanel.add(selectReportPeriodField);
    manPanel.add(createReportButton);
    manPanel.add(backButton);
    this.add(manPanel);
    this.setVisible(true);

  }
  public void updateFeeView() {
	  this.remove(manPanel);
	  manPanel.removeAll();
	  manPanel = new JPanel();
	  manPanel.add(new JLabel("Select Fee Amount "));
	  manPanel.add(updateFeeCost);
	  manPanel.add(new JLabel("Select Fee Period "));
	  manPanel.add(updateFeePeriod);
	  manPanel.add(setFeeButton);
	  manPanel.add(backButton);
	  this.add(manPanel);
	  this.setVisible(true);
  }
  public void updateStatusView() {
	  this.remove(manPanel);
	  manPanel.removeAll();
	  manPanel = new JPanel();
	  manPanel.add(new JLabel("Select Property ID to change: "));
	  manPanel.add(statusSetID);
	  manPanel.add(new JLabel("change Status: "));
	  String[] s1 = {"Rented", "Active","Suspended","Cancelled"};
	  statusSetter = new JComboBox(s1);
	  manPanel.add(statusSetter);
	  manPanel.add(setStatusButton);
	  manPanel.add(backButton);
	  this.add(manPanel);
	  
	  this.setVisible(true);
  }
  public void generateReport(int[] stats, Vector<Property> rentedProperties){
	
    if(report != null) {
    	report.removeAll();
    	this.remove(report);
    }
    report = new JPanel();
    report.add(new JLabel("Number of Houses Listed: "+ stats[0]));
    report.add(new JLabel("Number of Houses Rented: "+ stats[1]));
    report.add(new JLabel("Number of Total Listings: "+ stats[2]));
    report.add(new JLabel("All rented houses in the Period: "));
    for(Property p : rentedProperties){
      String s = "";
      s+= p.getAddress();
      s+= " ID: ";
      s+= p.getID();
      s+= " Landlord Name: ";
      s+= p.getOwnerFirstName();
      s+= p.getOwnerLastName();
      report.add(new JLabel(s));
      
    }
    this.add(report);
    this.setVisible(true);
  }
  public String getUpdateFeeCost() {
	  return updateFeeCost.getText();
  }
  public String getUpdateFeePeriod() {
	  return updateFeePeriod.getText();
  }
  public String getStatusSetId() {
	  return statusSetID.getText();
  }
  public String getStatusSet() {
	  return statusSetter.getSelectedItem().toString();
  }
  public String getEmail() {
	  return email;
  }
  public String getReportPeriod(){
    return selectReportPeriodField.getText();
  }
  public JButton getGenerateReportButton(){
    return generateReportButton;
  }
  public JButton getUpdateStatusButton(){
    return updateStatusButton;
  }
  public JButton getSearchDatabaseButton(){
    return generateReportButton;
  }
  public JButton getUpdateFeeButton(){
    return updateFeesButton;
  }
  public JButton getLogoutButton(){
    return logoutButton;
  }
  public JButton getBackButton(){
    return backButton;
  }
  public void displayErrorMessage(String errorMessage) {
  	JOptionPane.showMessageDialog(this, errorMessage);
  }
  
}