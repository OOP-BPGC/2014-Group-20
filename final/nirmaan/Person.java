package nirmaan;

import java.io.Serializable;

public class Person implements Serializable  {
	private String name;
	private String contactNumber;
	
	public void setName(String name) {
		this.name= name;
	}
	public void setContactNumber(String number) {
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return this.name;
	}
	public String getContactNumber() {
		return this.contactNumber;
	}
	
}
