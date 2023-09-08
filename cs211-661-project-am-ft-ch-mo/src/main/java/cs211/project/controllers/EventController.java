package cs211.project.controllers;

import cs211.project.models.Events;
import cs211.project.models.EventsList;
import cs211.project.services.Datasource;
import cs211.project.services.EventsListFileDatasource;
import cs211.project.services.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class EventController {
    @FXML private Label eventNameLabel;
    @FXML private Label dateLabel;
    @FXML private Label seatLabel;
    @FXML private Label detailLabel;
    @FXML private ImageView eventImageView;

    private Datasource<EventsList> datasource;
    private EventsList eventsList;
    private Events events;
    Image image;
    @FXML
    public void initialize() {
        datasource = new EventsListFileDatasource("data", "events-list.csv");
        eventsList = datasource.readData();

        String eventName = (String) FXRouter.getData();
        System.out.println(eventName);
        events = eventsList.findEventByName(eventName);
        System.out.println(events.getEventImagePath());
        image = new Image("file:"+events.getEventImagePath());
        System.out.println(image.getClass());
        showEvents(events);
    }



    private void showEvents(Events events) {
        eventNameLabel.setText(events.getEventName());
        dateLabel.setText(events.getStartDate());
        seatLabel.setText(String.valueOf(events.getMaxSeat()));
        detailLabel.setText(events.getEventDetail());
        eventImageView.setImage(image);
    }

    @FXML
    protected void joinBtnClick() {

    }

    @FXML
    protected void backBtnClick() {
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
