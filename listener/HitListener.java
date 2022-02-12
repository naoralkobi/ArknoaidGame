package listener;
//315679985
import notifier.Block;
import sprite.Ball;

/**
 * this this interface represent listener.HitListener.
 * @author naor alkobi.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit is the block that been hitting.
     * @param hitter is the sprite.Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}