package com.company.entities.PowerUps;

import java.awt.*;

public class BloodHeal extends PowerUp
{
    boolean up = true;
    int blue = 0;
    int fadeRate = 100;
    int fadeCounter = 0;

    public BloodHeal(int x, int y)
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
        g.setColor(new Color(117, 0, 0));
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
            player.heal(50);
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
