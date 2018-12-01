package com.learning.swing.input;

import com.learning.swing.entity.Player;
import com.learning.swing.entity.Spawner;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Spawner spawner;
    private boolean uP = false;
    private boolean dP = false;
    private boolean lP = false;
    private boolean rP = false;

    public KeyInput(Spawner spawner) {
        this.spawner = spawner;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        Player player = spawner.getPlayer();
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

        Player player = spawner.getPlayer();
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
