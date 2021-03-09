package com.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BowlingGame {

    private List<Player> players;
    private List<Round> rounds;
    private List<Score> scores;
    private Integer maxRounds;
    private Integer currentRound = 1;
    private Integer maxPins = 0;

    public void setScore(Integer playerId, Double score) {
        Score playerScore = scores.stream()
                .filter(s -> s.getPlayer().getId().equals(playerId))
                .findFirst().get();
        playerScore.setScore(playerScore.getScore() + score);
    }
}
