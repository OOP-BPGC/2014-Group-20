package nirmaan;

import java.io.Serializable;

/**
 * @author Amit Patil
 *
 */
public class Person implements Serializable  {
	private String name;
	private String contactNumber;
	
	/**
	 * Setter method for name
	 * @param name Name of the person
	 */
	public void setName(String name) {
		this.name= name;
	}
	
	/**
	 * Setter method for contactNumber
	 * @param number Contact number
	 */
	public void setContactNumber(String number) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * @return Name of the person
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return Contact number
	 */
	public String getContactNumber() {
		return this.contactNumber;
	}
	
}
