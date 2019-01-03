package com.Entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Cookie {
    
    private int x; // CREATES A NEW INT TO STORE THE COOKIES X POSITION
    private int y; // CREATES A NEW INT TO STORE THE COOKIES Y POSITION
    private int width; // CREATES A NEW INT TO STORE THE COOKIES SPRITE WIDTH
    private int height; // CREATES A NEW INT TO STORE THE COOKIES SPRITE HEIGHT
    private BufferedImage sprite; // CREATES A NEW BUFFEREDIMAGE TO STORE THE COOKIES SPRITE
    private Random rnd;
    
    public Cookie() 
    {
        init(); // CALLS THE INIT METHOD TO SETUP THE PLAYER
    }
    
    private void init() 
    { 
        rnd = new Random(); // INTIALISES THE RANDOM VARIABLE SO WE CAN GENERATE RANDOM NUMBERS
        x = rnd.nextInt(1024 - width); // USES THE RANDOM VARIABLE TO GENERATE A NUMBER FROM THE WINDOWS WIDTH - THE COOKIES SPRITE WIDTH
        y = rnd.nextInt(740 - height); // USES THE RANDOM VARIABLE TO GENERATE A NUMBER FROM THE WINDOWS HEIGHT - THE COOKIES SPRITE HEIGHT
        width = 64; // SETS THE COOKIES SPRITE HEIGHT TO 64
        height = 64; // SETS THE COOKIES SPRITE HEIGHT TO 64
        
        try 
        {
            sprite = ImageIO.read(getClass().getResource("/resources/cookie.png")); // GETS THE COOKIES SPRITE FROM THE RESOURCES FOLDER
        }
        catch (IOException e)
        {
            System.err.println("Error finding cookie Image!"); // IF THE GAME CAN'T FIND THE IMAGE AN ERROR WILL BE PRINTED
        }
    }
            
    public boolean checkCollision(Rectangle a, Rectangle b) 
    {
        if(a.intersects(b)) // IF RECTANGLE A INTERSECTS WITH RECTANLE B
        {
            x = rnd.nextInt(1024 - width); // GENERATE THE COOKIE A NEW X FROM THE WINDOWS WIDTH - THE COOKIES SPRITE WIDTH
            y = rnd.nextInt(740 - height); // GENERATE THE COOKIE A NEW Y FROM THE WINDOWS HEIGHT - THE COOKIES SPRITE HEIGHT
            return true; // RETURNS THE METHOD AS TRUE
        }
        
        return false; // IF NO COLLISION HAPPENS THIS RETURNS THE METHOD AS FALSE
    }

    public void paintComponent(Graphics2D g)
    {
        g.drawImage(sprite, x, y, width, height, null); // DRAWS THE PLAYER SPRITE AT THE GIVEN X AND Y CO-ORDINATES WITH THE SPECIFIED WIDTH AND HEIGHT WITH NO IMAGE OBSERVER
    }
    
    public Rectangle getBounds()
    {
        Rectangle r = new Rectangle(x, y, width, height); // CREATES A NEW RECTANGLE AT THE PLAYER X AND Y WITH THE PLAYERS WIDTH AND HEIGHT
        return r; // RETURNS THAT CREATED RECTANGLE
    }
}