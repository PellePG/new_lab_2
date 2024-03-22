import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class CarModel {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<CarObserver> observerList = new ArrayList<>();

    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public Timer timer = new Timer(delay, new TimerListener());

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Car> carsToRemove = new ArrayList<>();
            for (Car car : cars) {
                car.move();
                if (car instanceof Volvo240 && car.getX()>=290 && car.getX()<= 310 && car.getY() == 300) {
                    carsToRemove.add(car);
                    System.out.println("Car added to Workshop");
                }
            }
            cars.removeAll(carsToRemove);
            notifyObservers();

        }
    }

    //methods:


    public void addObserver(CarObserver observer){
        observerList.add(observer);
    }
    public void removeObserver(CarObserver observer){
        observerList.remove(observer);
    }
    public void notifyObservers(){
        for(CarObserver observer: observerList){
            observer.update();
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void stopAllCars() {
        for (Car car : cars) {
            car.currentSpeed = 0;

        }
    }

    void raiseTruckBed(){
        for (Car car: cars) {
            if (car instanceof Scania) {
                car.stopEngine();
                ((Scania) car).raiseTruckbed(70);
            }
        }}

    void lowerTruckbed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                car.stopEngine();
                ((Scania)car).lowerTruckbed(70);
            }
        }}

    void addCarButton(String carOption) {
        if (cars.size() < 10) {
            if (carOption.equals("Random")) {
                Random rand = new Random();
                int randomNumber = rand.nextInt(3);
                switch (randomNumber) {
                    case 0:
                        cars.add(CarFactory.volvo240Factory().createCar(0, 300));
                        break;
                    case 1:
                        cars.add(CarFactory.saab95Factory().createCar(0, 150));
                        break;
                    case 2:
                        cars.add(CarFactory.scaniaFactory().createCar(0, 1));
                        break;
                }
            } else if (carOption.equals("Volvo")) {
                cars.add(CarFactory.volvo240Factory().createCar(0, 300));
            } else if (carOption.equals("Saab")) {
                cars.add(CarFactory.saab95Factory().createCar(0, 150));
            } else {
                cars.add(CarFactory.scaniaFactory().createCar(0, 1));
            }}}

    void removeCarButton(){
        if (!cars.isEmpty()) {
            cars.removeFirst();

        }

    }}

