package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.CanvasMap;
import raycast.entity.FpsCounter;

/**
 *
 * @author baphucnguyen
 */
public class StaticShapes extends AbstractAnimator {

    private static final Color BACKGROUND = Color.AQUA;

    @Override
    public String toString() {

        return "Static Shapes";
    }

    @Override
    protected void handle(long now, GraphicsContext gc) {

        clearandFill(gc, Color.BLANCHEDALMOND);

        map.shapes();

        for (int i = 0; i < map.shapes().size(); i++) {

            map.shapes().get(i).draw(gc);
        }
    }

}
