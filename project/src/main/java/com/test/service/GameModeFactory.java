package com.test.service;

import com.test.enums.GameMode;
import com.test.service.impl.AbstractBowlingManager;
import com.test.service.impl.ConsoleBowlingLaneServiceImpl;
import com.test.service.impl.DummyBowlingLaneServiceImpl;

public class GameModeFactory {
    private AbstractBowlingManager dummyBowlingManager;
    private AbstractBowlingManager consoleBowlingManager;
    private AbstractBowlingManager fileBowlingManager;

    public GameModeFactory() {
        dummyBowlingManager = new DummyBowlingLaneServiceImpl();
        consoleBowlingManager = new ConsoleBowlingLaneServiceImpl();
        dummyBowlingManager = new DummyBowlingLaneServiceImpl();
    }

    public AbstractBowlingManager getBowlingManager(GameMode gameMode){
        if(gameMode == GameMode.DUMMY){
            return dummyBowlingManager;
        } else if(gameMode == GameMode.FILE){
            return fileBowlingManager;
        } else {
            return consoleBowlingManager;
        }
    }
}
