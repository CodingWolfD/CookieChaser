package com.Main;

import com.Entities.Cookie;
import com.Entities.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Display extends JPanel implements ActionListener
{
    private final Timer time; // USED FOR STARTING THE GAME TIME
    private final Player pl; // USED TO CREATE A NEW INSTANCE OF THE PLAYER CLASS
    private final Cookie ck; // USED TO CREATE A NEW INSTANCE OF THE COOKIE CLASS
    private int score; // USED TO STORE THE PLAYERS SCORE WHILE THEY PLAY
    private final int neededScore; // USED TO DEFINE THE NEEDED SCORE TO WIN
    private List<Integer> timeForCookie; // USED TO STORE WHAT TIME EACH COOKIE WAS PICKED UP
    private int timeElapsed; // USED TO STORE HOW MUCH TIME HAS PASSED
    private static int gameScreen; // USED TO TELL THE GAME WHAT SCREEN TO DISPLAY
    
    public Display()
    {
        time = new Timer(5, this); // CREATES A NEW TIMER WITH THE DELAY OF 5 MILLISECONDS AND PASSES IN THIS CLASSES ACTIONLISTENER
        pl = new Player(); // INSTANTIATES THE PLAYER CLASS
        ck = new Cookie(); // INSTANTIATES THE COOKIE CLASS
        
        timeForCookie = new ArrayList<>(); // INSTANTAIATES THE TIMEFORCOOKIE ARRAY
        neededScore = 50; // INITIALIZES THE NEEDEDSCORE AND SETS IT TO 50
        gameScreen = 0; // INITIALIZES THE GAMESCREEN AND ASSIGNS THE START GAMESCREEN TO 0
        score = 0; // INITIALIZES THE SCORE AND ASSIGNS IT TO 0
        
        addKeyListener(new TA()); // ADDS A NEW KEYLISTENER TO THE DISPLAY AND PASSES IN THE PRIVATE CLASS TA
        setFocusable(true); // SETS THE WINDOW TO FOCUSABLE        
        TStart(); // CALLS THE TSTART METHOD TO START THE TIME
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g; // CREATES A NEW GRAPHICS2D REFERENCE AND CASTS THE GRAPHICS G TO THE NEW GRAPHICS2D
        super.paintComponent(g2d); // CALLS THE SUPER.PAINTCOMPONENT(G2D) TO USE THE NEW GRAPHICS2D
              
        switch(gameScreen) // SWITCH STATEMENT HANDLES WHAT GET'S DISPLAYED BASED ON THE GAMESCREEN INT
        {
        	case 0: // IF GAMESCREEN IS EQUAL TO 0
        	{
        		g2d.setColor(Color.GREEN); // SET THE GRAPHICS2D COLOUR TO GREEN 
                g2d.fillRect(0, 0, 1024, 768); // FILL A RECTANGLE FROM THE CO-ORDINATES OF 0 AND 0 AND GIVE IT A WIDTH AND HEIGHT OF 1024 BY 768
                
                g2d.setColor(Color.BLACK); // CHANGES THE GRAPHICS2D COLOUR TO BLACK
                g2d.setFont(new Font("Arial", 20, 20)); // SETS THE GRAPHICS2D FONT TO ARIAL WITH A STYLE OF 20 AND A SIZE OF 20
                g2d.drawString("Press [SPACE] to play", 0, 37); /* CREATES A NEW STRING AND DRAWS IT ON THE SCREEN
                TELLING THE PLAYER TO PRESS SPACE TO PLAY AND POSITIONS IT AT 0 and 37*/
        	}
        		break;
        	case 1:
        	{
        		 g2d.setColor(Color.GREEN); // SET THE GRAPHICS2D COLOUR TO GREEN
                 g2d.fillRect(0, 0, 1024, 768); // FILL A RECTANGLE FROM THE CO-ORDINATES OF 0 AND 0 AND GIVE IT A WIDTH AND HEIGHT OF 1024 BY 768
             
                 g2d.setColor(Color.BLACK); // CHANGES THE GRAPHICS2D COLOUR TO BLACK
                 g2d.setFont(new Font("Arial", 20, 20)); // SETS THE GRAPHICS2D FONT TO ARIAL WITH A STYLE OF 20 AND A SIZE OF 20
                 g2d.drawString("Time: " + timeElapsed / 100, 0, 37); // CREATES A NEW STRING WHICH DISPLAYS HOW MUCH TIME HAS PASSED AT 0 AND 37
                 g2d.drawString("Score: " + score, 0, 18); // CREATES A NEW STRING WHICH DISPLAYS HOW MUCH SCORE THE PLAYER HAS AT 0 AND 18
             
                 ck.paintComponent(g2d); // CALLS THE COOKIE'S PAINTCOMPONENT METHOD AND PASSES IN THE G2D VARIABLE
                 pl.paintComponent(g2d); // CALLS THE PLAYER'S PAINTCOMPONENT METHOD AND PASSES IN THE G2D VARIABLE
                 g2d.dispose(); // CALLS THE GRAPHICS2D DISPOSE METHOD WHICH HELPS THE GARBAGE COLLECTOR FREE MEMORY
        	}
        		break;
        	case 2:
        	{                 
                 g2d.setColor(Color.GREEN); // SET THE GRAPHICS2D COLOUR TO GREEN
                 g2d.fillRect(0, 0, 1024, 768);// FILL A RECTANGLE FROM THE CO-ORDINATES OF 0 AND 0 AND GIVE IT A WIDTH AND HEIGHT OF 1024 BY 768
                                  
                 g2d.setColor(Color.BLACK); // SET THE GRAPHICS2D COLOUR TO GREEN
                 g2d.setFont(new Font("Arial", 100, 30)); // SETS THE GRAPHICS2D FONT TO ARIAL WITH A STYLE OF 100 AND A SIZE OF 30
                 g2d.drawString("You Collected: " + score / 10 + " Cookies", 320, 100); // CREATES A NEW STRING TELLING THE PLAYER HOW MANU COOKIES THEY COLLECTED 
                 // AT THE POSITION OF 320 ON THE X-AXIS AND 100 ON THE Y-AXIS
                 
                 g2d.setColor(Color.WHITE); // SET THE GRAPHICS2D COLOUR TO GREEN
                                  
                 g2d.drawString("Cookie 1 : " + timeForCookie.get(0) + " Seconds", 350, 325); // CREATES A NEW STRING WHICH DISPLAYS WHAT COOKIE WAS COLLECTED AFTER SO MANY SECONDS
                 g2d.drawString("Cookie 2 : " + timeForCookie.get(1) + " Seconds", 350, 355); // CREATES A NEW STRING WHICH DISPLAYS WHAT COOKIE WAS COLLECTED AFTER SO MANY SECONDS
                 g2d.drawString("Cookie 3 : " + timeForCookie.get(2) + " Seconds", 350, 385); // CREATES A NEW STRING WHICH DISPLAYS WHAT COOKIE WAS COLLECTED AFTER SO MANY SECONDS
                 g2d.drawString("Cookie 4 : " + timeForCookie.get(3) + " Seconds", 350, 415); // CREATES A NEW STRING WHICH DISPLAYS WHAT COOKIE WAS COLLECTED AFTER SO MANY SECONDS
                 g2d.drawString("Cookie 5 : " + timeForCookie.get(4) + " Seconds", 350, 445); // CREATES A NEW STRING WHICH DISPLAYS WHAT COOKIE WAS COLLECTED AFTER SO MANY SECONDS
        	}
        		break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {    	
    	switch(gameScreen) // CHECKS WHAT GAMESCREEN IS ACTIVE SO THE GAME KNOWS WHICH GAME LOGIC TO RUN
        {
        	case 1:
        	{
        		pl.move(); // CALLS THE PLAYER.MOVE METHOD WHICH CONTROLS INPUT FOR THE PLAYER
                
                if(ck.checkCollision(pl.getBounds(), ck.getBounds())) // IF THE COOKIE.CHECKCOLLISION RECOGNISES THE PLAYERS BOUNDING BOX
                {
                    int nextTime = timeElapsed / 100; // SETS THE CURRENT TIME TO WHAT THE CURRENT TIME IN SECONDS ARE TO THE TIME ELAPSED DIVDED BY 100 
                
                    for(int j = 0; j < 1; j++) // CREATES A NEW FOR LOOP TO RUN ONCE WHEN CALLED 
                    {
                        timeForCookie.add(nextTime); // ADDS THE NEW TIME TO THE TIMEFORCOOKIE ARRAY
                    } 
                
                    score += 10; // ADDS 10 TO THE SCORE
                }
            
                if(score == 50) // IF THE PLAYERS SCORE IS 50
                {
                	TStop(); // CALLS THE TSTOP METHOD
                	gameScreen = 2; // SETS THE GAMESCREEN TO 2
                }
            
            		timeElapsed++; // INCREASES THE TIMEELAPSED COUNTER BY 1
            		repaint(); // CALLS THE REPAINT METHOD
        	}
        		break;
        }        
    }
    
    private void TStart() 
    {
        time.start(); // STARTS THE TIMER FOR THE GAME
    }
    
    private void TStop() 
    {
        time.stop(); // STOPS THE TIMER FOR THE GAME
    }
   
    private class TA extends KeyAdapter 
    {
        @Override
        public void keyPressed(KeyEvent e) // CREATES A NEW METHOD CALLED KEYPRESSED WHICH HANDLES ALL THE KEYPRESSES IN THE GAME PASSING IN A NEW KEYEVENT
        {
        	if(gameScreen == 0 && e.getKeyCode() == KeyEvent.VK_SPACE) // IF THE GAMESCREEN IS 0 AND THE PLAYER PRESSES SPACE
            {
                gameScreen = 1; // SETS THE GAMESCREEN TO 1
            }
        	
            pl.keyPressed(e); // CALLS THE PLAYERS KEYPRESSED METHOD AND PASSES IN THE KEYEVENT
        }
        
        @Override
        public void keyReleased(KeyEvent e) // CREATES A NEW METHOD CALLED KEYRELEASED WHICH HANDLES ALL THE KEYRELEASES IN THE GAME PASSING IN A NEW KEYEVENT
        {
            pl.keyReleased(e); // CALLS THE PLAYERS KEYRELEASED METHOD AND PASSES IN THE KEYEVENT
        }
    }
}