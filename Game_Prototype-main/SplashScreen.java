import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplashScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplashScreen extends World
{
    double timeSplashScreen = System.currentTimeMillis();
    GreenfootSound gameMusic_Splash;
    /**
     * Constructor for objects of class SplashScreen.
     * 
     */
    public SplashScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(580, 600, 1); 
        prepare();
        gameMusic_Splash = new GreenfootSound("level2.wav");
    }

    public void act()
    {
        int timerValue = (int) (System.currentTimeMillis() - timeSplashScreen)/1000;        

        if (System.currentTimeMillis() >= (timeSplashScreen + (7 * 1000)))
        {
            Greenfoot.setWorld(new Menu()); 
        }

    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ClickToStart clickToStart = new ClickToStart();
        addObject(clickToStart,240,476);
        clickToStart.setLocation(295,480);
    }
    
    public void started()
    {
        gameMusic_Splash.playLoop();
    }
    
    public void stopped()
    {
        gameMusic_Splash.stop();
    }
}
