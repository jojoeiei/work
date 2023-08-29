package cs211.project.controllers;

import cs211.project.models.User;
import cs211.project.models.UserList;
import cs211.project.services.Datasource;
import cs211.project.services.FXRouter;
import cs211.project.services.UserListFileDatasource;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditProfileController {
    @FXML private Label errorLabel;
    @FXML private Label usernameLabel;
    @FXML private Label nameLabel;
    @FXML private TextField newNameTextField;
    @FXML private PasswordField currPasswordField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField confirmPasswordField;

    private Datasource<UserList> datasource;
    private UserList userList;
    private User user;

    @FXML
    public void initialize() {
        datasource = new UserListFileDatasource("data", "user-list.csv");
        userList = datasource.readData();
        errorLabel.setText("");

        String currentUser = (String) FXRouter.getData();
        user = userList.findUserByUsername(currentUser);
        usernameLabel.setText(user.getUsername());
        nameLabel.setText(user.getName());
    }
    @FXML
    private void onSaveEditProfileBtnClick(){
        String newNameText = newNameTextField.getText();
        String currPassText = currPasswordField.getText();
        String newPassText = newPasswordField.getText();
        String confirmPassText = confirmPasswordField.getText();

        if (!newNameText.equals("") && !currPassText.equals("") && !newPassText.equals("") && !confirmPassText.equals("")) {
            if (newPassText.equals(currPassText)) {
                errorLabel.setText("password cannot be same");
            }
            if (!currPassText.equals(user.getPassword())) {
                errorLabel.setText("wrong current password");
            }
            if (!confirmPassText.equals(newPassText)) {
                errorLabel.setText("password not match");
            }
            if (!newPassText.equals(currPassText) && currPassText.equals(user.getPassword()) && confirmPassText.equals(newPassText)){
                // todo : write new data to csv

                try {
                    FXRouter.goTo("user-profile");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            errorLabel.setText("please fill out the field");
        }
    }
}
