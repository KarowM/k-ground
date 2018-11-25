package com.learning.swing;

import com.learning.swing.entity.Spawner;
import com.learning.swing.graphics.HUD;

import java.awt.*;

public class Handler {
    private HUD hud;
    private Spawner spawner;

    private int score = 0;
    private int level = 1;

    public Handler(HUD hud) {
        this.hud = hud;
    }

    public void setSpawner(Spawner spawner) {
        this.spawner = spawner;

        spawner.createPlayer();
        spawner.createNewBasicEnemy();
    }

    public void tick() {
        score++;

        if (score % 10 == 0) {
            incrementLevel();

            spawner.createNewBasicEnemy();
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
