package cs211.project.models;

public class Events {
    private String eventName;
    private String eventDetail;
    private Integer maxSeat;
    private String startDate;
    private String finishDate;
    private String eventImagePath = "/events/samplePic.png";
    private String eventCreatorUsername;

    public Events(String eventName, String eventDetail, int maxSeat, String startDate, String finishDate, String eventImagePath, String eventCreatorUsername) {
        this.eventName = eventName;
        this.eventDetail = eventDetail;
        this.maxSeat = maxSeat;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.eventImagePath = eventImagePath;
        this.eventCreatorUsername = eventCreatorUsername;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public int getMaxSeat() {
        return maxSeat;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getEventImagePath() { return eventImagePath; }
    public String getEventCreatorUsername(){ return  eventCreatorUsername; }

    public void setEventImagePath(String eventImagePath) {
        this.eventImagePath = eventImagePath;
    }

    public boolean isEventName(String eventName) {
        return this.eventName.equals(eventName);
    }
    public boolean isCreatorUsername(String eventCreatorUsername){
        return this.eventCreatorUsername.equals(eventCreatorUsername);
    }
}