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
        super(600, 500, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Coin coin = new Coin();
        addObject(coin,425,308);
        Coin coin2 = new Coin();
        addObject(coin2,274,72);
        Coin coin3 = new Coin();
        addObject(coin3,57,184);
        Coin coin4 = new Coin();
        addObject(coin4,581,321);
        Coin coin5 = new Coin();
        addObject(coin5,259,320);
        Coin coin6 = new Coin();
        addObject(coin6,339,265);
        Coin coin7 = new Coin();
        addObject(coin7,405,217);
        Coin coin8 = new Coin();
        addObject(coin8,427,146);
        Coin coin9 = new Coin();
        addObject(coin9,52,319);
        Coin coin10 = new Coin();
        addObject(coin10,123,307);
        Coin coin11 = new Coin();
        addObject(coin11,119,163);
        Coin coin12 = new Coin();
        addObject(coin12,330,99);
        Coin coin13 = new Coin();
        addObject(coin13,249,226);
        Coin coin14 = new Coin();
        addObject(coin14,418,314);
        Coin coin15 = new Coin();
        addObject(coin15,171,181);
        Coin coin16 = new Coin();
        addObject(coin16,367,50);
        Coin coin17 = new Coin();
        addObject(coin17,466,187);
        Coin coin18 = new Coin();
        addObject(coin18,206,290);
        Coin coin19 = new Coin();
        addObject(coin19,92,109);
        coin16.setLocation(241,82);
        coin2.setLocation(318,29);
        coin12.setLocation(337,91);
        coin2.setLocation(296,46);
        coin5.setLocation(307,317);
        coin14.setLocation(490,310);
        coin6.setLocation(379,291);
        coin7.setLocation(379,206);
        coin17.setLocation(470,176);
        coin13.setLocation(267,225);
        coin18.setLocation(205,287);
        coin18.setLocation(218,298);
        coin10.setLocation(121,288);
        coin19.setLocation(172,101);
        Coin coin20 = new Coin();
        addObject(coin20,288,95);
    }
}
