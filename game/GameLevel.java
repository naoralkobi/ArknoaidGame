package game;
//315679985
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.Animation;
import animation.KeyPressStoppableAnimation;
import animation.PauseScreen;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.Velocity;
import listener.BallRemover;
import geometry.Point;
import geometry.Rectangle;
import listener.BlockRemover;
import listener.ScoreTrackingListener;
import notifier.Collidable;
import notifier.Block;
import sprite.SpriteCollection;
import sprite.Ball;
import sprite.Sprite;
import sprite.Paddle;
/**
 * this is game.Game class.
 * this class is initialize a game and run it.
 * @author naor alkobi.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter currentBlocks;
    private Counter currentBalls;
    private Counter points;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Rectangle paddle;
    /**
     * this method is the constructor for this class.
     * @param levelInformation the current level.
     * @param keyboard the sensor.
     * @param animationRunner the animation runner.
     * @param gui this gui.
     * @param points counter of points.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner animationRunner,
                     Counter points, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.gui = gui;
        this.levelInformation = levelInformation;
        this.currentBlocks = new Counter();
        this.currentBalls = new Counter();
        this.points = points;
        this.runner = animationRunner;
        this.keyboard = keyboard;
        this.paddle = new Rectangle(new Point(400 - (this.levelInformation.paddleWidth() / 2), 575),
                this.levelInformation.paddleWidth(), 15);
    }
    /**
     * this method add a new collidable to environment list.
     * @param c is the new collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * this method add a new sprite to Sprites list.
     * @param s is the new sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * this method initialize a new game: create the Blocks and sprite.
     * Ball (and sprite.Paddle) and add them to the game.
     */
    public void initialize() {
        // backGround
        this.addSprite(this.levelInformation.getBackground());
        // create frame.
        Rectangle rectangle1 = new Rectangle(new Point(0, 20), 800, 25);
        Rectangle rectangle2 = new Rectangle(new Point(0, 20), 25, 600);
        Rectangle rectangle3 = new Rectangle(new Point(775, 20), 25, 600);
        Rectangle[] rectangles = new Rectangle[]{rectangle2, rectangle3, rectangle1};
        for (Rectangle rectangle : rectangles) {
            Block block = new Block(rectangle, Color.DARK_GRAY);
            block.addToGame(this);
            this.environment.addCollidable(block);
        }
        BlockRemover remover = new BlockRemover(this, currentBlocks);
        BallRemover remover2 = new BallRemover(this, currentBalls);
        ScoreTrackingListener track = new ScoreTrackingListener(this.points);
        // create death region block.
        Rectangle deathRegion = new Rectangle(new Point(25, 599), 750, 1);
        Block block1 = new Block(deathRegion, Color.BLACK);
        block1.addHitListener(remover2);
        block1.addToGame(this);
        this.environment.addCollidable(block1);
        // create blocks that can be removed.
        List<Block> blocks = this.levelInformation.blocks();
        for (Block block : blocks) {
            block.addToGame(this);
            this.environment.addCollidable(block);
            block.addHitListener(remover);
            block.addHitListener(track);
        }
        currentBlocks.increase(this.levelInformation.numberOfBlocksToRemove());
        // create paddle
        Paddle paddle1 = new Paddle(this.paddle, Color.ORANGE, keyboard, this.levelInformation.paddleWidth(),
                this.levelInformation.paddleSpeed());
        paddle1.addToGame(this);
        this.environment.addCollidable(paddle1);
        // for points
        ScoreIndicator score = new ScoreIndicator(this.points, this.levelInformation.levelName());
        this.addSprite(score);
        this.createBallsOnTopOfPaddle();
    }
    /**
     * this method Run the game.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(4, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }
    /**
     * this method remove a collidable from the list.
     * @param c this collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * this method remove a sprite from the list.
     * @param s this sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);
        if (this.currentBlocks.getValue() == 0) {
            this.points.increase(100);
            this.running = false;
        }
        if (this.currentBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboard)) {
            });
        }
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * this method create new balls for our game.
     */
    public void createBallsOnTopOfPaddle() {
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        List<Ball> balls = new ArrayList<>();
        // create balls.
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(this.paddle.getUpperLeft().getX() + (this.paddle.getWidth() / 2),
                    this.paddle.getUpperLeft().getY() - 5, 6, Color.white, this.environment);
            ball.setVelocity(velocities.get(i).getDx(), velocities.get(i).getDy());
            ball.addToGame(this);
        }
        currentBalls.increase(this.levelInformation.numberOfBalls());
    }
    /**
     * this method is a getter for the current balls.
     * @return number of balls.
     */
    public int getCurrentBalls() {
        return this.currentBalls.getValue();
    }
    /**
     * this method is a getter for the current blocks.
     * @return number of blocks.
     */
    public int getCurrentBlocks() {
        return this.currentBlocks.getValue();
    }
}