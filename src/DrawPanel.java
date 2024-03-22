import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.
public class DrawPanel extends JPanel implements CarObserver {
    // Just a single image, TODO: Generalize

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 300);
    CarModel cm;

    //TODO: Make this general for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel cm) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.cm = cm;
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (Car car : cm.cars) {
            g.drawImage(car.image, car.x, car.y, null); // see javadoc for more info on the parameters
        }

    }
    public void update(){
        this.repaint();
    }

}

