package notifier;
//315679985
import listener.HitListener;

/**
 * this interface represent HitNotifier.
 * @author naor alkobi.
 */
public interface HitNotifier {
    /**
     * this method Add hl as a listener to hit events.
     * @param hl is the new listener.
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * this method remove hl as a listener to hit events.
     * @param hl is the listener.
     */
    void removeHitListener(HitListener hl);
}