package org.satal.diamonds.view;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.model.GridField;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.gemeView.GameView;

public class AppView{


    protected static volatile Grid[][] grids = new Grid[(int) PROP.gridLineCount.getValue()][(int) PROP.gridLineCount.getValue()];
    public Pane startPane;
    public GridPane gridPane;
    public Pane gameField;
//    protected final GameView gameView;

    public AppView() {
//        this.gameView = new GameView(this);
        this.gridPane = new GameView(this);
    }


    public void startGame(MouseEvent mouseEvent) {
        startPane.setVisible(false);
        gridPane.setVisible(true);
    }

//    public boolean updateField(Grid[][] grids){
//    public boolean updateField(){
//        return gameView.updateField(grids);
//    }

    public void test(){
        System.out.println();
        System.out.println();
    }
}
