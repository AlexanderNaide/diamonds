package org.satal.diamonds.model;

import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public abstract class Grid extends Button {

    public abstract boolean getCorrect();
    public abstract void setCorrect(boolean correct);
    public abstract void fall(int i, int k);

    public Grid() {
//        this.setOnDragDetected(event -> {
//            System.out.println("OnDragDetected");
//
//            System.out.println(this.getText() + " - " + event.getScreenX() + "/" + event.getScreenY());
//        });
    }
}
