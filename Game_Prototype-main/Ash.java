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
    
    private GreenfootImage walk1 = new GreenfootImage("leftWalkingAsh1.png");
    private GreenfootImage walk2 = new GreenfootImage("leftWalkingAsh2.png");
    private GreenfootImage walk3 = new GreenfootImage("rightWalkingAsh1.png");
    private GreenfootImage walk4 = new GreenfootImage("rightWalkingAsh2.png");
    private int animationDelay = 0;  // controls speed of the walkng animation
    private int animationSpeed = 20; 
     
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
    
    private int coinsCollected = 0;
    
    public void act()
    {
        moveLeftRight();
        useJetpack();         
        applyGravity();      
        checkIfOnGround();

        checkCollision();
        rechargeFuel();
        updateFuelBar();
        
        checkCoinPickup();
    }
    
   private void moveLeftRight() {
        if (Greenfoot.isKeyDown("a")) {
            
            setLocation(getX() - speed, getY());
            
            animationDelay++;
            if (animationDelay >= animationSpeed) {
            if (getImage() == walk1) {
                setImage(walk2);
            } else {
                setImage(walk1);
            }
            animationDelay = 0;
            }
        }
        
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
            animationDelay++;
            if (animationDelay >= animationSpeed) {
                
            if (getImage() == walk3) {
            setImage(walk4);
            } else {
            setImage(walk3);
            }
            animationDelay = 0;
            }
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
        fuelBar.setLocation(getX(), getY() - 55);
        fuelBar.updateFuel(fuel, maxFuel);
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
    
        private void checkCoinPickup() {
    Coin coin = (Coin) getOneIntersectingObject(Coin.class);
    if (coin != null) {
        getWorld().removeObject(coin);
        coinsCollected++;

        if (coinsCollected == 10 ) {
            Greenfoot.setWorld(new Lobby());

            // Optional: Set a global flag to lock the portal
            //OverworldPortal.setLocked(true);
        }
    }
}
}
