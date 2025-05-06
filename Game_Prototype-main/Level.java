import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private int Timer = 0;
    private final int timeLimit = 30 * 30;
    GreenfootSound gameMusic;

    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
        prepare();
        showTimer();
        gameMusic = new GreenfootSound("preview.mp3");
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Ash.class, ground.class);

        FireGround fireGround = new FireGround();
        addObject(fireGround,497,516);
        Ash ash = new Ash();
        addObject(ash,29,95);

        Fire fire = new Fire();
        addObject(fire,269,139);
        Fire fire2 = new Fire();
        addObject(fire2,401,403);
        Fire fire3 = new Fire();
        addObject(fire3,478,244);
        Fire fire4 = new Fire();
        addObject(fire4,608,94);
        Fire fire5 = new Fire();
        addObject(fire5,718,367);
        Fire fire6 = new Fire();
        addObject(fire6,147,399);
        Fire fire7 = new Fire();
        addObject(fire7,909,368);
        Fire fire8 = new Fire();
        addObject(fire8,171,23);
    }

    public void act(){
        if(Timer < timeLimit){
            Timer ++;
            showTimer();
        }
        else 
        {
            showText("Time's up!", 300, 200);
            LavaPortal.setLocked(true);
            Greenfoot.setWorld(new Lobby());
            
        } 

    }

    public void showTimer(){
        int seconds = Timer / 30;
        showText("Timer: " + seconds, 70,25);
    }
    
    public void started()
    {
        gameMusic.playLoop();
    }
    
    public void stopped()
    {
        gameMusic.stop();
    }

}

