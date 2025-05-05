import greenfoot.*;

public class CreditsButton extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("CreditsButton-big.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("CreditsButton-small.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new CreditsMenu()); 
        }
    }
}
