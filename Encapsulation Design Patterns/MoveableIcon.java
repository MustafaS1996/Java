import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 *  an Icon that can be moved
 */
public class MoveableIcon extends ImageIcon implements MoveableShape  {
    /**
     *
     * @param filename a file to move
     * @param x the positon of x
     * @param y position of y
     */
    public MoveableIcon(String filename, int x, int y)
    {
        //img = new ImageIcon(filename);
        super(filename);

        this.x = x;
        this.y = y;
    }

    /**
     * moves the shape
     */

    public void move() {

        if (Math.random() < 0.5){
            x += 15;
        }
        else {x -= 15;}
    }

    /**
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {

        g2.drawImage(this.getImage(),this.x,this.y,null);


    }

    /**
     *
     * @return a rectangle
     */
    public Rectangle getBounds() {
        bounds = new Rectangle(x,y,this.getIconWidth(),this.getIconHeight());
        return bounds;
    }

    private Rectangle bounds;
    private ImageIcon img;
    private int x;
    private int y;


}
