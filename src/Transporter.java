import java.awt.*;
import java.util.ArrayList;

public class Transporter extends Car{
    public boolean rampUp;
    public int maxLoad;
    public double maxSize;

    public ArrayList<Car> load;
    public Transporter(){
        super(2, Color.GREEN, 350, "Transporter", 1, 1);
        rampUp = true;
        maxLoad = 3;
        maxSize = 150;
        load = new ArrayList<>();
    }

    public boolean canAdd(Car car){
        if (load.size() < maxLoad && car.getEnginePower()<= maxSize &&
                Math.abs(x - getX()) <= 1 && Math.abs(y - getY()) <= 1 && !isRampUp()){
            return true;
        } else {
            return false;
        }
    }
    public void addCar(Car car){
        if (canAdd(car)){
            load.add(car);
            updateCarPosition();
            System.out.println("Car succesfully added");
        } else {
            System.out.println("Can't add this car");
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
    public int getLoadPosition(Car car){
        return load.indexOf(car);
    }
    public boolean isRampUp() {  // Works as a ready to drive aswell
        return rampUp;
    }
    public void lowerRamp() {
        if (isRampUp() &&  getCurrentSpeed() == 0) {
            rampUp = false;
        } else {
            System.out.println("Cannot raise the ramp while driving or if the truck bed is not down.");
        }
    }

    public void raiseRamp() {
        if (!isRampUp() && getCurrentSpeed() == 0) {
            rampUp = true;
        } else {
            System.out.println("Cannot lower the ramp while driving or if the truck bed is not up.");
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








}