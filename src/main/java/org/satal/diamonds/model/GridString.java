package org.satal.diamonds.model;

public class GridString implements Grid{

    private final String title;

    public GridString(int i) {
        this.title = getTitle(i);
    }

    private String getTitle(int i){
        return switch (i){
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            default -> "#";
        };
    }

    @Override
    public String getTitle() {
        return title;
    }
}
