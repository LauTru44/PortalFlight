import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(580, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayButton playButton = new PlayButton();
        addObject(playButton,280,388);
        CreditsButton creditsButton = new CreditsButton();
        addObject(creditsButton,284,415);
        ControlsButton controlsButton = new ControlsButton();
        addObject(controlsButton,295,469);
        creditsButton.setLocation(295,425);
        playButton.setLocation(295,399);
        creditsButton.setLocation(295,455);
        controlsButton.setLocation(295,520);
        playButton.setLocation(295,424);
        creditsButton.setLocation(295,455);
        controlsButton.setLocation(295,483);
    }
}
