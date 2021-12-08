package Resources.Controllers;

import Resources.Entities.Landlord;

public class LandlordForm {
	DBconnector db;
	Landlord landlord;
	public LandlordForm(Landlord landlord){
		this.landlord = landlord;
	}
	public boolean payFee() {
		//update fee payment to db
		//return true if successful
		return true;
	}
	public boolean addHouse(String address, String type, double beds, double baths, String furn,
			String quad) {
		//add house to database and landlord
		//return true if success
		return true;
	}
	public boolean changePropertyStatus(int id, String status)
	{
		return false;
		//return false if property is already listed as suspended and dont update database
	}
}
