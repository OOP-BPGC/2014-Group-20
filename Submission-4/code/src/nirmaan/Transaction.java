package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public Transaction(String userName,String reason,double amount)
    {
        this.userName=userName;// while creating a transaction in the main code pass the member object's 
        this.reason=reason;//user name attribute there.to avoid repetition of code
        this.amount=amount;
        this.approved=false;
            }
    
   public void modifyFunds()
    {   
        if(this.approved)
        {	
        	funds = funds - this.getamount();
        	
            
        }
    }
   public double getFunds() {
	   return funds;
   }
   //Gives ConcurrentModificationException sometimes
    public static void approveTransaction(Transaction E)
    {
    	
	    	ArrayList<Transaction> trans;
	    	ArrayList<Transaction> temp = new ArrayList<Transaction>();
	        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
	        if(trans==null)
	        {
	        	return;
	        }
	        try
	        
	        {
	        	
	        	for(Transaction tran:trans) {
	        		if(E.getuser().equals(tran.getuser())&& E.getreason().equals(tran.getreason()) && E.getamount()==tran.getamount()){
	        			
	            }
	        	else{
	        		
	        		temp.add(tran);
	        	}
	        		
	        	}
	        E.approved=true;
	      
	        E.modifyFunds();
	        temp.add(E);
	        Utility.serialize(temp, "Transactions.ser");
	        return;
	        }
	        catch(Exception e)
	        {
	            return;
	                    }
	        
	        
	    	
	    
    	
    }
    public String getuser()
    {
        return this.userName;
    }
    public String getreason()
    {
        return this.reason;
        
    }
    public double getamount()
    {
        return this.amount;
        
    }
    public boolean checkapproval()
    {
        return this.approved;
    }
    
    public boolean registertransaction()
    {
        ArrayList<Transaction> trans;
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
    public ArrayList<Transaction> view() {
    	ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        return trans;
    }
    public static ArrayList<Transaction> getPending()
    {
        ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        ArrayList<Transaction> temp = new ArrayList<Transaction>();
       try
       {for(Transaction tr : trans)
        {   if(!tr.checkapproval())
            {
                temp.add(tr);
                
            }
                
        }
       }
       catch ( NullPointerException e)
       {
           
       }
        return temp;
        
        
    }
    
    public static void main(String[] args) {
    	
    	
    }
    
    
    
}
