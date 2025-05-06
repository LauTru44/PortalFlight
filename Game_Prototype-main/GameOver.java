import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
   GreenfootSound gameMusic_GameOver;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        gameMusic_GameOver = new GreenfootSound("GAMEOVER.mp3");
    }
    
    public void started()
    {
        gameMusic_GameOver.playLoop();
    }
    
     public void stopped()
    {
        gameMusic_GameOver.stop();
    }
}
