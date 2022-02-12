//315679985
import animation.AnimationRunner;
import biuoop.GUI;
import game.GameFlow;
import game.LevelInformation;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import levels.WideEasy;
import java.util.ArrayList;
import java.util.List;
/**
 * this is Ass5Game class.
 * this class is initialize and run a game.
 * @author naor alkobi.
 */
public class Ass6Game {
    /**
     * this is main method for this class.
     * @param args none.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid - GAME", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor(), gui);
        List<LevelInformation> levelInformation = new ArrayList<>();
        DirectHit level1 = new DirectHit();
        WideEasy level2 = new WideEasy();
        Green3 level3 = new Green3();
        FinalFour level4 = new FinalFour();
        levelInformation.add(level1);
        levelInformation.add(level2);
        levelInformation.add(level3);
        levelInformation.add(level4);
        List<LevelInformation> levelList = new ArrayList<>();
        for (String str : args) {
            try {
                int value = Integer.parseInt(str);
                if (value >= 1 && value <= 4) {
                    levelList.add(levelInformation.get(value - 1));
                }
            } catch (Exception e) {
                //continue;
            }
        }
        if (levelList.isEmpty()) {
            gameFlow.runLevels(levelInformation);
        } else {
            gameFlow.runLevels(levelList);
        }
    }
}
