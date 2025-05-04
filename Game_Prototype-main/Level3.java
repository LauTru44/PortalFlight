import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 550, 1); 
        prepare();
        
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Ash ash = new Ash();
        addObject(ash,47,55);
        smallGround smallGround = new smallGround();
        addObject(smallGround,768,326);
        smallGround smallGround2 = new smallGround();
        addObject(smallGround2,176,494);
        Coin coin = new Coin();
        addObject(coin,859,47);
        Coin coin2 = new Coin();
        addObject(coin2,740,469);
        Coin coin3 = new Coin();
        addObject(coin3,332,29);
        Coin coin4 = new Coin();
        addObject(coin4,525,163);
        Coin coin5 = new Coin();
        addObject(coin5,972,280);
        Coin coin6 = new Coin();
        addObject(coin6,278,428);
        Coin coin7 = new Coin();
        addObject(coin7,113,25);
        Coin coin8 = new Coin();
        addObject(coin8,43,448);
        Coin coin9 = new Coin();
        addObject(coin9,504,452);
        smallGround.setLocation(736,276);
        coin5.setLocation(933,204);
        Coin coin10 = new Coin();
        addObject(coin10,396,252);
    }
    

}
