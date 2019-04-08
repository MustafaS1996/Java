import java.awt.*;
import java.awt.geom.*;
import java.util.*;


/**
 * Compounds all shapes together into one
 */

public class CompoundShape implements MoveableShape {
    /**
     *
     * @param shapes a variable amount of shapes
     */
    public CompoundShape(MoveableShape... shapes) {

        for (MoveableShape i : shapes) {
            shapeList.add(i);
        }
    }

    /**
     * moves all shapes
     */
    public void move() {
        for (MoveableShape i : shapeList) {
            i.move();
        }
    }

    /**
     * draws all shapes
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        for (MoveableShape i : shapeList) {
            i.draw(g2);
        }
    }

    /**
     *
     * @return a rectangle with bounds
     */
    public Rectangle getBounds() {
        int x = 9999;
        int y = 9999;
        int width = 0;
        int height = 0;


        for (MoveableShape i : shapeList) {
            int shapeX = i.getBounds().x;
            int shapeY = i.getBounds().y;
            int shapeW = i.getBounds().width;
            int shapeH = i.getBounds().height;

             if (x >= shapeX) {
                 x = shapeX;
             }
             if (y >= shapeY) {
                y = shapeY;
             }
             if (width <= shapeX + shapeW){
                 width = shapeX + shapeW;
             }
             if (height <=  shapeY + shapeH) {
                 height = shapeY + shapeH;
             }
        }
        return new Rectangle(x, y, Math.abs(width - x), Math.abs(height - y));
    }
    private ArrayList<MoveableShape> shapeList = new ArrayList<>();
}
