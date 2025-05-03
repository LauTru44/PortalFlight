import greenfoot.*;

public class FuelBar extends Actor
{
    private int width = 40;
    private int height = 6;
    private int fuel = 100;
    private int maxFuel = 100;

    public void act()
    {
        updateImage();
    }

    public void updateFuel(int currentFuel, int maxFuel)
    {
        this.fuel = currentFuel;
        this.maxFuel = maxFuel;
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.GRAY);
        image.fillRect(0, 0, width, height);

        int fuelWidth = (int)((double)fuel / maxFuel * width);
        image.setColor(Color.GREEN);
        image.fillRect(0, 0, fuelWidth, height);

        setImage(image);
    }
}
