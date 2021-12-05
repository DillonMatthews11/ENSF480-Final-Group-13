package Resources.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Resources.Entities.Landlord;
import Resources.FrontEnd.LandlordView;
import Resources.FrontEnd.LoginView;

public class LoginController {
	private String mode;
	private LoginView theView;
	private DBconnector dB;
	public LoginController(LoginView theView) {
		this.theView = theView;
		this.theView.addModeListener(new ModeListener());
		this.theView.addEntryListener(new EntryListener());
	}
	private boolean validLogin(String email, String pass) {
		return true;
	}
	class ModeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton) e.getSource();
			String selectedMode = temp.getText();
			mode = selectedMode;
			if (selectedMode.equals("Default user")) {
				
			}
			else {
				theView.setEntryView();
			}
			
			
		}
		
	}
	class EntryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(validLogin(theView.getUserName(),theView.getPassword())) {
					theView.dispose();
					if(mode.equals("LandLord")) {
						LandlordView lv = new LandlordView(theView.getUserName());
						Landlord landLord = new Landlord("Badlands","chug", "irelandBelike444@gmail.com", 4.3);
						LandlordController lc = new LandlordController(lv,landLord);
					}
					else if(mode.equals("Renter")) {
						//renter view
					}
					else {
						//manager
					}
				}
				else {
					theView.displayErrorMessage("incorrect email or password");
				}
				
			}
			catch(NumberFormatException n){
				theView.displayErrorMessage("Please populate both fields");
			}
			
		}
		
	}
}
