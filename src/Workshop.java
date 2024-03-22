import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends NewCar> {
    private String name;
    private int maxCapacity; //maximum capacity of cars in the shop
    private ArrayList<NewCar> carsInWorkshop;
    private List<String> typeCar;

    public Workshop(String name, int maxCapacity, List<String> typeCar) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.carsInWorkshop = new ArrayList<>();
        this.typeCar = typeCar;
    }

    public boolean canAdd(NewCar car) {
        if (typeCar.contains(car.modelName) && carsInWorkshop.size() <= maxCapacity) {
            return true;
        } else {
            return false;
        }
    }

    public void addCar(NewCar car) {
        if (canAdd(car)) {
            carsInWorkshop.add(car);
            System.out.println("Car has been added to the workshop: " + name);
        } else {
            System.out.println("Workshop: " + name + " doesn´t accept this car");
        }
    }

    public void unloadCar(NewCar car) {
        if (carsInWorkshop.contains(car)) {
            carsInWorkshop.remove(car);
        } else {
            System.out.println("This car isn't in the workshop");
        }
    }

}
