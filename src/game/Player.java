package game;

import org.joml.Vector2d;

public interface Player {
    void move(Vector2d dir);
    Vector2d getPosition();
}
