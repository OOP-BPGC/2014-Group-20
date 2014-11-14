package nirmaan;

import java.io.Serializable;

/**
 * @author Raghav
 */

public class Funds implements Serializable {
    private double fund;
    Funds() {
        this.fund=0.0;
    }
    public void setFund(double amt) {
        this.fund=amt;
        
    }
    public boolean deduct(double Funddeduct) {   
        this.fund-=Funddeduct;
        if(this.fund<0) { 
        	System.out.println("Cannot perform transaction Funds empty");
            this.fund+=Funddeduct;
            return false;
        }
        return true;
    }
    public void add(double newfund) {
        fund+=newfund;
    }
}
