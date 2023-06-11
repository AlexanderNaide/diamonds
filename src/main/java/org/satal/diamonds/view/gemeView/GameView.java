package org.satal.diamonds.view.gemeView;

import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.AppView;

public class GameView {

    private final AppView appView;
    private final int gridSize;

    public GameView(AppView appView) {
        this.appView = appView;
        this.gridSize = PROP.gridHeight.getValue();
    }

    public void updateField(Grid[][] grids){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                ButtonView buttonView = new ButtonView(gridSize);
                buttonView.setText(grids[i][j].getTitle());
                buttonView.setLayoutX(i * gridSize);
                buttonView.setLayoutY(j * gridSize);
                if(grids[i][j].getTitle().equals("X")){
                    buttonView.setBackground(Background.fill(Color.RED));
                }
                appView.gameField.getChildren().add(buttonView);
            }
        }
    }
}
