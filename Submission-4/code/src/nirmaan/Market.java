package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author Amit Patil
* 
**/
public class Market  implements Serializable{

    private String Name;
    private String Address;
   
    
    /**
     * Class Constructor
     * @param name Name of the Market
     * @param address Address of the Market
     */
    public Market(String name,String address) {
    this.Name=name;
    this.Address=address;
    
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
     * Adds Market details
     */
    public void addMarket() {
    	ArrayList<Market> markets;
    	markets = (ArrayList<Market>)Utility.deserialize("markets.ser");
    	if(markets == null) {
    		markets = new ArrayList<Market>();
    	}
    	markets.add(this);
    	Utility.serialize(markets, "markets.ser");
    }

    /**
     * Removes Market details 
     */
    public void removeMarket() {
    	ArrayList<Market> markets;
    	markets = (ArrayList<Market>)Utility.deserialize("markets.ser");
    	if(markets == null) {
    		markets = new ArrayList<Market>();
    	}
	markets.remove(this);
	Utility.serialize(markets, "markets.ser");
    }

    /**
	 * Searches the database for matching Market names
	 * @param query The search parameter (name of the market)
	 * @return ArrayList containing matching queries
	 */
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




