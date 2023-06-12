package org.satal.diamonds.properties;

public enum PROP {
    windowHeight(600.0),
    windowWidth(400.0),
    gameWindowHeight(360.0),
    gameWindowWidth(360.0),
    gridLineCount(8.0),
    gridHeight(45.0),
    gridWidth(45.0),
    duration(600.0);

    private final double value;

    PROP(double i) {
        this.value = i;
    }

    public double getValue(){
        return value;
    }


}
