package notifier;
//315679985
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import biuoop.DrawSurface;
import game.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listener.HitListener;
import sprite.Ball;
import sprite.Sprite;
/**
 * this represent class of ball.
 * this class create a block implements notifier.Collidable and sprite.Sprite.
 * block has shape and color.
 * @author naor alkobi
 */
public class Block implements Collidable, Sprite, HitNotifier {
    // fields
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    /**
     * this is the constructor for this class.
     * @param rectangle is the shape of the block.
     * @param color is the color of the block.
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * this is a accessors method.
     * @return the "collision shape" of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param collisionPoint  the intersection point.
     * @param currentVelocity the current velocity of the ball.
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Rectangle rect = getCollisionRectangle();
        Point upperLeft = rect.getUpperLeft();
        Point upperRight = new Point(upperLeft.getX() + rect.getWidth(), upperLeft.getY());
        Point bottomRight = new Point(upperLeft.getX() + rect.getWidth(), upperLeft.getY() + rect.getHeight());
        Point bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + rect.getHeight());
        Line topEdge = new Line(upperLeft, upperRight);
        Line bottomEdge = new Line(bottomLeft, bottomRight);
        this.notifyHit(hitter);
        /*
        * check where the ball hit and change the velocity according to the side.
        * start with check top edge or bottom edge.
         */
        if ((topEdge.onSegment(upperLeft, collisionPoint, upperRight))
            || (bottomEdge.onSegment(bottomLeft, collisionPoint, bottomRight))) {
            return new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        // else left side or right side.
        return new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
    }
    /**
     * this method draw the ball on the given DrawSurface.
     * @param surface is a draw surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(), (int) getCollisionRectangle().getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) getCollisionRectangle().getUpperLeft().getX(),
                (int) getCollisionRectangle().getUpperLeft().getY(),
                (int) getCollisionRectangle().getWidth(), (int) getCollisionRectangle().getHeight());
    }
    /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
    }
    /**
     * this method adds the block to the environment.
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * this method remove a block after block hit on it.
     * @param game is the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * this method is notify all listeners about hitting.
     * @param hitter the ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
