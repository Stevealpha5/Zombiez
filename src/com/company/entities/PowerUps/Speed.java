package com.company.entities.PowerUps;

import java.awt.*;

public class Speed extends PowerUp
{
    public Speed(int x, int y)
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
        g.setColor(new Color(255, 101, 0));
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
            player.setSpeedBoost(7, 250);
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
