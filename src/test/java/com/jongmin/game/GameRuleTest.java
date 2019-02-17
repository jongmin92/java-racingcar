package com.jongmin.game;

import static org.junit.Assert.assertEquals;

import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class GameRuleTest {

    GameRule rule;

    @Before
    public void setUp() {
        rule = new GameRule();
    }

    @Test
    public void test_moveRule_return_false() {
        Predicate<Integer> moveRule = rule.getMoveRule();

        assertEquals(false, moveRule.test(1));
    }

    @Test
    public void test_moveRule_return_true() {
        Predicate<Integer> moveRule = rule.getMoveRule();

        assertEquals(true, moveRule.test(2));
    }
}
