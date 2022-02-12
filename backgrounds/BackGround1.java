package backgrounds;
// 315679985
import biuoop.DrawSurface;
import sprite.BackGround;
import geometry.Rectangle;
import java.awt.Color;
/**
 * this class is drawing the back ground for the first level.
 * @author naor alkobi.
 */
public class BackGround1 extends BackGround {
    /**
     * this method is constructor for this class.
     * @param backGround is the rectangle background.
     * @param color is the color of the background.
     */
    public BackGround1(Rectangle backGround, Color color) {
        super(backGround, color);
    }
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.BLUE);
        d.drawLine(400, 45, 400, 140);
        d.drawLine(400, 190, 400, 300);
        d.drawLine(265, 165, 375, 165);
        d.drawLine(425, 165, 530, 165);
        d.drawCircle(400, 165, 60);
        d.drawCircle(400, 165, 90);
        d.drawCircle(400, 165, 120);
    }
    @Override
    public void timePassed() {
    }
}
