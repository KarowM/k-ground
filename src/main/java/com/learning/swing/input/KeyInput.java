package com.learning.swing.input;

import com.learning.swing.Handler;
import com.learning.swing.entity.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean uP = false;
    private boolean dP = false;
    private boolean lP = false;
    private boolean rP = false;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        Player player = handler.getPlayer();
        if (key == KeyEvent.VK_W) {
            uP = true;
            player.setVelY(-5);
        }
        if (key == KeyEvent.VK_S) {
            dP = true;
            player.setVelY(5);
        }
        if (key == KeyEvent.VK_A) {
            lP = true;
            player.setVelX(-5);
        }
        if (key == KeyEvent.VK_D) {
            rP = true;
            player.setVelX(5);
        }

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        Player player = handler.getPlayer();
        if (key == KeyEvent.VK_W) {
            uP = false;
            if (dP) {
                player.setVelY(5);
            } else {
                player.setVelY(0);
            }
        }
        if (key == KeyEvent.VK_S) {
            dP = false;
            if (uP) {
                player.setVelY(-5);
            } else {
                player.setVelY(0);
            }
        }
        if (key == KeyEvent.VK_A) {
            lP = false;
            if (rP) {
                player.setVelX(5);
            } else {
                player.setVelX(0);
            }
        }
        if (key == KeyEvent.VK_D) {
            rP = false;
            if (lP) {
                player.setVelX(-5);
            } else {
                player.setVelX(0);
            }
        }
    }
}
