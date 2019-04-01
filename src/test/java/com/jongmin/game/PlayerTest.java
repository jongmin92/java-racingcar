package com.jongmin.game;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    private Car car;
    private final String name = "Player1";

    @Before
    public void setUp() {
        car = mock(Car.class);
        player = new Player(name, car);
    }

    @Test
    public void getName() {
        assertEquals(name, player.getName());
    }

    @Test
    public void getCar() {
        assertEquals(car, player.getCar());
    }

    @Test
    public void doTurn_with_true_move_rule() {
        GameRule rule = mock(GameRule.class);
        Predicate<Integer> alwaysReturnTrue = num -> true;
        doReturn(alwaysReturnTrue).when(rule).getMoveRule();

        player.doTurn(rule);
        verify(car, times(1)).move(anyInt());
    }

    @Test
    public void doTurn_with_false_move_rule() {
        GameRule rule = mock(GameRule.class);
        Predicate<Integer> alwaysReturnFalse = num -> false;
        doReturn(alwaysReturnFalse).when(rule).getMoveRule();

        player.doTurn(rule);
        verify(car, times(0)).move(anyInt());
    }

    @Test
    public void getScore() {
        int expectedScore = 10;
        doReturn(expectedScore).when(car).getPosition();

        assertEquals(expectedScore, player.getScore());
    }
}
