
package nirmaan;


import java.io.Serializable;
import java.util.ArrayList;
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
public class Event implements Serializable{
    
    private ArrayList<Activity> activities;
    private String name;
    private Date StartDate;
    private Date EndDate;
    private ArrayList<Person> participants;
    private boolean approved;
    public Event(String Name,Date sd,Date ed)
    {	participants=new ArrayList<Person>();
        activities=new ArrayList<Activity>();
        this.name=Name;
        this.StartDate=sd;
        this.EndDate=ed;
    }
    public static boolean ApproveEvent(Event E)
    {
        E.approved=true;
        ArrayList<Event> events = new ArrayList<Event>();
        events=(ArrayList<Event>)Utility.deserialize("/home/sreejith/NetBeansProjects/WebApplication1/src/java/src/Events.ser");
        if(events.size()==0)
            return false;
        ArrayList<Event> temp = new ArrayList<Event>();
        boolean found=false;
        for(Event e : events)
        {
            if(!(e.getEvent().equals(E.getEvent())&&e.getStartDate().equals(E.getStartDate())))
            {   found=true;
                temp.add(e);
                
            }
        }
        temp.add(E);
        Utility.serialize(temp, "/home/sreejith/NetBeansProjects/WebApplication1/src/java/src/Events.ser");
        return found;
        
        
        
    }
    public void addParticipants(Person person) {
		participants.add(person);
	}
            
    public String getEvent()
    {
        return this.name;
    }
    public Date getStartDate()
    {
        return this.StartDate;
        
    }
    public Date getEndDate()
    {
        return this.EndDate;
        
    }
    public boolean checkapproval()
    {
        return this.approved;
    }
    public void AddActivity(String name,Date date)
    {
        Activity newone=new Activity(name,date);
        
        this.activities.add(newone);
       
    }
    
    public boolean registerEvent()
    {   
        ArrayList<Event> event = new ArrayList<Event>();
        event = (ArrayList<Event>)Utility.deserialize("/home/sreejith/NetBeansProjects/WebApplication1/src/java/src/Events.ser");
        if(event==null)
        {
        event=new ArrayList<Event>();
        }
        boolean flag=true;
        try
        {
            for(Event e :event)
            {         
                if(!(this.StartDate.before(e.StartDate)&&this.EndDate.before(e.StartDate)||this.StartDate.after(e.EndDate)&&this.EndDate.after(e.EndDate)))
                flag=false;
            }
            if(flag)
                event.add(this);
        Utility.serialize(event, "/home/sreejith/NetBeansProjects/WebApplication1/src/java/src/Events.ser");
        return flag;
        }
        catch(Exception E)
        {
            return false;
                    }
        
        
        }
    public static ArrayList<Event> getPending()
    {
        ArrayList<Event> event = new ArrayList<Event>();
        event = (ArrayList<Event>)Utility.deserialize("/home/sreejith/NetBeansProjects/WebApplication1/src/java/src/Events.ser");
        ArrayList<Event> temp = new ArrayList<Event>();
       try
       {for(Event tr : event)
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
    public  ArrayList<Activity> showallactivity()
    {
        
         return this.activities;
        
    }
  /* public static void main(String args[])
    {   
        Date start= new Date(2014, 1, 1);
        Date end = new Date(2014,1,4);
        Event instance = new Event("testevent", start,end);
        //System.out.println(instance.registerEvent());
        
        
        
        ArrayList<Event> e= new ArrayList<Event>();
        
                
           e=Event.getPending();
        //Event.ApproveEvent(e.get(0));
           e=Event.getPending();
        
        for(Event a : e)
        {
            System.out.println(a.getEvent());
        }
        
    }
   */
    
}
