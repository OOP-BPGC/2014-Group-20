package nirmaan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Amit Patil
 *
 */
public class Utility {
	
	/**
	 * Deserialize the .ser file
	 * @param name File name
	 * @return List of details in the file
	 */
	public static Object deserialize(String name)  {
		//System.out.println("777");
		try {
			//System.out.println("77");
			
			FileInputStream fileIn = new FileInputStream(name);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			//System.out.println("3");
			Object object = in.readObject();
			in.close();
			fileIn.close();
			return object; 
		}
		catch(Exception i){
			i.printStackTrace();
	        return null;
	        
	        
	    }
	}
	
	/**
	 * Serializes details into the file
	 * @param object ArrayList to be serialized into the .ser file
	 * @param name File name
	 */
	public static void serialize(Object object, String name) {
	//	System.out.println("7777");
		try {
			
	         FileOutputStream fileOut = new FileOutputStream(name);
	  //       System.out.println("777");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(object);
	    //     System.out.println("4");
	         out.close();
	         fileOut.close();
	   
	      }catch(Exception i)
	      {
	          i.printStackTrace();
	      }
	}
}
