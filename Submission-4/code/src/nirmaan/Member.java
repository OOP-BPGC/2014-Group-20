package nirmaan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * 
 * @author Amit Patil
 *
 */
public class Member extends Person implements Serializable{
	private String userName;
	private String password;
	private Designation designation;
	
	/**
	 * Class Constructor
	 * @param name Name of the member
	 * @param contact Contact number of the member
	 * @param userName username of the member
	 * @param password password of the member 
	 * @param designation Designation of the member
	 */
	public Member(String name,String contact,String userName,String password,Designation designation) {
		this.userName= userName;
		this.password = sha256(password);
		this.designation = designation;
		this.setName(name);
		this.setContactNumber(contact);
		
	}
	/**
	 * Takes a string, hashes it using SHA-256 and then returns a hex string.
	 * @param base The string before encryption
	 * @return Encrypted string
	 */
	private static String sha256(String base) {
		
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
            	
            	String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
            }
	        return hexString.toString();
	    }catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	/**
	 * Use this method to register a member and returns true if successful. Adds the current object to an ArrayList and serializes it.
	 * @return registration status
	 */
	@SuppressWarnings("unchecked")
	public boolean register() throws Exception {
		ArrayList<Member> members;
		members = (ArrayList<Member>)Utility.deserialize("members.ser");
	
		if(members == null) {
			members = new ArrayList<Member>();
		
		}
		
		if(this.checkUserNameExists(members)== false) {
			members.add(this); 
			Utility.serialize(members, "members.ser");
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Finds the designation of the member
	 * @param userName username of the member
	 * @param password password of the member
	 * @return Designation of the member
	 */
	public static Designation authenticate(String userName, String password) {
		ArrayList<Member> members;
		password = sha256(password);
		members = (ArrayList<Member>)Utility.deserialize("members.ser");
		if(members == null) {
			return null;
		}
		
		for(Member member:members) {
			if(member.userName.equals(userName) && member.password.equals(password)) {
				return member.designation;
			}
		}
		return null;
	}
	
	/**
	 * Checks if the user name already exists; returns true if it does
	 * @param members ArrayList of members
	 * @return existence of the username
	 */
	private boolean checkUserNameExists(ArrayList<Member> members) throws Exception {
		
		for(Member member:members) {
			
			if(this.userName.equals(member.userName)){
			
				return true;
			
			}
			
		}
		return false;
	}
	
	/**
	 * Searches the database for matching member names
	 * @param query The search parameter (name of the member)
	 * @return ArrayList containing matching queries
	 */
	public static ArrayList<Member> search(String query) {
		ArrayList<Member> members;
		ArrayList<Member> result = new ArrayList<Member>();
		members = (ArrayList<Member>)Utility.deserialize("members.ser");
		for(Member member: members) {
		
			if(member.userName.contains(query) || member.getName().contains(query)) {
				
				result.add(member);
				
			}
			
		}
		return result;
	}
	
}
