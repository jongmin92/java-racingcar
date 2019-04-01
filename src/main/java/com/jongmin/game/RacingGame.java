package com.jongmin.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.annotations.VisibleForTesting;

public class RacingGame {

    private final int turnCount;
    private int remainTurnCount;
    private final List<Player> players;
    private final GameRule rule;

    public RacingGame(int turnCount, List<Player> players, GameRule rule) {
        this.turnCount = turnCount;
        this.remainTurnCount = turnCount;
        this.players = players;
        this.rule = rule;
    }

    public int getTurnCount() {
        return turnCount;
    }

    @VisibleForTesting
    public int getRemainTurnCount() {
        return remainTurnCount;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Player> getWinPlayers() {
        Collections.sort(players);

        int highestScore = players.get(0).getScore();
        List<Player> winPlayers = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() >= highestScore) {
                winPlayers.add(players.get(i));
            } else {
                break;
            }
        }

        return Collections.unmodifiableList(winPlayers);
    }

    public void executeTurn() {
        players.forEach(player -> player.doTurn(rule));
        remainTurnCount--;
    }

    public boolean isGameEnd() {
        return remainTurnCount == 0;
    }
}
