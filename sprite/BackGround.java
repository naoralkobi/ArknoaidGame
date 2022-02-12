package sprite;
import biuoop.DrawSurface;
import geometry.Rectangle;
import java.awt.Color;
/**
 * this represent BackGround class which implements sprite.
 * @author naor alkobi.
 */
public class BackGround implements Sprite {
    //fields
    private Rectangle backGround;
    private Color color;
    /**
     * this method is constructor for this class.
     * @param backGround is the rectangle background.
     * @param color is the color of the background.
     */
    public BackGround(Rectangle backGround, Color color) {
        this.backGround = backGround;
        this.color = color;
    }
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.backGround.getUpperLeft().getX(),
                (int) this.backGround.getUpperLeft().getY(),
                (int) this.backGround.getWidth(), (int) this.backGround.getHeight());
    }
    @Override
    public void timePassed() {

    }
}
