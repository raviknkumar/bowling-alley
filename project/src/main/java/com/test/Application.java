package com.test;

import com.test.constants.StringConstants;
import com.test.enums.GameMode;
import com.test.service.GameModeFactory;
import com.test.service.impl.AbstractBowlingManager;

import java.util.Scanner;

public class Application {

    static Scanner sc = new Scanner(System.in);
    AbstractBowlingManager bowlingManager;
    GameModeFactory gameModeFactory;

    public Application() {
        gameModeFactory = new GameModeFactory();
    }

    public static void main(String[] args) {
        Application application = new Application();
        System.out.println(StringConstants.ENTER_GAME_MODE);
        //int gamemode = sc.nextInt();
        int gamemode = 2;
        GameMode gameMode = GameMode.findById(gamemode);
        AbstractBowlingManager bowlingManager = application.gameModeFactory.getBowlingManager(gameMode);
        bowlingManager.initialize();
        bowlingManager.play();
        bowlingManager.calculateWinner();
    }
}
