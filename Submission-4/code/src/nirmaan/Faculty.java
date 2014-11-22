package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sreejith
 */
public class Faculty extends Person implements Serializable {
    private boolean donated;
    private String PSRN_no;
    public Faculty(String Name,String PSRN_no)
    {
        this.setName(Name);
        this.setPSRN_no(PSRN_no);
        this.donated=false;
    }
    
    public boolean checkDonationStatus()
    {
        return this.donated;
    }
    public void setDonationStatus(boolean Donate)
    {
        this.donated=Donate;
    }
    public void setPSRN_no(String PSRN)
    {
        this.PSRN_no=PSRN;
    }
    public String getPSRN_no()
    {
        return this.PSRN_no;
    }
    public void addFaculty() {
ArrayList<Faculty> faculty;
faculty = (ArrayList<Faculty>)Utility.deserialize("faculty.ser");
if(faculty == null) {
faculty = new ArrayList<Faculty>();
}
faculty.add(this);
Utility.serialize(faculty, "faculty.ser");
}
public void removeFaculty() {
ArrayList<Faculty> faculty;
faculty = (ArrayList<Faculty>)Utility.deserialize("faculty.ser");
if(faculty == null) {
faculty = new ArrayList<Faculty>();
}
faculty.remove(this);
Utility.serialize(faculty, "faculty.ser");
}
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

public static ArrayList<Faculty> getPending()
    {
        ArrayList<Faculty> trans = new ArrayList<Faculty>();
        trans = (ArrayList<Faculty>)Utility.deserialize("/home/sreejith/NetBeansProjects/NirmaanJunit/src/Facultys.ser");
        ArrayList<Faculty> temp = new ArrayList<Faculty>();
       try
       {for(Faculty f : trans)
        {   if(!f.checkDonationStatus())
            {
                temp.add(f);
            }
                
        }
       }
       catch ( NullPointerException e)
       {
           
       }
        return temp;
        
        
    }
}
    
    
    

