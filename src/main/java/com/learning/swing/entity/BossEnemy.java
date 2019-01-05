package com.learning.swing.entity;

import com.learning.swing.Game;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends Entity {
    private static final Random R = new Random();
    public static final int SIZE = 96;
    private EntityManager entityManager;

    private int entranceTimer = 160;
    private int movementTimer = 600;

    BossEnemy(double x, double y, EntityManager entityManager) {
        super(x, y, SIZE, SIZE);
        this.entityManager = entityManager;

        velX = 0;
        velY = 0;
    }

    @Override
    public void collideWithPlayer(Player player, EntityManager entityManager) {
        player.decrementHealth();
    }

    public void tick() {
        x += velX;
        y += velY;

        entranceTimer--;
        movementTimer--;

        if (entranceTimer == 110) {
            velY = 1;
        }

        if (entranceTimer == 0) {
            velY = 0;
        }

        if (movementTimer == 0) {
            velX = 3;
        }

        if (movementTimer <= 250) {
            int spawn = R.nextInt(10);
            if (spawn < 2) {
                entityManager.createNewBossEnemyBullet(x + width / 2, y + height);
            }
        }

        if (x <= 0 || x >= Game.WIDTH - width) {
            velX *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) x, (int) y, width, height);
    }
}
