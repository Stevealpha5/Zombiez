package com.company.handlers;

import com.company.GameObject;
import com.company.Utilities.ID;

import java.awt.*;
import java.util.LinkedList;

public class EnemeyHandler
{
    public LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    public void tick()
    {
        for (int i = 0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).tick();
        }
    }

    public void render(Graphics g)
    {
        for (int i = 0; i < gameObjects.size(); i++)
        {
            gameObjects.get(i).render(g);
        }

    }

    public void addObject(GameObject object)
    {
        gameObjects.add(object);
    }

    public void removeObject(GameObject object)
    {
        gameObjects.remove(object);
    }

    public void clearEnemys()
    {
        for (int i =0; i < gameObjects.size(); i++)
        {
            if(gameObjects.get(i).getId() != ID.Player)
            {
                gameObjects.remove(i);
                i--;
            }
        }
    }

}
