package com.company.entities.PowerUps;

import java.awt.*;

public class Heal extends PowerUp
{
    boolean up = true;
    int blue = 0;
    int fadeRate = 100;
    int fadeCounter = 0;

    public Heal(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void tick()
    {
        collistion();
        timeOut();
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(new Color(0, 255, 203));
        g.fillRect(x, y, 8,  8);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 8, 8);
    }

    @Override
    protected void collistion()
    {
        if (getBounds().intersects(player.getBounds()))
        {
            player.heal(25);
            player.addPoints(100);
            itemHandler.removeObject(this);
        }

    }

    @Override
    protected void timeOut()
    {
        timeOutTimer++;

        if(timeOutTimer > 150)
        {
            timeOutTimer = 0;
            itemHandler.removeObject(this);
        }
    }
}
