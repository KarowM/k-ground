package com.learning.swing.entity;

import com.learning.swing.utils.ID;

import java.awt.*;

public class SmartEnemy extends GameObject {

    public static final int ENEMY_SIZE = 16;
    private final Player player;
    private Spawner spawner;

    public SmartEnemy(int x, int y, ID id, Spawner spawner) {
        super(x, y, id);
        this.spawner = spawner;
        this.player = spawner.getPlayer();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, ENEMY_SIZE, ENEMY_SIZE);
    }

    public void tick() {
        x += velX;
        y += velY;

        int playerX = player.getX();
        int playerY = player.getY();

        if (x > playerX && y > playerY) {
            velX = -2;
            velY = -2;
        }
        if (x > playerX && y < playerY) {
            velX = -2;
            velY = 2;
        }
        if (x < playerX && y < playerY) {
            velX = 2;
            velY = 2;
        }
        if (x < playerX && y > playerY) {
            velX = 2;
            velY = -2;
        }

        spawner.addObject(new Trail(x, y, ID.Trail, Color.BLUE, ENEMY_SIZE, ENEMY_SIZE, 0.05, spawner));
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
