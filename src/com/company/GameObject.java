package com.company;

import com.company.Utilities.ID;

import java.awt.*;

public abstract class GameObject
{
    protected int x, y;

    protected ID id;

    protected int volX, volY;

    public GameObject(int x, int y, ID id)
    {
        this.x = x;
        this. y = y;
        this. id = id;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public ID getId()
    {
        return id;
    }

    public int getVolX()
    {
        return volX;
    }

    public int getVolY()
    {
        return volY;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setId(ID id)
    {
        this.id = id;
    }

    public void setVolX(int volX)
    {
        this.volX = volX;
    }

    public void setVolY(int volY)
    {
        this.volY = volY;
    }
}
