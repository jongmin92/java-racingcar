package com.jongmin.game;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class InputView {

    private InputView() { }

    private static final Scanner sc = new Scanner(System.in);
    private static final String PLAYER_NAME_DELIMITER = " ";

    public static List<String> inputPlayerName() {
        System.out.println("플레이어 이름을 입력하세요: ");

        String input = sc.nextLine();

        List<String> playerNameList = Arrays.asList(parsePlayerName(input));
        return Collections.unmodifiableList(playerNameList);
    }

    public static int inputTurnCount() {
        System.out.println("진행 횟수를 입력하세요: ");

        int turnCount = sc.nextInt();
        return turnCount;
    }

    private static String[] parsePlayerName(String names) {
        return names.split(PLAYER_NAME_DELIMITER);
    }
}
