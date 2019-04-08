import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 This program implements an animation that moves
 an array of shapes.
 */
public class Animation
{
    /**
     *
     * @param shapes list of shapes
     * @param strategy the strategy to display the shapes
     * @param width Dimensions of width for frame
     * @param height height for frame
     */
    public static void show(List<MoveableShape> shapes, MoveStrategy strategy, int width, int height)
    {
        JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(width,height));

        for (int i = 0; i < shapes.size(); i++ ) {

            MoveableShape Boxs = shapes.get(i);

            ShapeIcon icon = new ShapeIcon(Boxs,
                    width, height);

            final JLabel label = new JLabel(icon);
            frame.setLayout(new FlowLayout());
            frame.add(label);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


            final int DELAY = 100;
            // Milliseconds between timer ticks

            Timer t = new Timer(DELAY, event ->
            {
                strategy.process(shapes);
                label.repaint();
            });
            t.start();
        }

    }

}



