package com.company.handlers;

import com.company.Game;
import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.Utilities.STATE;
import com.company.entities.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter
{
    private Player player = Game.spawner.player;

    private EnemeyHandler gameObjectHandler;

    public KeyInputHandler(EnemeyHandler gameObjectHandler)
    {
        this.gameObjectHandler = gameObjectHandler;
    }

    private boolean[] keyPressed = {false, false, false, false};

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

         if(key == KeyEvent.VK_W) {player.setVolY(player.getSpeed() * -1); keyPressed[0] = true;}
         if(key == KeyEvent.VK_A) {player.setVolX(player.getSpeed() * -1); keyPressed[1] = true;}
         if(key == KeyEvent.VK_S) {player.setVolY(player.getSpeed());  keyPressed[2] = true;}
         if(key == KeyEvent.VK_D) {player.setVolX(player.getSpeed());  keyPressed[3] = true;}

        if(key ==  KeyEvent.VK_ESCAPE && Game.gameState == STATE.Game){Game.gameState = STATE.Pause;}
        else if(key ==  KeyEvent.VK_ESCAPE && Game.gameState == STATE.Pause){Game.gameState = STATE.Game;}

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();


        if(key == KeyEvent.VK_W) keyPressed[0] = false;
        if(key == KeyEvent.VK_A) keyPressed[1] = false;
        if(key == KeyEvent.VK_S) keyPressed[2] = false;
        if(key == KeyEvent.VK_D) keyPressed[3] = false;

        if(!keyPressed[0] && !keyPressed[2])
                player.setVolY(0);

        if(!keyPressed[1] && !keyPressed[3])
                player.setVolX(0);

    }
}
