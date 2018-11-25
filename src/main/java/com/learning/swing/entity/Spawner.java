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

    public void createPlayer() {
        handler.addPlayer(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player));
    }

    public void createNewBasicEnemy() {
        handler.addObject(new BasicEnemy(R.nextInt(Game.WIDTH) - BasicEnemy.ENEMY_SIZE, R.nextInt(Game.HEIGHT) - BasicEnemy.ENEMY_SIZE, ID.BasicEnemy, handler));
    }
}
