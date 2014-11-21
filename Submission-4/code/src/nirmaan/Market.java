package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;
/**
*
* @author Amit Patil
* 
**/
public class Market implements Serializable{

    private String Name;
    private String Address;
      
    /**
     * Class Constructor
     * @param name Name of the market
     * @param address Address of the market
     */
    public Market(String name,String address) {
    	this.Name=name;
    	this.Address=address;
    
    }
    
    /**
     * Add details of market to the database
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
     * Deletes market details from the database
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
	 * Searches the database for matching market names
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




