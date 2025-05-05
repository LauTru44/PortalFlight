import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheEnd extends World
{
    GreenfootSound gameMusic_TheEnd;
    /**
     * Constructor for objects of class TheEnd.
     * 
     */
    public TheEnd()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 600, 1); 
        gameMusic_TheEnd = new GreenfootSound("theEnd.mp3");
    }
    
     public void started()
    {
        gameMusic_TheEnd.playLoop();
    }
    
    
    public void stopped()
    {
        gameMusic_TheEnd.stop();
    }
}
