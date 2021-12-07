package Resources.Entities;

public class Manager extends Person {
    private String firstName;
    private String lastName;
    private String email;
    //ctor
    public Manager(String first, String last, String emailadd) {
        this.firstName = first;
        this.lastName = last;
        this.email = emailadd;
    }
    public String getEmail(){
        return email;
    }
}
