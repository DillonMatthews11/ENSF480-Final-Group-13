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
    public void addProperty(Property p){
        ownedProperties.add(p);
    }
}
