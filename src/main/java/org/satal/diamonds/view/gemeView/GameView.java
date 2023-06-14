package org.satal.diamonds.view.gemeView;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import org.satal.diamonds.model.ButtonView;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.AppView;

public class GameView extends GridPane {

    private final AppView appView;
    private final double count;

    public GameView(AppView appView) {
        this.appView = appView;
//        this.setHgap(5.0);
//        this.setVgap(5.0);
        this.count = PROP.gridLineCount.getValue();
        generationProcess();
    }

    private void generationProcess(){
        boolean done = true;
        fill();
        while (done) {
            parseGrids();
            deletedGrids();
            done = gridFall();
            update();
        }
//        rename();
    }

    private void fill() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
            }
        }
    }

    private ButtonView get(int col, int row){
        Node result = null;
        ObservableList<Node> child = this.getChildren();
        for (Node node : child) {
            if (getColumnIndex(node) == col && getRowIndex(node) == row){
                result = node;
                break;
            }
        }
        return (ButtonView) result;
    }

    public void update(){
        for (int i = 0; i < this.getColumnCount(); i++) {
            if (this.get(i, 0) == null){
                this.add(new ButtonView(PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), i, 0);
            }
        }
    }

    private void parseGrids(){
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                ButtonView cur = this.get(j, i);
                if (cur != null){
                    String x = cur.getText();
                    ButtonView firstX = i < count - 2 ? this.get(j, i + 1) : null;
                    if (firstX != null && firstX.getText().equals(x)){
                        ButtonView secondX = this.get(j, i + 2);
                        if(secondX != null && secondX.getText().equals(x)){
                            cur.setCorrect(false);
                            firstX.setCorrect(false);
                            secondX.setCorrect(false);

//                            cur.setBackground(Background.fill(Color.BLUE));
//                            firstX.setBackground(Background.fill(Color.BLUE));
//                            secondX.setBackground(Background.fill(Color.BLUE));
                        }
                    }
                    ButtonView firstY = j < count - 2 ? this.get(j + 1, i) : null;
                    if (firstY != null && firstY.getText().equals(x)){
                        ButtonView secondY = this.get(j + 2, i);
                        if(secondY != null && secondY.getText().equals(x)){
                            cur.setCorrect(false);
                            firstY.setCorrect(false);
                            secondY.setCorrect(false);

//                            cur.setBackground(Background.fill(Color.BLUE));
//                            firstY.setBackground(Background.fill(Color.BLUE));
//                            secondY.setBackground(Background.fill(Color.BLUE));
                        }
                    }
                }
            }
        }
    }

    private void deletedGrids(){
        ObservableList<Node> children = this.getChildren();
        for (int i = 0; i < children.size(); i++) {
            if(!((ButtonView) children.get(i)).getCorrect()) {
                children.remove(i);
            }
        }
    }

    private boolean gridFall(){
        boolean result = false;
        for (int i = (int) (count - 1); i >= 0; i--) { // строка
            for (int j = 0; j < count; j++) { // столбец
                if(this.get(j, i) == null){
                    result = true;
                    for (int k = i - 1; k >= 0; k--) {
                        ButtonView r = this.get(j, k);
                        if (r != null){
//                            System.out.println("Было " + getRowIndex(r) + "|" + getColumnIndex(r) + " - " + r.getText());
                            int finalI = i;
                            r.fall(c -> setRowIndex(r, finalI));
//                            setRowIndex(r, i);
//                            System.out.println("Стало " + getRowIndex(r) + "|" + getColumnIndex(r) + " - " + r.getText());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private void rename(){
        for (Node child : this.getChildren()) {
            ((ButtonView) child).setText(((ButtonView) child).getText() + "\n" + getRowIndex(child) + "|" + getColumnIndex(child));
        }
    }


}
