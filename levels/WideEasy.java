package levels;
// 315679985
import backgrounds.BackGround2;
import game.LevelInformation;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import notifier.Block;
import sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class represent the second level which called "wide Easy".
 * @author naor alkobi.
 */

public class WideEasy implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 10;
    }
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double speed = 5;
        int angle = -40;
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(angle, speed);
            velocities.add(velocity);
            angle += 10;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BackGround2(new Rectangle(new Point(25, 45), 750, 560), new Color(51, 204, 255));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.red, Color.ORANGE, Color.yellow, Color.blue, Color.pink, Color.cyan};
        int x = 25;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                Rectangle rectangle = new Rectangle(new Point(x, 250), 50, 25);
                Block block1 = new Block(rectangle, colors[j]);
                blocks.add(block1);
                x += 50;
            }
        }
        for (int i = 0; i < 3; i++) {
            Rectangle rectangle = new Rectangle(new Point(x, 250), 50, 25);
            Block block1 = new Block(rectangle, Color.GREEN);
            blocks.add(block1);
            x += 50;
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 2; i++) {
                Rectangle rectangle = new Rectangle(new Point(x, 250), 50, 25);
                Block block1 = new Block(rectangle, colors[j + 3]);
                blocks.add(block1);
                x += 50;
            }
        }
        return blocks;
    }
    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
