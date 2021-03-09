package com.test.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Queue;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {
    private List<Player> players;
    int roundNumber;
    private Integer maxRolls;
    private Player winner;
    private List<RoundScore> scores;
}
