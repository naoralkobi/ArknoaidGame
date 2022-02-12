package game;
//315679985
import geometry.Velocity;
import notifier.Block;
import sprite.Sprite;
import java.util.List;
/**
 * this represent Level Information interface.
 * @author naor alkobi.
 */
public interface LevelInformation {
    /**
     * this method initial number of balls.
     * @return number of balls
     */
    int numberOfBalls();
    /**
     * this method initial velocity of each ball.
     * @return list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * this method initial the paddle speed.
     * @return the speed of the paddle.
     */
    int paddleSpeed();
    /**
     * this method initial the width of the paddle.
     * @return the width.
     */
    int paddleWidth();
    /**
     the level name will be displayed at the top of the screen.
     * @return the name of the level.
     */
    String levelName();
    /**
     * this method Returns a sprite with the background of the level.
     * @return sprite.
     */
    Sprite getBackground();
    /**
     * this method return a list of Blocks that make up this level, each block contains its size, color and location.
     * @return list of blocks.
     */
    List<Block> blocks();
    /**
     * this method has Number of blocks that should be removed before the level is considered to be "cleared".
     * @return number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}
