package org.satal.diamonds.model;

public class GridString implements Grid{

    private String title;
    private final int line;
    private final int col;


    public GridString(int i, int line, int col) {
        this.title = convertTitle(i);
        this.line = line;
        this.col = col;
    }

    private String convertTitle(int i){
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

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setTitle(String n) {
        this.title = n;
    }
}
