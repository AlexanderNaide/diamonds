package org.satal.diamonds.controller;

import org.satal.diamonds.model.ButtonView;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;

public class GameController {
    private final Grid[][] grids;

    public GameController() {
        double count = PROP.gridLineCount.getValue();
        this.grids = new Grid[(int) count][(int) count];
        reload();
    }

    private void reload(){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1);
            }
        }
    }

    public Grid[][] getField() {
        update();
        return grids;
    }

    private void update(){
        for (int i = 0; i < grids.length; i++) {
            if (grids[0][i] == null){
                grids[0][i] = new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1);
            }
        }
    }


}
