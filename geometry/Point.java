package geometry;
//315679985
/**
 * this represent class class of point.
 * it can calculate distance between two points, check if two points
 * are equal and return the value of x and y.
 */
public class Point {
    // Fields
    private double x;
    private double y;
    /**
     * this is the constructor for this class.
     * @param x is this x point.
     * @param y is this y point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * this method gets two points and calculate the distance between of them.
     * @param other -is the other point to calculate the distance.
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    /**
     * this method gets two points and checks if they are equals.
     * @param other - is the other point to compare.
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        double epsilon = Math.pow(10, -2);
        if ((Math.abs(other.getX() - this.getX()) < epsilon) && (Math.abs(other.getY() - this.getY()) < epsilon)) {
            return true;
        }
        return this.x == other.x && this.y == other.y;
    }
    /**
     * this is a accessors method.
     * @return x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * this is a accessors method.
     * @return y value of this point
     */
    public double getY() {
        return this.y;
    }
}