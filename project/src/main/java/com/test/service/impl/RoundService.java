package com.test.service.impl;

import com.test.models.LastRound;
import com.test.models.Player;
import com.test.models.Round;

import java.util.List;

import static com.test.constants.ConfigConstants.MAX_ROLLS;
import static com.test.constants.ConfigConstants.MAX_ROLLS_LAST_ROUND;

public class RoundService {

    Round createRound(List<Player> players, Integer currentRound, Integer maxRounds){
        // move to round factory
        Round round = Round
                .builder()
                .roundNumber(currentRound)
                .players(players)
                .build();
        if (currentRound.equals(maxRounds)){
            round.setMaxRolls(MAX_ROLLS_LAST_ROUND);
            return round;
        } else {
            round.setMaxRolls(MAX_ROLLS);
        }
        return round;
    }
}
