import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    GreenfootSound gameMusic_level2;

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
        gameMusic_level2 = new GreenfootSound("level2.wav");
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CaveGround caveGround = new CaveGround();
        addObject(caveGround,494,564);
        caveGround.setLocation(494,591);
        caveGround.setLocation(503,598);
        caveGround.setLocation(503,591);
        caveGround.setLocation(504,591);
        Ash ash = new Ash();
        addObject(ash,41,64);
    }
    
    public void started()
    {
        gameMusic_level2.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_level2.stop();
    }
}
