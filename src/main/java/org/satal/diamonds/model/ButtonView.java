package org.satal.diamonds.model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Callback;
import javafx.util.Duration;
import org.satal.diamonds.properties.PROP;

import java.util.function.Consumer;


public class ButtonView extends Grid {

    private boolean correct;
    private final Duration dur;

//    public ButtonView(double gridSize, int x, int i, int j) {
    public ButtonView(double gridSize, int x) {
//        super(i, j);
        this.correct = true;
        this.setText(convertTitle(x));
        this.dur = Duration.millis(PROP.duration.getValue() + 10000);
//        this.title = "(" + line + ":" + col + ")";
        this.setPrefHeight(gridSize);
        this.setPrefWidth(gridSize);
        this.setAlignment(Pos.CENTER);
//        this.setOpacity(0.4);
//        this.getStyleClass().add("button-view");
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
//    public void fall(Consumer<ButtonView> consumer) {
    public void fall(Callback<> callback) {
//        Platform.runLater(() -> fallThis());
//        TranslateTransition transition = new TranslateTransition(dur, this);
//        transition.setByY(i * PROP.gridHeight.getValue() - k * PROP.gridHeight.getValue());
//        transition.play();
//        consumer.accept(this);
        consumer.accept(this);
    }


//    public void fall() {
//        Platform.runLater(() -> fallThis());
//        TranslateTransition transition = new TranslateTransition(dur, this);
//        transition.setByY(i * PROP.gridHeight.getValue() - k * PROP.gridHeight.getValue());
//        transition.play();
//    }

    public void fallThis() {
        TranslateTransition transition = new TranslateTransition(dur, this);
        transition.setByY(i * PROP.gridHeight.getValue() - this.getLayoutY());
//        System.out.println("Отправили " + this.getText() + " на -" + (i));
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
