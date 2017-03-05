package com.company.entities;

import com.company.GUI.HUD;
import com.company.Game;
import com.company.Utilities.Difficulty;
import com.company.Utilities.GameMode;
import com.company.Utilities.STATE;
import com.company.entities.Enemys.BasicEnemy;
import com.company.entities.Enemys.EnemyBoss;
import com.company.entities.Enemys.RandomEnemy;
import com.company.entities.Enemys.SmartEnemy;
import com.company.entities.PowerUps.BloodHeal;
import com.company.entities.PowerUps.Heal;
import com.company.entities.PowerUps.Speed;
import com.company.handlers.EnemeyHandler;
import com.company.handlers.ItemHandler;

import java.util.Random;

public class Spawner
{
    public EnemeyHandler handler = new EnemeyHandler();
    public ItemHandler itemHandler = new ItemHandler();

    public Player player = new Player((Game.WIDTH / 2) - 32, (Game.HEIGHT / 2) - 32, handler);
    public HUD hud = new HUD(player);

    private int score;
    public int level = 1;

    public Difficulty difficulty = Difficulty.Talc;
    public GameMode gameMode = GameMode.Health4Points;

    private boolean isFirst = true;

    private int hotSeatCounter = 50;

    Random random = new Random();

    public void tick()
    {

        switch (gameMode)
        {
            case Classic:
                switch (difficulty)
                {
                    case Talc:
                        talc();
                        break;
                    case Gypsum:
                        break;
                    case Calcite:
                        break;
                    case Fluorite:
                        fluorite();
                        break;
                    case Apatite:
                        break;
                    case Orthoclase:
                        break;
                    case Quartz:
                        quartz();
                        break;
                    case Topaz:
                        break;
                    case Diamond:
                        break;
                }

                break;
            case HotSeat:
                hotSeat();
                break;
            case Health4Points:
                blood();
                break;
        }


        player.tick();
        itemHandler.tick();
        handler.tick();
        hud.tick();
    }

    public void render()
    {

    }

    private void talc()
    {
        score++;

        if(score % 1000 == random.nextInt(101))
            itemHandler.addObject(new Speed(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 50)));

        if(isFirst)
        {
            handler.gameObjects.add(new BasicEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 50), handler, 5));
            isFirst = false;
        }

        if(score >= 250)
        {
            score = score - 250;
            level += 1;

            if(level <= 5)
                handler.gameObjects.add(new BasicEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 25), handler, 5));

            if(level == 10)
            {
                handler.clearEnemys();
                handler.gameObjects.add(new EnemyBoss(Game.WIDTH / 2 - 47, -100, handler, 100));
            }
        }
    }

    private void fluorite()
    {
        score++;

        if (isFirst)
        {
            handler.gameObjects.add(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 25), handler, 5));
            isFirst = false;
        }

        if (score >= 250)
        {
            score = score - 250;
            level += 1;

            if (level <= 5)
                handler.gameObjects.add(new BasicEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 25), handler, 5));

            if (level > 5 && level < 7)
                handler.gameObjects.add(new RandomEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 25), handler, 5));

            if (level == 10)
            {
                handler.clearEnemys();
                handler.gameObjects.add(new EnemyBoss(Game.WIDTH / 2 - 47, -100, handler, 50));
            }
        }
    }

    private void quartz()
    {
        score++;

        if(isFirst)
        {

            handler.gameObjects.add(new RandomEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 25), handler, 7));
            isFirst = false;
        }

        if(score >= 250)
        {
            score = score - 250;
            level ++;

            if(level <= 5)
                handler.gameObjects.add(new BasicEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 25), handler, 7));

            if(level > 5 && level < 7)
                handler.gameObjects.add(new RandomEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 25), handler, 7));

            if(level > 7 && level < 10)
                handler.gameObjects.add(new SmartEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 25), handler, 2));

            if(level == 10)
            {
                handler.clearEnemys();
                handler.gameObjects.add(new EnemyBoss(Game.WIDTH / 2 - 47, -100, handler, 25));
            }
        }
    }

    public void reset()
    {
        handler.gameObjects.clear();
        itemHandler.gameObjects.clear();
        player.setX((Game.WIDTH / 2) - 32);
        player.setY((Game.HEIGHT / 2) - 32);
        player.setHealth(100);
        player.score = 0;
        isFirst = true;
        level = 1;
    }

    private void hotSeat()
    {
       if(player.getVolX() == 0 && player.getVolY() == 0)
       {
           hotSeatCounter--;
       }else
       {
           hotSeatCounter = 10;
       }

        if(hotSeatCounter <= 0)
       {
           hotSeatCounter = 0;
           player.damage(1);
       }

        switch (difficulty)
        {
            case Talc:
                talc();
                break;
            case Gypsum:
                break;
            case Calcite:
                break;
            case Fluorite:
                fluorite();
                break;
            case Apatite:
                break;
            case Orthoclase:
                break;
            case Quartz:
                quartz();
                break;
            case Topaz:
                break;
            case Diamond:
                break;
        }

    }

    private void blood()
    {
        score++;

        if(isFirst)
        {
            score = 0;
            handler.gameObjects.add(new RandomEnemy(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 50), handler, 5));
            itemHandler.addObject(new BloodHeal(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 50)));
            isFirst = false;
        }

        if (score % 250 == 0)
            handler.gameObjects.add(new RandomEnemy(random.nextInt(Game.WIDTH - 20), random.nextInt(Game.HEIGHT - 25), handler, 5));

        if (score % 100 == 0)
            itemHandler.addObject(new BloodHeal(random.nextInt(Game.WIDTH -20), random.nextInt(Game.HEIGHT - 50)));
    }
}
