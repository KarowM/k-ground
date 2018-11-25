package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.Handler;
import com.learning.swing.graphics.HUD;
import com.learning.swing.utils.ID;

import java.util.Random;

public class Spawner {

    private Handler handler;
    private HUD hud;
    private static final Random R = new Random();

    private int scoreKeep;

    public Spawner(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep == 100) {
            scoreKeep = 0;
            hud.incrementLevel();

            createNewBasicEnemy();
        }
    }

    private void createNewBasicEnemy() {
        handler.addObject(new BasicEnemy(R.nextInt(Game.WIDTH), R.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
    }
}
