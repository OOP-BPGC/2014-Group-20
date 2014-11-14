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
	public void save() {
		ArrayList<Event> events;
		events = (ArrayList<Event>)Utility.deserialize("events.ser");
		if(events == null) {
			events = new ArrayList<Event>();
		}
		events.add(this);
		Utility.serialize(events, "events.ser");
	}
}
