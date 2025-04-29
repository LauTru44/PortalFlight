import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playButton extends Actor
{
    private GreenfootImage playButton;
    private boolean isHovered = false;

    public playButton() {
        playButton = new GreenfootImage("PlayButton.png");
        setImage(playButton);
    }
    
    public void act()
    {
        checkHover();
        checkClick();
    }
        private void checkHover() {
        if (Greenfoot.mouseMoved(this) && !isHovered) {
            isHovered = true;
            GreenfootImage scaledImage = new GreenfootImage(playButton);
            scaledImage.scale((int)(playButton.getWidth() * 1.1), (int)(playButton.getHeight() * 1.1));
            setImage(scaledImage);
        } else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && isHovered) {
            isHovered = false;
            setImage(playButton);
        }
    }

    private void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Lobby()); // This line sends you to the Lobby
        }
    }
}
