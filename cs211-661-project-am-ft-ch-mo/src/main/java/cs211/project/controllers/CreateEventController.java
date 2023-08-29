package cs211.project.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import cs211.project.services.FXRouter;

import java.io.IOException;
public class CreateEventController {
    @FXML
    private TextField eventNameTextField;
    @FXML
    private TextField maxseatTextField;
    @FXML
    private TextField maxteammemberTextField;
    @FXML
    private TextField detailsTextField;
    @FXML
    private TextField ddTextField1;
    @FXML
    private TextField mmTextField1;
    @FXML
    private TextField yyTextField1;
    @FXML
    private TextField ddTextField2;
    @FXML
    private TextField mmTextField2;
    @FXML
    private TextField yyTextField2;
    @FXML
    private TextField ddTextField3;
    @FXML
    private TextField mmTextField3;
    @FXML
    private TextField yyTextField3;

    @FXML
    protected void uploadfileButtonClick(){ //ปุ่มของ upload file
        try{
            FXRouter.goTo(""); //ยังไม่มี
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void createButtonClick(){ //ปุ่มของ create
        try{
            FXRouter.goTo(""); //ยังไม่มี
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void onBackBtnClick(){
        try {
            FXRouter.goTo("manage-event");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}