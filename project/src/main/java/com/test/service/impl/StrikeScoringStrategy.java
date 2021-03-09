package com.test.service.impl;

import com.test.models.Pin;
import com.test.service.ScoringStrategy;

import java.util.List;

public class StrikeScoringStrategy implements ScoringStrategy {

    private Double scoreForPin = 1d;
    private Double bonusScore = 10d;

    public StrikeScoringStrategy(Double scoreForPin, Double bonusScore) {
        this.scoreForPin = scoreForPin;
        this.bonusScore = bonusScore;
    }

    public StrikeScoringStrategy() {
        bonusScore = 0d;
        scoreForPin = 1d;
    }

    @Override
    public Double calculateScore(List<Pin> pins) {
        return null;
    }



    @Override
    public Double calculateScore(int pinsKnocked, int maxPins) {
        Double totalScore = 0d;
        totalScore += scoreForPin * pinsKnocked;
        totalScore += bonusScore(pinsKnocked, maxPins);
        return totalScore;
    }

    @Override
    public Double bonusScore(int pinsKnocked, int maxPins) {
        Double bonus = 0d;
        if(pinsKnocked == maxPins){
            bonus += bonusScore;
        }
        return bonus;
    }
}
