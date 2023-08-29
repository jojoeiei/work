package cs211.project.controllers;

import cs211.project.models.User;
import cs211.project.models.UserList;
import cs211.project.services.Datasource;
import cs211.project.services.FXRouter;
import cs211.project.services.UserListFileDatasource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class UserProfileController {
    private Datasource<UserList> datasource;
    private UserList userList;
    private User user;
    @FXML private Label nameLabel;
    @FXML private Label usernameLabel;

    @FXML
    public void initialize() {
        datasource = new UserListFileDatasource("data", "user-list.csv");
        userList = datasource.readData();

        String currentUser = (String) FXRouter.getData();
        user = userList.findUserByUsername(currentUser);
        nameLabel.setText(user.getName());
        usernameLabel.setText(user.getUsername());
    }
    @FXML
    void eventsBtnClick() {
        try {
            FXRouter.goTo("events");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void eventOneButtonClick() {//ปุ่ม event 1
        try {
            FXRouter.goTo("event-detail"); //เอาไปเติมนะ
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void eventTwoButtonClick() {//ปุ่ม event 2
        try {
            FXRouter.goTo("event-detail"); //เอาไปเติมนะ
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void eventThreeButtonClick() {//ปุ่ม event 3
        try {
            FXRouter.goTo("event-detail"); //เอาไปเติมนะ
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void eventFourButtonClick() {//ปุ่ม event 4
        try {
            FXRouter.goTo("event-detail"); //เอาไปเติมนะ
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onEditProfileBtnClick(){
        try {
            FXRouter.goTo("edit-profile", user.getUsername());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onManageEventBtnClick(){
        try {
            FXRouter.goTo("manage-event");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
