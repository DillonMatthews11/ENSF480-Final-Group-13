package Resources.Entities;
import java.util.*;
public class Landlord extends Person {
    
    private Vector<Property> ownedProperties;
    private double amountOwed;
    public Landlord(String firstName, String lastName, String email, double amountOwed){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amountOwed = amountOwed;
        this.ownedProperties = new Vector<Property>();
    }
    public void addProperty(String address, String propertyType, double bathrooms,
     int bedrooms, String quadrant, boolean furnishedStatus, String propertyStatus, String ownerFirstName, String ownerLastName){
        ownedProperties.add(new Property(-1, address, propertyType, bathrooms, bedrooms, quadrant, furnishedStatus, propertyStatus,ownerFirstName, ownerLastName));
    }
}
