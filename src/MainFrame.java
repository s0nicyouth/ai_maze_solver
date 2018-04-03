import game.GameEngine;
import game.PlayerImpl;
import org.joml.Vector2d;
import renderer.Display;
import renderer.Engine;
import renderer.Renderer;
import utils.GameUtils;
import utils.ImageUtils;

import java.awt.image.BufferedImage;

public class MainFrame {
    public static void main(String[] args) {
        BufferedImage level = ImageUtils.readImage("resources/map.png");
        Vector2d playerStart = GameUtils.getMarkLocation(level, GameUtils.START_MARK);

        Display disp = new Display();
        Engine engine = new GameEngine(new PlayerImpl(playerStart), level);

        Renderer render = new Renderer(engine, disp);
    }
}
