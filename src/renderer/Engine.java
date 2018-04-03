package renderer;

import java.awt.*;

public interface Engine {
    void tick(Canvas canvas, long delta);
    void render(Canvas canvas);
}
