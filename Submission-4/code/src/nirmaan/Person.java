package nirmaan;

import java.io.Serializable;

/**
 * @author Sreejith
 *
 */
public class Person implements Serializable  {
	private String name;
	private String contactNumber;
	
	/**
	 * @param name Name of the person
	 */
	public void setName(String name) {
		this.name= name;
	}
	
	/**
	 * @param number Contact number
	 */
	public void setContactNumber(String number) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * @return Name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return Contact Number
	 */
	public String getContactNumber() {
		return this.contactNumber;
	}
	
}
