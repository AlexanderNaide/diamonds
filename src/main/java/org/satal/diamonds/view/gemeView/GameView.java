package org.satal.diamonds.view.gemeView;

import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.AppView;

public class GameView {

    private final AppView appView;
    private final double gridSize;

    public GameView(AppView appView) {
        this.appView = appView;
        this.gridSize = PROP.gridHeight.getValue();
    }

    public boolean updateField(Grid[][] grids){

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != null){
                    if(!grids[i][j].getCorrect()){
//                        appView.gameField.getChildren().remove(grids[i][j]);
                        grids[i][j] = null;
                    } else if (!appView.gameField.getChildren().contains(grids[i][j])) {
                        grids[i][j].setLayoutX(j * gridSize);
                        grids[i][j].setLayoutY(i * gridSize);
                        appView.gameField.getChildren().add(grids[i][j]);
                    }
                }
            }
        }
        parse(grids);
        return gridFall(grids);

//        TranslateTransition transition = new TranslateTransition(duration, grids[0][0]);
//        transition.setByY(PROP.gameWindowHeight.getValue() - PROP.gridHeight.getValue());
//        transition.setAutoReverse(true);
//        transition.setCycleCount(6);
//        transition.play();
    }

    public boolean gridFall(Grid[][] grids){
        boolean result = false;
        for (int i = grids.length - 1; i >= 0; i--) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] == null){
                    result = true;
                    for (int k = i - 1; k >= 0; k--) {
                        if (grids[k][j] != null){
                            grids[i][j] = grids[k][j];
                            grids[i][j].fall(i, k);
//                            appView.gameField.getChildren().remove(grids[k][j]);
                            grids[k][j] = null;
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println("gridFall " + !result);
        return !result;
    }

    public void parse(Grid[][] grids){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != null){
                    String x = grids[i][j].getText();
                    if (i < grids.length - 2 && grids[i + 1][j] != null && grids[i + 1][j].getText().equals(x)){
                        if(grids[i + 2][j] != null && grids[i + 2][j].getText().equals(x)){
                            grids[i][j].setCorrect(false);
                            grids[i + 1][j].setCorrect(false);
                            grids[i + 2][j].setCorrect(false);
                        }
                    }
                    if (j < grids[i].length - 2 && grids[i][j + 1] != null && grids[i][j + 1].getText().equals(x)){
                        if(grids[i][j + 2] != null && grids[i][j + 2].getText().equals(x)){
                            grids[i][j].setCorrect(false);
                            grids[i][j + 1].setCorrect(false);
                            grids[i][j + 2].setCorrect(false);
                        }
                    }
                }
            }
        }
    }
}
