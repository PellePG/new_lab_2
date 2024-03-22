public interface CarFactory {
    static CarFactory volvo240Factory() {
        return new Volvo240Factory();
    }

    static CarFactory saab95Factory() {
        return new Saab95Factory();
    }

    static CarFactory scaniaFactory() {
        return new ScaniaFactory();
    }

    Car createCar(int x, int y);

    // Factory methods and inner classes remain the same
}

class Volvo240Factory implements CarFactory {
    @Override
    public Car createCar(int x, int y) {
        Volvo240 volvo = new Volvo240();
        volvo.setX(x);
        volvo.setY(y);
        // Set other factors as needed
        return volvo;
    }
}

class Saab95Factory implements CarFactory {
    @Override
    public Car createCar(int x, int y) {
        Saab95 saab = new Saab95();
        saab.setX(x);
        saab.setY(y);
        // Set other factors as needed
        return saab;
    }
}

class ScaniaFactory implements CarFactory {
    @Override
    public Car createCar(int x, int y) {
        Scania scania = new Scania();
        scania.setX(x);
        scania.setY(y);
        // Set other factors as needed
        return scania;
    }
}