package Resources.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Resources.Entities.Landlord;
import Resources.FrontEnd.LandlordView;
import Resources.FrontEnd.LoginView;
import Resources.FrontEnd.ManagerView;

public class LandlordController {
    LandlordView theView;
    Landlord landLord;
    public LandlordController(LandlordView theView, Landlord landLord) {
    	this.theView = theView;
    	this.landLord = landLord;
    	this.theView.addLandlordMenuListener(new LandlordMenuListener());
    	
    }
    private void back() {
    	theView.dispose();
		theView = new LandlordView(theView.getEmail());
		LandlordController lc = new LandlordController(theView, landLord);
    }
    class LandlordAddPropertyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton())
				back();
			else {
				String address = theView.getAddress();
				String propType = theView.getPropertyType();
				double bedrooms = Double.parseDouble(theView.getNumBedrooms());
				double bathrooms = Double.parseDouble(theView.getNumBathrooms());
				String furnished = theView.getFurnished();
				String quad = theView.getFurnished();
				LandlordForm lf = new LandlordForm(landLord);
				boolean b = lf.addHouse(address, propType, bedrooms, bathrooms, furnished, quad);
				if(b) {
					theView.displayErrorMessage("Property successfully made");
					back();
				}else {
					theView.displayErrorMessage("Something went wrong");
				}
			}		
		}
    	
    }
    class LandlordFeeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton())
				back();
			else {
				LandlordForm lf = new LandlordForm(landLord);
				if(lf.payFee()) {
					theView.displayErrorMessage("Fee paid");
					landLord.setAmountOwed(0.0);
					
					back();
				}else {
					theView.displayErrorMessage("Payment unsuccessful");
					back();
				}
				
			}
		}
    	
    }
    class LandlordMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == theView.getViewPropertyButton()) {
				landLord.addProperty(1,"7 7th street","house", 3,4,"",true," ","joe", "mama");
				theView.setViewProperties(landLord);
				System.out.println("joe");
				
				
			} else if (e.getSource() == theView.getAddPropertyButton()) {
				theView.setAddPropertyView();
				theView.addAddPropertyListener(new LandlordAddPropertyListener());

			} else if (e.getSource() == theView.getLogoutButton()) {
				theView.dispose();
				LoginView loginView = new LoginView();
				LoginController lc = new LoginController(loginView);
				loginView.setVisible(true);
				
			}else if(e.getSource() == theView.getPayFeesButton()){
				theView.setFeeView(landLord);
				theView.addLandlordFeeListener(new LandlordFeeListener());
			}else if(e.getSource() == theView.getChangeStatusButton()) {
				theView.setChangeStatusView();
				theView.addChangePropertyListener(new ChangeStatusListener());
			}
			
		}
	}
    class ChangeStatusListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton())
				back();
			else {
				int id = Integer.parseInt(theView.getStatusSetId());
				String status = theView.getStatusSet();
				LandlordForm lf = new LandlordForm(landLord);
				if(lf.changePropertyStatus(id, status)) {
					theView.displayErrorMessage("update Successful");
				}
				else {
					theView.displayErrorMessage("Property with that Id doesnt Exist or a Manager has suspended it");
				}
				back();
				
				
			}
			
		}
    	
    }
}