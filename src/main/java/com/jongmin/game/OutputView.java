package com.jongmin.game;

import java.util.List;
import java.util.stream.Collectors;

public final class OutputView {

    private static final char SCORE = '-';
    private static final char LINE_FEED = '\n';
    private static final String DELIMITER_NAME = ", ";

    private OutputView() { }

    public static void printPlayersStatus(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        players.forEach(player -> {
            printPlayerName(sb, player);
            printScore(sb, player);
            sb.append(LINE_FEED);
        });

        System.out.println(sb.toString());
    }

    private static void printPlayerName(StringBuilder sb, Player player) {
        sb.append(player.getName());
        sb.append(": ");
    }

    private static void printScore(StringBuilder sb, Player player) {
        int score = player.getScore();
        while (score > 0) {
            sb.append(SCORE);
            score--;
        }
    }

    public static void printWinPlayers(List<Player> players) {
        String names = players.stream()
                              .map(Player::getName)
                              .collect(Collectors.joining(DELIMITER_NAME));

        System.out.println(String.format("우승자는 %s 입니다.", names));
    }
}
