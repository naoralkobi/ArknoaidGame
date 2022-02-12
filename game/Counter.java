package game;
// 315679985
/**
 * this class represent game.Counter class.
 * @author naor alkobi
 */
public class Counter {
    // fields
    private int counter;
    /**
     * this method is constructor for this class.
     */
    public Counter() {
        this.counter = 0;
    }
    /**
     * this method is constructor for this class.
     * @param value is the value for the counter.
     */
    public Counter(int value) {
        this.counter = value;
    }
    /**
     * this method add number to current count.
     * @param number the value to add.
     */
    public void increase(int number) {
        this.counter += number;
    }
    /**
     * this method subtract number from current count.
     * @param number the value to subtract.
     */
    public void decrease(int number) {
        this.counter -= number;
    }
    /**
     * this method is a getters method for this class.
     * @return current count.
     */
    public int getValue() {
        return this.counter;
    }
}