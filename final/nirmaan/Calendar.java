package nirmaan;

import java.util.ArrayList;

import nirmaan.Event.Activity;

public class Calendar {
	public String smallCalendar() {
		ArrayList<Event> events;
		events = (ArrayList<Event>)Utility.deserialize("events.ser");
		String calendar = "";
		if (events != null) {
			for(Event event: events) {
				calendar = calendar + event.name + " from "  + event.startDate.toString()  + " to "  + event.endDate.toString() + "\n Activities:";
				for(Activity activity: event.activities) {
					calendar = calendar + activity.name + " on " + activity.date.toString();
				}
			}
		}
		return calendar;
	}
}
