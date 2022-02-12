package backgrounds;
// 315679985
import biuoop.DrawSurface;
import sprite.BackGround;
import geometry.Rectangle;
import java.awt.Color;
/**
 * this class is drawing the back ground for the second level.
 * @author naor alkobi.
 */
public class BackGround2 extends BackGround {
    /**
     * this method is constructor for this class.
     * @param backGround is the rectangle background.
     * @param color is the color of the background.
     */
    public BackGround2(Rectangle backGround, Color color) {
        super(backGround, color);
    }
    @Override
    public void drawOn(DrawSurface d) {
        super.drawOn(d);
        d.setColor(Color.BLACK);
        d.setColor(new Color(255, 255, 0));
        d.fillCircle(150, 130, 60);
        d.drawCircle(150, 130, 40);
        d.setColor(new Color(255, 255, 204));
        d.fillCircle(150, 130, 60);
        d.setColor(new Color(255, 255, 153));
        d.fillCircle(150, 130, 50);
        d.setColor(Color.yellow);
        int x = 20;
        for (int i = 0; i < 75; i++) {
            d.drawLine(150, 130, x, 250);
            x += 10;
        }
        d.setColor(Color.WHITE);
        d.fillCircle(150, 400, 25);
        d.fillCircle(190, 385, 25);
        d.fillCircle(220, 400, 25);
        d.fillCircle(195, 420, 25);
        d.fillCircle(160, 420, 25);
        d.fillCircle(550, 400, 25);
        d.fillCircle(590, 385, 25);
        d.fillCircle(620, 400, 25);
        d.fillCircle(595, 420, 25);
        d.fillCircle(560, 420, 25);
        d.fillCircle(700, 320, 25);
        d.fillCircle(740, 305, 25);
        d.fillCircle(770, 320, 25);
        d.fillCircle(745, 340, 25);
        d.fillCircle(710, 340, 25);
        d.fillCircle(350, 320, 25);
        d.fillCircle(390, 305, 25);
        d.fillCircle(420, 320, 25);
        d.fillCircle(395, 340, 25);
        d.fillCircle(360, 340, 25);
        d.drawLine(400, 500, 405, 500);
        d.drawLine(405, 500, 415, 510);
        d.drawLine(415, 510, 425, 500);
        d.drawLine(425, 500, 430, 500);
        int y = 490, z = 375;
        for (int i = 0; i < 4; i++) {
            d.drawLine(z, y, z + 5, y);
            d.drawLine(z + 5, y, z + 15, y + 10);
            d.drawLine(z + 15, y + 10, z + 25, y);
            d.drawLine(z + 25, y, z + 30, y);
            z -= 25;
            y -= 10;
        }
        z = 425;
        y = 490;
        for (int i = 0; i < 4; i++) {
            d.drawLine(z, y, z + 5, y);
            d.drawLine(z + 5, y, z + 15, y + 10);
            d.drawLine(z + 15, y + 10, z + 25, y);
            d.drawLine(z + 25, y, z + 30, y);
            z += 25;
            y -= 10;
        }
    }
    @Override
    public void timePassed() {
    }
}
