package sprite;
// 315679985
import java.awt.Color;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.GameLevel;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import notifier.Collidable;
/**
 * this is sprite.Paddle class.
 * this class create a paddle implements notifier.Collidable and sprite.Sprite.
 * @author naor alkobi 2
 */
public class Paddle implements Sprite, Collidable {
    // fields
    private Rectangle rectangle;
    private java.awt.Color color;
    private biuoop.KeyboardSensor keyboard;
    private int width;
    private int speed;

    /**
     * this method is constructor for this class.
     * @param rectangle is the shape of the paddle.
     * @param color is the color of the paddle.
     * @param keyboard is keyboard for the paddle
     * @param width is the width of the paddle.
     * @param speed is the speed of the paddle.
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard, int width, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.width = width;
        this.speed = speed;
    }
    /**
     * this method check if the paddle not in the limit point in the left side.
     * if yes so do not move the paddle. else it can move to the left.
     */
    public void moveLeft() {
        double leftLimit = 25;
        if (this.rectangle.getUpperLeft().getX() == leftLimit) {
            return;
        }
        this.rectangle.setUpperLeft(this.rectangle.getUpperLeft().getX() - speed,
                this.rectangle.getUpperLeft().getY());
    }
    /**
     * this method check if the paddle not in the limit point in the right side.
     * if yes so do not move the paddle. else it can move to the right.
     */
    public void moveRight() {
        double rightLimit = 775 - this.width;
        if (this.rectangle.getUpperLeft().getX() == rightLimit) {
            return;
        }
        this.rectangle.setUpperLeft(this.rectangle.getUpperLeft().getX() + speed,
                this.rectangle.getUpperLeft().getY());
    }

    /**
     * this method notify the sprite that time has passed and moving the paddle.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
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
    }
    /**
     * this is a accessors method.
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double region = this.rectangle.getWidth() / 5;
        double upperLeftX = getCollisionRectangle().getUpperLeft().getX();
        double velocity = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        // region 1.
        if (collisionPoint.getX() >= upperLeftX && collisionPoint.getX() < upperLeftX + region) {
            return Velocity.fromAngleAndSpeed(300, velocity);
            // region 2.
        } else if (collisionPoint.getX() < upperLeftX + region * 2 && collisionPoint.getX() >= region) {
            return Velocity.fromAngleAndSpeed(330, velocity);
            // region 3.
        } else if (collisionPoint.getX() < upperLeftX + region * 3 && collisionPoint.getX() >= region * 2) {
            return Velocity.fromAngleAndSpeed(0, velocity);
        // region 4.
        } else if (collisionPoint.getX() < upperLeftX + region * 4 && collisionPoint.getX() >= region * 3) {
            return Velocity.fromAngleAndSpeed(30, velocity);
        } else {
            // region 5.
            return Velocity.fromAngleAndSpeed(60, velocity);
        }
    }
    /**
     * this method adds the block to the environment.
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}