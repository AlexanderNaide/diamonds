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

import javax.security.auth.callback.Callback;

public class GameView extends GridPane {

    private final AppView appView;
    private final double count;
    private boolean generation;

    private ButtonView temp;

    public GameView(AppView appView) {
        generation = true;
        this.appView = appView;
        count = PROP.gridLineCount.getValue();
        generationProcess();
    }

    private void generationProcess(){
//        boolean done = true;
//        fillOne();
        fill();
        updateProcess();
//        while (done) {
//            parseGrids();
//            deletedGrids();
//            gridFall();
//            done = update();
//        }
        generation = false;
//        rename();
    }

    public void updateProcess(){
        boolean done = true;
        while (done) {
            parseGrids();
            deletedGrids();
            gridFall();
            done = update();
        }
    }

    public void test_getRemoved(){
//        ButtonView buttonView = this.get(0, 0);
//        ButtonView buttonViewN = this.get(0, 1);
//        System.out.println("0 - " + buttonView);
//        System.out.println("1 - " + buttonViewN);
//        if (buttonView != null){
//            buttonView.fall(0, 1);
//            setRowIndex(buttonView, 1);
//        }

//        for (int i = 0; i < count; i++) {
//            System.out.print(this.get(i, 0).getText() + " ");
//        }
//        System.out.println();

        this.updateBounds();
    }

    private void fillOne() {
        this.add(new ButtonView(this, PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), 0, 0);
    }

    private void fill() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                this.add(new ButtonView(this, PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), j, i);
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

    public boolean update(){
        boolean result = false;
        for (int i = 0; i < this.getColumnCount(); i++) {
            if (this.get(i, 0) == null){
                result = true;
                this.add(new ButtonView(this, PROP.gridWidth.getValue(), (int) (Math.random() * 4) + 1), i, 0);
            }
        }
        return result;
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

    private void gridFall(){

        for (int i = (int) (count - 1); i >= 0; i--) { // ������
            for (int j = 0; j < count; j++) { // �������
                if(this.get(j, i) == null){

                    for (int k = i - 1; k >= 0; k--) {
                        ButtonView r = this.get(j, k);
                        if (r != null){
//                            System.out.println("���� " + getRowIndex(r) + "|" + getColumnIndex(r) + " - " + r.getText());
                            if(!generation){
                                r.fall(k, i);
                            } else {
                                setRowIndex(r, i);
                            }
//                            System.out.println("����� " + getRowIndex(r) + "|" + getColumnIndex(r) + " - " + r.getText());
                            break;
                        }
                    }
                }
            }
        }

    }

    private void rename(){
        for (Node child : this.getChildren()) {
            ((ButtonView) child).setText(((ButtonView) child).getText() + "\n" + getRowIndex(child) + "|" + getColumnIndex(child));
        }
    }

    public void changingByClick(ButtonView buttonView){
        if (temp == null){
            temp = buttonView;
        } else {
            changing(temp, buttonView);
            temp = null;
        }
    }

    private void changing(ButtonView one, ButtonView two){
//        System.out.println("������ " + one.getText() + " & " + two.getText());
        int oneRow = getRowIndex(one);
        int twoRow = getRowIndex(two);
        int oneCol = getColumnIndex(one);
        int twoCol = getColumnIndex(two);
//        System.out.printf("%s col=%d row=%d; %s col=%d row=%d \n", one.getText(), oneCol, oneRow, two.getText(), twoCol, twoRow);
        if (oneRow == twoRow){
            one.slide(oneCol, twoCol);
            two.slide(twoCol, oneCol);
//            ButtonView temp = one;
//            setColumnIndex(one, twoCol);
//            setColumnIndex(two, oneCol);
        } else if (oneCol == twoCol) {
            one.fall(oneRow, twoRow);
            two.fall(twoRow, oneRow);
//            ButtonView temp = one;
//            setRowIndex(one, twoRow);
//            setRowIndex(two, oneRow);
        }

//        updateProcess();
    }

    public synchronized void test(){
        parseGrids();
        deletedGrids();
    }

}
