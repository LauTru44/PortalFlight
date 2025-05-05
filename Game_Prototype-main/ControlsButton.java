import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ControlsButton extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("ControlsButton-big.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("ControlsButton-small.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ControlsMenu()); 
        }
    }
}
