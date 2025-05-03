import greenfoot.*;

public class CavePortal extends Actor
{
    private long timeTouched = 0;
    private boolean touchingAsh = false;

    public void act()
    {
        if (isTouching(Ash.class)) {
            if (!touchingAsh) {
                timeTouched = System.currentTimeMillis();
                touchingAsh = true;
            } else {
                long elapsed = System.currentTimeMillis() - timeTouched;
                if (elapsed >= 2000) {
                    Greenfoot.setWorld(new Level2()); // Lava portal goes to Level
                }
            }
        } else {
            touchingAsh = false;
            timeTouched = 0;
        }
    }
}

