import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


/**
 * A bouncing ball
 */
public class BouncingBall implements MoveableShape
    {
        /**
         Constructs a ball item.
         @param x the left of the bounding ball
         @param y the top of the bounding ball
         @param r radius of the ball
         */
        public BouncingBall(int x, int y, int r)
        {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        /**
         * Move the ball
         */
        public void move()
        {
            if (up == false) {
                x = x+5;
                y = y+15;
                up = true;
            }
            else {
                x = x+5;
                y = y-15;
                up = false;
            }
        }

        /**
         *
         * @param g2 the graphics context
         */
        public void draw(Graphics2D g2) {
        g2.drawOval(x,y,r,r);
    }

        /**
         *
         * @return a rectangle
         */
        public Rectangle getBounds() {
            bounds = new Rectangle(x,y,50,50);
            return bounds;
        }

        private Rectangle bounds;
        private boolean up = false;
        private int r;
        private int x;
        private int y;
    }






