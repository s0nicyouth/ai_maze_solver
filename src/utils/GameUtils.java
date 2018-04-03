package utils;

import org.joml.Vector2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameUtils {

    public static final int START_MARK = Color.decode("#ff0000").getRGB();
    public static final int FINISH_MARK = Color.decode("#0b0000").getRGB();

    public static Vector2d getMarkLocation(BufferedImage level, int mark) {
        for (int x = 0; x < level.getWidth(); x++) {
            for (int y = 0; y < level.getHeight(); y++) {
                if (level.getRGB(x, y) == mark)
                    return new Vector2d(x, y);
            }
        }

        return new Vector2d(0, 0);
    }
}
