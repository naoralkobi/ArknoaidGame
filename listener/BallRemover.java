package listener;
// 315679985
import game.Counter;
import game.GameLevel;
import notifier.Block;
import sprite.Ball;
/**
 * this represent sprite.Ball Remover class which implement listener.HitListener.
 * @author naor alkobi
 */
public class BallRemover implements HitListener {
    // fields
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * this method is constructor for this class.
     * @param game game.
     * @param removedballs counter.
     */
    public BallRemover(GameLevel game, Counter removedballs) {
        this.game = game;
        this.remainingBalls = removedballs;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.game.removeSprite(hitter);
        hitter.removeFromGame(game);
        remainingBalls.decrease(1);
    }
}
