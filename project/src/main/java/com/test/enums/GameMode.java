package com.test.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GameMode {
    FILE(1), CONSOLE(2), DUMMY(3);

    private final int mode;

    GameMode(int mode) {
        this.mode = mode;
    }

    public static GameMode findById(int gameMode) {
        return Arrays.stream(GameMode.values()).filter(gm -> gm.mode == gameMode)
                .findFirst()
                .orElse(null);
    }
}
