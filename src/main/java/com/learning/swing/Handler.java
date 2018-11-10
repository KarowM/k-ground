package com.learning.swing;

import com.learning.swing.entity.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Handler {
    List<GameObject> objects = new ArrayList<GameObject>();

    public void tick() {
        int size = objects.size();
        for (int i = 0; i < size; i++) {
            objects.get(i).tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }
}
