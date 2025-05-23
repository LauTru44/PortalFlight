import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    GreenfootSound gameMusic_Menu;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(580, 600, 1); 
        prepare();
        gameMusic_Menu = new GreenfootSound("MENU.mp3");
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayButton playButton = new PlayButton();
        addObject(playButton,290,396);
        CreditsButton creditsButton = new CreditsButton();
        addObject(creditsButton,290,436);
        ControlsButton controlsButton = new ControlsButton();
        addObject(controlsButton,290,476);
        creditsButton.setLocation(290,440);
    }
    
    public void started()
    {
        gameMusic_Menu.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_Menu.stop();
    }
}
