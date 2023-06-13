package org.satal.diamonds.view.gemeView;

import javafx.scene.layout.GridPane;
import org.satal.diamonds.model.ButtonView;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.AppView;

public class GameView extends GridPane {

    private final AppView appView;
//    private final double gridSize;

    public GameView(AppView appView) {
        this.appView = appView;
        fill(PROP.gridLineCount.getValue());
    }

    private void fill(Double count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
            }
        }
    }

    public void update(){
        for (int i = 0; i < this.getColumnCount(); i++) {
            if (this.getCellBounds(i, 0).isEmpty()){
                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), i, 0);
            }
        }
    }

    public boolean renderingGrids(Grid[][] grids){
//        parse(grids);
//        for (int i = 0; i < grids.length; i++) {
//            for (int j = 0; j < grids[i].length; j++) {
//                if (grids[i][j] != null){
//                    if(!grids[i][j].getCorrect()){
////                        appView.gameField.getChildren().remove(grids[i][j]);
//                        grids[i][j] = null;
//                    } else if (!appView.gameField.getChildren().contains(grids[i][j])) {
//                        grids[i][j].setLayoutX(j * gridSize);
//                        grids[i][j].setLayoutY(i * gridSize);
//                        appView.gameField.getChildren().add(grids[i][j]);
//                    }
//                }
//            }
//        }


        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] != null && !appView.gameField.getChildren().contains(grids[i][j])){
//                    grids[i][j].setI(i);
//                    grids[i][j].setJ(j);
                    grids[i][j].setLayoutY(i * gridSize);
                    grids[i][j].setLayoutX(j * gridSize);
                    appView.gameField.getChildren().add(grids[i][j]);
                }
            }
        }
//        System.out.println("��������� ��");
        parseGrids(grids);
        deletedGrids(grids);
        return gridFall(grids);

//        TranslateTransition transition = new TranslateTransition(duration, grids[0][0]);
//        transition.setByY(PROP.gameWindowHeight.getValue() - PROP.gridHeight.getValue());
//        transition.setAutoReverse(true);
//        transition.setCycleCount(6);
//        transition.play();
    }

    private void parseGrids(Grid[][] grids){
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

    private void deletedGrids(Grid[][] grids){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] != null && !grids[i][j].getCorrect()){
                    appView.gameField.getChildren().remove(grids[i][j]);
                    grids[i][j] = null;
                }
            }
        }
    }

    private boolean gridFall(Grid[][] grids){
        System.out.println();
        System.out.println("��������");
        boolean result = false;
        for (int i = grids.length - 1; i >= 0; i--) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] == null){
                    System.out.println("����� null � " + i + "|" + j);
                    result = true;
                    for (int k = i - 1; k >= 0; k--) {
                        if (grids[k][j] != null){
                            System.out.println("����� " + grids[k][j].getText() + " � " + k + "|" + j + " ����������� �� " + i + "|" + j + ", " + k + "|" + j + " null" );
                            grids[i][j] = grids[k][j];
                            grids[i][j].setI(i);
                            grids[i][j].setJ(j);
//                            grids[i][j].fall();
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


}
