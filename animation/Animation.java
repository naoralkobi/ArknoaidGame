package animation;
// 315679985
import biuoop.DrawSurface;
/**
 * this interface represent animation.Animation.
 * @author naor alkobi.
 */
public interface Animation {
    /**
     * this methods is in charge of the logic of the game.
     * @param d is the surface.
     */
    void doOneFrame(DrawSurface d);
    /**
     * this method should decide when to game need to stop.
     * @return boolean value.
     */
    boolean shouldStop();
}