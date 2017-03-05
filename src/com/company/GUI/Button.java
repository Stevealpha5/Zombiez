package com.company.GUI;

import com.company.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Button//Todo make object and implement something for key presses
{
    public static void button(double x, double y, double width, double height, String text, Font fnt, Graphics g, Color colour)
    {

        Font fntT = g.getFont();


        g.setFont(fnt);
        g.setColor(colour);

        FontMetrics metrics = g.getFontMetrics();
        Rectangle2D bounds = metrics.getStringBounds(text, g);

        int textWidth = (int)bounds.getWidth();
        int textHeight = (int)bounds.getHeight();

        int rectX = (int)(x * Game.WIDTH),
            rectY = (int)(y * Game.HEIGHT),
            rectWidth = (int)(width * Game.WIDTH),
            rectHeight = (int)(height * Game.HEIGHT);

        int fontX = rectX + ((rectWidth / 2 ) - (textWidth / 2)),
            fontY = rectY + ((rectHeight / 2 ) + (textHeight / 4));

        g.drawRect(rectX, rectY, rectWidth, rectHeight);
        g.drawString(text, fontX, fontY);

        g.setFont(fntT);
    }
}
