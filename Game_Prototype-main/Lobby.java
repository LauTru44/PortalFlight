import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobby extends World
{
    GreenfootSound gameMusic_Lobby;
    /**
     * Constructor for objects of class Lobby.
     * 
     */
    public Lobby()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
        gameMusic_Lobby = new GreenfootSound("level3.wav");
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
        ash.setLocation(34,180);
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
        exitPortal.setLocation(792,468);
    }
    
    public void act(){
    if (LavaPortal.isLocked() && CavePortal.isLocked() && OverworldPortal.isLocked()) {
        ExitPortal.setLocked(false);
    }
    }
    
    
    public void started()
    {
        gameMusic_Lobby.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_Lobby.stop();
    }
}
