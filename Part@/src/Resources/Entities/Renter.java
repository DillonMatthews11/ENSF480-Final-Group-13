package Resources.Entities;

import java.util.Vector;

public class Renter extends Person{
    private Vector<String> preferences;
    
    
    //ctor
    public Renter(String first, String last, String emailadd, Vector<String> prefs) {
        preferences = prefs;
        this.firstName = first;
        this.lastName = last;
        this.email = emailadd;
    }

    
}