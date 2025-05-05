import greenfoot.*;
public class PlayButton extends Actor
{
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage("PlayButton-big.png");
        }

        if (Greenfoot.mouseMoved(getWorld()))
        {
            setImage("PlayButton-small.png");
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new Lobby()); 
        }
    }
}
