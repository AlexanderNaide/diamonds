package org.satal.diamonds.view;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.view.gemeView.GameView;

public class AppView{
    public Pane startPane;
    public Pane gridPane;
    public Pane gameField;
    private final GameView gameView;

    public AppView() {
        this.gameView = new GameView(this);
    }


    public void startGame(MouseEvent mouseEvent) {
        startPane.setVisible(false);
        gridPane.setVisible(true);
    }

    public void updateField(Grid[][] grids){
        gameView.updateField(grids);
    }

    public void test(){
        System.out.println();
        System.out.println();
    }
}
