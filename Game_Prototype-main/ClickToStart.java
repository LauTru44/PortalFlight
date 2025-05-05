import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClickToStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClickToStart extends Actor
{
    /**
     * Act - do whatever the ClickToStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("ClickToStart-Big.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("ClickToStart-Small.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            getWorld().stopped();
            Menu menu = new Menu();
            menu.started();
            Greenfoot.setWorld(menu);
        }
    }
}
