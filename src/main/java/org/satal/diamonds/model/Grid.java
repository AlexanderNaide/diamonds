package org.satal.diamonds.model;

import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import lombok.Data;

@Data
public abstract class Grid extends Button {

//    protected int i;

//    protected int j;
    public abstract boolean getCorrect();
    public abstract void setCorrect(boolean correct);
    public abstract void fall();

//    public Grid(int i, int j) {
//        this.setOnDragDetected(event -> {
//            System.out.println("OnDragDetected");
//
//            System.out.println(this.getText() + " - " + event.getScreenX() + "/" + event.getScreenY());
//        });
//    }
}
