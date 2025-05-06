import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditsMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsMenu extends World
{
    GreenfootSound gameMusic_CreMenu;

    /**
     * Constructor for objects of class CreditsMenu.
     * 
     */
    public CreditsMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(364, 545, 1); 
        prepare();
        gameMusic_CreMenu = new GreenfootSound("CREDITS.mp3");
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BackButton backButton = new BackButton();
        addObject(backButton,74,503);
        backButton.setLocation(70,500);
    }
    
    public void started()
    {
        gameMusic_CreMenu.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_CreMenu.stop();
    }
}
