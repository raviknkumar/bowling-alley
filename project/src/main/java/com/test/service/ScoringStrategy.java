package com.test.service;

import com.test.models.Pin;

import java.util.List;

public interface ScoringStrategy {

    default Double calculateTotalScore(int pinsKnocked, int maxPins){
        Double score = 0d;
        score += calculateScore(pinsKnocked, maxPins);
        score += bonusScore(pinsKnocked, maxPins);
        return score;
    }

    Double calculateScore(List<Pin> pins);
    Double calculateScore(int pinsKnocked, int maxPins);
    Double bonusScore(int pinsKnocked, int maxPins);
}
