package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;
import java.util.Random;

public class BossEnemyBullet extends GameObject {

    public static final int ENEMY_SIZE = 16;
    private Spawner spawner;
    private Random R = new Random();

    public BossEnemyBullet(int x, int y, ID id, Spawner spawner) {
        super(x, y, id);
        this.spawner = spawner;

        velX = R.nextInt(5 + 1 + 5) - 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y >= Game.HEIGHT || x >= Game.WIDTH) {
            spawner.removeObject(this);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
