import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ash extends Actor
{
    //movement fields
    private int yVelocity = 0;
    private int gravity = 1;
    private int jumpStrength = -10;
    private int speed = 4;
    private boolean onGround = false;
     
    //portal analisis fields
    private long timeEnteredPortal = 0;
    private boolean isTouchingPortal = false;
    
    //jetpack fields
    private int maxFuel = 80;
    private int fuel = maxFuel;
    private int jetpackPower = -5; // negative to go up
    private double fuelRechargeRate = 1;
    private int fuelUsageRate = 2;
    private FuelBar fuelBar;
    
    private boolean fuelEmpty = false;
    private long timeFuelEmptied = 0;
    private boolean isCoolingDown = false;
    private int cooldownDuration = 1500; // 5 seconds in milliseconds
    
    public void act()
    {
        moveLeftRight();
        useJetpack();         
        applyGravity();      
        checkIfOnGround();

        checkCollision();
        rechargeFuel();
        updateFuelBar();
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
    
    private void useJetpack() {
        if (fuel >= fuelUsageRate && Greenfoot.isKeyDown("space") && !isCoolingDown) {
        yVelocity = jetpackPower;
        fuel -= fuelUsageRate;

        if (fuel <= 0) {
            fuel = 0;
            fuelEmpty = true;
            isCoolingDown = true;
            timeFuelEmptied = System.currentTimeMillis();
        }
        }
    }
    
    private void rechargeFuel() {
        if (isCoolingDown) {
        long timeSinceEmpty = System.currentTimeMillis() - timeFuelEmptied;
        if (timeSinceEmpty >= cooldownDuration) {
            isCoolingDown = false;
            fuelEmpty = false;
        }
        } else if (fuel < maxFuel) {
        fuel += fuelRechargeRate;
        if (fuel > maxFuel) fuel = maxFuel;
        }
    }
    
    private void updateFuelBar() {
        if (fuelBar == null) {
        fuelBar = new FuelBar();
        getWorld().addObject(fuelBar, getX(), getY() - 30);
        } else {
        fuelBar.setLocation(getX(), getY() - 30);
        fuelBar.updateFuel(fuel, maxFuel);
        }
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
