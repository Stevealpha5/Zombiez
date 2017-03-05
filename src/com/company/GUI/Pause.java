package com.company.GUI;

import com.company.Game;
import com.company.Utilities.STATE;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pause extends MouseAdapter
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

        if(Game.gameState == STATE.Pause)
        {

            if (mouseOver(mx, my, 210, 250, 200, 64))
            {
                Game.gameState = STATE.Game;
            }

            if (mouseOver(mx, my, 210, 350, 200, 64))
            {
                Game.spawner.reset();
                Game.gameState = STATE.Meneu;

            }


        }
    }

    public void render(Graphics g)
    {
        Font fntP = g.getFont();//font transparency

        Font fnt = new Font("arial", Font.PLAIN, 50);
        Font fnt2 = new Font("arial", Font.PLAIN, 30);

        g.setFont(fnt);
        g.setColor(Color.cyan);
        g.drawString("Pause", 240, 70);

        g.setFont(fnt2);

        g.drawString("Resume", 250, 290);
        g.drawRect(210, 250, 200, 64);

        g.drawString("Main Menu", 240, 390);
        g.drawRect(210, 350, 200, 64);

        g.setFont(fntP);
    }
}
