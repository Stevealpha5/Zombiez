package com.company.entities.Enemys;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.Trail;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject
{
    EnemeyHandler handler;
    Random random = new Random();
    int damage = 1;
    int timer = 100;
    int timer2 = 100;
    int spawnChance;
    int spawnTimer = random.nextInt(100) + 1;

    public EnemyBoss(int x, int y, EnemeyHandler handler, int spawnChance)
    {
        super(x, y, ID.EnemeyBoss);

        this.handler = handler;
        this.spawnChance = spawnChance;

        volY = 2;
        volX = 0;
    }


    @Override
    public void tick()
    {
        x += volX;
        y += volY;

        if(timer <= 0)
               volY = 0;
        else
            timer--;

       if(timer <= 0)
           timer2--;

        if(timer2 <= 0 && volX == 0)
            volX = 5;

       if(x <= 0 || x >= Game.WIDTH - 94)
           volX *= -1;

        spawnTimer--;

        if(spawnTimer <= 0)
        {
            handler.addObject(new EnemyBossBullet((x + 47), (y + 47), handler));
            spawnTimer = random.nextInt(spawnChance) + 1;
        }

        handler.addObject(new Trail(x, y, 94, 94, 0.05f, Color.pink, handler));
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
        return new Rectangle(0, 0, Game.WIDTH,  y + 94);
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
