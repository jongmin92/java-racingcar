package com.jongmin.game;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RacingGameTest {

    private RacingGame racingGame;

    private final int turnCount = 10;
    private Player mockPlayer1;
    private Player mockPlayer2;
    private List<Player> mockPlayers;
    private GameRule mockRule;

    @Before
    public void setUp() {
        mockPlayer1 = mock(Player.class);
        mockPlayer2 = mock(Player.class);
        mockPlayers = Arrays.asList(mockPlayer1, mockPlayer2);
        mockRule = mock(GameRule.class);

        racingGame = new RacingGame(turnCount, mockPlayers, mockRule);
    }

    @Test
    public void test_getTurnCount() {
        assertEquals(turnCount, racingGame.getTurnCount());
    }

    @Test
    public void test_getRemainTurnCount() {
        assertEquals(turnCount, racingGame.getRemainTurnCount());
    }

    @Test
    public void test_getPlayers() {
        assertEquals(mockPlayers, racingGame.getPlayers());
    }

    @Test
    public void test_getWinPlayers_return_one_player() {
        int hightScore = 10;
        int lowScore = 5;
        doReturn(hightScore).when(mockPlayer1).getScore();
        doReturn(lowScore).when(mockPlayer2).getScore();
        List<Player> expectedWinPlayers = Arrays.asList(mockPlayer1);

        assertEquals(expectedWinPlayers, racingGame.getWinPlayers());
    }

    @Test
    public void test_getWinPlayers_return_multiple_player() {
        int score = 10;
        doReturn(score).when(mockPlayer1).getScore();
        doReturn(score).when(mockPlayer2).getScore();
        List<Player> expectedWinPlayers = Arrays.asList(mockPlayer1, mockPlayer2);

        assertEquals(expectedWinPlayers, racingGame.getWinPlayers());
    }

    @Test
    public void test_executeTurn_with_always_move_rule() {
        racingGame.executeTurn();

        racingGame.getPlayers()
                  .forEach(player -> verify(player, times(1)).doTurn(mockRule));
        assertEquals(turnCount - 1, racingGame.getRemainTurnCount());
    }

    @Test
    public void test_isGameEnd_true() {
        while (racingGame.getRemainTurnCount() != 0) {
            racingGame.executeTurn();
        }

        assertEquals(true, racingGame.isGameEnd());
    }

    @Test
    public void test_isGameEnd_false() {
        assertEquals(false, racingGame.isGameEnd());
    }
}
