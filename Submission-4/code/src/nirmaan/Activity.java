package nirmaan;


import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sreejith
 */
public class Activity implements Serializable{
    Date date;
    String name;
    /**
     * Class Constructor
     * @param name Name of the activity
     * @param d Date of the Activity
     */
    public Activity(String name, Date d)
    {
        this.date=d;
        this.name=name;
    }
    /**
     * @param d Date
     */
    
    public void setdate(Date d)
    {
        this.date=d;
    }
    
    /**
     * @param name Activity name
     */
    public void setname(String name)
    {
        this.name=name;
    }
    /**
     * @return Date
     */
    public Date getdate()
    {
        return this.date;
    }
    /**
     * @return Name of the Activity
     */
    public String getname()
    {
        return this.name;
    }
}