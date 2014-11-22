package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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
    
    /**
	 * Class Constructor
	 * @param user username of the member
	 * @param eventName Name of the event
	 * @param startDate Start Date of the event
	 * @param endDate End date of the event
	 */
    public Event(String Name,Date sd,Date ed)
    {	participants=new ArrayList<Person>();
        activities=new ArrayList<Activity>();
        this.name=Name;
        this.StartDate=sd;
        this.EndDate=ed;
    }
    
    
    /**
     * Approves an event
     * @param E Event object
     * @return Status of approval
     */
    public static boolean ApproveEvent(Event E)
    {
        E.approved=true;
        ArrayList<Event> events = new ArrayList<Event>();
        events=(ArrayList<Event>)Utility.deserialize("Events.ser");
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
        Utility.serialize(temp, "Events.ser");
        return found;
    }  
        
        
    
    /**
     * @param person Person
     */
    public void addParticipants(Person person) {
		participants.add(person);
	}
            
    /**
     * @return Event name
     */
    public String getEvent()
    {
        return this.name;
    }
    
    /**
     * @return Start Date
     */
    public Date getStartDate()
    {
        return this.StartDate;
        
    }
    
    /**
     * @return End Date
     */
    public Date getEndDate()
    {
        return this.EndDate;
        
    }
    
    /**
     * @return Check approval status of event
     */
    public boolean checkapproval()
    {
        return this.approved;
    }
    
    /**
     * Adds activities to an event
     * @param name Name of activity
     * @param date Date of activity
     */
    public void AddActivity(String name,Date date)
    {
        Activity newone=new Activity(name,date);
        
        this.activities.add(newone);
       
    }
    
    /**
     * Registers the event
     * @return registration status
     */
    public boolean registerEvent()
    {   
        ArrayList<Event> event = new ArrayList<Event>();
        event = (ArrayList<Event>)Utility.deserialize("Events.ser");
        if(event==null)
        {
        event=new ArrayList<Event>();
        }
        boolean flag=true;
        try
        {
            for(Event e :event)
            {         
                if(!(this.StartDate.before(e.StartDate)&&this.EndDate.before(e.StartDate)
                		||this.StartDate.after(e.EndDate)&&this.EndDate.after(e.EndDate)))
                	flag=false;
            }
            if(flag)
                event.add(this);
        Utility.serialize(event, "Events.ser");
        return flag;
        }catch(Exception E){
        	return false;
        }
        
        
    }
    
    /**
     * @return List of Pending Events
     */
    public static ArrayList<Event> getPending()
    {
        ArrayList<Event> event = new ArrayList<Event>();
        event = (ArrayList<Event>)Utility.deserialize("Events.ser");
        ArrayList<Event> temp = new ArrayList<Event>();
       try
       {	for(Event tr : event)
        	{   if(!tr.checkapproval())
            	{
        			temp.add(tr);
            	}
                
        	}
       }
       catch(NullPointerException e)
       {
           System.out.println("Null pointer exception");
       }
       
       return temp;
        
        
    }
    /**
     * @return List of all activities
     */
    public ArrayList<Activity> showallactivity()
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
