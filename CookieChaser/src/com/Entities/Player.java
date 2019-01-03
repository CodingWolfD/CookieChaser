package com.Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player 
{    
    private int x; // CREATES A NEW INT TO STORE THE PLAYERS X POSITION
    private int y; // CREATES A NEW INT TO STORE THE PLAYERS Y POSITION
    private int dx; // CREATES A NEW INT TO ADD TO THE PLAYERS CURRENT X POSITION
    private int dy; // CREATES A NEW INT TO ADD TO THE PLAYERS CURRENT Y POSITION
    private int speed; // CREATES A NEW INT TO STORE THE PLAYERS SPEED
    private int width; // CREATES A NEW INT TO STORE THE PLAYERS SPRITE WIDTH
    private int height; // CREATES A NEW INT TO STORE THE PLAYERS SPRITE HEIGHT
    private BufferedImage sprite; // CREATES A NEW BUFFEREDIMAGE TO STORE THE PLAYERS SPRITE
    
    public Player() 
    {
       init(); // CALLS THE INIT METHOD TO SETUP THE PLAYER
    }
    
    private void init() 
    {
        x = 100; // SETS THE PLAYERS X POSITION TO 100
        y = 100; // SETS THE PLAYERS Y POSITION TO 100
        width = 64; // SETS THE PLAYERS SPRITE WIDTH TO 34
        height = 64; // SETS THE PLAYERS SPRITE HEIGHT TO 64
        speed = 5; // SETS THE PLAYERS SPEED TO 5
        
        try  
        {
            sprite = ImageIO.read(getClass().getResource("/resources/player.png")); // GETS THE PLAYERS SPRITE FROM THE RESOURCES FOLDER
        }
        catch (IOException e)
        {
            System.err.println("Error finding player Image!"); // IF THE GAME CAN'T FIND THE IMAGE AN ERROR WILL BE PRINTED
        }
    }
    
    public void move()  
    {
        x += dx; // SETS THE PLAYERS X POSITION TO EQUAL THE CURRENT X PLUS THE DX 
        y += dy; // SETS THE PLAYERS Y POSITION TO EQUAL THE CURRENT Y PLUS THE DY
        
        checkOutBounds(); // CALLS THE CHECKOUTBOUNDS METHOD
    }
    
    private void checkOutBounds() 
    {
        if(x <= -3) // IF THE PLAYERS X IS LESS THAN OR EQUAL TO -3 
        {
            x = -3; // SET THE PLAYERS X TO -3
        }
        else if(x > 1024 - width) // IF THE PLAYERS X IS GREATER THAN 1024 WHICH IS THE LEFT BORDER - THE PLAYERS SPRITE WIDTH 
        {
            x = 1024 - width; // SET THE PLAYERS X TO 1024 - THE PLAYERS SPRITE WIDTH
        }
        
        if( y <= 0) // IF THE PLAYERS Y IS LESS THAN OR EQUAL TO 0 
        {
            y = 0; // SET THE PLAYERS Y TO 0
        }
        else if(y >= 740 - height) // IF THE PLAYERS Y IS GREATER THAN OR EQUAL TO 720 WHICH IS THE LEFT BORDER - THE PLAYERS SPRITE HEIGHT 
        {
            y = 740 - height; // SET THE PLAYERS Y TO 740 - THE PLAYERS SPRITE HEIGHT
        }
    }
    
    public void paintComponent(Graphics2D g) 
    {
        g.drawImage(sprite, x, y, width, height, null); // DRAWS THE PLAYER SPRITE AT THE GIVEN X AND Y CO-ORDINATES WITH THE SPECIFIED WIDTH AND HEIGHT WITH NO IMAGE OBSERVER
    }
    
    public void keyPressed(KeyEvent e) 
    {
        int k = e.getKeyCode(); // CREATES A NEW INT K EQUAL TO E.GETKEYCODE
        
        if(k == KeyEvent.VK_LEFT) // IF K IS EQUAL TO KEYEVENT.VK_LEFT
        { 
            dx -= speed; // SET THE DX TO THE CURRENT DX - SPEED
                   
            if(dx < -speed) // IF THE DX BECOMES LESS THAN THE -SPEED
            {
                dx = -speed; // SET DX EQUAL TO -SPEED SO THE PLAYER CAN'T MOVE FASTER THAN THE SPECIFIED SPEED
            }
        }
        
        if(k == KeyEvent.VK_RIGHT) // IF K IS EQUAL TO KEYEVENT.VK_RIGHT
        {
            dx += speed; // SET THE DX TO THE CURRENT DX + SPEED
                        
            if(dx > speed) // IF THE DX BECOMES MORE THAN THE SPEED
            {
                dx = speed; // SET DX EQUAL TO SPEED SO THE PLAYER CAN'T MOVE FASTER THAN THE SPECIFIED SPEED
            }
        }
        
        if(k == KeyEvent.VK_UP) // IF K IS EQUAL TO KEYEVENT.VK_UP
        {
            dy -= speed; // SET THE DY TO THE CURRENT DY - SPEED
            
            if(dy < -speed) // IF THE DY BECOMES LESS THAN THE -SPEED
            {
                dy = -speed; // SET DY EQUAL TO -SPEED SO THE PLAYER CAN'T MOVE FASTER THAN THE SPECIFIED SPEED
            }
        }
        
        if(k == KeyEvent.VK_DOWN) // IF K IS EQUAL TO KEYEVENT.VK_DOWN
        {
            dy += speed; // SET THE DY TO THE CURRENT DY + SPEED
            
            if(dy > speed) // IF THE DY BECOMES LESS THAN THE SPEED
            {
                dy = speed; // SET DY EQUAL TO SPEED SO THE PLAYER CAN'T MOVE FASTER THAN THE SPECIFIED SPEED
            }
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        int k = e.getKeyCode(); // CREATES A NEW INT K EQUAL TO E.GETKEYCODE
        
        if(k == KeyEvent.VK_LEFT) // IF K IS EQUAL TO KEYEVENT.VK_LEFT
        {
            dx = 0; // SETS DX EQUAL TO 0 SO THE PLAYER STOPS AT THE CURRENT X POSITION
        }
        
        if(k == KeyEvent.VK_RIGHT) // IF K IS EQUAL TO KEYEVENT.VK_RIGHT
        {
            dx = 0; // SETS DX EQUAL TO 0 SO THE PLAYER STOPS AT THE CURRENT X POSITION
        }
        
         if(k == KeyEvent.VK_UP) // IF K IS EQUAL TO KEYEVENT.VK_UP
        {
            dy = 0; // SETS DY EQUAL TO 0 SO THE PLAYER STOPS AT THE CURRENT Y POSITION
        }
        
        if(k == KeyEvent.VK_DOWN) // IF K IS EQUAL TO KEYEVENT.VK_DOWN
        {
            dy = 0; // SETS DY EQUAL TO 0 SO THE PLAYER STOPS AT THE CURRENT Y POSITION
        }
    }
    
    public Rectangle getBounds() 
    {
        Rectangle r = new Rectangle(x, y, width, height); // CREATES A NEW RECTANGLE AT THE PLAYER X AND Y WITH THE PLAYERS WIDTH AND HEIGHT
        return r; // RETURNS THAT CREATED RECTANGLE
    }
}