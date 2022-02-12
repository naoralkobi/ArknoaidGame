package game;
// 315679985
import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import animation.LoseScreen;
import animation.WinScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;
/**
 * this represent Game flow class.
 * @author naor alkobi.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private Counter points;
    private GUI gui;
    /**
     * this method is constructor for this class.
     * @param ar is the animation runner.
     * @param ks is the keyboard.
     * @param gui is the gui.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboard = ks;
        this.points = new Counter();
        this.gui = gui;
    }
    /**
     * this method is running the levels one by one.
     * @param levels is list of the level.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboard,
                    this.animationRunner, this.points, this.gui);
            level.initialize();
            while (level.getCurrentBalls() > 0 && level.getCurrentBlocks() > 0) {
                level.run();
            }
            if (level.getCurrentBalls() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                        new LoseScreen(this.keyboard, this.points)) {
                });
                gui.close();
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboard,
                KeyboardSensor.SPACE_KEY, new WinScreen(this.keyboard, this.points)) {
        });
        gui.close();
    }
}