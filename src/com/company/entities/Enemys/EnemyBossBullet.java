package com.company.entities.Enemys;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.Trail;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject
{
    EnemeyHandler handler;
    Random random = new Random();
    int damage = 1;

    public EnemyBossBullet(int x, int y, EnemeyHandler handler)
    {
        super(x, y, ID.BasicEnemy);

        this.handler = handler;

        volY = 5;
        volX = random.nextInt(11) - 5;
    }


    @Override
    public void tick()
    {
        x += volX;
        y += volY;

        if(y <= 0 || y >= Game.HEIGHT - 32 || x <= 0 || x >= Game.WIDTH - 32)
            handler.removeObject(this);

        handler.addObject(new Trail(x, y, 16, 16, 0.05f, Color.pink, handler));
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
