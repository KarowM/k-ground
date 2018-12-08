package com.learning.swing;

import com.learning.swing.entity.EntityManager;

import java.awt.*;
import java.util.Random;

public class Handler {
    private final static Random R = new Random();

    private EntityManager entityManager;

    private int score = 0;
    private boolean isBossLevel;

    public Handler(EntityManager entityManager) {
        this.entityManager = entityManager;

        isBossLevel = false;
    }

    public void tick() {
        score++;

        if (score % 100 == 0 && !isBossLevel) {
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

        if (R.nextInt(200) == 1) {
            entityManager.createHealthPowerUp();
        }

        entityManager.tick();
    }

    public void render(Graphics g) {
        entityManager.render(g);
    }
}
