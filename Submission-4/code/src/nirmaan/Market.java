package nirmaan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Amit Patil
 * 
 **/
import java.io.Serializable;
import java.util.ArrayList;
public class Market  implements Serializable{

    private String Name;
    private String Address;
   
    
    public Market(String name,String address) {
    this.Name=name;
    this.Address=address;
    
    }
    public String getName() {
    	return this.Name;
    }
    public String getAdd() {
    	return this.Address;
    }
public void addMarket() {
ArrayList<Market> markets;
markets = (ArrayList<Market>)Utility.deserialize("markets.ser");
if(markets == null) {
markets = new ArrayList<Market>();
}
markets.add(this);
Utility.serialize(markets, "markets.ser");
}
public void removeMarket() {
ArrayList<Market> markets;
markets = (ArrayList<Market>)Utility.deserialize("markets.ser");
if(markets == null) {
markets = new ArrayList<Market>();
}
markets.remove(this);
Utility.serialize(markets, "markets.ser");
}
public static ArrayList<Market> search(String query) {
ArrayList<Market> markets;
ArrayList<Market> result = new ArrayList<Market>();
markets = (ArrayList<Market>)Utility.deserialize("markets.ser");
for(Market in: markets) {
if(in.Name.contains(query) ) {
result.add(in);
}
}
return result;
}


}




