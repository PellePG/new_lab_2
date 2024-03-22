import static org.junit.Assert.*;

import com.sun.jdi.VoidValue;
import org.junit.Before;
import org.junit.Test;

public class Junit {
    private Saab95 saab;
    private Volvo240 volvo;
    private Scania scania;
    private Transporter transporter;

    @Before
    public void setup() {
        saab = new Saab95();
        volvo = new Volvo240();
        scania = new Scania();
        transporter = new Transporter();
    }
    @Test
    public void testStartEngine(){
        volvo.startEngine();
        saab.startEngine();
        assertEquals(0.1, volvo.getCurrentSpeed(), 0.0);
        assertEquals(0.1, saab.getCurrentSpeed(), 0.0);
    }
    @Test
    public void testMaxSpeed(){
        volvo.gas(1);
        saab.gas(1);
        assertEquals(volvo.enginePower, volvo.getCurrentSpeed(), volvo.enginePower);
        assertEquals(saab.enginePower, saab.getCurrentSpeed(), saab.enginePower);
    }
    @Test
    public void testLowerRamp() {
        transporter.lowerRamp();
        assertFalse(transporter.isRampUp());
    }
    @Test
    public void testRaiseRamp() {
        transporter.raiseRamp();
        assertTrue(transporter.isRampUp());
    }
    @Test
    public void testCanAdd() {
        transporter.lowerRamp();
        assertTrue(transporter.canAdd(saab));
        assertTrue(transporter.canAdd(volvo));

        assertFalse(transporter.canAdd(scania));
        assertTrue(transporter.canAdd(saab));  // Max load reached

    }
    @Test
    public void testUnloadWithRampUp() {
        System.out.println(transporter.isRampUp());
        transporter.lowerRamp();
        transporter.addCar(saab);
        transporter.raiseRamp();
        System.out.println(transporter.isRampUp());
        transporter.lowerRamp();
        transporter.unloadCar(saab);

        //assertTrue(transporter.load.isEmpty());
    }

    @Test
    public void coordinates() {
        transporter.lowerRamp();
        transporter.addCar(saab);
        transporter.raiseRamp();
        System.out.println("The coordinates of the car is " + saab.x + ", " + saab.y);
        transporter.gas(1);
        transporter.move();
        transporter.brake(1);
        System.out.println("The coordinates of the car is " + saab.x + ", " + saab.y);

    }



}
