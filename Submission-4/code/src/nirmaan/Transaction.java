package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Amit Patil
 */
public class Transaction implements Serializable{
    
    private String userName;
    private String reason;
    private double amount;
    private static double funds;
    public boolean approved;
    
    /**
     * Class Constructor
     * @param userName Username of the member
     * @param reason Details of the transaction
     * @param amount Amount in Rupees
     */
    public Transaction(String userName,String reason,double amount) {
        this.userName=userName;// while creating a transaction in the main code pass the member object's 
        this.reason=reason;//user name attribute there.to avoid repetition of code
        this.amount=amount;
        this.approved=false;
    }
    
    private void modifyFunds() {   
        if(this.approved) {	
        	funds = funds - this.getamount();
        }
    }
   
    /**
     * Approves a transaction
     * @param E Transaction to be approves
     * @return approved/rejected
     */
    public static void approveTransaction(Transaction E)
    {
    	
	    	ArrayList<Transaction> trans;
	    	ArrayList<Transaction> temp = new ArrayList<Transaction>();
	        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
	        if(trans==null){
	        	return;
	        }
	        try {
	        
	        	for(Transaction tran:trans) {
	        		if(E.getuser().equals(tran.getuser())&& E.getreason().equals(tran.getreason())
	        				&& E.getamount()==tran.getamount()){
	        		}else{
	        			temp.add(tran);
	        		}
	        	}
	        	E.approved=true;
	        	E.modifyFunds();
	        	temp.add(E);
	        	Utility.serialize(temp, "Transactions.ser");
	        return;
	        } catch(Exception e){
	            return;
	        }
    }
    
    /**
     * @return username
     */
    public String getuser() {
        return this.userName;
    }
    
    /**
     * @return Reason
     */
    public String getreason() {
        return this.reason;
        
    }
    /**
     * @return Amount
     */
    public double getamount() {
        return this.amount;
        
    }
    /**
     * @return Approval status
     */
    public boolean checkapproval() {
        return this.approved;
    }
    
    /**
     * Registering the transaction, pending approval
     * @return Status of registration
     */
    public boolean registertransaction() {
        ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        if(trans==null) {
        	trans=new ArrayList<Transaction>();
        }
        try{
        	trans.add(this);
        	Utility.serialize(trans, "Transactions.ser");
        	return true;
        }catch(Exception E){
            return false;
        }
    }
    
    /**
     * Print all the transactions
     */
    public void printall() {
    	ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        if(trans!=null)
        {
        for(Transaction tran:trans) {
        System.out.println(tran.approved + " " + tran.getuser());
        }
        }
    }
    
    /**
     * @return ArrayList of pending transactions
     */
    public static ArrayList<Transaction> getPending()
    {
        ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        ArrayList<Transaction> temp = new ArrayList<Transaction>();
        try{
        	for(Transaction tr : trans){
        		if(!tr.checkapproval()) {
        			temp.add(tr);
                }
        	}    
        }catch (NullPointerException e) {
        	e.printStackTrace();
       	}
        return temp;
    }
    /*
    public static void main(String[] args) {
    	Transaction one = new Transaction("swx","swx",33);
    //one.registertransaction();
    	one.printall();
    	ArrayList<Transaction> pend = Transaction.getPending();
    	//System.out.println(pend.get(0).getuser());
    	System.out.println(pend.size());
    	System.out.println(Transaction.approveTransaction(one));
    	one.printall();
    	
    	//pend = Transaction.getPending();
    	//System.out.println(pend.get(0).funds);
    	//System.out.println(pend.size()); 
    	
    	
    }
	*/
    
}
