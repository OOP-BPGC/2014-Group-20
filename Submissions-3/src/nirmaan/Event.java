package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Event implements Serializable {
	private String userName;
	String name;
	Date startDate;
	Date endDate;
	ArrayList<Activity> activities;
	ArrayList<Person> participants;
	private boolean approved;
	public class Activity implements Serializable {
		String name;
		int numStudents;
		Date date;
		String desc;
		
	}
	public Event(String user, String eventName, Date startDate, Date endDate) {
		this.endDate = endDate;
		this.startDate = startDate;
		this.userName = user;
		this.name = eventName;
		activities = new ArrayList<Activity>();
		participants = new ArrayList<Person>();
	}
	public void addActivity(String name, String desc, Date date, int numStudents) {
		Activity activity = new Activity();
		activity.name = name;
		activity.date = date;
		activity.desc = desc;
		activity.numStudents = numStudents;
		activities.add(activity);
	}
	public void addParticipants(Person person) {
		participants.add(person);
	}
	public static  void approve(Event e) {
		e.approved = true;
	}
	public boolean checkApproval() {
		return this.approved;
	}
	public void save() {
		ArrayList<Event> events;
		events = (ArrayList<Event>)Utility.deserialize("events.ser");
		if(events == null) {
			events = new ArrayList<Event>();
		}
		boolean flag = true;
		for(Event e :events)
        {         
            if(!(this.startDate.before(e.startDate)&&this.endDate.before(e.startDate)||this.startDate.after(e.endDate)&&this.endDate.after(e.endDate)))
            flag=false;
        }
        if(flag) {
        	events.add(this);
        }
		Utility.serialize(events, "events.ser");
	}
	 public static ArrayList<Event> getPending()
	    {
	        ArrayList<Event> event = new ArrayList<Event>();
	        event = (ArrayList<Event>)Utility.deserialize("Events.ser");
	        ArrayList<Event> temp = new ArrayList<Event>();
	       try
	       {for(Event tr : event)
	        {   if(!tr.checkApproval())
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
}