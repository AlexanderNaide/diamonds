package org.satal.diamonds.properties;

public enum PROP {
    windowHeight(600),
    windowWidth(400),
    gameWindowHeight(360),
    gameWindowWidth(360),
    gridLineCount(8),
    gridHeight(45),
    gridWidth(45);

    private final int value;

    PROP(int i) {
        this.value = i;
    }

    public int getValue(){
        return value;
    }


}
