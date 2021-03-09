package com.test.service.impl;

import com.test.service.ScoringStrategy;

import java.util.ArrayList;
import java.util.List;

public class ScoringService {

    ScoringStrategy strikeScoringStrategy;
    ScoringStrategy spareScoringStrategy;

    public ScoringService() {
        this.strikeScoringStrategy = new StrikeScoringStrategy();
        spareScoringStrategy = new SpareScoringStrategy();
    }

    public Double calculateScore(int turn, int pinsKnocked, int maxPins){
        if(turn == 2){
            return spareScoringStrategy.calculateScore(pinsKnocked, maxPins);
        } else {
            return strikeScoringStrategy.calculateScore(pinsKnocked, maxPins);
        }
    }
}
