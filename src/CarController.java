import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {
    public CarModel carM;
    private int gasAmount;
    public String carOption;

    public CarController(CarModel carM) {
        this.carM = carM;
    }

    public ActionListener createGasButtonListener(JSpinner gasSpinner) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gasAmount = (int) gasSpinner.getValue();
                carM.gas(gasAmount);
            }
        };
    }

    public ActionListener createBrakeButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.brake(gasAmount);
            }
        };
    }

    public ActionListener createTurboOnButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.turboOn();
            }
        };
    }

    public ActionListener createTurboOffButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.turboOff();
            }
        };
    }

    public ActionListener createStopButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.stopAllCars();
            }
        };
    }

    public ActionListener createStartButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.gas(gasAmount);
            }
        };
    }

    public ActionListener createLiftBedButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.raiseTruckBed();
            }
        };
    }

    public ActionListener createLowerBedButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.lowerTruckbed();
            }
        };
    }

    public ActionListener createAddCarButton(JSpinner carSpinner){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carOption = (String) carSpinner.getValue();
                carM.addCarButton(carOption);
            }
        };
    }

    public ActionListener createRemoveCarButton(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carM.removeCarButton();
            }
        };
    }




}