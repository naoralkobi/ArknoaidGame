package listener;
// 315679985
import game.Counter;
import game.GameLevel;
import notifier.Block;
import sprite.Ball;

/**
 * this represent listener.BlockRemover class which implements Hit Listener.
 * is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 * @author naor alkobi.
 */
public class BlockRemover implements HitListener {
    // fields
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * this method is constructor for this class.
     * @param game current game.
     * @param removedBlocks rhe remaining blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.game.removeCollidable(beingHit);
        this.game.removeSprite(beingHit);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);
        remainingBlocks.decrease(1);
    }
}