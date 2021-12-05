package Resources.Entities;

public class Property {
    private String address;
    private String propertyType;
    private double bathrooms;
    private double bedrooms;
    private String quadrant;
    private String furnishedStatus;
    private String propertyStatus;
    private int propertyId;
    private static int nextID;
    public Property(String address, String propertyType, double bathrooms, double bedrooms, String quadrant, String furnishedStatus, String propertyStatus){
        this.address = address;
        this.propertyType = propertyType;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.quadrant = quadrant;
        this.furnishedStatus = furnishedStatus;
        this.propertyStatus = propertyStatus;
        propertyId = nextID;
        nextID++;
    }

}
