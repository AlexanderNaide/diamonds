package org.satal.diamonds.controller;

import javafx.fxml.Initializable;
import org.satal.diamonds.view.AppView;

import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends AppView implements Initializable {


    private GameController gameController;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameController = new GameController();
        super.updateField(gameController.getField());
    }
}