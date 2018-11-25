package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.Handler;
import com.learning.swing.utils.ID;

import java.util.Random;

public class Spawner {

    private Handler handler;
    private static final Random R = new Random();

    public Spawner(Handler handler) {
        this.handler = handler;
    }

    public void tick() {
    }

    public void createNewBasicEnemy() {
        handler.addObject(new BasicEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
    }
}
