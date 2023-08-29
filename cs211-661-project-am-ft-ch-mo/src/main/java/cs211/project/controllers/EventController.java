package cs211.project.controllers;

import cs211.project.models.Events;
import cs211.project.models.EventsList;
import cs211.project.models.UserList;
import cs211.project.services.Datasource;
import cs211.project.services.EventsListFileDatasource;
import cs211.project.services.FXRouter;
import cs211.project.services.UserListFileDatasource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class EventController {
    @FXML private Label eventNameLabel;
    @FXML private Label dateLabel;
    @FXML private Label seatLabel;
    @FXML private Label detailLabel;
    @FXML private Label registerDayLabel;
    @FXML private ImageView eventImageView;

    private Datasource<EventsList> datasource;
    private EventsList eventsList;
    private Events events;


    @FXML
    public void initialize() {
        datasource = new EventsListFileDatasource("data", "events-list.csv");
        eventsList = datasource.readData();

        String eventName = (String) FXRouter.getData();
        events = eventsList.findNameByEventName(eventName);
        showEvents(events);
    }



    private void showEvents(Events events) {
        eventNameLabel.setText(events.getEventName());
        dateLabel.setText(events.getEventDate());
        seatLabel.setText(String.valueOf(events.getSeatAvailable()));
        detailLabel.setText(events.getEventDetail());
        registerDayLabel.setText(events.getEventRegistrationEndDate());
        //eventImageView.setText(events.getEventImagePath());
       //Image image = new Image(getClass().getResource("/images/...").toString());
        // eventImageView.setImage(image);
    }



    @FXML
    protected void joinAsTeamBtnClick() {

    }

    @FXML
    protected void joinBtnClick() {

    }
    @FXML
    protected void profileBtnClick() {
        try {
            FXRouter.goTo("user-profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void eventsBtnClick() {
        try {
            FXRouter.goTo("events");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onJoinAsTeamBtnClick(){
        try {
            FXRouter.goTo("join-as-team");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
