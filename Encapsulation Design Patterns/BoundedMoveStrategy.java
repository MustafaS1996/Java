import java.awt.*;
import java.util.List;

/**
 This program implements an animation that moves
 a car shape.
 */

public class BoundedMoveStrategy implements MoveStrategy
{
    /**
     *
     * @param rect a rectangle
     */
    public BoundedMoveStrategy(Rectangle rect) {
        this.rectangle = rect;
    }

    /**
     *
     * @param shapes arraylist of shapes
     */
    public void process(List<MoveableShape> shapes) {

        for (MoveableShape i: shapes) {
            if (rectangle.contains(i.getBounds()))
                i.move();
        }
    }
        private Rectangle rectangle;
}



