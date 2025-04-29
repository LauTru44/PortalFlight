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
        super(500, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        creditsButton creditsButton = new creditsButton();
        addObject(creditsButton,252,416);
        creditsButton.setLocation(290,412);
        creditsButton.setLocation(252,417);
        playButton playButton = new playButton();
        addObject(playButton,254,332);
        exitButton exitButton = new exitButton();
        addObject(exitButton,249,492);
        exitButton.setLocation(253,493);
    }
}
