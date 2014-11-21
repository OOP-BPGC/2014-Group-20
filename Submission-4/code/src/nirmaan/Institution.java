package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Amit Patil
 *
 */
public class Institution implements Serializable{

    private String Name;
    private String Address;
    private String type;
    
    /**
     * Class Constructor
     * @param name Name of the institution
     * @param address Address of the institution
     * @param type Type of institution
     */
    public Institution(String name,String address,String type) {
    this.Name=name;
    this.Address=address;
    this.type=type;
    }

    /**
     * Adds details of an institution to the database
     */
    public void addInstitution() {
    	ArrayList<Institution> institutions;
    	institutions = (ArrayList<Institution>)Utility.deserialize("institutions.ser");
    	if(institutions == null) {
    		institutions = new ArrayList<Institution>();
    	}
    	institutions.add(this);
    	Utility.serialize(institutions, "institutions.ser");
    }
    
    /**
     * Removes details of the institution from the database
     */
    public void removeInstitution() {
    	ArrayList<Institution> institutions;
    	institutions = (ArrayList<Institution>)Utility.deserialize("institutions.ser");
    	if(institutions == null) {
    		institutions = new ArrayList<Institution>();
    	}
    	institutions.remove(this);
    	Utility.serialize(institutions, "institutions.ser");
    }

    /**
     * Searches the database for matching institution names
     * @param query The search parameter (name of the institution)
     * @return ArrayList containing matching queries
     */
    public static ArrayList<Institution> search(String query) {
    	ArrayList<Institution> institutions;
    	ArrayList<Institution> result = new ArrayList<Institution>();
    	institutions = (ArrayList<Institution>)Utility.deserialize("institutions.ser");
    	for(Institution in: institutions) {
    		if(in.Name.contains(query) ) {
    			result.add(in);
    		}
    	}
    	return result;
    }

}


