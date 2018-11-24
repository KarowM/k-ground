package com.learning.swing.entity;

import com.learning.swing.Game;
import com.learning.swing.Handler;
import com.learning.swing.graphics.HUD;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Player extends GameObject {

    public static final int PLAYER_SIZE = 32;
    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x = clamp(x + velX, 0, Game.WIDTH - PLAYER_SIZE);
        y = clamp(y + velY, 0, Game.HEIGHT - PLAYER_SIZE);

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObj = handler.objects.get(i);

            if (tempObj.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObj.getBounds())) {
                    HUD.currentHealth -= 1;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, PLAYER_SIZE, PLAYER_SIZE);
    }
}
