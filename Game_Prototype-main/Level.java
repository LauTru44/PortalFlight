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

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Ash.class, ground.class);

        Fire fire = new Fire();
        addObject(fire,58,114);
        Fire fire2 = new Fire();
        addObject(fire2,508,103);
        Fire fire3 = new Fire();
        addObject(fire3,220,317);
        Fire fire4 = new Fire();
        addObject(fire4,441,223);
        fire2.setLocation(434,107);
        fire2.setLocation(544,83);
        fire4.setLocation(351,213);
        fire2.setLocation(466,94);
        fire4.setLocation(418,208);
        fire3.setLocation(235,285);
        fire.setLocation(122,103);
        fire2.setLocation(522,108);
        Ash ash = new Ash();
        addObject(ash,55,73);
        ground ground = new ground();
        addObject(ground,505,526);
        removeObject(ground);
        FireGround fireGround = new FireGround();
        addObject(fireGround,577,510);
        fireGround.setLocation(500,551);
        fireGround.setLocation(500,548);
        fireGround.setLocation(500,540);
        fireGround.setLocation(500,537);
        fireGround.setLocation(500,538);
        fireGround.setLocation(500,547);
    }

    public void act(){
        if(Timer < timeLimit){
            Timer ++;
            showTimer();
        }
        else 
        {
            showText("Time's up!", 300, 200);
            Greenfoot.setWorld(new TheEnd());
        } 

    }

    public void showTimer(){
        int seconds = Timer / 30;
        showText("Timer: " + seconds, 70,25);
    }
}

