package org.satal.diamonds.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.RequiredArgsConstructor;
import org.satal.diamonds.view.AppView;
import org.satal.diamonds.view.gemeView.GameView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.util.ResourceBundle;

@RequiredArgsConstructor
public class Controller implements Initializable {
    private final GameController gameController;
    private final AppView appView;
    public Pane startPane;
    public Pane gridPane;
    public Pane gameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new AnnotationConfigApplicationContext("org.satal.diamonds");
        appView.updateField(gameController.getField());
    }

    public void startGame(MouseEvent mouseEvent) {
        startPane.setVisible(false);
        gridPane.setVisible(true);
    }
}