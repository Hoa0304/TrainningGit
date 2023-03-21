package com.ttchoa22ite.population.controllers.home;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeController implements Initializable {

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageButton;

    @FXML
    private Button permanan;

    @FXML
    void getResident(MouseEvent event) {
        if (event.getSource()== permanan ){
            try {
                Parent parent = FXMLLoader.load(((getClass().getResource("resident.fxml"))));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                scene.setFill(Color.TRANSPARENT);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ResidentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    void logout(MouseEvent event){
        if (event.getSource()== logoutBtn){
            try {
                Parent parent = FXMLLoader.load(((getClass().getResource("loginAdmin.fxml"))));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                scene.setFill(Color.TRANSPARENT);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ResidentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }
}

