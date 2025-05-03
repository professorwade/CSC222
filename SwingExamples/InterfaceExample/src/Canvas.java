package src;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    protected Color canvasColor;


    Canvas(Color c, int xdimension, int ydimension) {

        setPreferredSize(new Dimension(xdimension, ydimension)); // Set preferred size of the canvas
        canvasColor = c;
        setBackground(c); // Set background color

        JFrame frame = new JFrame("Drawing Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        // Pack and display the frame
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window on screen
        frame.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to ensure proper rendering

    }



    public Graphics2D getContext() {
        System.out.println(this);
        Graphics g = getGraphics();
        System.out.println(g);
        return (Graphics2D) g;
    }

    public static void main(String[] args) {

        // Add the custom canvas to the frame
        Canvas canvas = new Canvas(Color.WHITE, 800, 800);
        Circle c = new Circle(canvas,400,400,100,Color.red);



    }

}
