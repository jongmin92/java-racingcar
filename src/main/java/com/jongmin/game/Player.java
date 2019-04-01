package com.jongmin.game;

public class Player implements Comparable<Player> {

    private final String name;
    private final Car car;

    public Player(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public void doTurn(GameRule rule) {
        int randomNum = (int) (Math.random() * 10);

        if (rule.getMoveRule().test(randomNum)) {
            car.move(1);
        }
    }

    public int getScore() {
        return car.getPosition();
    }

    @Override
    public int compareTo(Player o) {
        return o.getScore() - getScore();
    }
}
