package Resources.Controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Resources.Entities.Landlord;
import Resources.FrontEnd.LandlordView;

public class LandlordController {
    LandlordView theView;
    Landlord landLord;
    public LandlordController(LandlordView theView, Landlord landLord) {
    	this.theView = theView;
    	this.landLord = landLord;
    	this.theView.addLandlordMenuListener(new LandlordMenuListener());
    	
    }
    class LandlordMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == theView.getViewPropertyButton()) {

			} else if (e.getSource() == theView.getAddPropertyButton()) {

			} else if (e.getSource() == theView.getLogoutButton()) {
				
			}
		}
	}
}