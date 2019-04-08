import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Boxes the shape
 */
public class BoxedShape implements MoveableShape{

    /**
     *
     * @param shape the shape to box
     * @param gap amount of gap
     */
    public BoxedShape(MoveableShape shape, int gap) {
        this.shapes = shape;
        this.gap = gap;

    }

    /**
     * moves the shape
     */
    public void move() {

        shapes.move();

    }

    /**
     *
     * @param g2 the graphics context
     *           Draw the getBounds rect and shape
     */
    public void draw(Graphics2D g2){

        shapes.draw(g2);
        g2.draw(getBounds());


    }

    /**
     *
     * @return a rectangle that has the bounds
     */

    public Rectangle getBounds() {

        return new Rectangle(shapes.getBounds().x - gap,  shapes.getBounds().y - gap,
                shapes.getBounds().width + (gap * 2), shapes.getBounds().height + (gap * 2));
    }

    private int gap;
    private MoveableShape shapes;
}

