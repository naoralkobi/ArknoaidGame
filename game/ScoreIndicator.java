package game;
// 315679985
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import sprite.Sprite;
import java.awt.Color;
/**
 * this represent game.ScoreIndicator class which implements sprite.Sprite.
 * @author naor alkobi.
 */
public class ScoreIndicator implements Sprite {
    // fields
    private Counter scoresCounter;
    private String name;

    /**
     * this method is constructor for this class.
     * @param points the score.
     * @param name is the name of the level.
     */
    public ScoreIndicator(Counter points, String name) {
        this.scoresCounter = points;
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        Rectangle rectangle = new Rectangle(new Point(0, 0), 800, 20);
        d.setColor(Color.GRAY);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(),
                (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.WHITE);
        d.drawText(350, 15, "Score: " + String.valueOf(this.scoresCounter.getValue()), 14);
        d.drawText(600, 15, "Level Name: " + this.name, 14);

    }

    @Override
    public void timePassed() {

    }
}
