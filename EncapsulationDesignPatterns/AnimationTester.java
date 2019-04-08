import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * Main tester file
 */
public class AnimationTester
{
    /**
     *
     * @param args main method
     */
    public static void main(String[] args)
    {
        final int CAR_WIDTH = 100;
        List<MoveableShape> shapes = new ArrayList<>();
        shapes.add(new BoxedShape(new CompoundShape(new BoxedShape(new CarShape(200, 20, CAR_WIDTH),5),
                new MoveableIcon("dog.png", 100, 10),
                new MoveableIcon("dog.png", 150, 100),
                new BouncingBall(50,100,30)), 0));
        Animation.show(shapes,
                new BoundedMoveStrategy(new Rectangle(0, 0, 500, 200)),
                600, 200);
    }
}