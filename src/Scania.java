import java.awt.*;

public class Scania extends Car {
    public double truckbedAngle;

    public Scania() {
        super(2, Color.BLACK, 300, "Scania",1, 1);
        truckbedAngle = 0;
        setImage("pics/Scania.jpg");
    }
    private boolean isAngleInRange(double angle) {
        return angle >= 0 && angle <= 70;}

    public void raiseTruckbed(double angle) {
        if (getCurrentSpeed() == 0 && isAngleInRange(angle)) {
            truckbedAngle = Math.min(truckbedAngle + angle, 70);
        } else {
            System.out.println("Cannot raise bed while driving");
        }
    }
    public void lowerTruckbed(double angle) {
        if (getCurrentSpeed() == 0 && isAngleInRange(angle)) {
            truckbedAngle = Math.max(truckbedAngle - angle, 0);
        } else {
            System.out.println("Cannot lower bed while driving");
        }
    }

    public boolean readyToDrive() {
        if (truckbedAngle == 0){return true;}
        else {return false;}
    }
    @Override
    public void gas(double amount) {
        if (readyToDrive()) {
            incrementSpeed(amount);;
        } else {
            System.out.println("Cannot accelerate with raised truck bed");
        }
    }

}