package org.satal.diamonds.model;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.util.Duration;
import org.satal.diamonds.properties.PROP;



public class ButtonView extends Grid {

    private boolean correct;

    private final Duration dur;

    public ButtonView(double gridSize, int i) {
        this.correct = true;
        this.setText(convertTitle(i));
        this.dur = Duration.millis(PROP.duration.getValue());
//        this.title = "(" + line + ":" + col + ")";
        this.setPrefHeight(gridSize);
        this.setPrefWidth(gridSize);
        this.setAlignment(Pos.CENTER);
        this.getStyleClass().add("button-view");
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
    public void fall(int i, int k) {
        TranslateTransition transition = new TranslateTransition(dur, this);
        transition.setByY(i * PROP.gridHeight.getValue() - k * PROP.gridHeight.getValue());
        transition.play();
    }

    @Override
    public boolean getCorrect() {
        return correct;
    }

    @Override
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
