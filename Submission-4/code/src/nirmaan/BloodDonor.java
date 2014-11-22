package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Amit Patil
 */
public class BloodDonor extends Volunteer implements Serializable{

    private String bloodGroup;
    private Date dateofdonation;
    
    /**
     * Class Constructor
     * @param bloodGroup Blood group of the donor
     * @param date Date of donation
     * @param name Name of the donor
     * @param number Contact number of the donor
     */
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
    /**
     * Adds the details of the blood donor to donors.ser file
     */
    public void addBloodDonor() {
    	ArrayList<BloodDonor> donors;
    	donors = (ArrayList<BloodDonor>)Utility.deserialize("donors.ser");
    	if(donors == null) {
    		donors = new ArrayList<BloodDonor>();
    	}
    	donors.add(this);
    	Utility.serialize(donors, "donors.ser");
    }

    /**
     * Deletes the details of a blood donor
     */
    public void removeBloodDonor() {
    	ArrayList<BloodDonor> donors;
    	donors = (ArrayList<BloodDonor>)Utility.deserialize("donors.ser");	
    	if(donors == null) {
    		donors = new ArrayList<BloodDonor>();
    	}	
    	donors.remove(this);
    	Utility.serialize(donors, "donors.ser");
    }

    /**
     * Searches the database for matching donor names
     * @param query The search parameter (name of the donor)
     * @return ArrayList containing matching queries
     */
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
    
