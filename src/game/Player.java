package game;

import org.joml.Vector2i;

public interface Player {
    void move(Vector2i dir);
    Vector2i getPosition();
}
