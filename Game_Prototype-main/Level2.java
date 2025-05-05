import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        CaveGround caveGround = new CaveGround();
        addObject(caveGround,494,564);
        caveGround.setLocation(494,591);
        caveGround.setLocation(503,598);
        caveGround.setLocation(503,591);
        caveGround.setLocation(504,591);
        Ash ash = new Ash();
        addObject(ash,41,64);
        Wall wall = new Wall();
        addObject(wall,236,205);    
        wall.setLocation(241,205);
        Wall wall2 = new Wall();
        addObject(wall2,515,205);
        Wall wall3 = new Wall();
        addObject(wall3,738,205);
        wall2.setLocation(516,205);
        Button button = new Button();
        addObject(button,214,95);
        Button button2 = new Button();
        addObject(button2,487,45);
        Button button3 = new Button();
        addObject(button3,485,346);
        Button button4 = new Button();
        addObject(button4,709,95);
        Button button5 = new Button();
        addObject(button5,708,318);
        FlippedButton flippedButton = new FlippedButton();
        addObject(flippedButton,275,372);
        FlippedButton flippedButton2 = new FlippedButton();
        addObject(flippedButton2,272,202);
        FlippedButton flippedButton3 = new FlippedButton();
        addObject(flippedButton3,548,167);
        FlippedButton flippedButton4 = new FlippedButton();
        addObject(flippedButton4,546,246);
        FlippedButton flippedButton5 = new FlippedButton();
        addObject(flippedButton5,767,35);
        FlippedButton flippedButton6 = new FlippedButton();
        addObject(flippedButton6,771,177);
        FlippedButton flippedButton7 = new FlippedButton();
        addObject(flippedButton7,772,346);
    }
}
