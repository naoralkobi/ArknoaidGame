package notifier;
//315679985
import geometry.Point;

/**
 * this represent class of Collision info.
 * this class has info about collision point and collision object.
 * @author naor alkobi
 */
public class CollisionInfo {
    // fields.
    private Point intersectionPoint;
    private Collidable collisionObject;

    /**
     * this is the constructor for this class.
     * @param intersectionPoint the intersection point.
     * @param collisionObject the collision object.
     */
    public CollisionInfo(Point intersectionPoint, Collidable collisionObject) {
        this.intersectionPoint = intersectionPoint;
        this.collisionObject = collisionObject;
    }
    /**
     * this method return the point at which the collision occurs.
     * @return collision point.
     */
    public Point collisionPoint() {
        return this.intersectionPoint;
    }
    /**
     * this method return the collidable object involved in the collision.
     * @return the object.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}