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
    private boolean approved;
    public Transaction(String userName,String reason,double amount)
    {
        this.userName=userName;// while creating a transaction in the main code pass the member object's 
        this.reason=reason;//user name attribute there.to avoid repetition of code
        this.amount=amount;
        this.approved=false;
            }
    
    private void modifyFunds()
    {   
        if(this.approved)
        {	
        	funds = funds - this.getamount();
        	
            
        }
    }
   
    public static boolean approveTransaction(Transaction E)
    {
    	if(E.approved == false) {
    	ArrayList<Transaction> trans;
        trans = (ArrayList<Transaction>)Utility.deserialize("Transactions.ser");
        if(trans==null)
        {
        	System.out.println("here");
        return false;
        }
        try
        
        {
        	boolean rem = false;
        	for(Transaction tran:trans) {
        		if(E.getuser().equals(tran.getuser())&& E.getreason().equals(tran.getreason()) && E.getamount()==tran.getamount())
        		rem = trans.remove(tran);
            }
        		
        	
        E.approved=true;
        System.out.println(E.approved+ "  " + rem);
        E.modifyFunds();
        trans.add(E);
        Utility.serialize(trans, "Transactions.ser");
        return true;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	return false;
            
                    }
        
        
    	
            }
    	else {
    		System.out.println("here1");
    		return false;
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
    	Transaction one = new Transaction("swx","swx",33);
    //one.registertransaction();
    	one.printall();
    	ArrayList<Transaction> pend = Transaction.getPending();
    	//System.out.println(pend.get(0).getuser());
    	System.out.println(pend.size());
    	System.out.println(Transaction.approveTransaction(one));
    	one.printall();
    	
    	/*pend = Transaction.getPending();
    	System.out.println(pend.get(0).funds);
    	System.out.println(pend.size()); */
    	
    	
    }
    
    
    
}
