import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlsMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlsMenu extends World
{
    GreenfootSound gameMusic_ConMenu;
    /**
     * Constructor for objects of class ControlsMenu.
     * 
     */
    public ControlsMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(540, 645, 1); 
        prepare();
        gameMusic_ConMenu = new GreenfootSound("level2.wav");
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BackButton backButton = new BackButton();
        addObject(backButton,475,604);
        backButton.setLocation(486,601);
    }
    
    public void started()
    {
        gameMusic_ConMenu.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_ConMenu.stop();
    }
}
