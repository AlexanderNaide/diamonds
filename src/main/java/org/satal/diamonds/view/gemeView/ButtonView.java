package org.satal.diamonds.view.gemeView;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ButtonView extends Button implements GridView{

    public ButtonView(Integer gridSize) {
        this.setPrefHeight(gridSize);
        this.setPrefWidth(gridSize);
        this.setAlignment(Pos.CENTER);
//        this.setOnMouseReleased(e -> {
//            if (e.getSceneY() < this.getLayoutX() ){
//                System.out.println("Вверх");
//            }
//            System.out.println("setOnMouseReleased " + e.getSceneX());
//            System.out.println("setOnMouseReleased " + this.getText());
//        });
        this.setOnMouseDragged(e -> {
            this.setLayoutX(e.getSceneX() - 32);
            this.setLayoutY(e.getSceneY() - 32);

            System.out.println("setOnMouseDragged " + e.getSceneX());
            System.out.println("setOnMouseDragged " + this.getText());
        });

    }
}
