package org.satal.diamonds.view;

import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import lombok.RequiredArgsConstructor;
import org.satal.diamonds.controller.Controller;
import org.satal.diamonds.controller.GameController;
import org.satal.diamonds.model.Grid;
import org.satal.diamonds.view.gemeView.GameView;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class AppView {

    private final GameController gameController;
    private final GameView gameView;

    public void updateField(Grid[][] grids){
        gameView.updateField(grids);
    }
}
