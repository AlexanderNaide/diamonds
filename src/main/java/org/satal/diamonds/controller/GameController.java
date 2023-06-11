package org.satal.diamonds.controller;

import org.satal.diamonds.model.Grid;
import org.satal.diamonds.model.GridString;
import org.satal.diamonds.properties.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GameController {

    private Grid[][] field;
    private Properties properties;


//    public GameController() {
////        this.field = new Grid[8][8];
//        this.field = new Grid[properties.getGridLineCount()][properties.getGridLineCount()];
//        reload();
//    }

    @Autowired
    public void init(Properties properties){
        this.properties = properties;
        this.field = new Grid[properties.getGridLineCount()][properties.getGridLineCount()];
        System.out.println(field.length);
        reload();
    }

    private void reload(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new GridString((int) (Math.random() * 4) + 1);
            }
        }
    }

    public Grid[][] getField() {
        return field;
    }
}
