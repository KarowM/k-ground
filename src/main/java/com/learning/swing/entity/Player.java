package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Player extends GameObject {

    public static final int PLAYER_SIZE = 32;
    private int timeLeftFrozen = 0;

    public Player(double x, double y, ID id) {
        super(x, y, id);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void freeze() {
        timeLeftFrozen = 50;
    }

    public void tick() {
        if (timeLeftFrozen > 0) {
            timeLeftFrozen--;
        }

        if (timeLeftFrozen == 0) {
            x = clamp(x + velX, 0, Game.WIDTH - PLAYER_SIZE);
            y = clamp(y + velY, 0, Game.HEIGHT - PLAYER_SIZE);
        }
    }

    public void render(Graphics g) {
        Color color = timeLeftFrozen > 0 ? Color.CYAN : Color.WHITE;
        g.setColor(color);
        g.fillRect((int) x, (int) y, PLAYER_SIZE, PLAYER_SIZE);
    }
}
