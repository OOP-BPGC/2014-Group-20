package nirmaan;

/**
 *
 * @author sreejith
 * 
 **/
import java.io.Serializable;
import java.util.ArrayList;
public class SHGworker extends Person implements Serializable{

	/**
	 * @param name Name of the worker
	 */
	public SHGworker(String name) {
		this.setName(name);
    }

	/**
	 * Add SHG worker details to the database
	 */
	public void addSHGworker() {
		ArrayList<SHGworker> workers;
		workers = (ArrayList<SHGworker>)Utility.deserialize("workers.ser");
		if(workers == null) {
			workers = new ArrayList<SHGworker>();
		}
		workers.add(this);
		Utility.serialize(workers, "workers.ser");
	}

	/**
	 * Remove SHG worker from the database
	 */
	public void removeSHGworker() {
		ArrayList<SHGworker> workers;
		workers = (ArrayList<SHGworker>)Utility.deserialize("workers.ser");
		if(workers == null) {
			workers = new ArrayList<SHGworker>();
		}
		workers.remove(this);
		Utility.serialize(workers, "workers.ser");
	}

	/**
	 * Searches the database for matching worker names
	 * @param query The search parameter (name of the worker)
	 * @return ArrayList containing matching queries
	 */
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



