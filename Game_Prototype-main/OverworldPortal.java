import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import greenfoot.*;

public class OverworldPortal extends LavaPortal
{
    private long timeTouched = 0;
    private boolean touchingAsh = false;
    
    private static boolean isLocked = false;

    public void act()
    {
        if (isLocked) {
            setImage("Overworld_portal_Locked.png"); // imagen gris
            return;
        }
        
        if (isTouching(Ash.class)) {
            if (!touchingAsh) {
                timeTouched = System.currentTimeMillis();
                touchingAsh = true;
            } else {
                long elapsed = System.currentTimeMillis() - timeTouched;
                if (elapsed >= 2000) {
                    Greenfoot.setWorld(new Level3()); // overworld portal goes to Level3
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
    
    public static boolean isLocked() {
    return isLocked;
    }
}

