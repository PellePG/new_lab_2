public class CarStart{


    public static void main(String[] args) {
        CarModel cm = new CarModel();
        DrawPanel drawPanel = new DrawPanel(CarView.X, CarView.Y-240, cm);
        CarView carView = new CarView("CarSim 1.0", cm, drawPanel);
        cm.addObserver(drawPanel);

        // Adjusted car creation to include position parameters
        Car volvo = CarFactory.volvo240Factory().createCar(0, 300);
        Car saab = CarFactory.saab95Factory().createCar(0, 150);
        Car scania = CarFactory.scaniaFactory().createCar(0, 1);

        // Add cars to the list
        cm.cars.add(volvo);
        cm.cars.add(saab);
        cm.cars.add(scania);
        cm.timer.start();
    }}

