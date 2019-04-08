import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that contains a moveable shape.
*/
public class ShapeIcon implements Icon
{
   /**
    *
    * @param shape a shape
    * @param width a width
    * @param height a height
    */
   public ShapeIcon(MoveableShape shape,
      int width, int height)
   {

         this.shape = shape;
         this.width = width;
         this.height = height;

   }

   /**
    *
    * @return get the width of the icon
    */
   public int getIconWidth()
   {
      return width;
   }

   /**
    *
    * @return the height of icon
    */
   public int getIconHeight()
   {
      return height;
   }

   /**
    *
    * @param c a component
    * @param g a grpahics
    * @param x position x
    * @param y position y
    */

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }

   private int count;
   private int width;
   private int height;
   private MoveableShape shape;
}


