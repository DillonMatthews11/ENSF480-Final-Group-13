package Resources.Controllers;

import java.util.*;
import java.sql.*;
import Resources.Entities.*;

public class GenerateReportForm{
    private DBconnector dB;
    private int period;
//    public GenerateReportForm(int period ){
//        this.period = period;
//        try {
//            dB.connectDatabase();
//        } catch (SQLException s) {
//            System.out.println("Could not connect to the database");
//        }
//    }
//    public int[] generatePropertyStats(){
//        int[] stats = new int[3];
//        String queryListed = "select * from status_on where Ondate > '" + period + "' and Status <> 'SUSPENDED'";
//        String queryActive = "select * from status_on where Ondate > '" + period + "' and Status = 'ACTIVE'"; 
//        String queryRented = "select * from status_on where Ondate > '" + period + "' and Status = 'RENTED'";
//        ResultSet qR;
//        ResultSet qA;
//        ResultSet qL;
//        try {
//            int i = 0, j = 0, k = 0;
//            qL = dB.databasePull(queryListed);
//            while(qL.next()) {
//                i++;
//            }
//            stats[0] = i;
//            qA = dB.databasePull(queryActive);
//            while(qA.next()) {
//                j++;
//            }
//            stats[1] = j;
//            qR = dB.databasePull(queryRented);
//            while (qR.next()) {
//                k++;
//            }
//            stats[2] = k;
//        } catch (SQLException s) {
//            System.out.println("Could not connect to database");
//        }
//        return stats;
//    }
//    public Vector<Property> generateRentedProperties(){
//        Vector<Property> rentedProperties = new Vector<Property>();
//        ResultSet report;
//        String query = "select p.IDno, p.Address, l.Fname, l.Lname" +
//        " from property as p, landlord as l, owns as o, status_on as s" +
//        " where l.email = o.email and p.IDno = o.IDno and p.IDno = s.IDno" +
//        "  and o.Ondate > '"+ period +"' and o.Ondate < '" + (period -30) + "' and s.Status = 'RENTED'";
//        try {
//            report = dB.databasePull(query);
//            while(report.next()) {
//                int id = report.getInt("IDno");
//                String addr = report.getString("Address");
//                String lFirst = report.getString("Fname");
//                String lLast = report.getString("Lname");
//                rentedProperties.add(new Property(id, addr,"", -1, -1, "", false, "", lFirst, lLast));
//            }
//        } catch (SQLException s) {
//            System.out.println("Could not connect to the database");
//        }
//        return rentedProperties;
//    }
    	
}

