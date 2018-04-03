package game;

import org.joml.Vector2d;
import org.joml.Vector2i;

public class PlayerImpl implements Player {

    private Vector2d mPosition;

    public PlayerImpl(Vector2d initialPos) {
        mPosition = initialPos;
    }

    @Override
    public void move(Vector2d dir) {
        mPosition.add(dir);
    }

    @Override
    public Vector2d getPosition() {
        return mPosition;
    }
}
