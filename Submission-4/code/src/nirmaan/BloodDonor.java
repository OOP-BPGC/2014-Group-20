package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amit Patil
 */
public class BloodDonor extends Volunteer implements Serializable{

    private String bloodGroup;
    private Date dateofdonation;
    public BloodDonor(String bloodGroup, Date date,String name, String number) {
        super(name, number);
        this.bloodGroup = bloodGroup;
        this.dateofdonation = date;
    }
    public String getBloodGroup() {
    	return this.bloodGroup;
    }
    public Date getDate() {
    	return this.dateofdonation;
    }
    public void addBloodDonor() {
ArrayList<BloodDonor> donors;
donors = (ArrayList<BloodDonor>)Utility.deserialize("donors.ser");
if(donors == null) {
donors = new ArrayList<BloodDonor>();
}
donors.add(this);
Utility.serialize(donors, "donors.ser");
}
public void removeBloodDonor() {
ArrayList<BloodDonor> donors;
donors = (ArrayList<BloodDonor>)Utility.deserialize("donors.ser");
if(donors == null) {
donors = new ArrayList<BloodDonor>();
}
donors.remove(this);
Utility.serialize(donors, "donors.ser");
}
public static ArrayList<BloodDonor> searchdonors(String query) {
ArrayList<BloodDonor> donors;
ArrayList<BloodDonor> result = new ArrayList<BloodDonor>();
donors = (ArrayList<BloodDonor>)Utility.deserialize("donors.ser");
for(BloodDonor volunteer: donors) {
if(volunteer.getName().contains(query) ) {
result.add(volunteer);
}
}
return result;

}
}
    
