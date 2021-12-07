package Resources.Controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

import java.security.*;
import java.sql.*;
import java.util.*;

import javax.swing.JButton;

import Resources.Entities.*;
import Resources.FrontEnd.*;


public class LoginController {
	private String mode;
	private LoginView theView;
	private DBconnector dB;
	private String fName;
	private String lName;
	private String email;
	public LoginController(LoginView theView) {
		this.theView = theView;
		this.theView.addModeListener(new ModeListener());
		
		
//		try {
//			dB.connectDatabase();
//		} catch (SQLException s) {
//			System.out.println("Could not connect to the database");
//		}
	}
	private void back() {
		theView.dispose();
		theView = new LoginView();
		LoginController mv = new LoginController(theView);
		theView.setVisible(true);
	}
	private boolean validLogin(String email, String pass) throws NoSuchAlgorithmException {
//		//hashing algorithm to hash password
//		MessageDigest digest = MessageDigest.getInstance("SHA-256");
//		byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
//		String hpass = bytesToHex(hash);
//		//query to Db
//		String query = "select * from person where Email = '" + email + "' AND Hpass = '" + hpass + "'"; //!! could be changed to a stmnt
//		ResultSet rs;
//		try {
//			//send query
//			rs = dB.databasePull(query);
//			//if return frm query
//			if(rs.next()) {
//				//set mode rerurn true
//				this.email = rs.getString("Email");
//				this.fName = rs.getString("Fname");
//				this.lName = rs.getString("Lname");
//				mode = rs.getString("Ptype");
//				return true;
//			//?? @Dillon is there something more you need me to add here if the passwords dont match?
//			} else {
//				return false;
//			}
//		} catch (SQLException s) {
//			System.out.println("Could not connect to the Database");
//		}
//		return true;
		return true;
	}
	class CreateListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == theView.getBackButton()) {
				back();
			}else {
				String email = theView.getUserName();
				String password = theView.getPassword();
				String first = theView.getFirst();
				String last = theView.getLast();
				String accType = theView.getAccountType();
				//will add in some error checking
				System.out.println(email+password+first+last+accType);
				NewUserForm nuf = new NewUserForm();
				if(nuf.createUser(accType, email, password,first,last)) {
					theView.displayErrorMessage("user Created");
					back();
				}
				else {
					theView.displayErrorMessage("Email is already registered");
				}
			}
		}
	}
	class ModeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton temp = (JButton) e.getSource();
			String selectedMode = temp.getText();
			mode = selectedMode;
			if (selectedMode.equals("Default User")) {
				
			}
			else if(selectedMode.equals("Create New Account")){
				theView.setNewUserView();
				theView.addCreateListener(new CreateListener());
			}
			else {
				theView.setEntryView();
				theView.addEntryListener(new EntryListener());
			}
			
		}
		
	}
	class EntryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(e.getSource() == theView.getBackButton()) {
					back();
				}else {
					if(validLogin(theView.getUserName(),theView.getPassword())) {
						theView.dispose();
						if(mode.equals("Landlord")) {
							//create landlord view
							LandlordView lv = new LandlordView(theView.getUserName());
	//						//populate the landlord entity
	//						double due = -1;
	//						String query = "select Amount_due from landlord where email = '" + email + "'";
	//						ResultSet rs;
	//						try {
	//							rs = dB.databasePull(query);
	//							if(rs.next()) {
	//								due = rs.getDouble("Amount_due");
	//							} else {
	//								due = 0;
	//							}
	//						} catch (SQLException s) {
	//							System.out.println("Could not connect to Db");
	//						}
	//						Landlord landLord = new Landlord(fName, lName, email, due);
							//create the landlord controller
							Landlord landLord = new Landlord("joe", "mama",theView.getUserName(),0);
							LandlordController lc = new LandlordController(lv,landLord);
						}
						else if(mode.equals("Renter")) {
							//renter view
							//??idk @Dillon, @all if this should continue as your 
							RenterView rv = new RenterView(theView.getUserName());
	//						//populate renter 
	//						//string vector to store renter preferences
	//						Vector<String> prefs = new Vector<String>(7);
	//						String query = "select * from renter where email = '" + email + "'";
	//						ResultSet rs;
	//						try {
	//							rs = dB.databasePull(query);
	//							if(rs.next()) {
	//								prefs.add(0, rs.getString("PQuad"));
	//								prefs.add(1, rs.getString("Ptype"));
	//								prefs.add(2, Integer.toString(rs.getInt("PFurn")));
	//								prefs.add(3, Integer.toString(rs.getInt("Pbeds")));
	//								prefs.add(4, Double.toString(rs.getDouble("Pbaths")));
	//								prefs.add(5, Double.toString(rs.getDouble("Pmin")));
	//								prefs.add(6, Double.toString(rs.getDouble("Pmax")));
	//							}
	//						} catch (SQLException s) {
	//							System.out.println("Could not connect to Db");
	//						}
	//						//create new entity
	//						Renter renter = new Renter(fName, lName, email, prefs);
	//						//create the renter controller
	//						RenterController rc = new RenterController(rv, renter);
						}
						else {
							//Manager view
							ManagerView mv = new ManagerView(theView.getUserName());
							//create Manager enitiy
							Manager manager = new Manager("mike", "hunt", theView.getUserName());
							//create manager controller
							ManagerController mc = new ManagerController (mv, manager);
						}
					}
					else {
						theView.displayErrorMessage("incorrect email or password");
					}
				}
				
			}
			catch(NumberFormatException n){
				theView.displayErrorMessage("Please populate both fields");
			}
			catch (NoSuchAlgorithmException h) {
				System.out.println("Uh oh the hash is not working");
				System.exit(1);
			}
			
		}
		
	}

	//method to 
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for(int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
