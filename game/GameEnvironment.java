package game;
//315679985
import geometry.Line;
import geometry.Point;
import notifier.Collidable;
import notifier.CollisionInfo;
import java.util.ArrayList;
import java.util.List;
/**
 * this is game environment class.
 * it save in list all the blocks in the environment.
 * @author naor alkobi
 */
public class GameEnvironment {
    // fields
    private List<Collidable> collidables;
    /**
     * this is a constructor for this class.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }
    /**
     * this method add new collidables to the list.
     * @param c is a collidables.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }
    /**
     * this method remove a collidable from the list.
     * @param c is a collidables.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
    /**
     * this method check if the ball is going to clash with blocks.
     * @param trajectory of the ball.
     * @return return the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // create list of points.
        List<Point> points = new ArrayList<>();
        List<Collidable> temp = new ArrayList<>();
        int i = 0;
        //loop that run all over the list.
        for (Collidable list : this.collidables) {
            Point intersection = trajectory.closestIntersectionToStartOfLine(list.getCollisionRectangle());
            if (intersection != null) {
                return new CollisionInfo(intersection, this.collidables.get(i));

            }
            i += 1;
        }
        // in case of there is no intersection.
        return null;
    }
}