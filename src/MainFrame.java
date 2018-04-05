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

        new Renderer(engine, disp);

        Classifier cls = new Classifier();

        Pair<RealMatrix, RealVector> data = Misc.readIrisData("resources/iris.data");

        RealMatrix train = new Array2DRowRealMatrix((int) Math.ceil(data.getFirst().getRowDimension() / 2), data.getFirst().getColumnDimension());
        RealVector trainY = new ArrayRealVector((int) Math.ceil(data.getSecond().getDimension() / 2));
        for (int i = 0, j = 0; i < data.getFirst().getRowDimension(); i++) {
            if (i % 2 == 0) {
                train.setRow(j, data.getFirst().getRow(i));
                trainY.setEntry(j, data.getSecond().getEntry(i));
                j++;
            }
        }

        cls.fit(train, trainY);

        int guessed = 0;
        for (int i = 0; i < data.getFirst().getRowDimension(); i++) {
            double predict = cls.predict(data.getFirst().getRowVector(i));
            if (predict == data.getSecond().getEntry(i))
                guessed++;
        }

        System.out.println("Accuracy: " + (double) guessed / data.getSecond().getDimension());
    }
}
