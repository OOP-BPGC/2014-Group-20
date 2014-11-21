package nirmaan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Amit Patil
 *
 */
public class Event implements Serializable {
	private String userName;
	String name;
	Date startDate;
	Date endDate;
	ArrayList<Activity> activities;
	ArrayList<Person> participants;
	private boolean approved;
	
	/**
	 * @author Amit Patil
	 * Inner Class : Acitivity
	 */
	public class Activity implements Serializable {
		String name;
		int numStudents;
		Date date;
		String desc;
		
	}
	
	/**
	 * Class Constructor
	 * @param user username of the member
	 * @param eventName Name of the event
	 * @param startDate Start Date of the event
	 * @param endDate End date of the event
	 */
	public Event(String user, String eventName, Date startDate, Date endDate) {
		this.endDate = endDate;
		this.startDate = startDate;
		this.userName = user;
		this.name = eventName;
		activities = new ArrayList<Activity>();
		participants = new ArrayList<Person>();
	}
	
	/**
	 * Adds details of the activity
	 * @param name Name of the activity
	 * @param desc Activity description
	 * @param date Date of the activity
	 * @param numStudents Number of students involved
	 */
	public void addActivity(String name, String desc, Date date, int numStudents) {
		Activity activity = new Activity();
		activity.name = name;
		activity.date = date;
		activity.desc = desc;
		activity.numStudents = numStudents;
		activities.add(activity);
	}
	
	/**
	 * The method adds a person to the ArrayList of person
	 * @param person An instance of Person class
	 */
	public void addParticipants(Person person) {
		participants.add(person);
	}
	
	/**
	 * Approves an event
	 * @param e Event object
	 */
	public static void approve(Event e) {
		e.approved = true;
	}
	
	/**
	 * @return approval status of the event
	 */
	public boolean checkApproval() {
		return this.approved;
	}
	
	/**
	 * Adds an event to events.ser file only if dates are free.
	 */
	public void save() {
		ArrayList<Event> events;
		events = (ArrayList<Event>)Utility.deserialize("events.ser");
		if(events == null) {
			events = new ArrayList<Event>();
		}
		boolean flag = true;
		for(Event e :events)
        {         
            if(!(this.startDate.before(e.startDate)&&this.endDate.before(e.startDate)
            		||this.startDate.after(e.endDate)&&this.endDate.after(e.endDate)))
            	flag=false;
        }
        if(flag) {
        	events.add(this);
        }
		Utility.serialize(events, "events.ser");
	}
	
	/**
	 * @return An ArrayList of pending events
	 */
	public static ArrayList<Event> getPending(){
	    ArrayList<Event> event = new ArrayList<Event>();
	    event = (ArrayList<Event>)Utility.deserialize("Events.ser");
	    ArrayList<Event> temp = new ArrayList<Event>();
	    try{
	    	for(Event tr : event){
	    		if(!tr.checkApproval()){
	                temp.add(tr);
	            }
	        }
	    }catch(NullPointerException e){
	           e.printStackTrace();
	     }
	       
	    return temp;
	}
}
