package org.satal.diamonds.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.model.GridField;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.gemeView.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class AppView {


    protected static volatile Grid[][] grids = new Grid[(int) PROP.gridLineCount.getValue()][(int) PROP.gridLineCount.getValue()];
    public Pane startPane;

    public GridPane gridPane;
    public Pane gameField;
//    protected final GameView gameView;

    public AppView(GridPane gridPane) {
//        this.gameView = new GameView(this);
//        this.gridPane = new GameView(this);
        this.gridPane = gridPane;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
//                gridPane.getCellBounds(j, i);
//                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
                Label label = new Label("A");
                GridPane.setHalignment(label, HPos.CENTER);
                gridPane.add(label, j, i);
            }
        }
        gridPane.setBackground(Background.fill(Color.BLUE));



    }


    public void startGame(MouseEvent mouseEvent) {
        startPane.setVisible(false);
//        gridPane.setVisible(true);
    }

//    public boolean updateField(Grid[][] grids){
//    public boolean updateField(){
//        return gameView.updateField(grids);
//    }

    public void test(){
        System.out.println();
        System.out.println();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        gameField.setVisible(true);
//        gridPane.setVisible(true);
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Label label = new Label("A");
//                GridPane.setHalignment(label, HPos.CENTER);
//                gridPane.add(label, j, i);
//            }
//        }
//    }
}
