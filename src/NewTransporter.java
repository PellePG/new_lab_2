import java.awt.*;
import java.util.ArrayList;

public class NewTransporter extends Truck {
    public boolean rampUp;
    public int maxLoad;
    public ArrayList<Car> load;
    public NewTransporter(int nrDoors, Color color, double enginePower, String modelName, int x, int y){
        super(nrDoors,color,enginePower,modelName,x,y);
        rampUp = true;
        maxLoad = 3;
        load = new ArrayList<>();
    }

    public boolean canAdd(Car car){
        if (load.size() < maxLoad && Math.abs(x - car.getX()) <= 1 && Math.abs(y - car.getY()) <= 1 && !isRampUp()){
            return true;
        } else {
            return false;
        }
    }
    public boolean isRampUp(){
        return rampUp;
    }
    public void raiseTruckbed(){
        if (!isRampUp() && getCurrentSpeed() == 0) {
            rampUp = true;
        } else {
            System.out.println("Cannot lower the ramp while driving or if the truck bed is not up.");
        }
    }
    public void lowerTruckbed(){
        if (isRampUp() &&  getCurrentSpeed() == 0) {
            rampUp = false;
        } else {
            System.out.println("Cannot raise the ramp while driving or if the truck bed is not down.");
        }
    }
    public boolean isLast(Car car){
        if (car == load.getLast()){
            return true;
        } else {return false;}
    }
    public void unloadCar(Car car){
        if (!rampUp && getCurrentSpeed() == 0){
            ArrayList<Car> inFront = new ArrayList<>();
            while (!isLast(car)){
                inFront.add(load.getLast());
                load.removeLast();
            }
            load.removeLast();
            load.addAll(inFront);
        }
    }
    private void updateCarPosition(){
        for (Car car : load){
            car.setX(x);
            car.setY(y);
        }
    }
    @Override
    public void move(){
        super.move();
        updateCarPosition();
    }
}