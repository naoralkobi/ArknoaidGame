package animation;
// 315679985
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * this represent class of pause screen.
 * @author naor alkobi
 */
public class PauseScreen implements Animation {
    // fields
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * this method is constructor for this class.
     * @param k is keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(100, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}