package cs211.project.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Events{
    private String eventName; //Event name
    private String eventDetail; // Event Detailed
    private String eventDate; // Event Day
    private String eventRegistrationEndDate; // Event End Date for Registration
    private int seatAvailable; // Available Seat for User to Join
    private int seatTaken; // Seat Taken by User
    private String eventImagePath; // Event Image Path

    public Events(String eventName, String eventDetail, String eventDate, String eventRegistrationEndDate, int seatAvailable, int seatTaken, String eventImagePath) {
        this.eventName = eventName;
        this.eventDetail = eventDetail;
        this.eventDate = eventDate;
        this.eventRegistrationEndDate = eventRegistrationEndDate;
        this.seatAvailable = seatAvailable;
        this.seatTaken = seatTaken;
        this.eventImagePath = eventImagePath;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventRegistrationEndDate() {
        return eventRegistrationEndDate;
    }

    public int getSeatAvailable() {
        return seatAvailable;
    }

    public int getSeatTaken() {
        return seatTaken;
    }

    public String getEventImagePath() {
        return eventImagePath;
    }

    public boolean isEventName(String eventName) {
        return this.eventName.equals(eventName);
    }

    @Override
    public String toString() {
        return "Events{" +
                "eventName='" + eventName + '\'' +
                ", eventDetail='" + eventDetail + '\'' +
                ", eventRegistrationStartDate='" + eventDate + '\'' +
                ", eventRegistrationEndDate='" + eventRegistrationEndDate + '\'' +
                ", seatAvailable=" + seatAvailable +
                ", seatTaken=" + seatTaken +
                ", eventImagePath='" + eventImagePath + '\'' +
                '}';
    }
}
