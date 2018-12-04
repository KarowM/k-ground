package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.Random;

public class BossEnemy extends Entity {

    public static final int BOSS_SIZE = 96;
    private static final Random R = new Random();
    private Spawner spawner;

    private int entranceTimer = 160;
    private int movementTimer = 600;

    public BossEnemy(int x, int y, ID id, Spawner spawner) {
        super(x, y, id);
        this.spawner = spawner;

        velX = 0;
        velY = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, BOSS_SIZE, BOSS_SIZE);
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
                spawner.createNewBossEnemyBullet(x + BOSS_SIZE / 2, y + BOSS_SIZE);
            }
        }

        if (x <= 0 || x >= Game.WIDTH - BOSS_SIZE) {
            velX *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect((int) x, (int) y, BOSS_SIZE, BOSS_SIZE);
    }
}
