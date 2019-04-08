import java.util.List;
import java.awt.*;

/**
 * interface for basic strategy
 */
public interface MoveStrategy  {
    /**
     *
     * @param shapes that are moved depending on strategy
     */
    void process(List<MoveableShape> shapes);

}
