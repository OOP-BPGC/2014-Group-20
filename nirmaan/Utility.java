package nirmaan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utility {
	public static Object deserialize(String name)  {
		
		try {
			FileInputStream fileIn = new FileInputStream(name);
			ObjectInputStream in = new ObjectInputStream(fileIn);
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
	public static void serialize(Object object, String name) {
	
		try {
			
	         FileOutputStream fileOut = new FileOutputStream(name);
	           ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(object);
	         out.close();
	         fileOut.close();
	   
	      }catch(Exception i)
	      {
	          i.printStackTrace();
	      }
	}
}
