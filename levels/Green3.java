package levels;
// 315679985
import backgrounds.BackGround3;
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
 * this class represent the third level which called "Green 3".
 * @author naor alkobi.
 */

public class Green3 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        double speed = 7;
        int angle = -20;
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity velocity = Velocity.fromAngleAndSpeed(angle, speed);
            velocities.add(velocity);
            angle += 40;
        }
        return velocities;
    }
    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new BackGround3(new Rectangle(new Point(25, 45), 750, 560), new Color(0, 153, 0));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int y = 100;
        Color[] colors = {Color.YELLOW, Color.ORANGE, Color.PINK, Color.MAGENTA, Color.RED};
        for (int i = 0; i < 5; i++) {
            int x = 725, limit = 10;
            limit -= i;
            for (int j = 0; j < limit; j++) {
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
        return 40;
    }
}
