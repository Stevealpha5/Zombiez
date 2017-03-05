package com.company.entities.PowerUps;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.entities.Player;
import com.company.handlers.EnemeyHandler;
import com.company.handlers.ItemHandler;

public abstract class PowerUp extends GameObject
{

    protected int timeOutTimer = 0;
    protected Player player = Game.spawner.player;
    protected ItemHandler itemHandler = Game.spawner.itemHandler;
    protected EnemeyHandler enemeyHandler = Game.spawner.handler;

    public PowerUp(int x, int y)
    {
        super(x, y, ID.PowerUP);
    }

    protected abstract void collistion();

    protected abstract void timeOut();
   /* {
        timeOutTimer++;

        if(timeOutTimer > 100)
        {
            timeOutTimer = 0;
            itemHandler.removeObject(this);
        }
    }*/


}
