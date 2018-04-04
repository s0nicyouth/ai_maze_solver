import game.GameEngine;
import game.PlayerImpl;
import math.linear_classifier.Classifier;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Pair;
import org.joml.Vector2d;
import renderer.Display;
import renderer.Engine;
import renderer.Renderer;
import utils.GameUtils;
import utils.ImageUtils;
import utils.Misc;

import java.awt.image.BufferedImage;

public class MainFrame {
    public static void main(String[] args) {
        BufferedImage level = ImageUtils.readImage("resources/map.bmp");
        Vector2d playerStart = GameUtils.getMarkLocation(level, GameUtils.START_MARK);

        Display disp = new Display();
        Engine engine = new GameEngine(new PlayerImpl(playerStart), level);

        Renderer render = new Renderer(engine, disp);

        Classifier cls = new Classifier();

        Pair<RealMatrix, RealVector> data = Misc.readIrisData("resources/iris.data");

        cls.fit(data.getFirst(), data.getSecond());
    }
}
