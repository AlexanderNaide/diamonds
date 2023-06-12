package org.satal.diamonds.controller;

import javafx.fxml.Initializable;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.view.AppView;

import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends AppView implements Initializable {


    private GameController gameController;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameController = new GameController();
        updateField();
    }

    private void updateField(){
        boolean finish = false;
        while (!finish){

//            Grid[][] grids = gameController.getField();
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 8; j++) {
//                    if (grids[i][j] != null){
//                        System.out.print(grids[i][j].getText());
//                    } else {
//                        System.out.print("-");
//                    }
//                }
//                System.out.println();
//            }

//            System.out.println("запросили updateField, сейчас finish = " + finish);
            finish = super.updateField(gameController.getField());
//            System.out.println("отправили updateField, сейчас finish = " + finish);
        }
    }
}