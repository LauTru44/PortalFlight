import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobby extends World
{

    /**
     * Constructor for objects of class Lobby.
     * 
     */
    public Lobby()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Ash.class, ground.class);

        Ash ash = new Ash();
        addObject(ash,67,296);
        ground ground = new ground();
        addObject(ground,500,585);
        LavaPortal lavaPortal = new LavaPortal();
        addObject(lavaPortal,337,481);
        CavePortal cavePortal = new CavePortal();
        addObject(cavePortal,471,479);
        OverworldPortal overworldPortal = new OverworldPortal();
        addObject(overworldPortal,603,479);
        ExitPortal exitPortal = new ExitPortal();
        addObject(exitPortal,756,468);
    }
}
