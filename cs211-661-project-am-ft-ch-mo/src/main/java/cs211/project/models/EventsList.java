package cs211.project.models;

import java.util.ArrayList;
import java.util.List;

public class EventsList {
    private ArrayList<Events> events;
    public EventsList() {
        events = new ArrayList<>();
    }
    public void addNewEvent(String eventName , String eventDetail, String eventDate, String eventRegistrationEndDate,int seatAvailable, int seatTaken , String eventImagePath) {
        eventName = eventName.trim();
        eventDetail = eventDetail.trim();
        eventDate = eventDate.trim();
        eventRegistrationEndDate = eventRegistrationEndDate.trim();
        eventImagePath = eventImagePath.trim();
        seatAvailable = seatAvailable;
        seatTaken = seatTaken;
        if (!eventName.equals("") && !eventDetail.equals("") && !eventDate.equals("") && !eventRegistrationEndDate.equals("") && !eventImagePath.equals("")) {
            Events exist = findNameByEventName(eventName);
            if (exist == null) {
                events.add(new Events(eventName.trim(), eventDetail.trim(), eventDate.trim(), eventRegistrationEndDate.trim(),seatAvailable,seatTaken,eventImagePath.trim()));
            }
        }
    }

    public Events findNameByEventName(String eventName) {
        for (Events event : events) {
            if (event.isEventName(eventName)) {
                return event;
            }
        }
        return null;
    }
    public void changeInfo(String eventName, String eventDetail, String eventDate, String eventRegistrationEndDate,int seatAvailable, String eventImagePath) {
        Events exist = findNameByEventName(eventName);
        if (exist != null) {
          //  exist.addInfo(username, name, password);
        }

    }
    public ArrayList<Events> getEvents() {
        return events;
    }

}
