package animation;
// 315679985
import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprite.SpriteCollection;
import java.awt.Color;
/**
 * this represent CountdownAnimation class which implements Animation.
 * @author naor alkobi
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
/**
     * this method is constructor for this game.
     * @param numOfSeconds the number of seconds.
     * @param countFrom start to count from.
     * @param gameScreen the game.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.RED);
        d.drawText(385, 400, String.valueOf(this.countFrom), 50);
        if (this.countFrom < 3) {
            sleeper.sleepFor((long) this.numOfSeconds * 1000 / 6);
        }
        this.countFrom -= 1;
        if (this.countFrom < 0) {
            this.stop = true;
        }
    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
