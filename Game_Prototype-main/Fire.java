import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fire extends Actor
{
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move (2);
        if (Greenfoot.getRandomNumber(100) < 5) {  
            turn(Greenfoot.getRandomNumber(91) - 45);
        }
        if (isAtEdge()){
            turn(180);
        }
    }  
    
}
