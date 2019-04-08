import java.util.List;

/**
 This program implements an animation that moves
 a car shape.
 */

public class SimpleMoveStrategy implements MoveStrategy
{
    /**
     *
     * @param shapes that are moved depending on strategy
     */

    public void process(List<MoveableShape> shapes) {
        for (int i = 0; i < shapes.size(); i++) {shapes.get(i).move();}
    }
}
