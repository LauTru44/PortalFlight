import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

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

    //animation sprites
    private GreenfootImage walk1 = new GreenfootImage("leftWalkingAsh1.png");
    private GreenfootImage walk2 = new GreenfootImage("leftWalkingAsh2.png");
    private GreenfootImage walk3 = new GreenfootImage("rightWalkingAsh1.png");
    private GreenfootImage walk4 = new GreenfootImage("rightWalkingAsh2.png");
    private GreenfootImage Fly1 = new GreenfootImage("rightFlyingAsh.png");
    private GreenfootImage Fly2 = new GreenfootImage("leftFlyingAsh.png");

    private int animationDelay = 0;  // controls speed of the walkng animation
    private int animationSpeed = 20;   

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

    //level 2
    private int buttonsPressed = 0;
    private boolean hasKey = false;

    //for level 3
    private int coinsCollected = 0;

    public void act()
    {
        moveLeftRight();
        jump();
        useJetpack();         
        applyGravity();      
        checkIfOnGround();

        checkCollision();
        rechargeFuel();
        updateFuelBar();

        pressedButton();
        checkKeyPickup();
        checkDoor();

        checkCoinPickup();
        checkIfFellOutOfLevel3();
    }

    private void moveLeftRight() {
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());

            if(isTouching(Wall.class))
            {
                setLocation(getX() + speed, getY());
            }
            if(isTouching(Color.class))
            {
                setLocation(getX() + speed, getY());
            }

            if (onGround==false && Greenfoot.isKeyDown("space")) {
                setImage(Fly2); // flying to the left
            } 
            else 
            {
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
        }

        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());

            if(isTouching(Wall.class))
            {
                setLocation(getX() - speed, getY());
            }
            if(isTouching(Color.class))
            {
                setLocation(getX() - speed, getY());
            }

            if (onGround == false && Greenfoot.isKeyDown("space")) {
                setImage(Fly1); // flying to the right
            } 
            else 
            {
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
            //for jumping correctly

            while (isTouching(ground.class)) {
                setLocation(getX(), getY() - 1);
            }
        } else {
            onGround = false;
        }
    }    

    private void checkCollision()
    {
        //for level 1
        Fire fireball = (Fire) getOneIntersectingObject(Fire.class);
        if (fireball != null) {
            getWorld().stopped();
            GameOver gameOver = new GameOver();
            gameOver.started();
            Greenfoot.setWorld(gameOver);
        }
    }

    private void checkCoinPickup() {
        Coin coin = (Coin) getOneIntersectingObject(Coin.class);
        if (coin != null) {
            getWorld().removeObject(coin);
            coinsCollected++;

            if (coinsCollected == 10 ) {
                getWorld().stopped();
                Lobby lobby = new Lobby();
                lobby.started();
                Greenfoot.setWorld(lobby);
                OverworldPortal.setLocked(true);
            }
        }
    }

    private void pressedButton()
    {
        Button button = (Button) getOneIntersectingObject(Button.class);
        if (button != null) 
        {
            buttonsPressed += 1;
            getWorld().removeObject(button);
        }
    }

    private void checkKeyPickup()
    {
        Key key = (Key) getOneIntersectingObject(Key.class);
        if (key != null) {
            Level2 world = (Level2) getWorld();
            hasKey = true;
            getWorld().removeObject(key);
        }
    }

    private void checkDoor() {
        Door door = (Door) getOneIntersectingObject(Door.class);
        if (door != null && hasKey == true && buttonsPressed == 12) {
            getWorld().stopped();
            Lobby lobby = new Lobby();
            lobby.started();
            Greenfoot.setWorld(lobby);
            CavePortal.setLocked(true);
        }
    }

    private void checkIfFellOutOfLevel3(){
        if(getWorld() instanceof Level3){
            if (getY()>= getWorld().getHeight()-1){
                getWorld().stopped();
                GameOver gameOver = new GameOver();
                gameOver.started();
                Greenfoot.setWorld(gameOver);  
            }

        }
    }
}
