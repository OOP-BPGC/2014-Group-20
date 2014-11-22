package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Amit Patil
 *
 */
public class Volunteer extends Person implements Serializable{
	
	/**
	 * Class Constructor
	 * @param name Name of the volunteer
	 * @param number Contact number of the volunteer
	 */
	public Volunteer(String name,String number) {
		this.setName(name);
		this.setContactNumber(number);
	}
	
	/**
	 * Adds the volunteer details to the database 
	 */
	public void addVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
	
		volunteers.add(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	
	/**
	 * Deletes the details of a volunteer 
	 */
	public void removeVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
		volunteers.remove(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	
	/**
	 * Searches the database for matching volunteer names
	 * @param query The search parameter (name of the volunteer)
	 * @return ArrayList containing matching queries
	 */
	public static ArrayList<Volunteer> search(String query) {
		ArrayList<Volunteer> volunteers;
		ArrayList<Volunteer> result = new ArrayList<Volunteer>();
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		System.out.println(volunteers.size()); 
		for(Volunteer volunteer: volunteers) {
			System.out.println(volunteer.getName());
			if(volunteer.getName().contains(query) ) {
				
				result.add(volunteer);
				
			}
			
		} 
		return result;
	}
	/*
	public static void main(String[] args) {
		Volunteer v = new Volunteer("hello","heelo");
		v.addVolunteer();
		ArrayList<Volunteer> res = Volunteer.search("he");
		System.out.println(res.size());
	}
	*/
}
