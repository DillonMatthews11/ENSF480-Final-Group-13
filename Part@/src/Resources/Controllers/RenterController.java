package Resources.Controllers;

import Resources.Entities.*;
import Resources.FrontEnd.*;

public class RenterController{
    private RenterView rv;
    private Renter renter;
    
    public RenterController(RenterView rv, Renter renter) {
        this.rv = rv;
        this.renter = renter;
    }
}