package org.satal.diamonds.controller;

import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import org.satal.diamonds.view.AppView;

import java.net.URL;
import java.util.ResourceBundle;
public class Controller extends AppView implements Initializable {
    public GridPane gridPane;
//    private GameController gameController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super(gridPane);

//        gameController = new GameController(gridPane);
        updateField();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Label label = new Label("A");
//                GridPane.setHalignment(label, HPos.CENTER);
//                gridPane.add(label, j, i);
//            }
//        }
    }

    private void updateField(){
        boolean finish = false;
//        while (!finish){

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
//            finish = super.updateField(gameController.getField());
//            gameController.update();
//            finish = super.updateField();

//            gameView.renderingGrids(grids);

//            finish = gameView.renderingGrids(grids);
//            finish = gameView.renderingGrids(gridPane);
//            finish = gridPane.renderingGrids(gridPane);
//            if (!finish){
//                gameController.update();
//            }

//            System.out.println("отправили updateField, сейчас finish = " + finish);
//            if (finish){
////            Grid[][] grids = gameController.getField();
//                for (int i = 0; i < 8; i++) {
//                    for (int j = 0; j < 8; j++) {
//                        if (grids[i][j] != null){
//                            System.out.print(grids[i][j].getText());
//                        } else {
//                            System.out.print("-");
//                        }
//                    }
//                    System.out.println();
//                }
//            }
//        }
    }

    public void OnDragDetected(MouseEvent mouseEvent) {
        System.out.println("OnDragDetected");
    }

    public void OnDragDone(DragEvent dragEvent) {
        System.out.println("OnDragDone");
    }

    public void OnDragDropped(DragEvent dragEvent) {
        System.out.println("OnDragDropped");
    }

    public void OnDragEntered(DragEvent dragEvent) {
        System.out.println("OnDragEntered");
    }

    public void OnDragExiterd(DragEvent dragEvent) {
        System.out.println("OnDragExiterd");
    }

    public void OnDragOver(DragEvent dragEvent) {
        System.out.println("OnDragOver");
    }

    public void OnMouseDragEnterd(MouseDragEvent event) {
        System.out.println("OnMouseDragEnterd");
    }

    public void OnMouseDragExited(MouseDragEvent event) {
        System.out.println("OnMouseDragExited");
    }

    public void OnMouseDragOver(MouseDragEvent event) {
        System.out.println("OnMouseDragOver");
    }

    public void OnMouseDragReleased(MouseDragEvent event) {
        System.out.println("OnMouseDragReleased");
    }
}