package com.learning.swing.input;

import com.learning.swing.entity.EntityManager;
import com.learning.swing.entity.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private EntityManager entityManager;
    private boolean uP = false;
    private boolean dP = false;
    private boolean lP = false;
    private boolean rP = false;

    public KeyInput(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        Player player = entityManager.getPlayer();
        switch (key) {
            case KeyEvent.VK_W:
                uP = true;
                player.setVelY(-5);
                break;
            case KeyEvent.VK_S:
                dP = true;
                player.setVelY(5);
                break;
            case KeyEvent.VK_A:
                lP = true;
                player.setVelX(-5);
                break;
            case KeyEvent.VK_D:
                rP = true;
                player.setVelX(5);
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        Player player = entityManager.getPlayer();

        switch (key) {
            case KeyEvent.VK_W:
                uP = false;
                break;
            case KeyEvent.VK_S:
                dP = false;
                break;
            case KeyEvent.VK_A:
                lP = false;
                break;
            case KeyEvent.VK_D:
                rP = false;
        }

        if (!uP && !dP) {
            player.setVelY(0);
        }
        if (!lP && !rP) {
            player.setVelX(0);
        }
    }
}
