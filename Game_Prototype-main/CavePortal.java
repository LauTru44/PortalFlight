import greenfoot.*;

public class CavePortal extends Actor
{
    private long timeTouched = 0;
    private boolean touchingAsh = false;
    
    private static boolean isLocked = false;

    public void act()
    {
        if (isLocked) {
            setImage("Cave_portal_Locked.png"); 
            return;
        }
        
        if (isTouching(Ash.class)) {
            if (!touchingAsh) {
                timeTouched = System.currentTimeMillis();
                touchingAsh = true;
            } else {
                long elapsed = System.currentTimeMillis() - timeTouched;
                if (elapsed >= 2000) {
                    Greenfoot.setWorld(new Level2()); // cave portal goes to Level 2
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

