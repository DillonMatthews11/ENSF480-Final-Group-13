package Resources.Entities;

public class Property {
    private String address;
    private String propertyType;
    private double bathrooms;
    private int bedrooms;
    private String quadrant;
    private boolean furnishedStatus;
    private String propertyStatus;
    private int propertyId;
    private String ownerFirstName;
    private String ownerLastName;
    public Property(int id, String address, String propertyType, double bathrooms, int bedrooms, String quadrant,
     boolean furnishedStatus, String propertyStatus,String ownerFirstName, String ownerLastName){
        propertyId = id;
        this.address = address;
        this.propertyType = propertyType;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.quadrant = quadrant;
        this.furnishedStatus = furnishedStatus;
        this.propertyStatus = propertyStatus;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
    }
    public String getAddress(){
        return address;
    }
    public int  getID(){
        return propertyId;
    }
    public String getOwnerFirstName(){
        return ownerFirstName;
    }
    public String getOwnerLastName(){
        return ownerLastName;
    }
}
