package game;

public interface CommandProcessor {
    enum Command {
        UP,
        DOWN,
        LEFT,
        RIGTH
    }
    Command getCommand();
}
