package backgrounds;
// 315679985
import biuoop.DrawSurface;
import sprite.BackGround;
import geometry.Rectangle;
import java.awt.Color;
/**
 * this class is drawing the back ground for the third level.
 * @author naor alkobi.
 */
public class BackGround4 extends BackGround {
    /**
     * this method is constructor for this class.
     * @param backGround is the rectangle background.
     * @param color is the color of the background.
     */
    public BackGround4(Rectangle backGround, Color color) {
        super(backGround, color);
    }
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(new Color(139, 134, 134));
        int x1 = 140, x2 = 120;
        for (int i = 0; i < 10; i++) {
            d.drawLine(x1, 400, x2, 600);
            x1 += 10;
            x2 += 10;
        }
        d.setColor(new Color(162, 162, 167));
        d.fillCircle(150, 400, 25);
        d.fillCircle(190, 385, 25);
        d.setColor(new Color(113, 113, 121));
        d.fillCircle(220, 400, 25);
        d.setColor(new Color(139, 134, 134));
        d.fillCircle(195, 420, 25);
        d.fillCircle(160, 420, 25);
        d.setColor(new Color(139, 134, 134));
        x1 = 540;
        x2 = 520;
        for (int i = 0; i < 10; i++) {
            d.drawLine(x1, 500, x2, 600);
            x1 += 10;
            x2 += 10;
        }
        d.setColor(new Color(162, 162, 167));
        d.fillCircle(550, 500, 25);
        d.fillCircle(590, 485, 25);
        d.setColor(new Color(113, 113, 121));
        d.fillCircle(620, 500, 25);
        d.setColor(new Color(139, 134, 134));
        d.fillCircle(595, 520, 25);
        d.fillCircle(560, 520, 25);
    }
    @Override
    public void timePassed() {
    }
}
