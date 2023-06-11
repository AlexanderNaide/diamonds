package org.satal.diamonds.view.gemeView;

import lombok.RequiredArgsConstructor;
import org.satal.diamonds.controller.Controller;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.Properties;
import org.satal.diamonds.view.AppView;

@RequiredArgsConstructor
public class GameView {
    private final Controller controller;
    private final Properties properties;
    public void updateField(Grid[][] grids){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                ButtonView buttonView = new ButtonView(properties.getGridHeight());
                buttonView.setText(grids[i][j].getTitle());
                buttonView.setLayoutX(i * properties.getGridWidth());
                buttonView.setLayoutY(j * properties.getGridHeight());
                controller.gameField.getChildren().add(buttonView);
            }
        }
    }
}
