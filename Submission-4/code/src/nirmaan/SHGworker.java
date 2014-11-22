package nirmaan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sreejith
 * 
 **/
import java.io.Serializable;
import java.util.ArrayList;
public class SHGworker extends Person implements Serializable{

     
   
    
    public SHGworker(String name) {
    this.setName(name);
    
    
    }
public void addSHGworker() {
ArrayList<SHGworker> workers;
workers = (ArrayList<SHGworker>)Utility.deserialize("workers.ser");
if(workers == null) {
workers = new ArrayList<SHGworker>();
}
workers.add(this);
Utility.serialize(workers, "workers.ser");
}
public void removeSHGworker() {
ArrayList<SHGworker> workers;
workers = (ArrayList<SHGworker>)Utility.deserialize("workers.ser");
if(workers == null) {
workers = new ArrayList<SHGworker>();
}
workers.remove(this);
Utility.serialize(workers, "workers.ser");
}
public static ArrayList<SHGworker> search(String query) {
ArrayList<SHGworker> workers;
ArrayList<SHGworker> result = new ArrayList<SHGworker>();
workers = (ArrayList<SHGworker>)Utility.deserialize("workers.ser");
for(SHGworker in: workers) {
if(in.getName().contains(query) ) {
result.add(in);
}
}
return result;
}


}



