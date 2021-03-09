package com.test.service.impl;

import com.test.models.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    @Getter
    private List<Player> players;

    Integer playerId;

    public PlayerService() {
        this.players = new ArrayList<>();
        playerId = 1;
    }

    public void addPlayer(String name){
        Player player = Player.builder()
                .id(playerId)
                .name(name)
                .build();
        players.add(player);
    }
}
