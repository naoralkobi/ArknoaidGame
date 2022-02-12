package animation;
// 315679985
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 * @author naor alkobi.
 */
public abstract class KeyPressStoppableAnimation implements Animation {
    // fields
    private KeyboardSensor keyboard;
    private boolean stop;
    private String key;
    private Animation decoratedAnimation;
    private boolean isAlreadyPressed;
    /**
     * this method is contructor fot this class.
     * @param sensor the keyboard.
     * @param key is the string.
     * @param animation the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.stop = false;
        this.decoratedAnimation = animation;
        this.isAlreadyPressed = true;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.decoratedAnimation.doOneFrame(d);
        if (this.keyboard.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
