package levels;
// 315679985
import backgrounds.BackGround4;
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
 * this class represent the four level which called "Final Four".
 * @author naor alkobi.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double speed = 5;
        int angle = -30;
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(angle, speed);
            velocities.add(velocity);
            angle += 30;
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 90;
    }

    @Override
    public String levelName() {
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new BackGround4(new Rectangle(new Point(25, 45), 750, 560), new Color(81, 194, 231));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int y = 100;
        Color[] colors = {Color.YELLOW, Color.ORANGE, Color.PINK, Color.MAGENTA, Color.RED, Color.cyan, Color.WHITE};
        for (int i = 0; i < 7; i++) {
            int x = 725;
            for (int j = 0; j < 15; j++) {
                Rectangle rectangle = new Rectangle(new Point(x, y), 50, 30);
                Block block = new Block(rectangle, colors[i]);
                blocks.add(block);
                x -= 50;
            }
            y += 30;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
