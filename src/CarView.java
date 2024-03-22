import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    public static final int X = 800;
    public static final int Y = 800;

    CarController carActions;

    // The controller member


    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JPanel carPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JSpinner carSpinner = new JSpinner();
    int gasAmount = 0;
    String carOption = "Random";
    JLabel gasLabel = new JLabel("Amount of gas");
    JLabel carLabel = new JLabel("Car");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton addCarButton = new JButton("Add Car");

    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    DrawPanel drawPanel;

    // Constructor
    public CarView(String framename, CarModel carM, DrawPanel panel){

        this.carActions = new CarController(carM);
        this.drawPanel = panel;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work

    public void update(ArrayList<Car> cars) {}
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerListModel spinner =
                new SpinnerListModel(new String[]{"Random", "Volvo", "Saab", "Scania"});

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        carSpinner = new JSpinner(spinner);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        carSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                carOption = (String) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        carPanel.setLayout(new BorderLayout());
        carPanel.add(carLabel, BorderLayout.PAGE_START);
        carPanel.add(carSpinner, BorderLayout.PAGE_END);


        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.Y_AXIS));

        spinnerPanel.add(gasPanel);
        spinnerPanel.add(carPanel);

        this.add(spinnerPanel);


        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.add(addCarButton);
        controlPanel.add(removeCarButton);
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        gasButton.addActionListener(carActions.createGasButtonListener(gasSpinner));
        brakeButton.addActionListener(carActions.createBrakeButtonListener());
        turboOnButton.addActionListener(carActions.createTurboOnButtonListener());
        turboOffButton.addActionListener(carActions.createTurboOffButtonListener());
        stopButton.addActionListener(carActions.createStopButtonListener());
        startButton.addActionListener(carActions.createStartButtonListener());
        liftBedButton.addActionListener(carActions.createLiftBedButtonListener());
        lowerBedButton.addActionListener(carActions.createLowerBedButtonListener());
        addCarButton.addActionListener(carActions.createAddCarButton(carSpinner));
        removeCarButton.addActionListener(carActions.createRemoveCarButton());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}