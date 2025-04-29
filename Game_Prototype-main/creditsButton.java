import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class creditsButton extends Actor
{
    private GreenfootImage playButton;
    private boolean isHovered = false;

    public creditsButton() {
        playButton = new GreenfootImage("CreditsButton.png");
        setImage(playButton);
    }
    
    public void act()
    {
            if (Greenfoot.mouseMoved(this) && !isHovered) {
            isHovered = true;
            GreenfootImage scaledImage = new GreenfootImage(playButton);
            scaledImage.scale((int)(playButton.getWidth() * 1.1), (int)(playButton.getHeight() * 1.1)); // 10% bigger
            setImage(scaledImage);
        } else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && isHovered) {
            isHovered = false;
            setImage(playButton);
        }
    }
}
