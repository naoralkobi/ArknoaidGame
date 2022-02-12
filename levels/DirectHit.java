package levels;
// 315679985
import backgrounds.BackGround1;
import game.LevelInformation;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import notifier.Block;
import sprite.Sprite;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
/**
 * this class represent the first level which called "direct Hit".
 * @author naor alkobi.
 */
public class DirectHit implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity velocity = new Velocity(0, 5);
        velocities.add(velocity);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new BackGround1(new Rectangle(new Point(25, 45), 750, 560), Color.BLACK);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(385, 150), 30, 30);
        Block block1 = new Block(rectangle, Color.RED);
        blocks.add(block1);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
