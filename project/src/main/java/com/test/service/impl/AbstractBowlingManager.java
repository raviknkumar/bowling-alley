package com.test.service.impl;

import com.test.BowlingManager;
import com.test.models.BowlingGame;

public class AbstractBowlingManager implements BowlingManager {

    BowlingGame bowlingGame;

    public AbstractBowlingManager() {
        this.bowlingGame = new BowlingGame();
    }

    public AbstractBowlingManager(BowlingGame bowlingGame) {
        this.bowlingGame = bowlingGame;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void calculateWinner() {

    }

    @Override
    public void play() {

    }

    @Override
    public boolean canEnd() {
        return true;
    }
}
