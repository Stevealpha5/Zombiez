package com.company.GUI;

import com.company.Game;
import com.company.Utilities.STATE;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lose extends MouseAdapter
{

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        if(mx >= x && mx <= (x + width) && my >= y && my <= (y + height))
            return true;
        else
            return false;

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY();

        if(Game.gameState == STATE.Lose)
        {

            if (mouseOver(mx, my, 210, 250, 200, 64))
            {

                Game.gameState = STATE.Game;
                Game.spawner.reset();
            }

            if (mouseOver(mx, my, 210, 350, 200, 64))
            {
                Game.gameState = STATE.Meneu;
                Game.spawner.reset();
            }
        }
    }

    public void render(Graphics g)
    {
        Font fnt = new Font("arial", Font.PLAIN, 50);
        Font fnt2 = new Font("arial", Font.PLAIN, 30);

        g.setFont(fnt);
        g.setColor(Color.cyan);
        g.drawString("You Died", 220, 70);

        g.setFont(fnt2);

        g.drawString("Score: " + Game.spawner.player.score, 260, 100);


        g.drawString("Try Again", 250, 290);
        g.drawRect(210, 250, 200, 64);

        g.drawString("I'm Out", 260, 390);
        g.drawRect(210, 350, 200, 64);
    }
}
