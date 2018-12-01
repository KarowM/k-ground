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
        return new Rectangle((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }

    public void tick() {
        x += velX;
        y += velY;

        double diffX = x - player.getX() - ENEMY_SIZE/2;
        double diffY = y - player.getY() - ENEMY_SIZE/2;

        double distance = Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        velX = ((-1.0 / distance) * diffX);
        velY = ((-1.0 / distance) * diffY);

        spawner.addObject(new Trail((int) x, (int) y, ID.Trail, Color.BLUE, ENEMY_SIZE, ENEMY_SIZE, 0.05, spawner));
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, ENEMY_SIZE, ENEMY_SIZE);
    }
}
