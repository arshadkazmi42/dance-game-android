package com.arshad.dancegame.model;

public class GameTile {

    boolean selected;
    int position;

    public GameTile() {}

    GameTile(int position, boolean selected) {
        this.position = position;
        this.selected = selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
