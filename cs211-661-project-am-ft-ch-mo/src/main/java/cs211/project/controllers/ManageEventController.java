package cs211.project.controllers;

import cs211.project.services.FXRouter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class ManageEventController {
    @FXML
    private ImageView p1;
    @FXML
    private ImageView p2;
    @FXML
    private ImageView p3;
    @FXML
    private ImageView p4;

    @FXML
    protected void manageEventOneButtonClick() {//manageEventOneButton
        try {
            FXRouter.goTo(""); //fill in the blanks
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void manageEventTwoButtonClick() {//manageEventTwoButton
        try {
            FXRouter.goTo(""); //fill in the blanks
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void manageEventThreeButtonClick() {// manageEventThreeButton
        try {
            FXRouter.goTo(""); //fill in the blanks
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void manageEventFourButtonClick() {//manageEventFourButton
        try {
            FXRouter.goTo(""); //fill in the blanks
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void onCreateEventBtnClick() {//ปุ่ม event 1
        try {
            FXRouter.goTo("create-event"); //fill in the blanks
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
