package Resources.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Resources.Entities.Manager;
import Resources.FrontEnd.LoginView;
import Resources.FrontEnd.ManagerView;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import Resources.Entities.*;

public class ManagerController{
	ManagerView theView;
    Manager manager;
	DBconnector db;
    public ManagerController(ManagerView theView, Manager manager) {
    	this.theView = theView;
    	this.manager = manager;
    	this.theView.addManagerMenuListener(new ManagerMenuListener());
		
    }
   
    class ManagerMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == theView.getGenerateReportButton())
			{
				
				theView.generateReportView();
				theView.addManagerReportListener(new ManagerReportListener());
				
			}else if(e.getSource() == theView.getUpdateStatusButton()){
				
				theView.addUpdateStatusListener(new UpdateStatusListener());
				theView.updateStatusView();
				
			}else if(e.getSource() == theView.getSearchDatabaseButton()){
				
			}else if(e.getSource() == theView.getUpdateFeeButton()){
				theView.addUpdateFeeListener(new UpdateFeeListener());
				theView.updateFeeView();
				
			}else if(e.getSource() == theView.getLogoutButton()){
				theView.dispose();
				LoginView loginView = new LoginView();
				LoginController lc = new LoginController(loginView);
				loginView.setVisible(true);
			}
		}
		
	}
    private void back() {
    	theView.dispose();
		theView = new ManagerView(theView.getEmail());
		ManagerController mv = new ManagerController(theView, manager);
    }
    class UpdateFeeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton())
				back();
			else {
				int feeCost = Integer.parseInt(theView.getUpdateFeeCost());
				int feePeriod = Integer.parseInt(theView.getUpdateFeePeriod());
				ManagerForm mf = new ManagerForm();
				if(mf.updateFee(feeCost, feePeriod)) {
					theView.displayErrorMessage("update Successful");
				}
				else {
					theView.displayErrorMessage("update Unsuccessful");
				}
				back();
			}
			
		}
    	
    }
    class UpdateStatusListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton())
				back();
			else {
				int selectedID = Integer.parseInt(theView.getStatusSetId());
				String status = theView.getStatusSet();
				ManagerForm mf = new ManagerForm();
				if(mf.updateStatus(selectedID, status)) {
					theView.displayErrorMessage("update Successful");
				}
				else {
					theView.displayErrorMessage("Property with that Id doesnt Exist");
				}
				back();
				
			}
			
		}
    	
    }
	class ManagerReportListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton()){
				back();
			}
			else{
//				GenerateReportForm grm = new GenerateReportForm(Integer.parseInt(theView.getReportPeriod()));
//				int[] stats = grm.generateStats();
//				Vector<Property> rentedProperties = grm.generateRentedProperties;
				int[] stats = {1,22,3};
				
				Vector<Property> rentedProperties = new Vector<Property>();
				rentedProperties.add(new Property(1,"7 7th street","house", 3,4,"",true," ","joe", "mama"));
				rentedProperties.add(new Property(2,"8 8th street","Appartment", 3,4,"",true," ","rufus", "smith"));
				theView.generateReport(stats, rentedProperties);
			}

		}
	}
    
}