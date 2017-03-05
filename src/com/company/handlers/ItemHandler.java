package com.company.handlers;

import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.PowerUps.PowerUp;

import java.awt.*;
import java.util.LinkedList;

public class ItemHandler
{
    public LinkedList<PowerUp> gameObjects = new LinkedList<PowerUp>();

    public void tick()
    {
        for (int i = 0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).tick();
        }
    }

    public void render(Graphics g)
    {
        for (int i =0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).render(g);
        }

    }

    public void addObject(PowerUp PowerUp)
    {
        gameObjects.add(PowerUp);
    }

    public void removeObject(PowerUp PowerUp)
    {
        gameObjects.remove(PowerUp);
    }

    public void clearAll()
    {
        gameObjects.clear();
    }

}
