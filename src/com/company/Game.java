package com.company;

import com.company.GUI.Lose;
import com.company.GUI.Menue;
import com.company.GUI.Options;
import com.company.GUI.Pause;
import com.company.Utilities.STATE;
import com.company.entities.Spawner;
import com.company.handlers.KeyInputHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int)screenSize.getWidth(), HEIGHT = (int)screenSize.getHeight();
    private boolean isRunning = false;
    private Thread thread;

    Menue menu = new Menue();
    Lose lose = new Lose();
    Options options = new Options();
    Pause pause = new Pause();

    public static Spawner spawner;

    public static STATE gameState = STATE.Meneu;

    public Game()
    {
        spawner = new Spawner();

        new com.company.GUI.Window((int)WIDTH, (int) HEIGHT, "Zombiez", this);
        this.addKeyListener(new KeyInputHandler(spawner.handler));
        this.addMouseListener(menu);
        this.addMouseListener(lose);
        this.addMouseListener(options);
        this.addMouseListener(pause);
    }

    public static void main(String[] args)
    {
       new Game();
    }

    @Override
    public void run()
    {
        this.requestFocus();

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;//check
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(isRunning)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1)
            {
                tick();
                delta--;
            }

            if(isRunning)
                render();
            
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: " + frames);
                System.out.println("Game State: " + Game.gameState);
                frames = 0;
            }
        }

    }

    private void tick()
    {
        if(gameState == STATE.Game)
        {
            spawner.tick();
        }
    }

    private void render()
    {
        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if(bufferStrategy == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);

        if(gameState == STATE.Game)
        {
            spawner.player.render(graphics);
            spawner.handler.render(graphics);
            spawner.itemHandler.render(graphics);
            spawner.hud.render(graphics);
        }else if (gameState == STATE.Meneu)
        {
            menu.render(graphics);
        }else if(gameState == STATE.Lose)
        {

            try
            {
                spawner.player.render(graphics);
                spawner.handler.render(graphics);
                spawner.itemHandler.render(graphics);
            } catch (Exception e)
            {
               System.out.println("Failed to render some object one lose screen");
            }
            lose.render(graphics);

        }else if(gameState == STATE.Options)
        {
            options.render(graphics);
        }else if(gameState == STATE.Pause)
        {

            try
            {
                spawner.player.render(graphics);
                spawner.handler.render(graphics);
                spawner.itemHandler.render(graphics);
                spawner.hud.render(graphics);
            } catch (Exception e)
            {
                System.out.println("Failed to render object during pause");
            }

            pause.render(graphics);
        }

        graphics.dispose();
        bufferStrategy.show();

    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            isRunning = false;
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
