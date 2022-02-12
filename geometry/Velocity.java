package geometry;
//315679985
/**
 * this is geometry.Velocity class which geometry.Velocity specifies the change in position on the 'x' and the 'y' axes.
 * @author naor alkobi
 */
public class Velocity {
    // Fields
    private double dx;
    private double dy;
    /**
     * this is the constructor for this class.
     * @param dx dx is the value on the x-axis.
     * @param dy dy is the value on the y-axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this method gets angle and speed and return new velocity.
     * @param angle is angle between 0-360.
     * @param speed double number.
     * @return new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx, dy;
        angle -= 90;
        dx = speed * Math.cos(Math.toRadians(angle));
        dy = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /**
     * this is a accessors method.
     * @return value of this dx
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * this is a accessors method.
     * @return value of this dy
     */
    public double getDy() {
        return this.dy;
    }
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    /**
     * this method is moving the ball from p1 to other p2.
     * @param p is the other point
     * @return new point of the ball.
     */
    public Point applyToPoint(Point p) {
        double x = this.dx + p.getX();
        double y = this.dy + p.getY();
        return new Point(x, y);
    }
}