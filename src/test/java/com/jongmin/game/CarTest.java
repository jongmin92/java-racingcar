package com.jongmin.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarTest {

    Car car;

    @Before
    public void setUp() {
        car = new Car();
    }

    @Test
    public void test_getPosition() {
        assertEquals(0, car.getPosition());
    }

    @Test
    public void test_move() {
        int moveCount = 1;

        car.move(moveCount);
        assertEquals(moveCount, car.getPosition());
    }
}
