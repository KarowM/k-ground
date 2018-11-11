package com.learning.swing.input;

import com.learning.swing.Handler;
import com.learning.swing.entity.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updatePlayerVelocity(e, 5);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updatePlayerVelocity(e, 0);
    }

    private void updatePlayerVelocity(KeyEvent e, int vel) {
        int key = e.getKeyCode();

        Player player = handler.getPlayer();
        if (key == KeyEvent.VK_W) {
            player.setVelY(-vel);
        }
        if (key == KeyEvent.VK_S) {
            player.setVelY(vel);
        }
        if (key == KeyEvent.VK_A) {
            player.setVelX(-vel);
        }
        if (key == KeyEvent.VK_D) {
            player.setVelX(vel);
        }
    }
}
