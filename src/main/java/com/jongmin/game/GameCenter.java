package com.jongmin.game;

import java.util.List;
import java.util.stream.Collectors;

public class GameCenter {

    public static void main(String[] args) {
        List<String> playerNameList = InputView.inputPlayerName();
        List<Player> playerList = playerNameList.stream()
                                                .map(name -> new Player(name, new Car()))
                                                .collect(Collectors.toList());

        int turnCount = InputView.inputTurnCount();
        GameRule rule = new GameRule();

        RacingGame racingGame = new RacingGame(turnCount, playerList, rule);

        while (!racingGame.isGameEnd()) {
            racingGame.executeTurn();
            OutputView.printPlayersStatus(racingGame.getPlayers());
        }

        OutputView.printWinPlayers(racingGame.getWinPlayers());
    }
}
