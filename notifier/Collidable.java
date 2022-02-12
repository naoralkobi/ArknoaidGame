package notifier;
//315679985
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprite.Ball;

/**
 * this interface represent Collidable.
 * @author naor alkobi
 */
public interface Collidable {
    /**
     * this is a accessors method.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /**
     * @param collisionPoint the intersection point.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter is the current ball.
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}