import java.awt.*;

public class NewScania extends Truck{
    public double truckbedAngle;
    public NewScania(int nrDoors, Color color, double enginePower, String modelName, int x, int y){
        super(nrDoors,color,enginePower,modelName,x,y);
        truckbedAngle = 0;
    }

    public boolean isRampUp(){
        if (truckbedAngle == 0){
            return true;
        } else {return false;}
    }

    private boolean isAngleInRange(double angle) {
        return angle >= 0 && angle <= 70;}

    public void raiseTruckbed(double angle){
        if (getCurrentSpeed() == 0 && isRampUp() && isAngleInRange(angle)){
            truckbedAngle = Math.min(truckbedAngle + angle, 70);
        } else{
            System.out.println("Cannot raise bed while driving");
        }
    }
    public void lowerTruckbed(double angle){
        if (getCurrentSpeed() == 0 && isRampUp() && isAngleInRange(angle)){
            truckbedAngle = Math.max(truckbedAngle + angle, 70);
        } else{
            System.out.println("Cannot raise bed while driving");
        }
    }
}