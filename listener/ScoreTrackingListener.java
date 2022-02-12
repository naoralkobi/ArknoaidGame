package listener;
// 315679985
import game.Counter;
import notifier.Block;
import sprite.Ball;

/**
 * this is listener.ScoreTrackingListener class which tracking over the scores in the game.
 */
public class ScoreTrackingListener implements HitListener {
    // fields
    private Counter currentScore;
    /**
     * this method is constructor for this class.
     * @param scoreCounter is counter for the points.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}