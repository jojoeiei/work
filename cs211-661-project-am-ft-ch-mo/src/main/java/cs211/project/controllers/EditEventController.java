package cs211.project.controllers;

import cs211.project.models.Events;
import cs211.project.models.EventsList;
import cs211.project.services.Datasource;
import cs211.project.services.EventsListFileDatasource;
import cs211.project.services.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class EditEventController {
    @FXML
    private Label eventNameLabel;
    @FXML
    private Label eventDetailLabel;
    @FXML
    private Label maxSeatLabel;
    @FXML
    private Label eventStartDateLabel;
    @FXML
    private Label eventFinishDateLabel;
    @FXML
    private TextField editEventNameTextField;
    @FXML
    private TextField editDetailTextField;
    @FXML
    private TextField editMaxSeatTextField;
    @FXML
    private DatePicker editDateStart;
    @FXML
    private DatePicker editDateFinish;
    @FXML
    private TableView teamTableView;
    @FXML
    private ImageView eventImageView;

    private Datasource<EventsList> datasource;
    private EventsList eventsList;
    private Events events;
    Image image;

    @FXML
    public void initialize(){
        datasource = new EventsListFileDatasource("data", "events-list.csv");
        eventsList = datasource.readData();
        String eventName = (String) FXRouter.getData();
        events = eventsList.findEventByName(eventName);
        image = new Image("file:"+events.getEventImagePath(), true);
        showEvents(events);
    }

    private void showEvents(Events events){
        eventNameLabel.setText(events.getEventName());
        eventDetailLabel.setText(events.getEventDetail());
        maxSeatLabel.setText(String.valueOf(events.getMaxSeat()));
        eventStartDateLabel.setText(events.getStartDate());
        eventFinishDateLabel.setText(events.getFinishDate());
        eventImageView.setImage(image);

    }

    @FXML
    private void onCreateNewTeamBtnClick(){
        try {
            FXRouter.goTo("create-team");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onEditEventPictureBtnClick(){
        try {
            FXRouter.goTo("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onSaveBtnClick(){
        try {
            FXRouter.goTo("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    private void onBackBtnClick(){
        try {
            FXRouter.goTo("user-profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
