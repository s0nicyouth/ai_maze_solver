import game.GameEngine;
import game.PlayerImpl;
import org.joml.Vector2i;
import renderer.Display;
import renderer.Engine;
import renderer.Renderer;

public class MainFrame {
    public static void main(String[] args) {
        Display disp = new Display();
        Engine engine = new GameEngine(new PlayerImpl(new Vector2i(400, 100)));

        Renderer render = new Renderer(engine, disp);
    }
}
