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
public class BackGround3 extends BackGround {
    /**
     * this method is constructor for this class.
     * @param backGround is the rectangle background.
     * @param color is the color of the background.
     */
    public BackGround3(Rectangle backGround, Color color) {
        super(backGround, color);
    }
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.WHITE);
        d.fillRectangle(75, 450, 120, 200);
        int y = 450;
        d.setColor(new Color(50, 49, 49));
        for (int i = 0; i < 5; i++) {
            d.fillRectangle(75, y, 120, 10);
            y += 30;
        }
        int x = 75;
        for (int i = 0; i < 7; i++) {
            d.fillRectangle(x, 450, 10, 200);
            x += 20;
        }
        d.setColor(new Color(51, 51, 51));
        d.fillRectangle(120, 400, 30, 50);
        d.setColor(new Color(102, 102, 102));
        d.fillRectangle(130, 200, 10, 200);
        d.setColor(new Color(255, 255, 204));
        d.fillCircle(135, 185, 15);
        d.setColor(new Color(255, 102, 102));
        d.fillCircle(135, 185, 10);
        d.setColor(Color.WHITE);
        d.fillCircle(135, 185, 5);



    }
    @Override
    public void timePassed() {
    }
}
