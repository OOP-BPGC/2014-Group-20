package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author Amit Patil
* 
**/
public class Institution  implements Serializable{

    private String Name;
    private String Address;
    private String type;
    
    /**
     * @param name Name of Institution
     * @param address Address
     * @param type Type of institution
     */
    public Institution(String name,String address,String type) {
    	this.Name=name;
    	this.Address=address;
    	this.type=type;
    }
    
    /**
     * @return Name
     */
    public String getName() {
    	return this.Name;
    }
    
    /**
     * @return Address
     */
    public String getAdd() {
    	return this.Address;
    }
    
    /**
     * @return Type
     */
    public String getType() {
    	return this.type;
    }
    
    /**
     *  Add institution details to the database
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
     * Remove institution from the database
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


