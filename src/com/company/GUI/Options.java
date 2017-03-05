package com.company.GUI;

import com.company.Game;
import com.company.Utilities.GameMode;
import com.company.Utilities.STATE;
import com.company.entities.Spawner;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Options extends MouseAdapter
{
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        return mx >= x && mx <= (x + width) && my >= y && my <= (y + height);
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY();

        if(Game.gameState == STATE.Options)
        {
            if(mouseOver(mx, my, 270, 394, 100, 32))
            {
                Game.gameState = STATE.Meneu;
            }

            if(mouseOver(mx, my, 459, 286, 100, 32))
            {
                Game.spawner.gameMode = GameMode.HotSeat;
            }

            if(mouseOver(mx, my, 459, 250, 100, 32))
            {
                Game.spawner.gameMode = GameMode.Classic;
            }

            if(mouseOver(mx, my, 459, 322, 100, 32))
            {
                Game.spawner.gameMode = GameMode.Health4Points;
            }
        }
    }

    public void render(Graphics g)
    {
        Font fnt = new Font("arial", Font.PLAIN, 50);
        Font fnt2 = new Font("arial", Font.PLAIN, 20);

        g.setFont(fnt);
        g.setColor(Color.cyan);
        g.drawString("Game Play Options", 100, 70);

        g.setFont(fnt2);

        //coumn 1

        g.drawString("Starting Difficulty", 40, 242);

        g.drawString("Talc", 15, 273);
        g.drawRect(10, 250, 100, 32);

        g.drawString("Gypsum", 15, 309);
        g.drawRect(10, 286, 100, 32);

        g.drawString("Calcite", 15, 345);
        g.drawRect(10, 322, 100, 32);

        g.drawString("Fluorite", 15, 381);
        g.drawRect(10, 358, 100, 32);

        //coumn 2

        g.drawString("Apatite", 119, 273);
        g.drawRect(114, 250, 100, 32);

        g.drawString("Orthoclase", 117, 309);
        g.drawRect(114, 286, 100, 32);

        g.drawString("Quartz", 119, 345);
        g.drawRect(114, 322, 100, 32);

        g.drawString("Topaz", 119, 381);
        g.drawRect(114, 358, 100, 32);

        //bottom
        g.drawString("Diamond", 56, 417);
        g.drawRect(51, 394, 100, 32);

        //GameModes

        g.drawString("Game Modes", 450, 242);

        g.drawString("Classic", 464, 273);
        g.drawRect(459, 250, 100, 32);

        g.drawString("Hot Seat", 464, 309);
        g.drawRect(459, 286, 100, 32);

        g.drawString("Blood", 464, 345);
        g.drawRect(459, 322, 100, 32);


        switch (Game.spawner.gameMode)
        {
            case Classic:
                g.setColor(new Color(0, 95, 255));
                g.fillRect(459, 250, 100, 32);

                g.setColor(Color.cyan);
                g.drawRect(459, 250, 100, 32);
                g.drawString("Classic", 464, 273);
                break;
            case HotSeat:
                g.setColor(new Color(0, 95, 255));
                g.fillRect(459, 286, 100, 32);

                g.setColor(Color.cyan);
                g.drawRect(459, 286, 100, 32);
                g.drawString("Hot Seat", 464, 309);
                break;
            case Health4Points:
                g.setColor(new Color(0, 95, 255));
                g.fillRect(459, 322, 100, 32);

                g.setColor(Color.cyan);
                g.drawRect(459, 322, 100, 32);
                g.drawString("Blood", 464, 345);
                break;
        }

        //Exit

        g.drawString("I'm Out", 290, 417);
        g.drawRect(270, 394, 100, 32);
    }
}
