package nirmaan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amit
 * 
 **/
import java.io.Serializable;
import java.util.ArrayList;
public class Institution  implements Serializable{

    private String Name;
    private String Address;
    private String type;
    
    public Institution(String name,String address,String type) {
    this.Name=name;
    this.Address=address;
    this.type=type;
    }
    public String getName() {
    	return this.Name;
    }
    public String getAdd() {
    	return this.Address;
    }
    public String getType() {
    	return this.type;
    }
public void addInstitution() {
ArrayList<Institution> institutions;
institutions = (ArrayList<Institution>)Utility.deserialize("institutions.ser");
if(institutions == null) {
institutions = new ArrayList<Institution>();
}
institutions.add(this);
Utility.serialize(institutions, "institutions.ser");
}
public void removeInstitution() {
ArrayList<Institution> institutions;
institutions = (ArrayList<Institution>)Utility.deserialize("institutions.ser");
if(institutions == null) {
institutions = new ArrayList<Institution>();
}
institutions.remove(this);
Utility.serialize(institutions, "institutions.ser");
}
public static  ArrayList<Institution> search(String query) {
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


