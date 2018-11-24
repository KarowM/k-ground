package com.learning.swing.entity;

import com.learning.swing.Handler;
import com.learning.swing.utils.ID;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Color color;
    private Handler handler;
    int width, height;
    double life;

    public Trail(int x, int y, ID id, Color color, int width, int height, double life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.handler = handler;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.0001f);
        } else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}
