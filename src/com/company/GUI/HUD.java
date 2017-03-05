package com.company.GUI;

import com.company.Game;
import com.company.entities.Player;

import java.awt.*;

public class HUD
{
    private Player player;
    private int health;

    boolean debugMode = false;

    public HUD(Player player)
    {
        this.health = player.getHealth();
        this.player = player;
    }

    public void tick()
    {
        this.health = player.getHealth();
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(15, 15, 200, 32);

        g.setColor(Color.green);
        g.fillRect(15, 15, health * 2, 32);

        g.setColor(Color.cyan);
        g.drawRect(15, 15, 200, 32);

        g.drawString("Score: " + player.score, 15, 64);
        g.drawString("Level: " + Game.spawner.level, 15, 79);

        if(debugMode)
        {
            g.drawString("Speed: " + player.getSpeed(), 15, 94);
            g.drawString("VolX: " + player.getVolX(), 15, 109);
            g.drawString("VolY: " + player.getVolY(), 15, 124);
            g.drawString("Speed Boost: " + player.getSpeedBoost(), 15, 139);
        }
    }

}
