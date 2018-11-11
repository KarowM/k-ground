package com.learning.swing.input;

import com.learning.swing.Handler;
import com.learning.swing.entity.GameObject;
import com.learning.swing.utils.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject= handler.objects.get(i);

            if (tempObject.getId().equals(ID.Player)) {

                if (key == KeyEvent.VK_W) {
                    tempObject.setY(tempObject.getY() - 1);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

    }

}
