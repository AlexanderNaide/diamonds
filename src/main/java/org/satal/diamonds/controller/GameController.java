package org.satal.diamonds.controller;

import org.satal.diamonds.model.Grid;
import org.satal.diamonds.model.GridString;
import org.satal.diamonds.properties.PROP;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class GameController {

    private final Grid[][] field;


    public GameController() {
        int count = PROP.gridLineCount.getValue();
        this.field = new Grid[count][count];
        reload();
    }

    private void reload(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new GridString((int) (Math.random() * 4) + 1, i, j);
            }
        }
    }

    public Grid[][] getField() {
        parse();
        return field;
    }

    public void parse(){
        LinkedHashSet<Grid> list = new LinkedHashSet<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                String x = field[i][j].getTitle();
                if (i < field.length - 2 && field[i + 1][j].getTitle().equals(x)){
                    if(field[i + 2][j].getTitle().equals(x)){
                        list.addAll(List.of(field[i][j], field[i + 1][j], field[i + 2][j]));
                    }
                }
                if (j < field[i].length - 2 && field[i][j + 1].getTitle().equals(x)){
                    if(field[i][j + 1].getTitle().equals(x)){
                        list.addAll(List.of(field[i][j], field[i][j + 1], field[i][j + 2]));
                    }
                }
            }
        }
        if (list.size() > 0){
            for (Grid grid : list) {
                grid.setTitle("X");
            }
        }
    }
}
