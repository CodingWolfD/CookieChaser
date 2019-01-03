package com.Main;

import javax.swing.JFrame;

public class Window
{ 
    private static JFrame frame; // USED TO CREATE A NEW JFRAME INSTANCE
    private static final int WIDTH = 1024; // USED TO SET THE WIDTH OF THE WINDOW 
    private static final int HEIGHT = 768; // USED TO SET THE HEIGHT OF THE WINDOW
    private static final String title = "Cookie Chaser"; // USED TO SET THE TITLE OF THE WINDOW
    
    public static void main(String[] args) // draws the frame, sets the title, width, height and location of window.
    {
        frame = new JFrame(title); // INSTANTIATES THE NEW JFRAME AND PASSES IN THE SPECIFIED TITLE
        frame.add(new Display()); // ADDS THE DISPLAY CLASS TO THE FRAME
        frame.setSize(WIDTH, HEIGHT); // SETS THE SIZE AND WIDTH OF THE FRAME TO THE SPECIFIED VARIABLES
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // SETS THE CLOSE OPERATION TO THE DEFAULT EXITONCLOSE
        frame.setVisible(true); // SETS THE VISIBLE BOOL TO TRUE SO THE WINDOW APPEARS
        frame.setLocationRelativeTo(null); // SETS THE LOCATIONRELATIVETO NULL SO THE WINDOW APPEARS IN THE MIDDLE OF THE SCREEN
        frame.setResizable(false); // SETS THE WINDOWS RESIZABLE BOOLEAN TO FALSE
    }
}