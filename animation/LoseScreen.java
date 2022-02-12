package animation;
// 315679985
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.Counter;
/**
 * this represent Lost screen which implements Animation.
 * @author naor alkobi.
 */
public class LoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter points;
    /**
     * this method is constructor for this class.
     * @param k is the keyboard.
     * @param points is counter of points.
     */
    public LoseScreen(KeyboardSensor k, Counter points) {
        this.keyboard = k;
        this.stop = false;
        this.points = points;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(150, d.getHeight() / 2, "Game Over. Your score is " + this.points.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
