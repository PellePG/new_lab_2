import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Vehicle implements Movable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public BufferedImage image;
    public int x; //the car x-pos

    public int y; //the car y-pos

    private CarController carController;

    private Car stored;

    Workshop workS;
    CarView CV;
    DrawPanel draw;
    VolvoWorkshop volvoWorkshop = new VolvoWorkshop();


    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, int x, int y) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        stopEngine();
    }
    public int getNrDoors() {return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setImage(String image){
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream(image));
        }catch (IOException ex){
            ex.printStackTrace();
        }}

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if(amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }else{
            System.out.println("Input must be between 0 and 1");
        }}

    public void brake(double amount) {
        if(amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else{
            System.out.println("Input must be between 0 and 1");
        }}
    public int direction;
    public static final int UP = 90;
    public static final int DOWN = 270;
    public static final int RIGHT = 0;
    public static final int LEFT = 180;

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(int NewX) {
        x = NewX;
    }
    public void setY(int NewY) {
        y = NewY;
    }

    public void move() {
        double distance = getCurrentSpeed();

        if (this instanceof Volvo240 && x>=290 && x<= 310 && y == 300){
            stopEngine();
            Volvo240 volvoCar = (Volvo240) this;
            volvoWorkshop.addCar(volvoCar);
        }
        else if (x <= 700 && x >= 0) {
            x += (int) (distance * Math.cos(direction));
        } else if (x < 0) {
            stopEngine();
            x = 0;
            startEngine();
            gas(1);
            direction = (int) (Math.PI - direction);
            x += (int) (distance * Math.cos(direction));
        } else if (x > 700) {
            stopEngine();
            x = 700;
            startEngine();
            gas(1);
            direction = (int) (Math.PI - direction);
            x += (int) (distance * Math.cos(direction));
        }}


    public void turnLeft() {
        if (direction == UP) {
            direction = LEFT;
        } else if (direction == LEFT) {
            direction = DOWN;
        } else if (direction == DOWN) {
            direction = RIGHT;
        } else if (direction == RIGHT) {
            direction = UP;
        }
    }
    public void turnRight() {
        if (direction == UP) {
            direction = RIGHT;
        } else if (direction == LEFT) {
            direction = UP;
        } else if (direction == DOWN) {
            direction = LEFT;
        } else if (direction == RIGHT) {
            direction = DOWN;
        }
    }}
