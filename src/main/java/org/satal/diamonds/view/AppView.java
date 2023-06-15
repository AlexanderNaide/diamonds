package org.satal.diamonds.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.satal.diamonds.controller.Controller;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.model.GridField;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.gemeView.GameView;

import java.net.URL;
import java.util.ResourceBundle;

public class AppView {


//    protected static volatile Grid[][] grids = new Grid[(int) PROP.gridLineCount.getValue()][(int) PROP.gridLineCount.getValue()];

    @FXML
    public Pane startPane;
    @FXML
    public Pane gameField;
    public GridPane gridPane;

    GameView gameView;

    public void init(){
        gameView = new GameView(this);
        gridPane = gameView;
        gridPane.setPrefSize(PROP.gameWindowHeight.getValue(), PROP.gameWindowWidth.getValue());
        gameField.getChildren().add(0, gridPane);
    }

    public void restart(MouseEvent mouseEvent) {
        gameView = new GameView(this);
        gridPane = gameView;
        gridPane.setPrefSize(PROP.gameWindowHeight.getValue(), PROP.gameWindowWidth.getValue());
        gameField.getChildren().add(0, gridPane);
    }

//    public AppView() {
//        this.gameView = new GameView(this);
//        this.gridPane = new GameView(this);
//        this.gridPane = new GameView(this);
//        gridPane.setPrefSize(60, PROP.gameWindowWidth.getValue());
//        System.out.println(gameField.getChildren().size());

//        gameField.getChildren()
//        gameField.getChildren().add(0, gridPane);

//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
////                gridPane.getCellBounds(j, i);
////                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
//                Label label = new Label("A");
//                GridPane.setHalignment(label, HPos.CENTER);
//                gridPane.add(label, j, i);
//            }
//        }
//        gridPane.setBackground(Background.fill(Color.BLUE));



//    }


    @FXML
    public void startGame(MouseEvent mouseEvent) {
        startPane.setVisible(false);
        gameField.setVisible(true);
    }

//    public boolean updateField(Grid[][] grids){
//    public boolean updateField(){
//        return gameView.updateField(grids);
//    }


    public void test(){
        gameView.test_getRemoved();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {

//        this.gridPane = new GridPane();

//        System.out.println(gameField.getChildren().size());

//        gameField.getChildren()



//        gameField.setVisible(true);
//        gridPane.setVisible(true);



//        System.out.println(gameField.getChildren().size());
//        this.gridPane = new GameView(this);
//        gridPane.setPrefSize(PROP.gameWindowHeight.getValue(), PROP.gameWindowWidth.getValue());
//        gameField.getChildren().add(0, gridPane);
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Label label = new Label("A");
//                GridPane.setHalignment(label, HPos.CENTER);
//                gridPane.add(label, j, i);
//            }
//        }
//    }
}
