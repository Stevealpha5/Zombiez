package com.company.entities;

import com.company.GameObject;
import com.company.Utilities.ID;
import com.company.handlers.EnemeyHandler;

import java.awt.*;

public class Trail extends GameObject
{
    private float alpha = 1.0f;
    private EnemeyHandler handler;
    private Color color;
    private int width, height;
    float life;

   public Trail(int x, int y, int width, int height, float life, Color color, EnemeyHandler handler)
    {
        super(x, y, ID.Trial);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick()
    {
       if(alpha > life)
        {
            alpha -= life - 0.001f;
        }else
        {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        g2d.setComposite(makeTransparent(1));
    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }

    private AlphaComposite makeTransparent(float alpha)
    {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }
}
