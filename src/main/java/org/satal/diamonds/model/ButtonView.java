package org.satal.diamonds.model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import org.satal.diamonds.properties.PROP;
import org.satal.diamonds.view.gemeView.GameView;

import javax.security.auth.callback.Callback;
import java.util.function.Consumer;


public class ButtonView extends Grid {

    private boolean correct;
    private final Duration dur;

    private final GameView gameView;

//    public ButtonView(double gridSize, int x, int i, int j) {
    public ButtonView(GameView gameView, double gridSize, int x) {
        this.gameView = gameView;
        this.correct = true;
        this.setText(convertTitle(x));
        this.dur = Duration.millis(PROP.duration.getValue());
//        this.title = "(" + line + ":" + col + ")";
        this.setPrefHeight(gridSize);
        this.setPrefWidth(gridSize);
        this.setAlignment(Pos.CENTER);
//        this.setFocused(false);
//        this.setOpacity(0.4);
//        this.getStyleClass().add("button-view");


        this.setOnMouseDragged(event -> {
            System.out.println("setOnMouseDragged");
        });
        this.setOnMousePressed(event -> {
//            System.out.println("setOnMousePressed " + this.getText());
            gameView.changingByClick(this);
        });
//        this.setOnMouseReleased(event -> {
//            System.out.println("setOnMouseReleased " + this.getText());
//        });






    }

    private String convertTitle(int i){
        return switch (i){
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            default -> "#";
        };
    }

    @Override
    public void fall(int startPosition, int endPosition) {
        Platform.runLater(() -> fallThis(startPosition, endPosition));
    }
    @Override
    public void slide(int startPosition, int endPosition) {
        Platform.runLater(() -> slideThis(startPosition, endPosition));
    }

    public void fallThis(int startPosition, int endPosition) {
        TranslateTransition transition = new TranslateTransition(dur, this);
        transition.setByY(endPosition * PROP.gridHeight.getValue() - startPosition * PROP.gridHeight.getValue());
        transition.setOnFinished(e -> {
            GridPane.setRowIndex(this, endPosition);
            this.setTranslateY(0.0);
            gameView.test();
//            gameView.updateProcess();
        });
        transition.play();
    }

    public void slideThis(int startPosition, int endPosition) {
        TranslateTransition transition = new TranslateTransition(dur, this);
        transition.setByX(endPosition * PROP.gridWidth.getValue() - startPosition * PROP.gridWidth.getValue());
        transition.setOnFinished(e -> {
            GridPane.setColumnIndex(this, endPosition);
            this.setTranslateX(0.0);
            gameView.test();
//            gameView.updateProcess();
        });
        transition.play();
    }

//    @Override
    public boolean getCorrect() {
        return correct;
    }

//    @Override
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
