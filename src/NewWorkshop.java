import java.util.ArrayList;
import java.util.List;

public class NewWorkshop <T extends Car> {
    private String name;
    private int maxCapacity; //maximum capacity of cars in the shop
    private ArrayList<T> carsInWorkshop;
    private List<String> typeCar;

    public NewWorkshop(String name, int maxCapacity, List<String> typeCar) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.carsInWorkshop = new ArrayList<>();
        this.typeCar = typeCar;
    }

    public boolean canAdd(T car) {
        if (typeCar.contains(car.modelName) && carsInWorkshop.size() <= maxCapacity) {
            return true;
        } else {
            return false;
        }
    }
    public void addCar(T car) {
        if (canAdd(car)) {
            carsInWorkshop.add(car);
            System.out.println("Car has been added to the workshop: " + name);
        } else {
            System.out.println("Workshop: " + name + " doesn´t accept this car");
        }
    }

    public T unloadCar(T car) { //returnera även T (void vaskar)
        if (carsInWorkshop.contains(car)) {
            carsInWorkshop.remove(car);
            return car;
        } else {
            System.out.println("This car isn't in the workshop");
            return null;
        }
    }

}