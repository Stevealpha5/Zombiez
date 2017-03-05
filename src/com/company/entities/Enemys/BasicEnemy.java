package com.company.entities.Enemys;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.Trail;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject
{
    EnemeyHandler handler;
    Random random = new Random();
    int damage = 1;

    public BasicEnemy(int x, int y, EnemeyHandler handler, int maxVel)
    {
        super(x, y, ID.BasicEnemy);

        this.handler = handler;

        volY = random.nextInt(maxVel * 2 + 1) - maxVel;
        volX = random.nextInt(maxVel * 2 + 1) - maxVel;

        if(volY == 0)
            volY += maxVel;

        if(volX == 0)
            volX -= maxVel;
    }

    @Override
    public void tick()
    {
        x += volX;
        y += volY;

        if(y <= 0 || y >= Game.HEIGHT - 32)
            volY *= -1;

        if(x <= 0 || x >= Game.WIDTH - 32)
            volX *= -1;

        handler.addObject(new Trail(x, y, 16, 16, 0.05f, new Color(255, Math.abs(255 / volX), Math.abs(255 / volY)), handler));
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.PINK);
        g.fillRect(x, y, 16,  16);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 16,  16);
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
