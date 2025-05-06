import greenfoot.*;

public class LavaPortal extends Actor
{
    private long timeTouched = 0;
    private boolean touchingAsh = false;

    private static boolean isLocked = false;

    public void act()
    {
        if (isLocked) {
            setImage("Fire_portal_Locked.png"); // imagen gris
            return;
        }

        if (isTouching(Ash.class)) {
            if (!touchingAsh) {
                timeTouched = System.currentTimeMillis();
                touchingAsh = true;
            } else {
                long elapsed = System.currentTimeMillis() - timeTouched;
                if (elapsed >= 2000) {
                    getWorld().stopped();
                    Level level = new Level();
                    level.started();
                    Greenfoot.setWorld(level);// Lava portal goes to Level
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

