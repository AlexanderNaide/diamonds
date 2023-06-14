package org.satal.diamonds.view.gemeView;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.satal.diamonds.model.ButtonView;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.AppView;

public class GameView extends GridPane {

    private final AppView appView;
    private final double count;

    public GameView(AppView appView) {
        this.appView = appView;
        this.count = PROP.gridLineCount.getValue();
        generationProcess();
    }

    private void generationProcess(){
        fill();
//        renderingGrids();
        parseGrids();
    }

    private void fill() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
//                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
                Label label = new Label("A");
                GridPane.setHalignment(label, HPos.CENTER);
                this.add(label, j, i);
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

//    public boolean renderingGrids(){
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < count; j++) {
//                if(grids[i][j] != null && !appView.gameField.getChildren().contains(grids[i][j])){
////                    grids[i][j].setI(i);
////                    grids[i][j].setJ(j);
//                    grids[i][j].setLayoutY(i * count);
//                    grids[i][j].setLayoutX(j * count);
//                    appView.gameField.getChildren().add(grids[i][j]);
//                }
//            }
//        }
//        System.out.println("Отрисовка всё");
//        parseGrids(grids);
//        deletedGrids(grids);
//        return gridFall(grids);

//        TranslateTransition transition = new TranslateTransition(duration, grids[0][0]);
//        transition.setByY(PROP.gameWindowHeight.getValue() - PROP.gridHeight.getValue());
//        transition.setAutoReverse(true);
//        transition.setCycleCount(6);
//        transition.play();
//    }

    private void parseGrids(){
//        for (int i = 0; i < count; i++) {
//            for (int j = 0; j < count; j++) {

//                if (this.getCellBounds(j, i).isEmpty()){
//                    this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), i, 0);
//                }





//                if (grids[i][j] != null){
//                    String x = grids[i][j].getText();
//                    if (i < grids.length - 2 && grids[i + 1][j] != null && grids[i + 1][j].getText().equals(x)){
//                        if(grids[i + 2][j] != null && grids[i + 2][j].getText().equals(x)){
//                            grids[i][j].setCorrect(false);
//                            grids[i + 1][j].setCorrect(false);
//                            grids[i + 2][j].setCorrect(false);
//                        }
//                    }
//                    if (j < grids[i].length - 2 && grids[i][j + 1] != null && grids[i][j + 1].getText().equals(x)){
//                        if(grids[i][j + 2] != null && grids[i][j + 2].getText().equals(x)){
//                            grids[i][j].setCorrect(false);
//                            grids[i][j + 1].setCorrect(false);
//                            grids[i][j + 2].setCorrect(false);
//                        }
//                    }
//                }


//            }
//        }
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
        System.out.println("Начинаем");
        boolean result = false;
        for (int i = grids.length - 1; i >= 0; i--) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] == null){
                    System.out.println("нашли null в " + i + "|" + j);
                    result = true;
                    for (int k = i - 1; k >= 0; k--) {
                        if (grids[k][j] != null){
                            System.out.println("нашли " + grids[k][j].getText() + " в " + k + "|" + j + " переместили на " + i + "|" + j + ", " + k + "|" + j + " null" );
                            grids[i][j] = grids[k][j];
//                            grids[i][j].setI(i);
//                            grids[i][j].setJ(j);
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
