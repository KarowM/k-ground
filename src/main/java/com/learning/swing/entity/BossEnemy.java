package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;

public class BossEnemy extends GameObject {

    public static final int BOSS_SIZE = 96;
    private Spawner spawner;

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

        spawner.addObject(new Trail(x, y, ID.Trail, Color.RED, BOSS_SIZE, BOSS_SIZE, 0.05, spawner));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, BOSS_SIZE, BOSS_SIZE);
    }
}
