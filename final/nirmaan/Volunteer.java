package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

public class Volunteer extends Person implements Serializable{
	public Volunteer(String name,String number) {
		this.setName(name);
		this.setContactNumber(number);
	}
	public void addVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
	
		volunteers.add(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	public void removeVolunteer() {
		ArrayList<Volunteer> volunteers;
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		if(volunteers == null) {
			volunteers = new ArrayList<Volunteer>();
		}
		volunteers.remove(this);
		Utility.serialize(volunteers, "volunteers.ser");
	}
	public static ArrayList<Volunteer> search(String query) {
		ArrayList<Volunteer> volunteers;
		ArrayList<Volunteer> result = new ArrayList<Volunteer>();
		volunteers = (ArrayList<Volunteer>)Utility.deserialize("volunteers.ser");
		System.out.println(volunteers.size()); 
		for(Volunteer volunteer: volunteers) {
			System.out.println(volunteer.getName());
			//if(volunteer.getName().contains(query) ) {
				
				//result.add(volunteer);
				
		//	}
			
		} 
		return result;
	}
	public static void main(String[] args) {
		Volunteer v = new Volunteer("hello","heelo");
		v.addVolunteer();
		ArrayList<Volunteer> res = Volunteer.search("he");
		System.out.println(res.size());
	}
}
