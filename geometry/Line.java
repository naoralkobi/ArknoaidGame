package geometry;
//315679985
import java.util.ArrayList;
import java.util.List;
/**
 * this represent class of line.
 * it create a new line from p1 to p2.
 * it can check if two line are intersecting and if yes it find the intersecting point.
 * @author naor alkobi
 */
public class Line {
    // Fields
    private Point p1;
    private Point p2;
    /**
     * this is the constructor for this class.
     * @param start is the start point of the line.
     * @param end is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.p1 = new Point(start.getX(), start.getY());
        this.p2 = new Point(end.getX(), end.getY());
    }
    /**
     * this is the constructor for this class.
     * @param x1 this is x1 value of point.
     * @param y1 this is y1 value of point.
     * @param x2 this is x2 value of point.
     * @param y2 this is y2 value of point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }
    /**
     * this  method is using the distance method from point class.
     * @return the length of the line
     */
    public double length() {
        return p1.distance(p2);
    }
    /**
     * this method calculate the middle between two points.
     * @return middle point
     */
    public Point middle() {
        double p3x = (this.p1.getX() + this.p2.getX()) / 2;
        double p3y = (this.p1.getY() + this.p2.getY()) / 2;
        Point p3 = new Point(p3x, p3y);
        return p3;
    }
    /**
     * this is a accessors method.
     * @return the point with the smaller x value which is the start point of the line.
     */
    public Point start() {
        return p1;
    }
    /**
     * this is a accessors method.
     * @return the point with the bigger x value which is the end point of the line.
     */
    public Point end() {
        return this.p2;
    }
    /**
     * this line gets this line and other line and check if they are intersecting.
     * @param other is the second line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        // Find the four orientations needed for general and
        // special cases
        double o1 = orientation(p1, p2, other.p1);
        double o2 = orientation(p1, p2, other.p2);
        double o3 = orientation(other.p1, other.p2, p2);
        double o4 = orientation(other.p1, other.p2, p1);
        /*check the general cases that are different */
        if (o1 != o2 && o3 != o4) {
            return true;
        }
        // p1, p2 and other.p1 are collinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, other.p1, p2)) {
            return true;
        }

        // p1, other.p2 and other.p1 are collinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, other.p2, p2)) {
            return true;
        }

        // p2, p1 and other.p2 are collinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(other.p1, p1, other.p2)) {
            return true;
        }

        // p2, other.p1 and other.p2 are collinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(other.p1, p2, other.p2)) {
            return true;
        }
        return false;
    }

    /**
     * this method is return the slope of this line.
     * @return the slope of the line.
     */
    public double slope() {
        /* slope = (y2-y1)/(x2-x1) */
        double dx = this.p2.getX() - this.p1.getX();
        double dy = this.p2.getY() - this.p1.getY();
        if (dx == 0) {
            return 0;
        }
        return (dy / dx);
    }
    /** this method gets this line and other line and use the method to check if they are intersecting.
     * return the intersection point.
     * @param other is the second line.
     * @return Returns the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            double m1 = this.slope();
            double m2 = other.slope();
            double b1 = this.start().getY() - m1 * this.start().getX();
            double b2 = other.start().getY() - m2 * other.start().getX();
            // in case of line consist one point.
            if ((this.start().equals(this.end())) || ((other.start().equals(other.end())))) {
                if (onSegment(other.start(), this.start(), other.end())) {
                    return new Point(this.start().getX(), this.start().getY());
                }
                if (onSegment(this.start(), other.start(), this.end())) {
                    return new Point(other.start().getX(), other.start().getY());
                }
            }
            // check if lines are merging.
            if (isMerging(other)) {
                return null;
            }
            // in case of the lines are Parallel to the y-axis.
            if ((m1 == 0 && m2 != 0) && (this.start().getX() == this.end().getX())) {
                double y2 = this.start().getX() * other.slope() + b2;
                return new Point(this.start().getX(), y2);
            }
            if ((m2 == 0 && m1 != 0) && (other.start().getX() == other.end().getX())) {
                double y1 = other.start().getX() * this.slope() + b1;
                return new Point(other.start().getX(), y1);
            }
            // in case of the lines are Parallel to the x-axis.
            if ((m1 == 0 && m2 != 0) && (this.start().getY() == this.end().getY())) {
                double x2 = (this.start().getY() - b2) / m2;
                return new Point(x2, this.start().getY());
            }
            if ((m2 == 0 && m1 != 0) && (other.start().getY() == other.end().getY())) {
                double x1 = (other.start().getY() - b1) / m1;
                return new Point(x1, other.start().getY());
            }
            // the next four cases are in case of start or end points are equal.
            if (this.end().equals(other.start())) {
                return new Point(this.end().getX(), this.end().getY());
            }
            if (this.end().equals(other.end())) {
                return new Point(other.end().getX(), other.end().getY());
            }
            if (this.start().equals(other.start())) {
                return new Point(other.start().getX(), other.start().getY());
            }
            if (this.start().equals(other.end())) {
                return new Point(other.end().getX(), other.end().getY());
            }
            // in case of the angle between the lines is 90.
            if (m1 == -m2) {
                if ((this.start().getX() == this.end().getX())
                        && (other.start().getY() == other.end().getY())) {
                    return new Point(this.start().getX(), other.start().getY());
                }
                if ((other.start().getX() == other.end().getX())
                        && (this.start().getY() == this.end().getY())) {
                    return new Point(other.start().getX(), this.start().getY());
                }
            }
            // in case of line is on y-axis
            if (b1 == 0 && m1 == 0) {
                return new Point(b1, b2);
            }
            if (b2 == 0 && m2 == 0) {
                return new Point(b2, b1);
            }
            double x = (b2 - b1) / (m1 - m2);
            double y = m1 * x + b1;
            return new Point(x, y);
        }
        return null;
    }

    /**
     * This method gets two lines and check if they have two intersection points, and the same slope.
     * if yes they are merging and the function return True.
     * else return False.
     * @param other line.
     * @return True if merging else false.
     */
    public boolean isMerging(Line other) {
        double m1 = this.slope();
        double m2 = other.slope();
        // check if the lines have the same slope.
        if (m1 == m2) {
            // check if this line is on other segment.
            if ((onSegment(other.start(), this.start(), other.end()))
                    && (onSegment(other.start(), this.end(), other.end()))) {
                return true;
            }
            // check if other line is on this segment.
            if ((onSegment(this.start(), other.start(), this.end()))
                    && (onSegment(this.start(), other.end(), this.end()))) {
                return true;
            }
            // check if the lines have two intersection points.
            if ((onSegment(this.start(), other.start(), this.end()))
                    && (onSegment(other.start(), this.end(), other.end()))
                    && (!other.start().equals(this.end()))) {
                return true;
            }
            // check if the lines have two intersection points.
            if ((onSegment(other.start(), this.start(), other.end()))
                    && (onSegment(this.start(), other.end(), this.end()))
                    && (!this.start().equals(other.end()))) {
                return true;
            }
        }
        return false;
    }
    /**
     * this method checks if the lines are equal. use distance method from point class.
     * @param other is the second line.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return (this.p1.distance(this.p2) == other.p1.distance(other.p2)
                && (this.start().equals(other.start()) || this.start().equals(other.end()))
                && (this.end().equals(other.start()) || this.end().equals(other.end())));
    }
    /**
     * this method gets three point and check whether point p2 lies on line segment 'p1p3'.
     * @param first first point.
     * @param second second point.
     * @param third third point.
     * @return true or false according to situation.
     */
    public boolean onSegment(Point first, Point second, Point third) {
        double epsilon = Math.pow(10, -2);
        return ((second.getX() <= Math.max(first.getX(), third.getX()))
                || (Math.abs(second.getX() - Math.max(first.getX(), third.getX())) < epsilon))
                && ((second.getX() >= Math.min(first.getX(), third.getX()))
                || (Math.abs(second.getX() - Math.min(first.getX(), third.getX())) < epsilon))
                && ((second.getY() <= Math.max(first.getY(), third.getY()))
                || (Math.abs(second.getY() - Math.max(first.getY(), third.getY())) < epsilon))
                && ((second.getY() >= Math.min(first.getY(), third.getY()))
                || (Math.abs(second.getY() - Math.min(first.getY(), third.getY())) < epsilon));
    }

    /**
     * this method is find the orientation of given three points.
     * @param p1 first point.
     * @param p2 second point.
     * @param p3 third point.
     * @return 0 if p1, p2 and p3 are in a row
     *         1 if the points arranged in Clockwise
     *         2 if the points Arranged in Counterclockwise
     */
    static double orientation(Point p1, Point p2, Point p3) {
        /* gets val value */
        double val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX())
                - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());
        /* in a row */
        if (val == 0) {
            return 0;
        }
        /* clock or counter clock wise */
        return (val > 0) ? 1 : 2;
    }
    /**
     * this method checks what is the closest intersection point.
     * @param rect is a rectangle.
     * @return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        // create list of points
        List<Point> points = new ArrayList<>();
        Line line = new Line(this.p1, this.p2);
        points = rect.intersectionPoints(line);
        if (points.isEmpty()) {
            return null;
        }
        if (points.size() == 1) {
            return points.get(0);
        } else {
            // two points because the line cross the triangle.
            if (points.get(0) == null || points.get(1) == null) {
                return null;
            }
            if (points.get(0).distance(line.start()) < points.get(1).distance(line.start())) {
                return points.get(0);
            } else {
                return points.get(1);
            }
        }
    }
}