package com.company.GUI;

import com.company.Game;
import com.company.Utilities.STATE;
import com.company.handlers.EnemeyHandler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menue extends MouseAdapter
{
    private EnemeyHandler handler;

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

        if(Game.gameState == STATE.Meneu)
        {

            if (mouseOver(mx, my, 210, 150, 200, 64))
            {
                Game.gameState = STATE.Game;
            }

            if (mouseOver(mx, my, 210, 250, 200, 64))
            {
                Game.gameState = STATE.Options;
            }

            if (mouseOver(mx, my, 210, 350, 200, 64))
            {
                System.exit(1);
            }
        }
    }

    public void render(Graphics g)
    {
        Font fnt = new Font("arial", Font.PLAIN, 50);
        Font fnt2 = new Font("arial", Font.PLAIN, 30);

        g.setFont(fnt);
        g.setColor(Color.cyan);
        g.drawString("Dodge the Thing", 154, 70);

        g.setFont(fnt2);

        g.drawString("Engage", 260, 190);
        g.drawRect(210, 150, 200, 64);

        g.drawString("The Stuff ;)", 240, 290);
        g.drawRect(210, 250, 200, 64);

        g.drawString("I'm Out", 260, 390);
        g.drawRect(210, 350, 200, 64);

        Button.button(0.33, 0.25, 0.25, 0.125, "Engage", fnt, g, Color.CYAN);


    }

}
