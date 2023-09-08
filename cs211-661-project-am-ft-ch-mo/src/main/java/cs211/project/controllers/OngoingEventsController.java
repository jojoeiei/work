package cs211.project.controllers;

import cs211.project.models.Events;
import cs211.project.models.EventsList;
import cs211.project.models.User;
import cs211.project.models.UserList;
import cs211.project.services.Datasource;
import cs211.project.services.EventsListFileDatasource;
import cs211.project.services.FXRouter;
import cs211.project.services.UserListFileDatasource;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class OngoingEventsController {
    @FXML private Button onLogOutBtnClick;
    @FXML private Button onProfileButtonClick;
    @FXML private TextField searchEventsTextField;
    @FXML private TableView eventsTableView;

    private Datasource<EventsList> datasource;
    private EventsList eventsList;
    private String currentUser;

    @FXML
    public void initialize(){
        datasource = new EventsListFileDatasource("data", "events-list.csv");
        eventsList = datasource.readData();
        showTable(eventsList);

        currentUser = (String) FXRouter.getData();

        eventsTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Events>() {
            @Override
            public void changed(ObservableValue observable, Events oldValue, Events newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง
                        FXRouter.goTo("event-detail", newValue.getEventName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    @FXML
    public void showTable(EventsList eventsList){
        TableColumn<Events, String> eventNameColumn = new TableColumn<>("Event Name");
        eventNameColumn.setCellValueFactory(new PropertyValueFactory<>("eventName"));

        TableColumn<Events, String> eventDetailColumn = new TableColumn<>("Event Detail");
        eventDetailColumn.setCellValueFactory(new PropertyValueFactory<>("eventDetail"));

        TableColumn<Events, String> eventDateColumn = new TableColumn<>("Event Day");
        eventDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<Events, String> seatAvailableColumn = new TableColumn<>("Seat Available");
        seatAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("maxSeat"));

        eventsTableView.getColumns().clear();
        eventsTableView.getColumns().add(eventNameColumn);
        eventsTableView.getColumns().add(eventDetailColumn);
        eventsTableView.getColumns().add(eventDateColumn);
        eventsTableView.getColumns().add(seatAvailableColumn);

        eventsTableView.getItems().clear();

        for(Events events: eventsList.getEvents()){
            eventsTableView.getItems().add(events);
        }

    }

    @FXML
    private void onProfileButtonClick(){
        try {
            FXRouter.goTo("user-profile", currentUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onLogOutBtnClick(){
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}