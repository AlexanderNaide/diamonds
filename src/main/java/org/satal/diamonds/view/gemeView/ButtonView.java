package org.satal.diamonds.view.gemeView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ButtonView extends Button implements GridView{

    public ButtonView(Integer gridSize) {
        this.setPrefHeight(gridSize);
        this.setPrefWidth(gridSize);
        this.setAlignment(Pos.CENTER);
    }
}
