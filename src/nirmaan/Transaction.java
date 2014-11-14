package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Raghav
 */

public class Transaction implements Serializable {
    private String userName;
    private String reason;
    private double amount;
    private static Funds funds;
    private boolean approved;
    
	Transaction(String userName, String reason, double amount) {
    	this.userName = userName;
        this.reason = reason;
        this.amount = amount;
        this.approved = false;
    }
    
    private void modifyFunds(double Funddeduct) {
    	boolean done;
        if(this.approved) {
        	done = funds.deduct(Funddeduct);
            if(!done) {
                System.out.println("Transaction cant modify funds disapproving it");
                this.approved=false;
            }
        }
    }
    
	public static void ApproveTransaction(Transaction T) {
    	T.approved = true;
	}
    
    public String getuser() {
        return this.userName;
    } 
    
    public String getreason() {
        return this.reason;
    } 
    
    public double getamount() {
        return this.amount;
    }
    public boolean checkapproval() {
        return this.approved;
    }
    
    public boolean registertransaction() {
        ArrayList<Transaction> trans = new ArrayList<Transaction>();
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        if(trans==null)
        {
        trans=new ArrayList<Transaction>();
        }
        try
        {trans.add(this);
        Utility.serialize(trans, "Transactions.ser");
        return true;
        }
        catch(Exception E)
        {
            return false;
                    }
        
        
        }
    public static ArrayList<Transaction> getPending() {
    	ArrayList<Transaction> trans = new ArrayList<Transaction>();
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        ArrayList<Transaction> temp = new ArrayList<Transaction>();
        try {
        	for(Transaction tr : trans) {   
        		if(!tr.checkapproval()) {
        			temp.add(tr);
        		}
        	}
        } catch ( NullPointerException e) {
           
        }
        return temp;
    }
}
