package com.company.entities.Enemys;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.Trail;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.util.Random;

public class RandomEnemy extends GameObject
{
    EnemeyHandler handler;
    Random random = new Random();
    int damage = 1;
    int maxVol;

    public RandomEnemy(int x, int y, EnemeyHandler handler, int maxVol)
    {
        super(x, y, ID.RandomEnemy);

        this.handler = handler;
        this.maxVol = maxVol;

        volY = 1;
        volX = 1;
    }


    @Override
    public void tick()
    {
        x += volX;
        y += volY;

        if(y <= 0)
            volY = (random.nextInt(maxVol) + 1);

        if(y >= Game.HEIGHT - 32)
            volY = (random.nextInt(maxVol) + 1) * -1;

        if(x <= 0)
            volX = random.nextInt(maxVol) + 1;

        if(x >= Game.WIDTH - 32)
            volX = (random.nextInt(maxVol) + 1) * -1;

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
