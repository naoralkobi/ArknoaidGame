package sprite;
//315679985
import biuoop.DrawSurface;
/**
 * this interface represent sprite.
 * @author naor alkobi
 */
public interface Sprite {
    /**
     * This method draw on surface.
     * @param d is the surface.
     */
    void drawOn(DrawSurface d);
    /**
     * this method notify the sprite that time has passed.
     */
    void timePassed();
}