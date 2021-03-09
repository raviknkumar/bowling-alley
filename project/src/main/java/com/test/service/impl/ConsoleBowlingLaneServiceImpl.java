package com.test.service.impl;

import com.test.models.BowlingGame;
import com.test.models.Player;
import com.test.models.Round;
import com.test.models.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleBowlingLaneServiceImpl extends AbstractBowlingManager {

    Scanner sc;
    PlayerService playerService;
    RoundService roundService;
    Random random;
    ScoringService scoringService;

    public ConsoleBowlingLaneServiceImpl() {
        super();
        sc = new Scanner(System.in);
        playerService = new PlayerService();
        random = new Random();
        scoringService = new ScoringService();
        roundService = new RoundService();
    }

    @Override
    public void initialize() {

        //System.out.println("Enter Max Rounds");
        //int maxRounds = sc.nextInt();
        int maxRounds = 10;

        //System.out.println("Enter Number of players");
        //int numPlayers = sc.nextInt();
        int numPlayers = 3;
        for (int i=0;i<numPlayers;i++){
            //System.out.println("Player name");
            //String name = sc.next();
            playerService.addPlayer(new String("Player_")+ (char)('A'+i));
        }

        List<Player> players = playerService.getPlayers();
        List<Score> scores = new ArrayList<>();
        for (Player player : players){
            scores.add(new Score(player, 0d));
        }

        Integer maxPins;
        //System.out.println("Enter Max Pins");
        //maxPins = sc.nextInt();
        maxPins = 10;

        this.bowlingGame = BowlingGame.builder()
                .maxRounds(maxRounds)
                .players(players)
                .scores(scores)
                .currentRound(1)
                .rounds(new ArrayList<>())
                .maxPins(maxPins)
                .build();
    }

    @Override
    public void calculateWinner() {
        Double max = Double.MIN_VALUE;
        Player winner = null;
        for (Score score : bowlingGame.getScores()){
            if (score.getScore() >= max) {
                max = score.getScore();
                winner = score.getPlayer();
            }
        }
        System.out.println("Winner is : "+ winner.getName());
    }

    @Override
    public void play() {
        while (!canEnd()){
            Round round = roundService.createRound(bowlingGame.getPlayers(), bowlingGame.getCurrentRound(), bowlingGame.getMaxRounds());
            List<Round> rounds = bowlingGame.getRounds();
            rounds.add(round);
            bowlingGame.setRounds(rounds);

            playRound(round);
        }
    }

    public void playRound(Round round){
        Integer currentRound = bowlingGame.getCurrentRound();
        System.out.println("Current Round: "+ currentRound);
        for (Player player : round.getPlayers()){
            Integer totalPins = bowlingGame.getMaxPins();
            Integer totalKnocked = 0;

            for (int turn=1; turn<= round.getMaxRolls();turn++) {
                int pinsKnocked = random.nextInt(totalPins);
                totalKnocked += pinsKnocked;
                totalPins -= pinsKnocked;
                System.out.println("Player: " + player.getName()+ "Turn " + turn+ " , pins knocked:" + pinsKnocked+", total:"+ totalKnocked);
                Double score = scoringService.calculateScore(turn, totalKnocked, totalPins);
                bowlingGame.setScore(player.getId(), score);
                System.out.println("Score for turn: "+ score);
                if(totalPins == 0)
                    break;
            }
        }
        System.out.println(bowlingGame.getScores());
        System.out.println("Going for Next round");
        bowlingGame.setCurrentRound(currentRound+1);
    }

    @Override
    public boolean canEnd() {
        return bowlingGame.getCurrentRound() > bowlingGame.getMaxRounds();
    }
}
