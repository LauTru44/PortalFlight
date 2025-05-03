import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ash extends Actor
{
    private int yVelocity = 0;
    private int gravity = 1;
    private int jumpStrength = -10;
    private int speed = 4;
    private boolean onGround = false;
 
    private long timeEnteredPortal = 0;
    private boolean isTouchingPortal = false;
    
    public void act()
    {
        
        moveLeftRight();
        applyGravity();
        checkIfOnGround();
        jump();
        checkLavaPortal();
        checkCollision();
    }
    
   private void moveLeftRight() {
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
    }

    private void jump() {
        if (Greenfoot.isKeyDown("w") && onGround) {
            yVelocity = jumpStrength;
            onGround = false;
        }
    }

    private void applyGravity() {
        setLocation(getX(), getY() + yVelocity);
        yVelocity += gravity;
    }

     private void checkLavaPortal() {
        if (isTouching(LavaPortal.class)) {
            if (!isTouchingPortal) {
                // First frame of contact: store the current time
                timeEnteredPortal = System.currentTimeMillis();
                isTouchingPortal = true;
            } else {
                long timeElapsed = System.currentTimeMillis() - timeEnteredPortal;
                if (timeElapsed >= 2000) { // 2 seconds
                    Greenfoot.setWorld(new Level());
                }
            }
        } else {
            isTouchingPortal = false;
            timeEnteredPortal = 0;
        }
    }
    
    private void checkIfOnGround() {
        if (isTouching(ground.class)) {
            onGround = true;
            yVelocity = 0;
            // Move Ash up until he's no longer sinking into the ground
            while (isTouching(ground.class)) {
                setLocation(getX(), getY() - 1);
            }
        } else {
            onGround = false;
        }
    }    
    
    private void checkCollision()
    {
        Fire fireball = (Fire) getOneIntersectingObject(Fire.class);
        double timeSplashScreen = System.currentTimeMillis();
        if (fireball != null) {
            getWorld().addObject(new Ash() , getX(), getY());
            Greenfoot.setWorld(new TheEnd()); 
        }
    }
}
