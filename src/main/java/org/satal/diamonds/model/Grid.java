package org.satal.diamonds.model;

import javafx.scene.control.Button;

public abstract class Grid extends Button {

    public abstract boolean getCorrect();
    public abstract void setCorrect(boolean correct);
    public abstract void fall(int i, int k);
}
