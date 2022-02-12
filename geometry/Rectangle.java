package geometry;
//315679985
import java.util.ArrayList;
import java.util.List;
/**
 * this represent class class of rectangle.
 * this class create a rectangle, and can check if line is intersection with one of the edge of the rectangle.
 * @author naor alkobi.
 */
public class Rectangle {
    // Fields
    private Point upperLeft;
    private double width;
    private double height;
    /**
     * this is a constructor method for this class.
     * @param upperLeft is the left corner of the rectangle.
     * @param width of the rectangle.
     * @param height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }
    /**
     * This method check if rectangle is intersection with line and return list of those points.
     * @param line the specified line.
     * @return Return a (possibly empty) List of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point bottomRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        Point bottomLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Line topEdge = new Line(upperLeft, upperRight);
        Line bottomEdge = new Line(bottomLeft, bottomRight);
        Line rightEdge = new Line(bottomRight, upperRight);
        Line leftEdge = new Line(bottomLeft, upperLeft);
        //create list of points.
        List<Point> points = new ArrayList<>();
        //check if line is intersecting with the triangle's edge.
        if (topEdge.isIntersecting(line)) {
            points.add(topEdge.intersectionWith(line));
        }
        if (bottomEdge.isIntersecting(line)) {
            points.add(bottomEdge.intersectionWith(line));
        }
        if (leftEdge.isIntersecting(line)) {
            points.add(leftEdge.intersectionWith(line));
        }
        if (rightEdge.isIntersecting(line)) {
            points.add(rightEdge.intersectionWith(line));
        }
        return points;
    }
    /**
     * this is a accessors method.
     * @return the width of rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * this is a accessors method.
     * @return the height of rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * this is a accessors method.
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * this method set a new position for the rectangle.
     * @param x new x position.
     * @param y new y position.
     */
    public void setUpperLeft(double x, double y) {
        this.upperLeft = new Point(x, y);
    }
}