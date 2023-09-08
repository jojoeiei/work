package cs211.project.controllers;

import cs211.project.models.Team;
import cs211.project.models.TeamList;
import cs211.project.services.Datasource;
import cs211.project.services.FXRouter;
import cs211.project.services.TeamListFileDatasource;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.PrivateKey;

public class CreateTeamController {
    @FXML
    private TextField teamNameTextField;
    @FXML
    private TextField teamMaxSeatTextField;
    @FXML
    private DatePicker registOpen;
    @FXML
    private DatePicker registClose;

    private TeamList teamList;
    private Team team;
    private Datasource<TeamList> datasource;

    @FXML
    public void initialize(){
        datasource = new TeamListFileDatasource("data", "team-list.csv");
        teamList = datasource.readData();
    }

    @FXML
    protected void onCreateTeamBtnClick(){
        String teamNameText = teamNameTextField.getText();
        Integer teamMaxSeatText = Integer.valueOf(teamMaxSeatTextField.getText());
        String registOpenText = String.valueOf(registOpen.getValue());
        String registCloseText = String.valueOf(registClose.getValue());

        if (team != null){
            TeamList teamList = new TeamList();
            teamList.addNewTeam(teamNameText,teamMaxSeatText,registOpenText,registCloseText);
            datasource.writeData(teamList);

            try {
                FXRouter.goTo("create-event");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("Team can't create");
        }
    }


    @FXML
    private void onBackBtnClick(){
        try {
            FXRouter.goTo("create-event");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
