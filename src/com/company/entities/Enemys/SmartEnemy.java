package com.company.entities.Enemys;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.Utilities.Util;
import com.company.entities.Player;
import com.company.entities.Trail;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.util.Random;

public class SmartEnemy extends GameObject
{
    EnemeyHandler handler;
    Random random = new Random();
    int damage = 1;
    Player player = Game.spawner.player;
    int diffuclty;

    public SmartEnemy(int x, int y, EnemeyHandler handler, int diffuclty)
    {
        super(x, y, ID.SmartEnemy);

        this.handler = handler;
        this.diffuclty = diffuclty;

        volY = 5;
        volX = 7;
    }

    @Override
    public void tick()
    {
        x += volX;
        y += volY;

        volX = Util.clamp((x - player.getX() - 8) * -1, diffuclty * -1, diffuclty);
        volY = Util.clamp((y - player.getY() - 8) * -1, diffuclty * -1, diffuclty);

        if(y <= 0)
            volY *= -1;

        if(y >= Game.HEIGHT - 32)
            volY *= -1;

        if(x <= 0)
            volX *= -1;

        if(x >= Game.WIDTH - 32)
            volX *= -1;



        handler.addObject(new Trail(x, y, 16, 16, 0.05f, new Color(255, Math.abs(255 / ((volX * 2) + 1)), Math.abs(255 / ((volY * 2) + 1))), handler));
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
