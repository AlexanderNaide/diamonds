package org.satal.diamonds.controller;

import javafx.scene.layout.GridPane;
import org.satal.diamonds.model.ButtonView;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;

public class GameController {
//    private final Grid[][] grids;
    private final GridPane gridPane;

    private int size;

//    public GameController(Grid[][] grids) {
    public GameController(GridPane gridPane) {
        this.gridPane = gridPane;
        this.size = (int) PROP.gridLineCount.getValue();
        fill();
    }

    private void fill(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//                grids[i][j] = new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1, i, j);
//                gridPane.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1, i, j), i, j);
                gridPane.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), i, j);
            }
        }
//        System.out.println("Заполнение всё");
    }

//    public Grid[][] getField() {
//        update();
//        return grids;
//    }

    public void update(){
        for (int i = 0; i < size; i++) {
            if (gridPane.getCellBounds(0, 1).isEmpty()){
//                gridPane.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1, 0, i), 0, 2);
                gridPane.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), 0, 2);
            }
        }
    }


}
