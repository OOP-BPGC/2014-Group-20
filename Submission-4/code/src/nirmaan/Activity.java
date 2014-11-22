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
    public Activity(String name, Date d)
    {
        this.date=d;
        this.name=name;
    }
    public void setdate(Date d)
    {
        this.date=d;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    public Date getdate()
    {
        return this.date;
    }
    public String getname()
    {
        return this.name;
    }
}