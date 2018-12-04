package com.learning.swing;

import com.learning.swing.entity.EntityManager;
import com.learning.swing.graphics.HUD;

import java.awt.*;

public class Handler {
    private HUD hud;
    private EntityManager entityManager;

    private int score = 0;
    private int level = 0;
    private boolean isBossLevel;

    public Handler(HUD hud, EntityManager entityManager) {
        this.hud = hud;
        this.entityManager = entityManager;

        isBossLevel = false;
        entityManager.createPlayer();
    }

    public void tick() {
        score++;

        if (score % 100 == 0 && !isBossLevel) {
            incrementLevel();
            entityManager.createNewBasicEnemy();
        }
        if (score % 400 == 0 && !isBossLevel) {
            entityManager.createNewSmartEnemy();
        }
        if (score == 1500) {
            entityManager.clearAll();
            isBossLevel = true;
            entityManager.createNewEnemyBoss();
        }

        entityManager.tick();
        hud.tick();
    }

    public void incrementLevel() {
        level++;
    }

    public void render(Graphics g) {
        entityManager.render(g);
        hud.render(g, score, level);
    }
}
