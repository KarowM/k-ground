package com.learning.swing;

import com.learning.swing.entity.Spawner;
import com.learning.swing.graphics.HUD;

import java.awt.*;

public class Handler {
    private HUD hud;
    private Spawner spawner;

    private int score = 0;
    private int level = 0;
    private boolean isBossLevel;

    public Handler(HUD hud, Spawner spawner) {
        this.hud = hud;
        this.spawner = spawner;

        isBossLevel = false;
        spawner.createPlayer();
    }

    public void tick() {
        score++;

        if (score % 100 == 0 && !isBossLevel) {
            incrementLevel();
            spawner.createNewBasicEnemy();
        }
        if (score % 400 == 0 && !isBossLevel) {
            spawner.createNewSmartEnemy();
        }
        if (score == 1500) {
            spawner.clearAll();
            isBossLevel = true;
            spawner.createNewEnemyBoss();
        }

        spawner.tick();
        hud.tick();
    }

    public void incrementLevel() {
        level++;
    }

    public void render(Graphics g) {
        spawner.render(g);
        hud.render(g, score, level);
    }
}
