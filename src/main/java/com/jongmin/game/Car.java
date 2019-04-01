package com.jongmin.game;

public class Car {

    private int position;

    public int getPosition() {
        return position;
    }

    public void move(int position) {
        this.position += position;
    }
}
