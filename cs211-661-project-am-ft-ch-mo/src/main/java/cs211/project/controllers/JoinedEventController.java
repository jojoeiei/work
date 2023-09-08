package cs211.project.controllers;

import cs211.project.services.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.IOException;

public class JoinedEventController {
    @FXML
    private TableView finishedEventTableView;
    @FXML
    private TableView activeEventTableView;
    private String currentUser;

    public void initialize() {
        currentUser = (String) FXRouter.getData();
    }

    public void onBackBtnClick() {
        try {
            FXRouter.goTo("user-profile", currentUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
