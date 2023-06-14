package org.satal.diamonds.model;

import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import lombok.Data;

import java.util.function.Consumer;

public abstract class Grid extends Button {

//    protected int i;

//    protected int j;
    public abstract boolean getCorrect();
    public abstract void setCorrect(boolean correct);
    public abstract void fall(Consumer<ButtonView> consumer);

//    public Grid(int i, int j) {
//        this.setOnDragDetected(event -> {
//            System.out.println("OnDragDetected");
//
//            System.out.println(this.getText() + " - " + event.getScreenX() + "/" + event.getScreenY());
//        });
//    }
}
