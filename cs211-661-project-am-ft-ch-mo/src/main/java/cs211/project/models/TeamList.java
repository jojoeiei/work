package cs211.project.models;

import java.util.ArrayList;

public class TeamList {
    private ArrayList<Team> teams;
    public TeamList(){
        teams = new ArrayList<>();
    }

    public void addNewTeam(String teamName, Integer teamMaxSeat, String registrationOpenDate, String registrationCloseDate){
        teamName = teamName.trim();
        if (!teamName.equals("") && teamMaxSeat != null && !registrationOpenDate.equals("") && !registrationCloseDate.equals("")){
            Team exist = findNameByTeamName(teamName);
            if (exist == null){
                teams.add(new Team(teamName, teamMaxSeat, registrationOpenDate, registrationCloseDate));
            }
        }
    }

    public Team findNameByTeamName(String teamName){
        for (Team team: teams){
            if (team.isTeamName(teamName)){
                return team;
            }
        }
        return null;
    }

    public ArrayList<Team> getTeams(){
        return teams;
    }
}
