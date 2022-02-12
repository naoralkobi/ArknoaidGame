package sprite;
//315679985
import biuoop.DrawSurface;
import game.GameEnvironment;
import game.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;
import notifier.Collidable;
import notifier.CollisionInfo;
import java.awt.Color;
/**
 * this represent class of ball.
 * it create a new ball and return his center and radius.
 * it set a random color for the ball and move the ball in specific frame.
 * @author naor alkobi
 */
public class Ball implements Sprite {
    static final double DEFAULT_DX = 5;
    static final double DEFAULT_DY = 5;

    // Fields
    private Point center;
    private double radius;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;
    /**
     * this is the constructor for this class.
     * @param center create point for the center of the ball.
     * @param r is radius of this ball.
     * @param color is color of this ball.
     * @param gameEnvironment is the environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = r;
        this.color = color;
        this.v = new Velocity(DEFAULT_DX, DEFAULT_DY);
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * this is second constructor for this class.
     * @param x is x point for the center of the ball.
     * @param y is Y point for the center of the ball.
     * @param r is radius of this ball.
     * @param color is color of this ball.
     * @param gameEnvironment is the environment of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this(new Point(x, y), r, color, gameEnvironment);
    }
    /**
     * this is a accessors method.
     * @return the x value of the center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * this is a accessors method.
     * @return the y value of the center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * this method draw the ball on the given DrawSurface.
     * @param surface is a draw surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.radius);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), (int) this.radius);
    }
    /**
     * this method notify the sprite that time has passed.
     */
    public void timePassed() {
        moveOneStep();
    }
    /**
     * this method gets dx and dy and ste it to this ball.
     * @param dx dx is the value on the x-axis.
     * @param dy dy is the value on the y-axis.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }
    /**
     * this is a accessors method.
     * @return velocity of this ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }
    /**
     * this method is moving the ball one step each time.
     */
    public void moveOneStep() {
        int count = 0, numOfLine = 4;
        CollisionInfo data;
        do {
        Line trajectory = new Line(this.getX(), this.getY(), this.getX() + this.v.getDx(),
                this.getY() + this.v.getDy());
            data = this.gameEnvironment.getClosestCollision(trajectory);
            if (data == null) {
                Point collision = this.center;
            } else {
                Point collision = data.collisionPoint();
                Collidable object = data.collisionObject();
                this.v = object.hit(this, collision, this.v);
            }
            count++;
        } while (count <= numOfLine && data != null);
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /**
     * this method adds the ball to the environment.
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * this method remove this ball for the environment.
     * @param g this game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
