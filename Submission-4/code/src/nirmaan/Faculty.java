package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sreejith
 */
public class Faculty extends Person implements Serializable {
    private boolean donated;
    private String PSRN_no;
    
    /**
     * Class Constructor
     * @param Name Faculty Name
     * @param PSRN_no PSRN no.
     */
    public Faculty(String Name,String PSRN_no)
    {
        this.setName(Name);
        this.setPSRN_no(PSRN_no);
        this.donated=false;
    }
    
    /**
     * @return Donation Status
     */
    public boolean checkDonationStatus()
    {
        return this.donated;
    }
    
    /**
     * @param Donate Donation status
     */
    public void setDonationStatus(boolean Donate)
    {
        this.donated=Donate;
    }
    
    /**
     * @param PSRN PSRN no.
     */
    public void setPSRN_no(String PSRN)
    {
        this.PSRN_no=PSRN;
    }
    
    /**
     * @return PSRN No.
     */
    public String getPSRN_no()
    {
        return this.PSRN_no;
    }
    
    /**
     * Adds Faculty to the database
     */
    public void addFaculty() {
    	ArrayList<Faculty> faculty;
    	faculty = (ArrayList<Faculty>)Utility.deserialize("faculty.ser");
    	if(faculty == null) {
    		faculty = new ArrayList<Faculty>();
    	}
    	faculty.add(this);
    	Utility.serialize(faculty, "faculty.ser");
    }

    /**
     * Removes faculty details from the database
     */
    public void removeFaculty() {
    	ArrayList<Faculty> faculty;
    	faculty = (ArrayList<Faculty>)Utility.deserialize("faculty.ser");
    	if(faculty == null) {
    		faculty = new ArrayList<Faculty>();
    	}
    	faculty.remove(this);
    	Utility.serialize(faculty, "faculty.ser");
    }
    
    /**
	 * Searches the database for matching Faculty names
	 * @param query The search parameter (name of the Faculty)
	 * @return ArrayList containing matching queries
	 */
    public static ArrayList<Faculty> search(String query) {
    	ArrayList<Faculty> faculty;
    	ArrayList<Faculty> result = new ArrayList<Faculty>();
    	faculty = (ArrayList<Faculty>)Utility.deserialize("faculty.ser");
    	for(Faculty f: faculty) {
    		if(f.getName().contains(query) ) {
    			result.add(f);
    		}
    	}
    	return result;
    }

    /**
     * @return List of faculties who haven't donated
     */
    public static ArrayList<Faculty> getPending(){
    	
        ArrayList<Faculty> trans = new ArrayList<Faculty>();
        trans = (ArrayList<Faculty>)Utility.deserialize("/home/sreejith/NetBeansProjects/" +
        		"NirmaanJunit/src/Facultys.ser");
        ArrayList<Faculty> temp = new ArrayList<Faculty>();
        try
        {	for(Faculty f : trans)
        	{   if(!f.checkDonationStatus())
            	{
                	temp.add(f);
            	}
                
        	}
        
        }
        catch(NullPointerException e)
        {
        	System.out.println("No pending events");        
        		
        }
        return temp;
    }
}
    
    
    

