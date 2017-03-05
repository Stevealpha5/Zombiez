package com.company.entities;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.GameMode;
import com.company.Utilities.ID;
import com.company.Utilities.STATE;
import com.company.Utilities.Util;
import com.company.handlers.EnemeyHandler;

import java.awt.*;

public class Player extends GameObject
{
    int health = 100;
    int speed = 7;
    int speedBoost = 0;
    int duration = 0;
    public int score = 0;
    int bloodMultiplyer = 2;;

    EnemeyHandler handler;

    public Player(int x, int y, EnemeyHandler handler)
    {
        super(x, y, ID.Player);

        this.handler = handler;

    }

    @Override
    public void tick()
    {
        if(Game.spawner.gameMode != GameMode.Health4Points)
            score++;

        if(speedBoost > 0 || duration > 0)
        {
            duration--;

            if(duration <= 0)
                speedBoost = 0;
        }
            x += volX + speedBoost;
            y += volY + speedBoost;

        x = Util.clamp(x, 5, (int)Game.WIDTH - 42);
        y = Util.clamp(y, 5, (int)Game.HEIGHT - 65);

        collision();

        if(health <= 0)
        {
            Game.gameState = STATE.Lose;
        }


    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 32, 32);
    }

    private void collision()
    {
        for(GameObject gameObject : handler.gameObjects)
        {
            if(gameObject.getId() == ID.BasicEnemy || gameObject.getId() == ID.SmartEnemy || gameObject.getId() == ID.EnemeyBoss || gameObject.getId() == ID.RandomEnemy)
            {
                if(getBounds().intersects(gameObject.getBounds()))
                {
                    setHealth(health - 5);

                    if(Game.spawner.gameMode == GameMode.Health4Points)
                    {
                        score += 20;
                    }
                }
            }
        }
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = Util.clamp(health, 0, 100);
    }

    public void damage(int damage)
    {
        this.health = Util.clamp(this.health - damage, 0, 100);

    }

    public void heal(int heal)
    {
        this.health = Util.clamp(this.health + heal, 0, 100);

    }

    public int getSpeed()
    {
        return speed + speedBoost;
    }

    public void setSpeedBoost(int speedBoost, int duration)
    {
        this.speedBoost = speedBoost;
        this.duration = duration;
    }

    public void addPoints(int points)
    {
        score += points;
    }

    public int getSpeedBoost()
    {
        return speedBoost;
    }

}
