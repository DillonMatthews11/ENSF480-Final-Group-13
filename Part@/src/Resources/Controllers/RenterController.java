package Resources.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

import Resources.Entities.*;
import Resources.FrontEnd.*;

public class RenterController{
    private RenterView theView;
    private Renter renter;
    private Vector<Property> searchedProperties;
    private Property contactProperty;
    public RenterController(RenterView rv, Renter renter) {
        this.theView = rv;
        this.renter = renter;
        theView.addRenterMenuListener(new RenterMenuListener());
    }
    
    private void back() {
    	theView.dispose();
		theView = new RenterView(theView.getEmail());
		RenterController rc = new RenterController(theView, renter);
    }
    class SearchListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton()) {
				back();
			}
			else {
				Vector<JButton> buttons = theView.getContactButtons();
				int index = 0;
				boolean found = false;
				for(JButton b : buttons) {
					if(b == e.getSource()) {
						break;
					}
						
					index++;
				}
				contactProperty = searchedProperties.get(index);
				theView.setMessageView();
				theView.addMessageListener(new MessageListener());
			}
			
		}
    	
    }
    class MessageListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			RenterForm rf = new RenterForm(renter);
			if(rf.sendMessage(contactProperty, theView.getMessage())) {
				theView.displayErrorMessage("message sent successfully");
			}
			else {
				theView.displayErrorMessage("message sent unsuccessfully");
			}
			back();
		}
    	
    }
    class UpdatePreferencesListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String type = theView.getPropertyType();
			String bedrooms = theView.getNumBedrooms();
			String bathrooms = theView.getNumBathrooms();
			String quadrant = theView.getQuadrant();
			String furn = theView.getFurnished();
			Vector<String> v = new Vector<String>();
			v.add(type);
			v.add(bedrooms);
			v.add(bathrooms);
			v.add(furn);
			v.add(quadrant);
			renter.setPrefs(v);
			RenterForm rf = new RenterForm(renter);
			rf.setPreferences(v);
			theView.displayErrorMessage("preferences saved");
			back();
		}
    	
    }
    class RenterMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getSearchButton()) {
				RenterForm rf = new RenterForm(renter);
				searchedProperties = rf.getSearchedProperties();
				theView.setSearchView(searchedProperties);
				theView.addSearchListener(new SearchListener());
			}else if(e.getSource() == theView.getNotificationButton()) {
				
			}else if(e.getSource() == theView.getLogoutButton()) {
				theView.dispose();
				LoginView loginView = new LoginView();
				LoginController lc = new LoginController(loginView);
				loginView.setVisible(true);
			}else if(e.getSource() == theView.getUpdatePreferencesButton()) {
				theView.addUpdatePreferencesListener(new UpdatePreferencesListener());
				theView.setPreferencesView();
				
			}
			
		}
    	
    }
}