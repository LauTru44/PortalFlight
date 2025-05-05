import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Actor
{
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("BackButton-big.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("BackButton-small.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Menu()); 
        }
    }
}
