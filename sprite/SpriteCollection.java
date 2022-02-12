package sprite;
// 315679985
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * this is sprite.Sprite collection class.
 * @author naor alkobi
 */
public class SpriteCollection {
    // fields
    private List<Sprite> sprites;
    /**
     * this is the constructor for this class.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * this is a accessors method.
     * @return list of sprite.Sprite.
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }
    /**
     * this method adds a new sprite to the list.
     * @param s is the sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * this method call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> iterator = new ArrayList<Sprite>(this.sprites);
        for (Sprite list : iterator) {
            list.timePassed();
        }
    }

    /**
     * this method is call to all sprites to draw on surface.
     * @param d in the surface.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> iterator = new ArrayList<Sprite>(this.sprites);
        for (Sprite list : iterator) {
            list.drawOn(d);
        }
    }
}