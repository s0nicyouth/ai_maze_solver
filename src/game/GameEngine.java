package game;

import org.joml.Vector2d;
import org.joml.Vector2i;
import renderer.Engine;
import utils.ImageUtils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class GameEngine implements Engine {

    private BufferedImage mImage = ImageUtils.readImage("resources/map.png");
    private Player mPlayer;
    private CommandProcessor mCommandProcessor = new SimpleCommandProcessor();

    public GameEngine(Player player) {
        mPlayer = player;
    }

    private Vector2d commandToVector(CommandProcessor.Command command) {
        switch (command) {
            case UP:
                return new Vector2d(0, -1);
            case DOWN:
                return new Vector2d(0, 1);
            case LEFT:
                return new Vector2d(-1, 0);
            case RIGTH:
                return new Vector2d(1, 0);
        }

        return new Vector2d(0, -1);
    }

    @Override
    public void tick(Canvas canvas, long delta) {
        Vector2d dir = commandToVector(mCommandProcessor.getCommand());
        System.out.println(delta / 100000000d);
        mPlayer.move(dir.mul(delta / 100000000d));
        Vector2d playerPosition = mPlayer.getPosition();
        if (playerPosition.x >= 0 &&
                playerPosition.y >= 0 &&
                playerPosition.x < mImage.getWidth() &&
                playerPosition.y < mImage.getHeight()) {
            int pixelAtPlayer = mImage.getRGB((int) playerPosition.x, (int) playerPosition.y);
            if (pixelAtPlayer == -1) {
                // Collision detected
                System.out.println("Collision!");
            }
        }
    }

    @Override
    public void render(Canvas canvas) {
        Graphics graphics = canvas.getGraphics();
        graphics.drawImage(mImage, 0, 0, null);
        Vector2d position = mPlayer.getPosition();
        Ellipse2D.Double player = new Ellipse2D.Double(position.x, position.y, 10, 10);
        graphics.setColor(Color.RED);
        graphics.fillOval((int) player.x, (int) player.y, (int) player.width, (int) player.height);
    }
}
