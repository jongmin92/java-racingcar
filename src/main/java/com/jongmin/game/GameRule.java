package com.jongmin.game;

import java.util.function.Predicate;

public class GameRule {

    public Predicate<Integer> getMoveRule() {
        return num -> (num % 2) == 0;
    }
}
