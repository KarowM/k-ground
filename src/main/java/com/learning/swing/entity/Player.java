package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Player extends GameObject {

    public static final int PLAYER_SIZE = 32;

    public Player(double x, double y, ID id) {
        super(x, y, id);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - PLAYER_SIZE);
        y = clamp(y + velY, 0, Game.HEIGHT - PLAYER_SIZE);
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int) x, (int) y, PLAYER_SIZE, PLAYER_SIZE);
    }
}
