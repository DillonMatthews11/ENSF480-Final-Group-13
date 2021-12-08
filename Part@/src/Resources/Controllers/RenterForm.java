package Resources.Controllers;

import java.util.Vector;

import Resources.Entities.Property;
import Resources.Entities.Renter;

public class RenterForm {
	private DBconnector db;
	private Renter renter;
	public RenterForm(Renter renter) {
		this.renter = renter;
	}
	public void setPreferences(Vector<String> prefs) {
		//add new preferences to database
	}
	public Vector<Property> getSearchedProperties(){
		//return all properties based on preferences
		Vector<Property> v = new Vector<Property>();
		v.add(new Property(1,"7 7th street","house", 3,4,"",true," ","joe", "mama"));
		v.add(new Property(2,"8 8th street","Appartment", 3,4,"",true," ","rufus", "smith"));
		return v;
	}
	public boolean sendMessage(Property p, String message) {
		return true;
		//return true if message sent
		//retrun false if problem
	}
}
