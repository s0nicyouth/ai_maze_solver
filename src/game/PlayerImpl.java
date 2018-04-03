package game;

import org.joml.Vector2i;

public class PlayerImpl implements Player {

    private Vector2i mPosition;

    public PlayerImpl(Vector2i initialPos) {
        mPosition = initialPos;
    }

    @Override
    public void move(Vector2i dir) {
        mPosition.add(dir);
    }

    @Override
    public Vector2i getPosition() {
        return mPosition;
    }
}
