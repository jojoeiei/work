package cs211.project.models;

public class Team {

    private String teamName;
    private Integer teamMaxSeat;
    private String registrationOpenDate;
    private String registrationCloseDate;
    private String teamInEvent;

    public Team(String teamName, int teamMaxSeat, String registrationOpenDate, String registrationCloseDate) {
        this.teamName = teamName;
        this.teamMaxSeat = teamMaxSeat;
        this.registrationOpenDate = registrationOpenDate;
        this.registrationCloseDate = registrationCloseDate;
    }

    public String getTeamName() { return teamName; }

    public int getTeamMaxSeat() { return teamMaxSeat; }

    public String getRegistrationOpenDate() { return registrationOpenDate; }

    public String getRegistrationCloseDate() { return registrationCloseDate; }

    public boolean isTeamName(String teamName){
        return this.teamName.equals(teamName);
    }
}
