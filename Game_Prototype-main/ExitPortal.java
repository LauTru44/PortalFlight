import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitPortal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitPortal extends LavaPortal
{
    private long timeTouched = 0;
    private boolean touchingAsh = false;
    
    private static boolean isLocked = true;

    public void act()
    {
        if (isLocked == false) {
            setImage("Exit_portal.png"); // unlocks the exit
        }
        
        if (isTouching(Ash.class) && (isLocked==false)) {
            if (touchingAsh==false) {
                timeTouched = System.currentTimeMillis();
                touchingAsh = true;
            } else {
                long elapsed = System.currentTimeMillis() - timeTouched;
                if (elapsed >= 2000) {
                    Greenfoot.setWorld(new TheEnd()); // Finishes game!!
                }
            }
        } else {
            touchingAsh = false;
            timeTouched = 0;
        }
    }
        
    public static void setLocked(boolean locked) {
        isLocked = locked;
    }
}
