import java.awt.*;

public abstract class Truck extends Vehicle {
    public Truck(int nrDoors, Color color, double enginePower, String modelName, int x, int y){
        super(nrDoors,color,enginePower,modelName,x,y);
    }
    abstract boolean isRampUp();
    public boolean readyToDrive() {
        if (isRampUp()) {
            return true;
        } else {
            return false;
        }
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